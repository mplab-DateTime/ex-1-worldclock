package de.hhn.mplab.ex1.ui.worldclock.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.hhn.mplab.ex1.ui.worldclock.WorldClockViewModel
import de.hhn.mplab.ex1.ui.worldclock.components.CurrentDateTime
import de.hhn.mplab.ex1.ui.worldclock.components.LocaleSelect
import de.hhn.mplab.ex1.ui.worldclock.components.TimeZoneSelect


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorldClockScreen(modifier: Modifier = Modifier) {
    val worldClockViewModel: WorldClockViewModel = viewModel()
    val clockState by worldClockViewModel.state.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = colorScheme.primaryContainer,
                    titleContentColor = colorScheme.primary,
                ),
                title = {
                    Text(
                        "Worldclock App",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CurrentDateTime(
                title = "System",
                currentTime = clockState.currentSystemTime,
                currentDate = clockState.currentSystemDate,
                timeZone = clockState.systemDefaultTimeZone.toString(),
                locale = clockState.systemDefaultLocale.displayName
            )

            HorizontalDivider(modifier = Modifier.padding(16.dp))

            CurrentDateTime(
                title = "Selected",
                currentTime = clockState.currentSelectedTime,
                currentDate = clockState.currentSelectedDate,
                timeZone = clockState.selectedTimeZone.toString(),
                locale = clockState.selectedLocale.displayName
            )

            TimeZoneSelect(
                onSelectTimeZone = { selectedTimeZone ->
                    Log.d("TimeZoneSelect", "$selectedTimeZone")
                    worldClockViewModel.setTimezone(selectedTimeZone)
                },
                timeZones = worldClockViewModel.getAvailableTimezones()
            )

            LocaleSelect(
                onSelectLocale = { selectedLocale ->
                    Log.d("LocaleSelect", "$selectedLocale")
                    worldClockViewModel.setLocale(selectedLocale)
                },
                locales = worldClockViewModel.getAvailableLocales()
            )

        }
    }
}