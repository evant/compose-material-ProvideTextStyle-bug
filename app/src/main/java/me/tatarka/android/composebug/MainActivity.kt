package me.tatarka.android.composebug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubcomposeLayout { constraints ->
                layout(constraints.maxWidth, constraints.maxHeight) {
                    subcompose(Unit) {
                        ProvideTextStyle(value = TextStyle(fontSize = 22.sp)) {
                            val style1 = LocalTextStyle.current
                            CompositionLocalProvider(
                                LocalContentColor provides Color.Black,
                                content = {})
                            val style2 = LocalTextStyle.current
                            assert(style1.fontSize == style2.fontSize) {
                                "mismatched fonts sizes: ${style1.fontSize} ${style2.fontSize}"
                            }
                            Box(modifier = Modifier)
                        }
                    }.first().measure(constraints).place(0, 0)
                }
            }
        }
    }
}