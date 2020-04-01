package com.gayathriarumugam.stackapps.Data.Remote

import com.gayathriarumugam.stackapps.Data.Model.ServerResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIFetch {
    @GET("users?pagesize=20&order=asc&sort=name&site=stackapps")
    fun getResponse(
        @Query("key") key: String,
        @Query("inname") name: String
    ): Single<ServerResponse>
}
