package com.gayathriarumugam.stackapps.Data.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class BadgeCounts: Serializable {

    @SerializedName("bronze")
    val bronze: Int = 0

    @SerializedName("silver")
    val silver: Int = 0

    @SerializedName("gold")
    val gold: Int = 0

    override fun toString(): String {
        return "Bronze = $bronze, Silver = $silver, Gold = $gold"
    }
}
