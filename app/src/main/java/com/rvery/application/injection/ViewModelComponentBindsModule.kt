package com.rvery.application.injection

import com.rvery.data.GetPictureOfCatsRepositoryImpl
import com.rvery.domain.GetPictureOfCatsUseCase
import com.rvery.domain.GetPictureOfCatsUseCaseImpl
import com.rvery.domain.repositories.GetPictureOfCatsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelComponentBindsModule {

    @Binds
    abstract fun bindFetchListPictureOfDayRepository(
        getPictureOfCatsRepositoryImpl: GetPictureOfCatsRepositoryImpl
    ) : GetPictureOfCatsRepository

    @Binds
    abstract fun bindFetchPicturesOfDayUseCase(
        fetchPicturesOfDayUseCaseImpl: GetPictureOfCatsUseCaseImpl
    ) : GetPictureOfCatsUseCase
}