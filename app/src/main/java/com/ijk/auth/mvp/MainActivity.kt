package com.ijk.auth.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ijk.auth.App
import com.ijk.auth.R
import javax.inject.Inject
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FirebaseAuth.AuthStateListener {

    @Inject
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        App.getAppComponent().inject(this)
    }

    override fun onAuthStateChanged(p0: FirebaseAuth) {
        var user = mAuth.currentUser
        if (user == null) {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }

    public override fun onStart() {
        super.onStart()
        mAuth.addAuthStateListener(this)
    }

    public override fun onStop() {
        super.onStop()
        try {
            mAuth.removeAuthStateListener(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
