package com.project.kupu_kuapps.main_ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentFavoriteBinding
import com.project.kupu_kuapps.kuis_handlers.Kuis
import com.project.kupu_kuapps.kuis_handlers.KuisAdapter

class Favorite : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var kuisAdapter: KuisAdapter
    private val kuisList = mutableListOf<Kuis>()
    private val favoriteKuisList = mutableListOf<Kuis>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Utility function to load favorite status from SharedPreferences
    private fun loadFavoriteStatus(context: Context, kuisList: List<Kuis>) {
        val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        kuisList.forEach { kuis ->
            kuis.isFavorited = sharedPreferences.getBoolean("favorite_${kuis.nameKuis}", false)
        }
    }

    private fun loadKuisData() {
        kuisList.clear() // Clear the list to prevent duplication
        kuisList.addAll(listOf(
            Kuis(
                R.mipmap.sejarah_indonesia,
                nameKuis = "Sejarah Indonesia",
                descKuis = "Asah pengetahuan kamu tentang sejarah negara kita tercinta",
                destinationId = R.id.action_navigationParentFragment_to_indonesiaKuisFragment // Check this ID
            ),
            Kuis(
                R.mipmap.sejarah_dunia,
                nameKuis = "Sejarah Dunia",
                descKuis = "Apakah kamu mengetahui sejarah dunia",
                destinationId = R.id.action_navigationParentFragment_to_sesiKuisFragment // Check this ID
            ),
            Kuis(
                R.mipmap.olahraga_ski,
                nameKuis = "Olahraga",
                descKuis = "Cobalah pengetahuan kamu tentang segala sesuatu di bidang olahraga!",
                destinationId = R.id.action_navigationParentFragment_to_sesiKuisFragment2 // Check this ID
            )
            // Tambahkan data lagi di sini jika ada tambahan
        ))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load data kuis
        loadKuisData()

        // Load favorite kuis
        loadFavoriteStatus(requireContext(), kuisList)
        favoriteKuisList.clear() // Clear the list to prevent duplication
        favoriteKuisList.addAll(kuisList.filter { it.isFavorited })

        kuisAdapter = KuisAdapter(favoriteKuisList, { kuis ->
            // Handle item click
            findNavController().navigate(kuis.destinationId)
        }, { kuis ->
            // Toggle favorite status
            kuis.isFavorited = !kuis.isFavorited
            saveFavoriteStatus(requireContext(), kuisList)
            // Update the favorite list
            favoriteKuisList.clear()
            favoriteKuisList.addAll(kuisList.filter { it.isFavorited })
            kuisAdapter.notifyDataSetChanged()
        }, { kuis ->
            // Handle button click
            findNavController().navigate(kuis.destinationId)
        })

        val recyclerViewFavoriteKuis = binding.rvFavoriteKuis
        recyclerViewFavoriteKuis.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerViewFavoriteKuis.setHasFixedSize(true)
        recyclerViewFavoriteKuis.adapter = kuisAdapter

        // Disable back button
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do nothing to disable back button
            }
        })
    }

    // Utility function to save favorite status in SharedPreferences
    private fun saveFavoriteStatus(context: Context, kuisList: List<Kuis>) {
        val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        kuisList.forEachIndexed { index, kuis ->
            editor.putBoolean("favorite_${kuis.nameKuis}", kuis.isFavorited)
        }
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
