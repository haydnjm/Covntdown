package com.haydnjm.covntdown.androidApp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.haydnjm.covntdown.androidApp.R
import org.koin.androidx.compose.getViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}

@Composable
fun MainLayout() {
    val covntdownViewModel = getViewModel<CovntdownViewModel>()

    CovntdownTheme {
        Surface {
            Image(
                painterResource(R.drawable.bg1),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "background image",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Counter()
                Text(covntdownViewModel.getData().infections.toString())
            }

        }
    }

}

@Preview()
@Composable
fun DefaultPreview() {
    CovntdownTheme {
        MainLayout()
    }
}
