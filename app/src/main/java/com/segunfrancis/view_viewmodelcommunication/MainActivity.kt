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
                is CountState.Success -> binding.numberText.text = state.count.toString()
                is CountState.Warning -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT)
                        .show()
                    binding.numberText.text = state.count.toString()
                }
            }
        }
    }
}
