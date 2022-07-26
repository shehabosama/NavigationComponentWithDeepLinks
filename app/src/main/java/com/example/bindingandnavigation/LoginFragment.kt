package com.example.bindingandnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bindingandnavigation.databinding.FragmentLoginBinding

class LoginFragment: Fragment(R.layout.fragment_login) {

    private val args:LoginFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentLoginBinding = FragmentLoginBinding.inflate(inflater , container , false)
        val usernameDeepLink = args.username
        binding.username.setText(usernameDeepLink)
        binding.btnLogin.setOnClickListener {
            val username:String = binding.username.text.toString()
            val password:String = binding.password.text.toString()

            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username , password)
            findNavController().navigate(action)
        }
        return binding?.root
    }
}