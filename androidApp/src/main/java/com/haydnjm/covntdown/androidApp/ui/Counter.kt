package com.haydnjm.covntdown.androidApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.haydnjm.covntdown.androidApp.R
import com.haydnjm.covntdown.shared.remote.Event
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Composable
fun Counter(event: Event) {

    var now = LocalDate.now()
    var formatter = DateTimeFormatter.ISO_DATE_TIME
    var eventDate = LocalDate.parse(event.date, formatter)
    var days = ChronoUnit.DAYS.between(now, eventDate)
    CountdownCard(days, event.fullName)
}

@Composable
fun CountdownCard(daysLeft: Long, fullName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = 10.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(20.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_timer),
                contentDescription = "And my axe",
                modifier = Modifier.size(50.dp)
            )
            Column(
                modifier = Modifier.padding(bottom = 3.dp, start = 20.dp)
            ) {
                Text(
                    "$daysLeft days left",
                    style = MaterialTheme.typography.h4,
                    color = Color.White,
                )
                Text(
                    "Until you can $fullName",
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                )
            }
        }
    }
}