package com.project.kupu_kuapps.main_ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.databinding.FragmentSemuaKuisBinding
import com.project.kupu_kuapps.kuis_handlers.Kuis
import com.project.kupu_kuapps.kuis_handlers.KuisAdapter

class SemuaKuis : Fragment() {

    private var _binding: FragmentSemuaKuisBinding? = null
    private val binding get() = _binding!!

    private lateinit var kuisAdapter: KuisAdapter
    private val kuisList = mutableListOf<Kuis>()
    private val displayedKuisList = mutableListOf<Kuis>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSemuaKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Utility function to save favorite status in SharedPreferences
    fun saveFavoriteStatus(context: Context, kuisList: List<Kuis>) {
        val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        kuisList.forEachIndexed { index, kuis ->
            editor.putBoolean("favorite_${kuis.nameKuis}", kuis.isFavorited)
        }
        editor.apply()
    }

    // Utility function to load favorite status from SharedPreferences
    fun loadFavoriteStatus(context: Context, kuisList: List<Kuis>) {
        val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        kuisList.forEach { kuis ->
            kuis.isFavorited = sharedPreferences.getBoolean("favorite_${kuis.nameKuis}", false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kuis
        if (kuisList.isEmpty()) {
            kuisList.addAll(listOf(
                Kuis(
                    R.mipmap.sejarah_indonesia,
                    nameKuis = "Sejarah Indonesia",
                    descKuis = "Asah pengetahuan kamu tentang sejarah negara kita tercinta",
                    destinationId = R.id.action_semuaKuis2_to_indonesiaKuisFragment

                ),
                Kuis(
                    R.mipmap.sejarah_dunia,
                    nameKuis = "Sejarah Dunia",
                    descKuis = "Apakah kamu mengetahui sejarah dunia",
                    destinationId = R.id.action_semuaKuis2_to_sesiKuisFragment

                ),
                Kuis(
                    R.mipmap.olahraga_ski,
                    nameKuis = "Olahraga",
                    descKuis = "Cobalah pengetahuan kamu tentang segala sesuatu di bidang olahraga!",
                    destinationId = R.id.action_semuaKuis2_to_sesiKuisFragment2

                )
                // Tambahkan data lagi disini jika ada tambahan
            ))
            loadFavoriteStatus(requireContext(), kuisList)
        }

        displayedKuisList.addAll(kuisList)

        kuisAdapter = KuisAdapter(displayedKuisList, { kuis ->
            // Handle item click
            findNavController().navigate(kuis.destinationId)
            // Handle item click
        },  { kuis ->
            // Toggle favorite status
            kuis.isFavorited = !kuis.isFavorited
            saveFavoriteStatus(requireContext(), kuisList)
            // Optionally save the favorite status to SharedPreferences or database
        }, { kuis ->
            // Handle button click
            findNavController().navigate(kuis.destinationId)
        })

        val recyclerViewSemuaKuis = binding.semuaKuis
        recyclerViewSemuaKuis.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerViewSemuaKuis.setHasFixedSize(true)
        recyclerViewSemuaKuis.adapter = kuisAdapter

        binding.tombolBackSemuaKuis.setOnClickListener {
            findNavController().navigate(R.id.action_semuaKuis2_to_navigationParentFragment)
        }

        setupSearchView()

        // Disable back button
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Do nothing to disable back button
            }
        })
    }

    private fun setupSearchView() {
        binding.searchSemuaKuis.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // No action needed for this use case
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterKuisList(newText)
                return true
            }
        })
    }

    private fun filterKuisList(query: String?) {
        displayedKuisList.clear()
        if (query.isNullOrEmpty()) {
            displayedKuisList.addAll(kuisList)
        } else {
            val lowerCaseQuery = query.lowercase()
            val filteredList = kuisList.filter {
                it.nameKuis.lowercase().contains(lowerCaseQuery) || it.descKuis.lowercase().contains(lowerCaseQuery)
            }
            displayedKuisList.addAll(filteredList)
        }
        kuisAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}