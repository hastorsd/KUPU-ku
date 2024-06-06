package com.project.kupu_kuapps.main_ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "Guest")
        val imageUrl = sharedPreferences.getString("image_url", null)

        binding.usernameTextView.text = username
        if (imageUrl != null) {
            // Load image using Glide
            Glide.with(this).load(imageUrl).into(binding.profileImageView)
        }

        binding.editProfileButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigationParentFragment_to_editProfileFragment)
        }

        binding.logoutButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigationParentFragment_to_loginFragment)
        }

        // Disable back button
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do nothing to disable back button
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
