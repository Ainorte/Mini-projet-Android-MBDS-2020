package com.mbds.bmp.newsletter.data

import com.mbds.bmp.newsletter.R
import com.mbds.bmp.newsletter.fragments.CategoriesFragment
import com.mbds.bmp.newsletter.fragments.CountriesFragment
import com.mbds.bmp.newsletter.fragments.EditorsFragment
import com.mbds.bmp.newsletter.model.Category
import com.mbds.bmp.newsletter.model.Country
import com.mbds.bmp.newsletter.model.Filter

class Data {
    companion object {
        fun getCategoryList() = listOf<Category>(
            Category(
                R.string.politic,
                "politic",
                "https://live.staticflickr.com/6053/7003137491_6fdea157f6_b.jpg"
            ),
            Category(
                R.string.economy,
                "economy",
                "https://cdn.pixabay.com/photo/2017/08/16/15/28/stock-exchange-2648118_1280.jpg"
            ),
            Category(
                R.string.education,
                "education",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS-yXHazNZII-J47VvcZxYZyl8ees-SoQcFrw&usqp=CAU"
            ),
            Category(
                R.string.pandemic,
                "pandemic",
                "https://etaples-sur-mer.fr/wp-content/uploads/2020/03/coronavirus-4914026_960_720.jpg"
            ),
            Category(
                R.string.sciences,
                "science",
                "https://cdn.pixabay.com/photo/2016/02/06/09/56/science-1182713_1280.jpg"
            ),
            Category(
                R.string.ecology,
                "ecologic",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTo3G8ojfWSwUpfbOD5iTgVbTvAoNFtQosyUA&usqp=CAU"
            )
        )

        fun getFilterList() = listOf<Filter>(
            Filter(
                R.string.countries,
                "countries",
                "https://c.pxhere.com/images/be/03/3f5b737ae10b7d18a40b198c0f2c-1585107.jpg!d",
                CountriesFragment()
            ),
            Filter(
                R.string.categories,
                "categories",
                "https://cdn.pixabay.com/photo/2015/07/03/12/41/the-text-of-the-830139_960_720.jpg",
                CategoriesFragment()
            ),
            Filter(
                R.string.editors,
                "editors",
                "https://c.pxhere.com/photos/8a/15/news_matrimonial_news_paper_marriage_business_bride_groom_job-602904.jpg!d",
                EditorsFragment()
            )
        )

        fun getCountryList() = listOf<Country>(
            Country(R.string.arab, "ar", ""),
            Country(R.string.german, "de", ""),
            Country(R.string.english, "en", ""),
            Country(R.string.spanish, "es", ""),
            Country(R.string.french, "fr", ""),
            Country(R.string.hebrew, "he", ""),
            Country(R.string.italian, "it", ""),
            Country(R.string.dutch, "nl", ""),
            Country(R.string.norwegian, "no", ""),
            Country(R.string.portuguese, "pt", ""),
            Country(R.string.russian, "ru", ""),
            Country(R.string.chinese, "zh", "")
        )
    }
}