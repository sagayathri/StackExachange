package com.gayathriarumugam.stackapps.Data.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Items: Serializable {

    @SerializedName("badge_counts")
    val badgeCounts: BadgeCounts? = null

    @SerializedName("account_id")
    val accountID: Long = 0

    @SerializedName("is_employee")
    val isEmployee: Boolean = false

    @SerializedName("last_access_date")
    val lastAccessDate: Long = 0

    @SerializedName("reputation_change_year")
    val reputationChangeYear: Long = 0

    @SerializedName("reputation_change_quarter")
    val reputationChangeQuarter: Long = 0

    @SerializedName("reputation_change_month")
    val reputationChangeMonth: Long = 0

    @SerializedName("reputation_change_week")
    val reputationChangeWeek: Long = 0

    @SerializedName("reputation_change_day")
    val reputationChangeDay: Long = 0

    @SerializedName("reputation")
    val reputation: Long = 0

    @SerializedName("creation_date")
    val creationDate: Long = 0

    @SerializedName("user_type")
    val userType: String? = null

    @SerializedName("user_id")
    val userID: Long = 0

    @SerializedName("location")
    val location: String? = null

    @SerializedName("link")
    val link: String? = null

    @SerializedName("profile_image")
    val profileImage: String? = null

    @SerializedName("display_name")
    val displayName: String? = null

    @SerializedName("last_modified_date")
    val lastModifiedDate: Long? = null

    @SerializedName("website_url")
    val websiteURL: String? = null

    override fun toString(): String {
        return "Items(badgeCounts=$badgeCounts, accountID=$accountID, isEmployee=$isEmployee, " +
                "lastAccessDate=$lastAccessDate, reputationChangeYear=$reputationChangeYear, " +
                "reputationChangeQuarter=$reputationChangeQuarter, reputationChangeMonth=$reputationChangeMonth, " +
                "reputationChangeWeek=$reputationChangeWeek, reputationChangeDay=$reputationChangeDay, " +
                "reputation=$reputation, creationDate=$creationDate, userType=$userType, userID=$userID, " +
                "location=$location, link=$link, profileImage=$profileImage, displayName=$displayName, " +
                "lastModifiedDate=$lastModifiedDate, websiteURL=$websiteURL)"
    }
}
