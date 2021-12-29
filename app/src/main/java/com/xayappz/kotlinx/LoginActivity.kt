package com.xayappz.kotlinx

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.xayappz.dataclasses.Login
import com.xayappz.kotlinx.Singleton.isEven
import com.xayappz.kotlinx.databinding.ActivityLoginBinding
import com.xayappz.viewmodels.LoginViewModel
import java.util.*


class LoginActivity : AppCompatActivity() {

    lateinit var name: String

    lateinit var testHiltString: String
    private var loginViewModel: LoginViewModel? = null

    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView(this@LoginActivity,com.xayappz.kotlinx. R.layout.activity_login)
        binding?.lifecycleOwner = this;
        binding?.loginViewModel = loginViewModel;


        loginViewModel!!.getUser().observe(this, Observer {
            Log.d("DATAT",it.email)
                if (TextUtils.isEmpty(Objects.requireNonNull(it).email)) {
                    binding?.editTextTextEmail?.error = "Enter an E-Mail Address"
                    binding?.editTextTextEmail?.requestFocus()
                } else if (!it.isEmailValid()) {
                    binding?.editTextTextEmail?.error = "Enter a Valid E-mail Address"
                    binding?.editTextTextEmail?.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(it).password)) {
                    binding?.editTextTextPassword?.error = "Enter a Password"
                    binding?.editTextTextPassword?.requestFocus()
                } else if (!it.isPasswordLengthGreaterThan5()) {
                    binding?.editTextTextPassword?.error = "Enter at least 6 Digit password"
                    binding?.editTextTextPassword?.requestFocus()
                } else {
                    Toast.makeText(this@LoginActivity, "Login Success!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

            }
        })


        //check null for lateint

        if (::name.isInitialized) {
            Log.d("NAME", " $name")

        } else {
            name = "My name is Akshay"
        }


        var x = 10
        x.isEven()


        printMsg(3)
        Log.e("Sum is = ", add(3, 5).toString())

    }

    //inline function
    fun add(n1: Int, n2: Int) = n1 + n2

    //default method if we don't pass any number it will take 2 as default
    fun printMsg(count: Int = 2) {
        for (i in 1..count) {

            Log.e("Printing... ", "print $i")

        }
    }

    override fun onResume() {
        super.onResume()

        if (::name.isInitialized) {
            Log.d("NAME", " $name")

        } else {
            name = "My name is Akshay"
        }
    }
}