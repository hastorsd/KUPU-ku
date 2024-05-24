package com.project.kupu_kuapps.main_ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentEditProfileBinding

class EditProfileFragment : Fragment() {
    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!
    private val PICK_IMAGE_REQUEST = 1
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "")
        val imageUrl = sharedPreferences.getString("image_url", null)

        binding.usernameEditText.setText(username)
        if (imageUrl != null) {
            Glide.with(this).load(imageUrl).into(binding.profileImageView)
        }

        binding.uploadImageButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        binding.saveButton.setOnClickListener {
            val newUsername = binding.usernameEditText.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("username", newUsername)
            imageUri?.let { uri ->
                editor.putString("image_url", uri.toString())
            }
            editor.apply()
            findNavController().navigateUp()
        }

        binding.tombolBackEditProfil.setOnClickListener {
            findNavController().navigate(R.id.action_editProfileFragment_to_navigationParentFragment)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUri = data.data
            binding.profileImageView.setImageURI(imageUri)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
