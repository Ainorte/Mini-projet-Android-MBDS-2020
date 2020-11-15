package com.mbds.bmp.newsletter.data

import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.model.Category


class HomeData {
    companion object {
        fun getCategoryList() = listOf<Category>(
            Category(R.string.Editeurs, "politic","https://live.staticflickr.com/6053/7003137491_6fdea157f6_b.jpg"),
            Category(R.string.Catégories, "economy","https://cdn.pixabay.com/photo/2017/08/16/15/28/stock-exchange-2648118_1280.jpg"),
            Category(R.string.pays, "ecologic","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTo3G8ojfWSwUpfbOD5iTgVbTvAoNFtQosyUA&usqp=CAU"))
    }
}
