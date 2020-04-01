package com.gayathriarumugam.stackapps.View

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gayathriarumugam.stackapps.Data.Model.Items
import com.gayathriarumugam.stackapps.R
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.row_item.*
import java.util.*

class DetailsActivity : AppCompatActivity() {

    var user: Items? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //Gets the user's data
        user = intent.getSerializableExtra("USER") as Items?

        //Sets up actionbar
        val actionbar = supportActionBar
        //Actionbar title
        actionbar!!.title = user!!.displayName
        //Back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        //Populates UI
        if (user != null) {
            //Loads avatar from URL using Glide
            Glide.with(this).load(user!!.profileImage).into(avatarImageView)

            //Loads all required texts
            displayNameTextView.text = user?.displayName.toString()
            reputationTextView.text = user?.reputation.toString()
            badgesTextView.text = user?.badgeCounts.toString()
            locationTextView.text = user?.location.toString()
            ageTextView.text = getAge()
            creationDateTextView.text = getDate()
        }
    }

    private fun getDate(): String {
        var dateString = ""
        if (user != null) {
            val sdf = java.text.SimpleDateFormat("dd-MM-yyyy")
            val date = Date(user!!.creationDate * 1000)
            dateString = sdf.format(date)
        }
        return dateString
    }

    private fun getAge(): String {
        var ageString = ""
        if (user != null) {
            var calendar = Calendar.getInstance()
            var currentYr:Int = calendar.get(Calendar.YEAR)
            val sdf = java.text.SimpleDateFormat("yyyy")
            val date = Date(user!!.creationDate * 1000)
            var birthdate = sdf.format(date).toInt()
            var age:Int = currentYr - birthdate
            ageString = age.toString()
        }
        return ageString
    }

    //Navigates back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}