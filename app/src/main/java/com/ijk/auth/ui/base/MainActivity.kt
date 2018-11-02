package com.ijk.auth.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.ijk.auth.App
import com.ijk.auth.R
import com.ijk.auth.ui.auth.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), FirebaseAuth.AuthStateListener {

    @Inject
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottom_app_bar)

        App.getAppComponent().inject(this)
    }

    override fun onAuthStateChanged(p0: FirebaseAuth) {
        var user = mAuth.currentUser
        if (user == null) {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }

    fun onClickFAB(v: View){
        displayMaterialSnackBar()
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

    private fun displayMaterialSnackBar() {
        val marginSide = 0
        val marginBottom = 150
        val snackbar = Snackbar.make(
                main_coordinator_layout,
                "FAB Clicked",
                Snackbar.LENGTH_LONG
        ).setAction("UNDO") {  }
        // Changing message text color
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))

        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams

        params.setMargins(
                params.leftMargin + marginSide,
                params.topMargin,
                params.rightMargin + marginSide,
                params.bottomMargin + marginBottom
        )

        snackbarView.layoutParams = params
        snackbar.show()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.app_bar_menu -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }

}
