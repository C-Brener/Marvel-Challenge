package com.caiquebrener.marvelchallenge.comics

import androidx.fragment.app.testing.launchFragmentInContainer
import com.caiquebrener.marvelchallenge.R
import com.caiquebrener.marvelchallenge.ui.fragment.ComicsFragment

open class ComicsTestBase {

    fun getComicsLaunchFragment() {
        launchFragmentInContainer<ComicsFragment>(
            themeResId = R.style.Theme_MarvelChallenge
        )
    }
}