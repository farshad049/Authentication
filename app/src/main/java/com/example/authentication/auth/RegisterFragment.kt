package com.example.authentication.auth

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.authentication.R
import com.example.authentication.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : BaseFragment(R.layout.fragment_register) {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterBinding.bind(view)



//        binding.tvLogin.setOnClickListener {
//            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
//        }



        binding.BtnRegister.setOnClickListener {
            validateFields()
        }


    }//FUN

    //validate fields
    private fun validateFields() {
        val name = binding.etEditFirstName.text.toString().trim()
        val lastName = binding.etEditLastName.text.toString().trim()
        val email = binding.etEditEmail.text.toString().trim()
        val password = binding.etEditPassword.text.toString().trim()
        val confirm = binding.etEditConfirm.text.toString().trim()

        when {
            name.isEmpty() -> {
                binding.etFirstName.error = "* please enter your name"
                binding.etEditFirstName.addTextChangedListener { binding.etFirstName.error = null }
                return
            }
            lastName.isEmpty() -> {
                binding.etLastName.error = "* please enter your last name"
                binding.etEditLastName.addTextChangedListener { binding.etLastName.error = null }
                return
            }
            email.isEmpty() || !(Patterns.EMAIL_ADDRESS.matcher(email).matches()) -> {
                binding.etEmail.error = "* please enter a valid email address"
                binding.etEditEmail.addTextChangedListener { binding.etEmail.error = null }
                return
            }
            password.isEmpty() -> {
                binding.etPassword.error = "* please enter a password"
                binding.etEditPassword.addTextChangedListener { binding.etPassword.error = null }
                return
            }
            password.length < 8 ||
                    !password.matches(".*[A-Z].*".toRegex()) ||
                    !password.matches(".*[a-z].*".toRegex()) ||
                    !password.matches(".*[0-9].*".toRegex())
            -> {
                binding.etPassword.error =
                    "* more than 8 character, include small and big character and number"
                binding.etEditPassword.addTextChangedListener { binding.etPassword.error = null }
                return
            }
            confirm.isEmpty() -> {
                binding.etConfirm.error = "* please confirm password"
                binding.etEditConfirm.addTextChangedListener { binding.etConfirm.error = null }
                return
            }
            confirm != password -> {
                binding.etConfirm.error = "* password Doesn't match"
                binding.etEditConfirm.addTextChangedListener { binding.etConfirm.error = null }
                return
            }
            !binding.checkAgree.isChecked -> {
                Snackbar.make(
                    mainActivity.findViewById(android.R.id.content),
                    "please check the agreement",
                    Snackbar.LENGTH_LONG
                ).show()
                return
            }
            else -> {



            }
        }
    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}