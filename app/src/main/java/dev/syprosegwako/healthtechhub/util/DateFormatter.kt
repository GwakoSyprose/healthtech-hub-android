package dev.syprosegwako.healthtechhub.util

import dev.syprosegwako.healthtechhub.util.Constants.API.INVALID_DATE
import dev.syprosegwako.healthtechhub.util.Constants.API.SERVER_DATE_FORMAT
import dev.syprosegwako.healthtechhub.util.Constants.UI.DISPLAY_DATE_FORMAT
import java.time.Instant
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun getCurrentTimestamp(): String {
    val now = Instant.now()
    val formatter = DateTimeFormatter.ofPattern(SERVER_DATE_FORMAT)
        .withZone(ZoneOffset.UTC)
    return formatter.format(now)
}

fun String.formatDate(): String {
    return try {
        val zonedDateTime = ZonedDateTime.parse(this)
        zonedDateTime.format(DateTimeFormatter.ofPattern(DISPLAY_DATE_FORMAT))
    } catch (e: Exception) {
        INVALID_DATE
    }
}