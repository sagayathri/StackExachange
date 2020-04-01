package com.gayathriarumugam.stackapps.ViewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import com.gayathriarumugam.stackapps.Data.Model.Items
import com.gayathriarumugam.stackapps.Data.Model.ServerResponse
import com.gayathriarumugam.stackapps.Data.Remote.RetrofitClient
import com.gayathriarumugam.stackapps.Utils.Constants

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

import java.io.IOException

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer

class ResponseViewModel(application: Application) : AndroidViewModel(application) {

    var context: Context? = null
    var constants: Constants

    var getItemsLiveData: MutableLiveData<List<Items>>? = null
    var myCompositeDisposable: CompositeDisposable? = null

    val items: MutableLiveData<List<Items>>
        get() {
            if (getItemsLiveData == null) {
                getItemsLiveData = MutableLiveData()
            }
            return getItemsLiveData as MutableLiveData<List<Items>>
        }

    init {
        this.constants = Constants()
        myCompositeDisposable = CompositeDisposable()
    }

    // This method is using Retrofit to get the JSON data from URL
    fun fetchResponse(displayName: String) {
        val call = RetrofitClient.instance.fetchFromAPI!!
        myCompositeDisposable?.add(call.getResponse(constants.key, displayName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError))
    }

    fun handleResponse(response: ServerResponse?) {
        if (response != null) {
            val users = response.items
            if(users!!.isNotEmpty()) {
                getItemsLiveData!!.postValue(users)
            }
            else {
                Toast.makeText(context, "Not found!!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun handleError(t: Throwable) {
        Log.e("ERROR:FetchingResponse", t.toString())
    }

    override fun onCleared() {
        super.onCleared()
        myCompositeDisposable?.clear()
    }
}
