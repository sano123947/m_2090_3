package ru.geekbraines.m_2090_3.viewmodel

import ru.geekbraines.m_2090_3.model.PictureOfTheDayResponseData

sealed class AppState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData): AppState()
    data class Error(val error: Throwable): AppState()
    object Loading:AppState()
}