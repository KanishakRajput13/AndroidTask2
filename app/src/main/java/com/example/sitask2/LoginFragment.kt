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


class LoginFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val forgotPassword: TextView = view.findViewById(R.id.forgotPasswordTextView)
        forgotPassword.setOnClickListener {
            Toast.makeText(requireContext(), "You cannot login without password", Toast.LENGTH_LONG)
                .show()
        }

        val createAccount: TextView = view.findViewById(R.id.createAccountTextView)
        createAccount.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.homeFragment,false)
                .build()
            navController.navigate(R.id.action_loginFragment_to_registrationFragment, null,navOptions)

        }

        val signInButton: Button = view.findViewById(R.id.signInButton)
        val emailEditText: EditText = view.findViewById(R.id.emailEditText)
        val passwordEditText: EditText = view.findViewById(R.id.passwordEditText)
        signInButton.setOnClickListener {
            val emailCheck = emailEditText.text.toString()
            val passwordCheck = passwordEditText.text.toString()
            if (emailCheck.isEmpty() || passwordCheck.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Fill out all the fields to continue !!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                navController.navigate(R.id.action_loginFragment_to_homeFragment)
                Toast.makeText(requireContext(), "Logged In Successfully", Toast.LENGTH_LONG).show()
            }
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