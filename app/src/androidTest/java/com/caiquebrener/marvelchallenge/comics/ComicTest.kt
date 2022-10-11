package com.caiquebrener.marvelchallenge.comics

import com.caiquebrener.marvelchallenge.R
import org.junit.Test


class ComicTest : ComicsTestBase() {

    @Test
    fun ensure_getComics_is_displayed(){
        getComicsLaunchFragment()
        getComics {
            isDisplayed(R.id.teste)
        }
    }
}