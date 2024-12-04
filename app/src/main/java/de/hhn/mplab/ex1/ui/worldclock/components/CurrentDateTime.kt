package de.hhn.mplab.ex1.ui.worldclock.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CurrentDateTime(
    title: String,
    currentDate: String,
    currentTime: String,
    timeZone: String,
    locale: String,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.padding(horizontal =  16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(4.dp)
        )
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CurrentTime(currentTime)
            CurrentDate(currentDate)
            HorizontalDivider()
            PropertyText("Timezone: ", timeZone)
            PropertyText("Locale: ", locale)
        }
    }
}

@Composable
fun CurrentTime(
    currentTime: String,
) {
    Text(
        text = currentTime,
        style = typography.titleLarge
    )
}

@Composable
fun CurrentDate(
    currentDate: String,
) {
    Text(
        text = currentDate,
        style = typography.titleLarge
    )
}

@Composable
fun PropertyText(
    name: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Start
        )
        Text(
            text = value,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End
        )
    }
}
