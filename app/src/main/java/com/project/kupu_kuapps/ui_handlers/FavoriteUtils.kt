// FavoriteUtils.kt
package com.project.kupu_kuapps.ui_handlers

import android.content.Context
import com.project.kupu_kuapps.kuis_handlers.Kuis

fun saveFavoriteStatus(context: Context, kuisList: List<Kuis>) {
    val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    kuisList.forEach { kuis ->
        editor.putBoolean("favorite_${kuis.nameKuis}", kuis.isFavorited)
    }
    editor.apply()
}

fun loadFavoriteStatus(context: Context, kuisList: List<Kuis>) {
    val sharedPreferences = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
    kuisList.forEach { kuis ->
        kuis.isFavorited = sharedPreferences.getBoolean("favorite_${kuis.nameKuis}", false)
    }
}
