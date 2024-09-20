package dev.syprosegwako.healthtechhub.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import dev.syprosegwako.healthtechhub.ui.theme.Typography
import dev.syprosegwako.healthtechhub.ui.theme.backgroundDark
import dev.syprosegwako.healthtechhub.ui.theme.backgroundDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.backgroundDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.backgroundLight
import dev.syprosegwako.healthtechhub.ui.theme.backgroundLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.backgroundLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.errorContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.errorContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorDark
import dev.syprosegwako.healthtechhub.ui.theme.errorDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorLight
import dev.syprosegwako.healthtechhub.ui.theme.errorLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.errorLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseOnSurfaceDark
import dev.syprosegwako.healthtechhub.ui.theme.inverseOnSurfaceDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseOnSurfaceDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseOnSurfaceLight
import dev.syprosegwako.healthtechhub.ui.theme.inverseOnSurfaceLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseOnSurfaceLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.inversePrimaryDark
import dev.syprosegwako.healthtechhub.ui.theme.inversePrimaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.inversePrimaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.inversePrimaryLight
import dev.syprosegwako.healthtechhub.ui.theme.inversePrimaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.inversePrimaryLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseSurfaceDark
import dev.syprosegwako.healthtechhub.ui.theme.inverseSurfaceDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseSurfaceDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseSurfaceLight
import dev.syprosegwako.healthtechhub.ui.theme.inverseSurfaceLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.inverseSurfaceLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onBackgroundDark
import dev.syprosegwako.healthtechhub.ui.theme.onBackgroundDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onBackgroundDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onBackgroundLight
import dev.syprosegwako.healthtechhub.ui.theme.onBackgroundLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onBackgroundLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.onErrorContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.onErrorContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorDark
import dev.syprosegwako.healthtechhub.ui.theme.onErrorDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorLight
import dev.syprosegwako.healthtechhub.ui.theme.onErrorLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onErrorLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryDark
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryLight
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onPrimaryLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryDark
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryLight
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSecondaryLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceDark
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceLight
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceVariantDark
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceVariantDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceVariantDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceVariantLight
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceVariantLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onSurfaceVariantLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryDark
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryLight
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.onTertiaryLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineDark
import dev.syprosegwako.healthtechhub.ui.theme.outlineDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineLight
import dev.syprosegwako.healthtechhub.ui.theme.outlineLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineVariantDark
import dev.syprosegwako.healthtechhub.ui.theme.outlineVariantDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineVariantDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineVariantLight
import dev.syprosegwako.healthtechhub.ui.theme.outlineVariantLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.outlineVariantLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.primaryContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.primaryContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryDark
import dev.syprosegwako.healthtechhub.ui.theme.primaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryLight
import dev.syprosegwako.healthtechhub.ui.theme.primaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.primaryLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.scrimDark
import dev.syprosegwako.healthtechhub.ui.theme.scrimDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.scrimDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.scrimLight
import dev.syprosegwako.healthtechhub.ui.theme.scrimLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.scrimLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.secondaryContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.secondaryContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryDark
import dev.syprosegwako.healthtechhub.ui.theme.secondaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryLight
import dev.syprosegwako.healthtechhub.ui.theme.secondaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.secondaryLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceBrightDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceBrightDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceBrightDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceBrightLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceBrightLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceBrightLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighestDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighestDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighestDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighestLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighestLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerHighestLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowestDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowestDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowestDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowestLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowestLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceContainerLowestLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDimDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDimDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDimDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDimLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDimLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceDimLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceVariantDark
import dev.syprosegwako.healthtechhub.ui.theme.surfaceVariantDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceVariantDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceVariantLight
import dev.syprosegwako.healthtechhub.ui.theme.surfaceVariantLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.surfaceVariantLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryContainerDark
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryContainerDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryContainerDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryContainerLight
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryContainerLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryContainerLightMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryDark
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryDarkHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryDarkMediumContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryLight
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryLightHighContrast
import dev.syprosegwako.healthtechhub.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun HealthTechHubTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
