package com.mbds.bmp.newsletter.model

import androidx.annotation.StringRes
import java.io.Serializable

data class Country (@StringRes val nameId: Int, val key: String, val image: String) : Serializable{}