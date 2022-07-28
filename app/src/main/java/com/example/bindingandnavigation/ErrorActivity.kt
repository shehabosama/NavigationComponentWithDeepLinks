package com.example.bindingandnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import com.example.bindingandnavigation.databinding.ActivityErrorBinding

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityErrorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /** you can log the reason of crash by adding this line of code
         *  CustomActivityOnCrash.getStackTraceFromIntent(intent)
         */

        //getting crashing intent
        val config = CustomActivityOnCrash.getConfigFromIntent(intent)
        val configError = CustomActivityOnCrash.getAllErrorDetailsFromIntent(this , intent)

        /**
         * If config is null or not getting an intent simply finish the app
         */
        if (config == null) {
            finish()
            return
        }

        if (config.isShowRestartButton && config.restartActivityClass != null) {
            binding.restartApp.text = "Restart App"
            binding.errorText.text = configError
            binding.restartApp.setOnClickListener {
                CustomActivityOnCrash.restartApplication(
                    this,
                    config
                )
            }
        } else {
            binding.restartApp.text = "Close App"
            binding.restartApp.setOnClickListener {
                CustomActivityOnCrash.closeApplication(
                    this,
                    config
                )
            }
        }
    }

    }