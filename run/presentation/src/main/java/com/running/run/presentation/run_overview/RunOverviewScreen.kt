package com.running.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.running.core.presentation.designsystem.AnalyticsIcon
import com.running.core.presentation.designsystem.LogoIcon
import com.running.core.presentation.designsystem.LogoutIcon
import com.running.core.presentation.designsystem.RunIcon
import com.running.core.presentation.designsystem.RunMasterTheme
import com.running.core.presentation.designsystem.components.RunMasterFloatingActionButton
import com.running.core.presentation.designsystem.components.RunMasterScaffold
import com.running.core.presentation.designsystem.components.RunMasterToolbar
import com.running.core.presentation.designsystem.components.util.DropDownItem
import com.running.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreenRoot(
    onStartRunClick: () -> Unit,
    viewModel: RunOverviewViewModel = koinViewModel()
) {
    RunOverviewScreen(
        onAction = { action ->
            when(action) {
                RunOverviewAction.OnStartClick -> onStartRunClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RunOverviewScreen(
    modifier: Modifier = Modifier,
    onAction: (RunOverviewAction) -> Unit
) {

    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RunMasterScaffold(
        topAppBar = {
            RunMasterToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.runmaster),
                scrollBehavior = scrollBehavior,
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics)
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout)
                    )
                ),
                onMenuItemClick = { index ->
                    when(index) {
                        0 -> onAction(RunOverviewAction.OnAnalyticsClick)
                        1 -> onAction(RunOverviewAction.OnLogoutClick)
                    }
                }
            )
        },
        floatingActionButton = {
            RunMasterFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartClick )
                }
            )
        }

    ) { paddingValues ->

    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RunMasterTheme {
        RunOverviewScreen {  }
    }
}