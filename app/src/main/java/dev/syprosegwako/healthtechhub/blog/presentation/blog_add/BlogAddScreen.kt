package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.syprosegwako.healthtechhub.R
import dev.syprosegwako.healthtechhub.blog.domain.TopicItem
import dev.syprosegwako.healthtechhub.blog.presentation.AppLayout
import dev.syprosegwako.healthtechhub.util.Constants.UI.CHARACTER_LIMIT
import kotlinx.coroutines.flow.collectLatest

@Composable
fun BlogAddScreen(
    navController: NavController,
    viewModel: BlogNewViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.value
    val formState = uiState.blog
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.showSnackbarMessage.collectLatest { message ->
            snackbarHostState.showSnackbar(
                message = message
            )
            navController.navigateUp() // Navigate back after the Snackbar is shown
        }
    }

    AppLayout(
        navController = navController,
        title = "Add new Post",
        snackbarHostState = snackbarHostState,
        showFab = false,
        onFabClick = {}
    ) { modifier ->
        Column(
            modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            GenericTextField(
                label = "Name",
                value = formState.name,
                onValueChange = { viewModel.onNameChanged(it) },
                isError = viewModel.nameError
            )
            GenericTextField(
                label = "Surname",
                value = formState.surname,
                onValueChange = { viewModel.onSurnameChanged(it) },
                isError = viewModel.surnameError
            )
            DropdownMenuBox(
                label = "Category",
                placeholder = "Select category",
                isError = viewModel.topicError,
                topics = uiState.topics,
                value = formState.topicId,
                onTopicSelect = { viewModel.onTopicSelected(it) }
            )
            GenericTextField(
                label = "Headline",
                value = formState.subject,
                onValueChange = { viewModel.onSubjectChanged(it) },
                isError = viewModel.subjectError
            )
            GenericMultiLineTextField(
                label = "Body",
                value = formState.body,
                onValueChange = { viewModel.onBodyChanged(it) },
                isError = viewModel.bodyError
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 24.dp)
            )
            Button(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isSubmitting,
                onClick = {
                    if (viewModel.isFormValid()) {
                        viewModel.saveBlog()
                    }
                }
            )
            {
                Text(
                    text = "Add a Post",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }

}


@Composable
fun GenericTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(modifier.padding(bottom = dimensionResource(R.dimen.text_field_padding))) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(label) },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = isError,
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = modifier.fillMaxWidth()
        )

        if (isError) ErrorText(text = "*$label is required.")
    }

}

@Composable
fun GenericMultiLineTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var charLimitError by remember { mutableStateOf(false) }
    val internalError = charLimitError || isError

    Column(modifier.padding(bottom = dimensionResource(R.dimen.text_field_padding))) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (it.length <= CHARACTER_LIMIT) {
                    onValueChange(it)
                    charLimitError = false
                }
                else charLimitError = true
            },
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text(label) },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            isError = internalError,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            supportingText = {
                Text(
                    text = "${value.length} / $CHARACTER_LIMIT",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                )
            },
            modifier = modifier
                .heightIn(min = dimensionResource(R.dimen.multi_line_input_field_height))
                .fillMaxWidth()
        )

        if (isError) ErrorText(text = "*$label is required.")
        if (internalError) ErrorText(text = "*Max character limit is exceeded.")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuBox(
    label: String,
    placeholder: String,
    topics: List<TopicItem>,
    value: Int,
    isError: Boolean = false,
    onTopicSelect: (Int) -> Unit
) {
    val selectedOption = topics.find { it.id == value }
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            Column(Modifier.padding(bottom = dimensionResource(R.dimen.text_field_padding))) {
                OutlinedTextField(
                    value = selectedOption?.title ?: "",
                    onValueChange = {},
                    label = { Text(label) },
                    placeholder = { Text(placeholder) },
                    isError = isError,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(MenuAnchorType.PrimaryEditable, true)
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ) {
                    topics.forEach { topic ->
                        DropdownMenuItem(
                            text = { Text(text = topic.title) },
                            onClick = {
                                expanded = false
                                onTopicSelect(topic.id)
                            }
                        )
                    }
                }

                if (isError) ErrorText(text = "*$label is required.")
            }
        }
    }
}

@Composable
fun ErrorText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(
            start = dimensionResource(R.dimen.padding_8),
            top = dimensionResource(R.dimen.padding_8)
        )
    )
}


@Preview(showBackground = true)
@Composable
fun BlogNewScreenPreview() {
    val navController = rememberNavController()
    BlogAddScreen(navController)
}