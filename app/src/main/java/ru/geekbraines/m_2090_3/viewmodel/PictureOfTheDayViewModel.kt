package ru.geekbraines.m_2090_3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbraines.m_2090_3.BuildConfig
import ru.geekbraines.m_2090_3.model.PictureOfTheDayResponseData
import ru.geekbraines.m_2090_3.model.RepositoryImpl

class PictureOfTheDayViewModel( private val liveData: MutableLiveData<AppState>, private val repositoryImpl: RepositoryImpl = RepositoryImpl()):
    ViewModel() {

    fun getLiveData(): MutableLiveData<AppState>{
        //
        return liveData
    }

     fun sentRequest(){
         liveData.postValue(AppState.Loading)
         repositoryImpl.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_API_KEY).enqueue(Callback)
     }

    private val Callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>,
        ) {
            if (response.isSuccessful){
                liveData.postValue(AppState.Success(response.body()!!))
            }else{
                liveData.postValue(AppState.Error(throw java.lang.IllegalStateException("что-то пошло не так")))
            }
            response.body()!!
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
           // TODO HW
        }

    }
}







