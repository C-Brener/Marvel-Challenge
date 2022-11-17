package com.caiquebrener.marvelchallenge.domain.usecase.getcomics.impl

import com.caiquebrener.marvelchallenge.utils.StubFactory
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class GetComicsUseCaseImplTest {
    private val getComicsUseCaseImpl: GetComicsUseCaseImpl = mockk(relaxed = true)
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun `Ensure getComics() return de list comics WHEN parameter provided correctly`() {
        runTest {
            val getComicsReturn = listOf(StubFactory().comicStub())

            coEvery { getComicsUseCaseImpl.getComics(any()) } answers { getComicsReturn }

            val getComics = getComicsUseCaseImpl.getComics("Hulk")

            assert(getComics == getComicsReturn )

        }
    }


}