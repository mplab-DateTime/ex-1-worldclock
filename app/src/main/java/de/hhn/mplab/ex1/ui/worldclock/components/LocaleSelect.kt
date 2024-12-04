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
import java.util.Locale

@Composable
fun LocaleSelect(
    onSelectLocale: (Locale) -> Unit,
    locales: Array<Locale>
) {
    var showDialog by remember { mutableStateOf(false) }
    Button(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = { showDialog = true }
    ) {
        Text("Select Locale")
    }

    if (showDialog) {
        LocaleDialog(
            onDismissRequest = { showDialog = false },
            onSelectLocale = { locale ->
                onSelectLocale(locale)
                showDialog = false
            },
            locales = locales
        )
    }
}

@Composable
fun LocaleDialog(
    onDismissRequest: () -> Unit,
    onSelectLocale: (Locale) -> Unit,
    locales: Array<Locale>
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Select Locale")
        },
        text = {
            LazyColumn(modifier = Modifier.heightIn(300.dp)) {
                items(locales.size) {
                    ListItem(
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                        ),
                        headlineContent = {
                            Text(locales[it].displayName)
                        },
                        modifier = Modifier
                            .clickable {
                                onSelectLocale(locales[it])
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