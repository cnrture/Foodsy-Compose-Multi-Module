package com.canerture.hogwartia.feature.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.feature.register.RegisterContract.UiAction
import com.canerture.hogwartia.feature.register.RegisterContract.UiEffect
import com.canerture.hogwartia.feature.register.RegisterContract.UiState
import com.canerture.ui.components.FSButton
import com.canerture.ui.components.FSButtonType
import com.canerture.ui.components.FSIcon
import com.canerture.ui.components.FSLoading
import com.canerture.ui.components.FSSpacer
import com.canerture.ui.components.FSSpacerWeight
import com.canerture.ui.components.FSText
import com.canerture.ui.components.FSTextField
import com.canerture.ui.extensions.collectWithLifecycle
import com.canerture.ui.extensions.noRippleClickable
import com.canerture.ui.theme.FSTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun RegisterScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {}

    RegisterContent(
        modifier = Modifier
            .fillMaxSize()
            .background(FSTheme.colors.lightYellow)
            .verticalScroll(rememberScrollState())
            .padding(36.dp),
        uiState = uiState,
        onAction = onAction,
    )

    if (uiState.isLoading) FSLoading()
}

@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        FSIcon(
            modifier = Modifier.size(140.dp),
            vector = FSTheme.icons.logo,
        )

        FSSpacer(34)

        FSText(
            text = stringResource(R.string.register),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            ),
        )

        FSSpacer(24)

        FSButton(
            text = stringResource(R.string.register_with_google),
            icon = FSTheme.icons.google,
            type = FSButtonType.SECONDARY,
            onClick = { onAction(UiAction.OnGoogleRegisterClick) }
        )

        FSSpacer(36)

        FSText(
            text = stringResource(R.string.or_with_email)
        )

        FSSpacer(24)

        FSTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.username_hint),
            value = uiState.username,
            onValueChange = { onAction(UiAction.OnUsernameChange(it)) },
        )

        FSSpacer(16)

        FSTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.email_hint),
            value = uiState.email,
            onValueChange = { onAction(UiAction.OnEmailChange(it)) },
        )

        FSSpacer(16)

        FSTextField(
            modifier = Modifier.fillMaxWidth(),
            isPassword = true,
            label = stringResource(R.string.password_hint),
            value = uiState.password,
            onValueChange = { onAction(UiAction.OnPasswordChange(it)) },
        )

        FSSpacer(30)

        FSButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.register),
            onClick = { onAction(UiAction.OnRegisterClick) },
        )

        FSSpacerWeight(1f)

        FSText(
            modifier = Modifier.noRippleClickable { onAction(UiAction.OnLoginClick) },
            fullText = stringResource(R.string.login_text),
            spanText = stringResource(R.string.login_text_span),
            spanStyle = SpanStyle(
                color = FSTheme.colors.green,
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(
    @PreviewParameter(RegisterScreenPreviewProvider::class) uiState: UiState,
) {
    RegisterScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}