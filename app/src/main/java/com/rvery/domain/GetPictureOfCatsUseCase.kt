package com.rvery.domain

import com.rvery.domain.model.PictureOfCat
import com.rvery.domain.repositories.GetPictureOfCatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface GetPictureOfCatsUseCase {
    fun getPictureOfCats() : Flow<List<PictureOfCat>>
}

class GetPictureOfCatsUseCaseImpl @Inject constructor(
    private val repository: GetPictureOfCatsRepository
) : GetPictureOfCatsUseCase {

    override fun getPictureOfCats() : Flow<List<PictureOfCat>> {

        return repository.getPictureOfCats()
            .flowOn(Dispatchers.Main)
    }
}