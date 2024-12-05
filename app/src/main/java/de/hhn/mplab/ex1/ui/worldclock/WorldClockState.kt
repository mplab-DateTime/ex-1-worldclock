package de.hhn.mplab.ex1.ui.worldclock

import java.time.ZoneId
import java.util.Locale

data class WorldClockState(
    // system
    val currentSystemTime: String = "",
    val currentSystemDate: String = "",
    val systemDefaultLocale: Locale = Locale.getDefault(),
    val systemDefaultTimeZone: ZoneId = ZoneId.systemDefault(),

    // selected
    val selectedTimeZone: ZoneId = ZoneId.systemDefault(),
    val selectedLocale: Locale = Locale.getDefault(),
    val currentSelectedTime: String = "",
    val currentSelectedDate: String = "",
)