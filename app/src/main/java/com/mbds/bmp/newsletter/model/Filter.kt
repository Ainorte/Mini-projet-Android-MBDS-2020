package com.mbds.bmp.newsletter.model

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import java.io.Serializable

data class Filter(
    @StringRes val nameId: Int,
    val key: String,
    val image: String,
    val fragment: Fragment
) : Serializable