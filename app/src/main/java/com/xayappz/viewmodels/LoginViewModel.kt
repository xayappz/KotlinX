package com.xayappz.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xayappz.dataclasses.Login


class LoginViewModel : ViewModel() {
    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    private var userMutableLiveData: MutableLiveData<Login>? = null
        fun getUser():MutableLiveData<Login> {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData<Login>()
            }
            return userMutableLiveData as MutableLiveData<Login>
        }

    fun onClick(view: View?) {
        val loginUser = Login(EmailAddress.value.toString(), Password.value.toString())
        Log.d("DATATVM",loginUser.email)
        userMutableLiveData!!.value = loginUser
    }
}