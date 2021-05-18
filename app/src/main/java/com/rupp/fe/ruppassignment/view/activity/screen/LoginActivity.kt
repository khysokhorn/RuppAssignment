package com.rupp.fe.ruppassignment.view.activity.screen

import android.content.Intent
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.databinding.ActivityLoginBinding
import com.rupp.fe.ruppassignment.modelData.other.LoginDataModel
import com.rupp.fe.ruppassignment.presenter.LoginPresenterImpl
import com.rupp.fe.ruppassignment.view.activity.BaseActivity
import com.rupp.fe.ruppassignment.view.activity.viewInf.LoginView

class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginView {
    override fun getViewBind(): ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    lateinit var loginPresenterImpl: LoginPresenterImpl
    private val REQUEST_CODE = 123
    lateinit var auth: FirebaseAuth

    override fun initView() {
        auth = FirebaseAuth.getInstance()
        loginPresenterImpl = LoginPresenterImpl(LoginDataModel(this))
        binding.btnSignInGoogle.setOnClickListener {
            onGmailLogin()
        }
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, EventListActivity::class.java))
        }
    }

    override fun loadData() {

    }

    override fun onGmailLogin() {
        val signInIntent = loginPresenterImpl.onGmailSign().signInIntent
        startActivityForResult(signInIntent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                Log.d(TAG, "onActivityResult: firebaseAuthWithGoogle id ${account?.id}")
                Log.d(TAG, "onActivityResult: firebaseAuthWithGoogle id ${account?.grantedScopes}")
                Log.d(TAG, "onActivityResult: firebaseAuthWithGoogle id ${account?.serverAuthCode}")
                Log.d(TAG, "onActivityResult: firebaseAuthWithGoogle id ${account?.idToken}")

                firebaseAuthWithGoogle(account?.idToken!!)

            } catch (e: ApiException) {
                Log.e(TAG, "onActivityResult: error with code  ${e.statusCode} and ${e.stackTrace} and ${e.cause}")
                e.printStackTrace()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Log.d(TAG, "firebaseAuthWithGoogle: success ${it.result?.user?.getIdToken(true)}")
                    } else {
                        Log.d(TAG, "firebaseAuthWithGoogle: something went wrong with ${it.exception}")
                    }
                }
    }

}

// get data from firebase test
//        val db = FirebaseFirestore.getInstance()
//        db.collection("profile")
//                .get()
//                .addOnSuccessListener { docmenets ->
//
//                    for (doc in docmenets) {
//
//                        Log.d(TAG, "loadData: ${doc.get("name")}")
//                    }
//                }
//                .addOnFailureListener { exption ->
//                    Log.e(TAG, "loadData: something went wrong with ${exption.message}")
//                }
