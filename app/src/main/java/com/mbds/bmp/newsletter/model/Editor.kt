package com.mbds.bmp.newsletter.model

import java.io.Serializable

class Editor(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String
) : Serializable