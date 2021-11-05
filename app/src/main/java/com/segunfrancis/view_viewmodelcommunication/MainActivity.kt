package com.segunfrancis.view_viewmodelcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.segunfrancis.view_viewmodelcommunication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObservers()
        setupClickListeners()
    }

    private fun setupClickListeners() = with(binding) {
        addCard.setOnClickListener {
            viewModel.addCount()
        }
        subtractCard.setOnClickListener {
            viewModel.subtractCount()
        }
    }

    private fun setupObservers() {
        viewModel.countState.observe(this) { state ->
            when (state) {
                is CountState.Success -> handleSuccess(state.count)
                is CountState.Warning -> handleWarning(message = state.message, count = state.count)
            }
        }
    }

    private fun handleSuccess(count: Int) = with(binding) {
        numberText.text = count.toString()
    }

    private fun handleWarning(message: String, count: Int) = with(binding) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
            .show()
        numberText.text = count.toString()
    }
}
