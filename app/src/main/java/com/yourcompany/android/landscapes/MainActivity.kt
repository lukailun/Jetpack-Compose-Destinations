package com.yourcompany.android.landscapes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yourcompany.android.landscapes.data.ThemeStore
import com.yourcompany.android.landscapes.data.ViewModel
import com.yourcompany.android.landscapes.ui.MainUi
import com.yourcompany.android.landscapes.ui.rememberWindowSizeClass

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: ViewModel by viewModels()
    private val themeStore by lazy { ThemeStore(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Switch to AppTheme for displaying the activity
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        // Your code
        setContent {
            val windowSize = rememberWindowSizeClass()
            MainUi(viewModel, windowSize, themeStore)
        }
    }
}
