package com.running.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.running.auth.domain.UserDataValidator

class RegisterViewModel(
    private val userDataValidator: UserDataValidator
): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    init {
        state.email.textAsFlow()
            .onEach { email ->
                state = state.copy(
                    isEmailValid = userDataValidator.isValidEmail(email.toString)
                )
            }
            .lau
    }
    fun onAction(action: RegisterAction) {
        
    }
}