package com.running.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.running.core.presentation.designsystem.RunIcon
import com.running.core.presentation.designsystem.RunMasterTheme


@Composable
fun RunMasterFloatingActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
    contentDescription: String? = null,
    iconSize: Dp = 50.dp
) {
    Box(
        modifier = modifier
            .size(75.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center

    ) {

        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(iconSize)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(12.dp),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun RunMasterFloatingActionButtonPreview() {
    RunMasterTheme {
        RunMasterFloatingActionButton(
            icon = RunIcon,
            onClick = {}
        )
    }
}