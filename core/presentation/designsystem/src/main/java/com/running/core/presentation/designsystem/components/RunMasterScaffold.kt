package com.running.core.presentation.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RunMasterScaffold(
    modifier: Modifier = Modifier,
    withGradient: Boolean = true,
    topAppBar: @Composable () -> Unit,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        topBar = topAppBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center
    ) {paddingValues ->
        if (withGradient) {
            GradientBackground {
                content(paddingValues)
            }
        } else {
            content(paddingValues)
        }

    }
}