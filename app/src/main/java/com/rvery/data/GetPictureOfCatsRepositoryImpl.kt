package com.rvery.data

import com.rvery.data.datasource.remote.GetPictureOfCatsService
import com.rvery.data.datasource.remote.model.PictureOfCatData
import com.rvery.domain.model.PictureOfCat
import com.rvery.domain.repositories.GetPictureOfCatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPictureOfCatsRepositoryImpl @Inject constructor(
    private val getPictureOfCatsService: GetPictureOfCatsService
) : GetPictureOfCatsRepository {

    override fun getPictureOfCats(): Flow<List<PictureOfCat>> {
        return flow {
            // limit, page and order will be sent by param
            emit(getPictureOfCatsService.getPictureOfCats(50, 10, "Desc")
                .map { mapDataToBO(it) })
        }.flowOn(Dispatchers.IO)
    }

    private fun mapDataToBO(it: PictureOfCatData): PictureOfCat {
        return PictureOfCat(
                createdAt = it.createdAt.orEmpty(),
                height = it.height ?: 0,
                id = it.id.orEmpty(),
                originalFilename = it.originalFilename.orEmpty(),
                subId = it.subId.orEmpty(),
                url = it.url.orEmpty(),
                width = it.width ?: 0
            )
    }
}