package de.hhn.mplab.ex1.ui.worldclock

import java.time.ZoneId
import java.util.Locale

data class WorldClockState(
    // system
    val currentSystemTime: String = "",
    val currentSystemDate: String = "",
    // TODO Change initial value to system locale and zone
    val systemDefaultLocale: Locale = Locale.getDefault(),
    val systemDefaultTimeZone: ZoneId = ZoneId.systemDefault(),

    // selected
    // TODO Change initial value to system locale and zone
    val selectedLocale: Locale = Locale.ENGLISH,
    val selectedTimeZone: ZoneId = ZoneId.of("UTC"),
    val currentSelectedTime: String = "",
    val currentSelectedDate: String = "",
)