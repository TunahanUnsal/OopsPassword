package com.ezdream.password.ui.pageB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ezdream.password.databinding.FragmentBBinding
import com.ezdream.password.model.PasswordModel
import com.ezdream.password.util.UiUtil.hideKeyboard
import com.ezdream.password.util.UiUtil.showSnackBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BFragment : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<BFragmentVM>()
    private val args by navArgs<BFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.passwordModel = viewModel.passwordModel.value

        if (args.passwordId != -1) {
            viewModel.getPassword(args.passwordId)
        }

        viewModel.passwordModel.observe(viewLifecycleOwner) {
            binding.title.setText(it.title)
            binding.username.setText(it.username)
            binding.password.setText(it.password)
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.save.setOnClickListener {

            val title = binding.title.text.trim().toString()
            val id = binding.username.text.trim().toString()
            val password = binding.password.text.toString()

            if (args.passwordId == -1) {
                viewModel.addNewPassword(
                    PasswordModel(
                        title = title,
                        username = id,
                        password = password
                    )
                )
                activity?.let { it1 -> hideKeyboard(it1) }
                showSnackBar(binding.root, "Added")
                findNavController().popBackStack()
            } else {
                viewModel.updatePassword(
                    PasswordModel(
                        id = viewModel.passwordModel.value!!.id,
                        title = title,
                        username = id,
                        password = password
                    )
                )
            }
            activity?.let { it1 -> hideKeyboard(it1) }
            showSnackBar(binding.root, "Updated")
            findNavController().popBackStack()
        }

        binding.delete.setOnClickListener {
            if (args.passwordId != -1) {
                viewModel.deletePassword()
                activity?.let { it1 -> hideKeyboard(it1) }
                showSnackBar(binding.root, "Deleted")
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}