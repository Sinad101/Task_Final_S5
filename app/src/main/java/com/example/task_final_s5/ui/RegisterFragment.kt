package com.example.task_final_s5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.task_final_s5.database.User
import com.example.task_final_s5.databinding.FragmentRegisterBinding
import com.example.task_final_s5.viewmodel.UserViewModel

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertUser()
    }

    private fun insertUser() {
        binding.apply {
            btnRegister.setOnClickListener {
                val username = edtUsername.text.toString()
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()
                val confirmPassword = edtConfirmPassword.text.toString()
                if (username.isNullOrEmpty() || email.isNullOrEmpty() || password.isNullOrEmpty() || confirmPassword.isNullOrEmpty()) {
                    Toast.makeText(
                        requireContext(), "Data tidak boleh kosong!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (password != confirmPassword) {
                    Toast.makeText(
                        requireContext(),
                        "Password tidak sesuai!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val user = User(0, username, email, password)
                    userViewModel.insert(user)
                    reset()
                    Toast.makeText(
                        requireContext(), "Register berhasil",
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigateUp()
                }
            }
        }
    }

    private fun reset() {
        binding.apply {
            edtUsername.setText("")
            edtUsername.clearFocus()
            edtEmail.setText("")
            edtEmail.clearFocus()
            edtPassword.setText("")
            edtPassword.clearFocus()
            edtConfirmPassword.setText("")
            edtConfirmPassword.clearFocus()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}