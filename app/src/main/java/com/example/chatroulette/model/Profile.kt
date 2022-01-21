package com.example.chatroulette.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Profile(
    var name: String? = null,
    var city: String? = null,
    var photo: String? = null
) : Parcelable
