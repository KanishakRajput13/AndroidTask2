package com.example.sitask2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class HomeFragment : Fragment() {
        private lateinit var navController: NavController

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            navController=Navigation.findNavController(view)

            val loginButton : Button = view.findViewById(R.id.loginButton)

            loginButton.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_loginFragment4)
            }

            val registerButton : Button = view.findViewById(R.id.registerButton)

            registerButton.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_registrationFragment)
            }
        }
    }