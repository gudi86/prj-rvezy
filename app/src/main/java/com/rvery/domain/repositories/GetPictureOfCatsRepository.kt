package com.rvery.domain.repositories

import com.rvery.domain.model.PictureOfCat
import kotlinx.coroutines.flow.Flow

interface GetPictureOfCatsRepository {
    fun getPictureOfCats() : Flow<List<PictureOfCat>>
}