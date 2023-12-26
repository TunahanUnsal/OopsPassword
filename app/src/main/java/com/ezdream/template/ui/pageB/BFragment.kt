package com.ezdream.template.ui.pageB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezdream.template.databinding.FragmentBBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BFragment : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<BFragmentVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}