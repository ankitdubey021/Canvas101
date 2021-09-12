package com.ankitdubey.canvas101.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ankitdubey.canvas101.R
import com.ankitdubey.canvas101.ui.theme.WHITE_LIGHT

@Composable
fun MToolbar(
    title: String,
    onBackClicked: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            MToolbarItem(
                title = title,
                onBackClicked = onBackClicked,
            )
        },
        backgroundColor = WHITE_LIGHT,
        content = {
            content()
        }
    )
}

@Composable
fun MToolbarItem(
    title: String,
    onBackClicked: (() -> Unit)? = null,
) {

    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface,
        elevation = 8.dp,
        navigationIcon = if (onBackClicked == null) null else ({
            MBackIcon(onBackClicked)
        })
    )
}

@Composable
fun MBackIcon(onPressed: () -> Unit, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = R.drawable.ic_left_icon),
        contentDescription = null,
        modifier = modifier
            .padding(top = 4.dp, bottom = 4.dp, start = 6.dp, end = 0.dp)
            .size(24.dp)
            .clickable { onPressed() }
    )
}