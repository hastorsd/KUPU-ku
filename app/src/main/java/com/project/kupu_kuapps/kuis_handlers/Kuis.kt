package com.project.kupu_kuapps.kuis_handlers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kuis(
    val imageKuis: Int,
    val nameKuis: String,
    val descKuis: String,
    var isFavorited: Boolean = false,
    val destinationId: Int // ID tujuan navigasi
) : Parcelable
