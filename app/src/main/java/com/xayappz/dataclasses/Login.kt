package com.xayappz.dataclasses

import android.util.Patterns




data class Login( val email:String,val password:String) {
    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    fun isPasswordLengthGreaterThan5(): Boolean {
        return password.length > 5
    }
}