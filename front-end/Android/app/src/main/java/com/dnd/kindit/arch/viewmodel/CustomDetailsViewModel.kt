package com.dnd.kindit.arch.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dnd.kindit.retrofit.RetrofitClient
import com.dnd.kindit.retrofit.domain.response.CommonResponse
import com.dnd.kindit.retrofit.domain.response.CustomDetailResponse
import com.dnd.kindit.util.PreferenceManager
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response

class CustomDetailsViewModel : ViewModel() {
    private val TAG = this.javaClass.toString()

    private val _detailMenu = MutableLiveData<CustomDetailResponse>()

    val detailMenu: LiveData<CustomDetailResponse>
        get() = _detailMenu

    fun getMenuDetail(context: Context, id: Int){
        val token = PreferenceManager.getString(context, "kindit_token").toString()
        
        val menuService = RetrofitClient.kindItSearchService()
        val menuCall = menuService.getMenuDetail(token, id)
        
        menuCall.enqueue(object : retrofit2.Callback<CustomDetailResponse>{
            override fun onFailure(call: Call<CustomDetailResponse>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }

            override fun onResponse(call: Call<CustomDetailResponse>, response: Response<CustomDetailResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody?.result == "success") {
                        _detailMenu.value = responseBody
                        Log.d("test", responseBody.toString())
                    }
                } else {
                    val responseErrorBody = GsonBuilder().create()
                        .fromJson(response.errorBody()?.string(), CommonResponse::class.java)
                    Log.d(TAG, responseErrorBody.toString())
                    // 실패 없음
                }
            }
        })
    }
}