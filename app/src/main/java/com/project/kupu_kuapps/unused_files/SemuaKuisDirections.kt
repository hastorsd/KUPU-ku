package com.project.kupu_kuapps.unused_files

import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.project.kupu_kuapps.R
import com.project.kupu_kuapps.kuis_handlers.Kuis

object SemuaKuisDirections {
    fun actionSemuaKuisToSesiKuis(kuis: Kuis) = Navigation.createNavigateOnClickListener(
        R.id.action_semuaKuis2_to_sesiKuisFragment,
        bundleOf(
            "kuis" to kuis
        )
    )
}
