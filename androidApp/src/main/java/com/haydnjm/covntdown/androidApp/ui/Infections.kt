package com.haydnjm.covntdown.androidApp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.haydnjm.covntdown.androidApp.R
import org.koin.androidx.compose.getViewModel

@Composable
fun Infections() {
    val covntdownViewModel = getViewModel<CovntdownViewModel>()

    var infectionsData = covntdownViewModel.infections.value
    var infectionCount =
        if (infectionsData.infected > 0) infectionsData.infected.toString() else "..."
    var recoveredCount =
        if (infectionsData.recovered > 0) infectionsData.recovered.toString() else "..."

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .padding(end = 15.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_virus),
                contentDescription = "Virus",
                modifier = Modifier.size(50.dp)
            )
        }
        Column {
            Text(
                "Current infection count:",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                infectionCount,
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .padding(end = 15.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_heart),
                contentDescription = "Virus",
                modifier = Modifier.size(50.dp)
            )
        }
        Column {
            Text(
                "Current recovered count:",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                recoveredCount,
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        }
    }
}