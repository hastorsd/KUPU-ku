package com.project.kupu_kuapps.main_ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Funfact(
    val imageFunfact: Int,
    val descFunfact: String,
) : Parcelable