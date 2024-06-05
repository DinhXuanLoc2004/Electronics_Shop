package com.example.demo_app_kotlin.asm.components.customCpns

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas

fun DrawScope.ShadowCustom() {
    val shadowColor = Color(0xFFAAAAAA)
    val offset = 50f

    // bóng phía trên
    drawIntoCanvas { canvas ->
        val TopPath = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width + offset, -offset)
            lineTo(-offset, -offset)
            close()
        }
        drawPath(
            TopPath,
            brush = Brush.verticalGradient(
                listOf(Color.Transparent, shadowColor.copy(0.1f)),
                startY = -offset,
                endY = 0f
            )
        )

        // Bóng phía bên phải
        val RightPath = Path().apply {
            moveTo(size.width, 0f)
            lineTo(size.width, size.height)
            lineTo(size.width + offset, size.height + offset)
            lineTo(size.width + offset, -offset)
            close()
        }
        drawPath(
            RightPath,
            brush = Brush.horizontalGradient(
                listOf(shadowColor.copy(0.15f), Color.Transparent),
                startX = size.width,
                endX = size.width + offset
            )
        )

        // Bóng phía dưới
        val BottomPath = Path().apply {
            moveTo(0f, size.height)
            lineTo(size.width, size.height)
            lineTo(size.width + offset, size.height + offset)
            lineTo(-offset, size.height + offset)
            close()
        }
        drawPath(
            BottomPath,
            brush = Brush.verticalGradient(
                listOf(shadowColor.copy(0.15f), Color.Transparent),
                startY = size.height,
                endY = size.height + offset
            )
        )

    }

}