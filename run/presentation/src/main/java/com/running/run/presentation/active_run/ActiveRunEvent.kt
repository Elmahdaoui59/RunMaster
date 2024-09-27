package com.running.run.presentation.active_run

import com.running.core.presentation.ui.UiText

interface ActiveRunEvent {
    data class Error(val error: UiText): ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}