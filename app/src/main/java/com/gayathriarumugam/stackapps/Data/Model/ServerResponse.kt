package com.gayathriarumugam.stackapps.Data.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ServerResponse: Serializable {

    @SerializedName("items")
    val items: List<Items>? = null

    @SerializedName("has_more")
    val hasMore: Boolean = false

    @SerializedName("quota_max")
    val quotaMax: Long = 0

    @SerializedName("quota_remaining")
    val quotaRemaining: Long = 0
}
