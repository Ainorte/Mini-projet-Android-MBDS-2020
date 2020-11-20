package com.mbds.bmp.newsletter.model

import java.io.Serializable

class SourceNewsApiResponse(
    status: String,
    sources: List<Editor>
) : Serializable