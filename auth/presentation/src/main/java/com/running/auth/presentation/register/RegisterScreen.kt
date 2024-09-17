package com.running.auth.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.running.auth.domain.PasswordValidationState
import com.running.auth.domain.UserDataValidator
import com.running.auth.presentation.R
import com.running.core.presentation.designsystem.CheckIcon
import com.running.core.presentation.designsystem.CrossIcon
import com.running.core.presentation.designsystem.EmailIcon
import com.running.core.presentation.designsystem.Poppins
import com.running.core.presentation.designsystem.RunMasterTheme
import com.running.core.presentation.designsystem.RuniqueDarkRed
import com.running.core.presentation.designsystem.RuniqueGray
import com.running.core.presentation.designsystem.RuniqueGreen
import com.running.core.presentation.designsystem.components.GradientBackground
import com.running.core.presentation.designsystem.components.RunMasterPasswordTextField
import com.running.core.presentation.designsystem.components.RunMasterTextField
import com.running.core.presentation.designsystem.components.RuniqueActionButton
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegisterScreenRoot(
    onSignInClick: () -> Unit,
    onSuccessfulRegistration: () -> Unit,
    viewModel: RegisterViewModel = koinViewModel()
) {
    RegisterScreen(
        viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit
) {
    GradientBackground {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.headlineMedium
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = Poppins,
                        color = RuniqueGray
                    )
                ) {
                    append(stringResource(id = R.string.already_have_account) + " ")
                    pushStringAnnotation(
                        tag = "clickable_text",
                        annotation = stringResource(id = R.string.login)
                    )
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = Poppins
                        )
                    ) {
                        append(stringResource(id = R.string.login))
                    }
                }
            }
            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(
                        tag = "clickable_text",
                        start = offset,
                        end = offset
                    ).firstOrNull()?.let {
                        onAction(RegisterAction.OnLoginClick)
                    }
                }
            )
            Spacer(Modifier.height(48.dp))
            RunMasterTextField(
                state = state.email,
                startIcon = EmailIcon,
                endIcon = if (state.isEmailValid) {
                    CheckIcon
                } else null,
                hint = stringResource(id = R.string.example_email),
                title = stringResource(id = R.string.email),
                modifier = Modifier.fillMaxWidth(),
                additionalInfo = stringResource(id = R.string.must_be_valid_email),
                keyboardType = KeyboardType.Email
            )
            Spacer(Modifier.height(16.dp))
            RunMasterPasswordTextField(
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onAction(RegisterAction.OnTogglePasswordVisibility)
                },
                hint = stringResource(id = R.string.password),
                title = stringResource(id = R.string.password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.at_least_x_characters, UserDataValidator.MIN_PASSWORD_LENGTH),
                isValid = state.passwordValidationState.hasMinLength,
            )
            Spacer(Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.at_least_one_number),
                isValid = state.passwordValidationState.hasNumber,
            )
            Spacer(Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.contains_lower_case_char),
                isValid = state.passwordValidationState.hasLowerCaseCharacter,
            )
            Spacer(Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.contains_upper_case_char),
                isValid = state.passwordValidationState.hasUpperCaseCharacter,
            )
            Spacer(Modifier.height(32.dp))
            RuniqueActionButton(
                text = stringResource(id = R.string.register),
                isLoading = state.isRegistering,
                enabled = state.canRegister,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onAction(RegisterAction.OnRegisterClick)
                }
            )
        }
    }
}

@Composable
fun PasswordRequirement(
    modifier: Modifier = Modifier,
    text: String,
    isValid: Boolean
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isValid) {
                CheckIcon
            } else {
                CrossIcon
            },
            contentDescription = null,
            tint = if (isValid) {
                RuniqueGreen
            } else {
                RuniqueDarkRed
            }
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RunMasterTheme {
        RegisterScreen(
            state = RegisterState(
                passwordValidationState = PasswordValidationState(
                    hasNumber = true,
                    hasLowerCaseCharacter = true,
                    hasUpperCaseCharacter = true,
                    hasMinLength = true
                )
            ),
            onAction = {}
        )
    }
}