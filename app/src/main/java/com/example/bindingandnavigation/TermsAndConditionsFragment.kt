package com.example.bindingandnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bindingandnavigation.databinding.FragmentSettingsBinding
import com.example.bindingandnavigation.databinding.FragmentTermsAndConditionsBinding
import com.example.bindingandnavigation.databinding.FragmentWelcomeBinding

class TermsAndConditionsFragment: Fragment(R.layout.fragment_terms_and_conditions) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentTermsAndConditionsBinding = FragmentTermsAndConditionsBinding.inflate(inflater , container , false)

        return binding.root
    }
}