package com.gayathriarumugam.stackapps.View

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gayathriarumugam.stackapps.Adapter.MyAdapter
import com.gayathriarumugam.stackapps.Data.Model.Items
import com.gayathriarumugam.stackapps.R
import com.gayathriarumugam.stackapps.ViewModel.ResponseViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), MyAdapter.Listener {

    var adapter: MyAdapter? = null
    var users: ArrayList<Items>? = null
    var viewModel: ResponseViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView!!.layoutManager = LinearLayoutManager(this)

        // Get a new or existing ViewModel from the ViewModelProvider.
        viewModel = ViewModelProviders.of(this).get(ResponseViewModel::class.java)
        viewModel!!.context = this
        btnSearch.setOnClickListener {
            hideKeyboard()
            if (nameEditText.text.isNotEmpty()) {
                Toast.makeText(applicationContext, "Searching!!!", Toast.LENGTH_SHORT).show()
                viewModel!!.fetchResponse(nameEditText.text.toString())
                viewModel!!.items.observe(this, Observer { getItems ->
                    users = getItems as ArrayList<Items>?
                    adapter = MyAdapter(users!!, this)
                    recyclerView!!.adapter = adapter
                })
            }
            else {
                Toast.makeText(
                    applicationContext,
                    "Please enter a name to search",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onItemClick(item: Items) {
        if(recyclerView.adapter != null) {
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("USER", item)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        nameEditText.text.clear()
    }

    //Hides the keyboard
    fun hideKeyboard() {
        val imm = applicationContext?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }
}
