package com.gayathriarumugam.stackapps.Data.Remote

import com.gayathriarumugam.stackapps.Utils.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    var retrofit: Retrofit? = null
    var constants = Constants()

    //creating the api interface
    val fetchFromAPI: APIFetch?
        get() {
            val database = sharedInstance!!.apiServer()
            if (database != null) {
                return database.create(APIFetch::class.java)
            }
            return null
        }

    //Creating a retrofit object for Address
    fun apiServer(): Retrofit? {
        val baseURL = constants.BASE_URL
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    companion object {
        private var sharedInstance: RetrofitClient? = null
        //Creates a shared instance of RetrofitClient class
        val instance: RetrofitClient
            @Synchronized get() {
                if (sharedInstance == null) {
                    sharedInstance = RetrofitClient()
                }
                return sharedInstance as RetrofitClient
            }
    }
}