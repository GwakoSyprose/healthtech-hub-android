package dev.syprosegwako.healthtechhub.blog.presentation.blog_add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BlogAddScreen() {

    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var subject by rememberSaveable { mutableStateOf("") }
    var body by rememberSaveable { mutableStateOf("") }
    var topicId by rememberSaveable { mutableIntStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(vertical = 40.dp)
    ) {


        //form
        GenericTextField(
            label = "Name",
            value = name,
            onValueChange = { name = it }
        )
        GenericTextField(
            label = "Surname",
            value = surname,
            onValueChange = { surname = it }
        )
        GenericTextField(
            label = "Subject",
            value = subject,
            onValueChange = { subject = it }
        )
        OutlinedTextField(value = "Subject", onValueChange = { subject = it })

        // Spacer to push the button to the bottom
        Spacer(modifier = Modifier.weight(1f))
        //button
        Button(
//            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            onClick = { }
        )
        {
            Text(
                text = "Add a Post",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

}


@Composable
fun GenericTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(modifier = Modifier.padding(horizontal = 40.dp)) {
        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.labelMedium
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = MaterialTheme.typography.bodyMedium,
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                cursorColor =  MaterialTheme.colorScheme.primary
            ),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BlogNewScreenPreview() {
    BlogAddScreen()
}