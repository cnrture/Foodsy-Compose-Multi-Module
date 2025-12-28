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
import com.canerture.hogwartia.ui.components.HWButton
import com.canerture.hogwartia.ui.components.HWButtonType
import com.canerture.hogwartia.ui.components.HWIcon
import com.canerture.hogwartia.ui.components.HWLoading
import com.canerture.hogwartia.ui.components.HWSpacer
import com.canerture.hogwartia.ui.components.HWSpacerWeight
import com.canerture.hogwartia.ui.components.HWText
import com.canerture.hogwartia.ui.components.HWTextField
import com.canerture.hogwartia.ui.extensions.collectWithLifecycle
import com.canerture.hogwartia.ui.extensions.noRippleClickable
import com.canerture.hogwartia.ui.theme.HWTheme
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
            .background(HWTheme.colors.lightYellow)
            .verticalScroll(rememberScrollState())
            .padding(36.dp),
        uiState = uiState,
        onAction = onAction,
    )

    if (uiState.isLoading) HWLoading()
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
        HWIcon(
            modifier = Modifier.size(140.dp),
            vector = HWTheme.icons.logo,
        )

        HWSpacer(34)

        HWText(
            text = stringResource(R.string.register),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            ),
        )

        HWSpacer(24)

        HWButton(
            text = stringResource(R.string.register_with_google),
            icon = HWTheme.icons.google,
            type = HWButtonType.SECONDARY,
            onClick = { onAction(UiAction.OnGoogleRegisterClick) }
        )

        HWSpacer(36)

        HWText(
            text = stringResource(R.string.or_with_email)
        )

        HWSpacer(24)

        HWTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.username_hint),
            value = uiState.username,
            onValueChange = { onAction(UiAction.OnUsernameChange(it)) },
        )

        HWSpacer(16)

        HWTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.email_hint),
            value = uiState.email,
            onValueChange = { onAction(UiAction.OnEmailChange(it)) },
        )

        HWSpacer(16)

        HWTextField(
            modifier = Modifier.fillMaxWidth(),
            isPassword = true,
            label = stringResource(R.string.password_hint),
            value = uiState.password,
            onValueChange = { onAction(UiAction.OnPasswordChange(it)) },
        )

        HWSpacer(30)

        HWButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.register),
            onClick = { onAction(UiAction.OnRegisterClick) },
        )

        HWSpacerWeight(1f)

        HWText(
            modifier = Modifier.noRippleClickable { onAction(UiAction.OnLoginClick) },
            fullText = stringResource(R.string.login_text),
            spanText = stringResource(R.string.login_text_span),
            spanStyle = SpanStyle(
                color = HWTheme.colors.green,
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