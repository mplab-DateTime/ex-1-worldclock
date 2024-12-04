package de.hhn.mplab.ex1.ui.worldclock.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.ZoneId

@Composable
fun TimeZoneSelect(
    onSelectTimeZone: (ZoneId) -> Unit,
    timeZones: Set<String>
) {
    var showDialog by remember { mutableStateOf(false) }

    Button(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = { showDialog = true }
    ) {
        Text("Select Timezone")
    }

    if (showDialog) {
        TimeZoneDialog(
            onDismissRequest = { showDialog = false },
            onSelectTimeZone = { timeZone ->
                onSelectTimeZone(timeZone)
                showDialog = false
            },
            timeZones = timeZones
        )
    }
}

@Composable
fun TimeZoneDialog(
    onDismissRequest: () -> Unit,
    onSelectTimeZone: (ZoneId) -> Unit,
    timeZones: Set<String>
) {

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Select Timezone")
        },
        text = {
            LazyColumn(modifier = Modifier.heightIn(300.dp)) {
                items(timeZones.size) {

                    ListItem(
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        ),
                        headlineContent = {
                            Text(timeZones.elementAt(it))
                        },
                        modifier = Modifier
                            .clickable {
                                onSelectTimeZone(ZoneId.of(timeZones.elementAt(it)))
                            }
                            .padding(horizontal = 8.dp)
                    )
                    HorizontalDivider()
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismissRequest
            ) {
                Text("Cancel")
            }
        }
    )
}