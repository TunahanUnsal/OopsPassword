package com.ezdream.password.ui.pageA

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ezdream.password.R
import com.ezdream.password.databinding.FragmentABinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AFragment : Fragment(), ItemClickListener {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<AFragmentVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.addData()
        viewModel.addData()
        viewModel.addData()

        binding.fragmentAFab.setOnClickListener {
            findNavController().navigate(R.id.action_AFragment_to_BFragment)
        }

        binding.itemClickListener = this

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(id: Int) {
        Log.i("TAG", "onClick")
    }

}