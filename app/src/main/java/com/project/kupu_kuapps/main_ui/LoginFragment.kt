package com.project.kupu_kuapps.main_ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.database.DatabaseHelper
import com.project.kupu_kuapps.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = DatabaseHelper(requireContext())

        binding.buttonLogin.setOnClickListener {
            val email = binding.logEmail.text.toString()
            val password = binding.logPassword.text.toString()

            if (dbHelper.checkUser(email, password)) {
                Toast.makeText(context, "Login berhasil!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment)
            } else {
                Toast.makeText(context, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buatAkun.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
