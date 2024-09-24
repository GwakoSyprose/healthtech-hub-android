package dev.syprosegwako.healthtechhub.util

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


fun String.formatDate(): String {
    val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
    //Log.e("seedate", this.format(formatter))
    return this.format(formatter)
}

fun getCurrentTimestamp(): String {
    return DateTimeFormatter
        .ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now())
}