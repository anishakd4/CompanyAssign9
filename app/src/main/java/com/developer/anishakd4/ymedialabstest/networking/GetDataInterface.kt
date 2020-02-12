package com.developer.anishakd4.ymedialabstest.networking

import com.developer.anishakd4.ymedialabstest.models.MainModel
import com.developer.anishakd4.ymedialabstest.models.VariantsModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataInterface {

    @GET("bins/1dh1hi")
    fun getData(): Deferred<MainModel>

}