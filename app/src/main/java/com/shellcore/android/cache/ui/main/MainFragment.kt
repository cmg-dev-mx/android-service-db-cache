package com.shellcore.android.cache.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.shellcore.android.cache.databinding.FragmentMainBinding
import com.shellcore.android.cache.ui.main.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.mainQueryBtn.setOnClickListener {
            viewModel.queryData()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.queryResponse.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                Snackbar.make(binding.root, "Success: $it", Snackbar.LENGTH_SHORT).show()
            }.onFailure {
                Snackbar.make(binding.root, "Failure: $it", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}