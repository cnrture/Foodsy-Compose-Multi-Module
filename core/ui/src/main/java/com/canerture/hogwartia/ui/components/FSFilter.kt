package com.canerture.hogwartia.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.hogwartia.ui.theme.FSTheme
import kotlin.math.abs

@Composable
fun FSFilter(
    modifier: Modifier = Modifier,
    minValue: Float,
    maxValue: Float,
    currentRange: ClosedFloatingPointRange<Float>,
    onRangeChange: (ClosedFloatingPointRange<Float>) -> Unit,
) {
    var startThumbPosition by remember(currentRange.start) {
        mutableStateOf(currentRange.start)
    }

    var endThumbPosition by remember(currentRange.endInclusive) {
        mutableStateOf(currentRange.endInclusive)
    }

    val green = FSTheme.colors.green
    val brown = FSTheme.colors.brown
    val orange = FSTheme.colors.orange

    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(18.dp),
            contentAlignment = Alignment.Center,
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()

                            val canvasWidth = size.width.toFloat()
                            val touchX = change.position.x

                            val startThumbX = ((startThumbPosition - minValue) / (maxValue - minValue)) * canvasWidth
                            val endThumbX = ((endThumbPosition - minValue) / (maxValue - minValue)) * canvasWidth

                            val distanceToStart = abs(touchX - startThumbX)
                            val distanceToEnd = abs(touchX - endThumbX)

                            if (distanceToStart < distanceToEnd) {
                                val newX = (startThumbX + dragAmount.x).coerceIn(0f, canvasWidth)
                                val newValue = (newX / canvasWidth) * (maxValue - minValue) + minValue
                                if (newValue < endThumbPosition) {
                                    startThumbPosition = newValue
                                    onRangeChange(startThumbPosition..endThumbPosition)
                                }
                            } else {
                                val newX = (endThumbX + dragAmount.x).coerceIn(0f, canvasWidth)
                                val newValue = (newX / canvasWidth) * (maxValue - minValue) + minValue
                                if (newValue > startThumbPosition) {
                                    endThumbPosition = newValue
                                    onRangeChange(startThumbPosition..endThumbPosition)
                                }
                            }
                        }
                    }
            ) {
                val canvasHeight = size.height
                val canvasWidth = size.width
                val trackY = canvasHeight / 2f
                val trackHeight = 5.dp.toPx()
                val thumbRadius = 12.dp.toPx()

                val startX = ((startThumbPosition - minValue) / (maxValue - minValue)) * canvasWidth
                val endX = ((endThumbPosition - minValue) / (maxValue - minValue)) * canvasWidth

                drawLine(
                    color = brown,
                    start = Offset(0f, trackY),
                    end = Offset(startX, trackY),
                    strokeWidth = trackHeight,
                    cap = StrokeCap.Round,
                )

                drawLine(
                    color = green,
                    start = Offset(startX, trackY),
                    end = Offset(endX, trackY),
                    strokeWidth = trackHeight,
                    cap = StrokeCap.Round,
                )

                drawLine(
                    color = brown,
                    start = Offset(endX, trackY),
                    end = Offset(canvasWidth, trackY),
                    strokeWidth = trackHeight,
                    cap = StrokeCap.Round,
                )

                drawCircle(
                    color = orange,
                    radius = thumbRadius,
                    center = Offset(startX, trackY),
                )

                drawCircle(
                    color = brown,
                    radius = thumbRadius,
                    center = Offset(startX, trackY),
                    style = Stroke(width = 3.dp.toPx()),
                )

                drawCircle(
                    color = orange,
                    radius = thumbRadius,
                    center = Offset(endX, trackY),
                )

                drawCircle(
                    color = brown,
                    radius = thumbRadius,
                    center = Offset(endX, trackY),
                    style = Stroke(width = 3.dp.toPx()),
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$${minValue.toInt()}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = FSTheme.colors.darkBrown,
            )

            Text(
                text = "$${startThumbPosition.toInt()}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = FSTheme.colors.darkBrown,
            )

            Text(
                text = "$${endThumbPosition.toInt()}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = FSTheme.colors.darkBrown,
            )

            Text(
                text = "$${maxValue.toInt()}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = FSTheme.colors.darkBrown,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FSFilterPreview() {
    FSTheme {
        FSFilter(
            minValue = 1f,
            maxValue = 30f,
            currentRange = 3f..16f,
            onRangeChange = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}