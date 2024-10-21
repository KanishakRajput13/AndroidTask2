package com.example.sitask2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation


class RegistrationFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val signUpButton : Button = view.findViewById(R.id.signUpButton)
        val emailEditText : EditText = view.findViewById(R.id.emailEditText)
        val passwordEditText : EditText = view.findViewById(R.id.passwordEditText)

        signUpButton.setOnClickListener {
            val createPasswordEditText : EditText = view.findViewById(R.id.createPasswordEditText)
            val emailCheck = emailEditText.text.toString()
            val passwordCheck = passwordEditText.text.toString()
            val createPCheck = createPasswordEditText.text.toString()
            if(emailCheck.isEmpty() || passwordCheck.isEmpty() || createPCheck.isEmpty()){
                Toast.makeText(requireContext(), "Fill out all the fields to continue !!!", Toast.LENGTH_SHORT).show()
            }
            else{
                navController.navigate(R.id.action_registrationFragment_to_loginFragment)
                Toast.makeText(requireContext(), "Registration Successful! Please Login to continue", Toast.LENGTH_LONG).show()
            }
        }
        val alreadyAccount : TextView = view.findViewById(R.id.alreadyHaveAccountTextView)
        alreadyAccount.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.homeFragment,false)
                .build()
            navController.navigate(R.id.action_registrationFragment_to_loginFragment,null,navOptions)
        }
        val googleButton : ImageButton = view.findViewById(R.id.googleButton)
        googleButton.setOnClickListener{
            Toast.makeText(requireContext(), "This Feature is not available yet", Toast.LENGTH_SHORT).show()
        }
        val fbButton : ImageButton = view.findViewById(R.id.facebookButton)
        fbButton.setOnClickListener{
            Toast.makeText(requireContext(), "This Feature is not available yet", Toast.LENGTH_SHORT).show()
        }
        val iosButton : ImageButton = view.findViewById(R.id.iosButton)
        iosButton.setOnClickListener{
            Toast.makeText(requireContext(), "This Feature is not available yet", Toast.LENGTH_SHORT).show()
        }
    }
}