package com.example.authentication.auth

import android.os.Bundle
import android.view.View
import com.example.authentication.R
import com.example.authentication.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar


class LoginFragment: BaseFragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding=FragmentLoginBinding.bind(view)


//        binding.tvRegister.setOnClickListener {
//            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
//        }
//
//        binding.tvForgetPassword.setOnClickListener {
//            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgetPasswordFragment())
//        }


        binding.btnLogin.setOnClickListener {
            val email = binding.etEditLoginEmail.text.toString().trim()
            val password = binding.etEditLoginPassword.text.toString().trim()

            when {
                email.isEmpty() -> {
                    Snackbar.make(
                        mainActivity.findViewById(android.R.id.content),
                        "please enter name",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                password.isEmpty() -> {
                    Snackbar.make(
                        mainActivity.findViewById(android.R.id.content),
                        "please enter name",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                else -> {


                }
            }
        }






    }//FUN






    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}