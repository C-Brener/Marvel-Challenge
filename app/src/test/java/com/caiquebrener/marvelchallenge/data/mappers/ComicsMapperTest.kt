package com.caiquebrener.marvelchallenge.data.mappers

import com.caiquebrener.marvelchallenge.utils.StubFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test


class ComicsMapperTest{
    private var mapper:ComicsMapper = mockk(relaxed = true)

    @Test
    fun `Ensure toComicsModel() converter Comic in the ComicsModel`(){
        val comic = StubFactory().comicStub()
        val expected = listOf(StubFactory().comicsModelStub())

        every { mapper.toComicsModel(any()) } answers { expected }

        val mapped = mapper.toComicsModel(listOf(comic))

        assert(mapped == expected)
    }
}