package com.example.auth.feature

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.auth.R
import com.example.auth.core.base.BaseActivity
import com.example.auth.util.BottomNavigationDrawerFragment
import com.example.auth.util.News
import com.example.auth.util.NewsAdapter
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class MainActivity : BaseActivity() {
    
    override fun obtainLayoutResId()= R.layout.activity_main
    
    @Inject
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setSupportActionBar(bottom_app_bar)

//        App.getAppComponent().inject(this)

        initAdapter()
    }

//    override fun onAuthStateChanged(p0: FirebaseAuth) {
//        val user = mAuth.currentUser
//        if (user == null) {
//            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
//            finish()
//        }
//    }

    private fun initAdapter() {
//        val rv = findViewById<RecyclerView>(R.id.recycler_view)
//        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val news = ArrayList<News>()
        news.add(News(resources.getString(R.string.title1), resources.getString(R.string.body1)))
        news.add(News(resources.getString(R.string.title2), resources.getString(R.string.body2)))
        news.add(News(resources.getString(R.string.title3), resources.getString(R.string.body3)))
        news.add(News(resources.getString(R.string.title4), resources.getString(R.string.body4)))
        news.add(News(resources.getString(R.string.title1), resources.getString(R.string.body1)))

        val adapter = NewsAdapter(news)
//        rv.adapter = adapter
    }

    fun onClickFAB(v: View) {
        displayMaterialSnackBar()
    }

    public override fun onStart() {
        super.onStart()
//        mAuth.addAuthStateListener(this)
    }

    public override fun onStop() {
        super.onStop()
        try {
//            mAuth.removeAuthStateListener(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun displayMaterialSnackBar() {
        val marginSide = 0
        val marginBottom = 220
//        val snackbar = Snackbar.make(
//                main_coordinator_layout,
//                "FAB Clicked",
//                Snackbar.LENGTH_LONG
//        ).setAction("UNDO") {  }

//        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))

//        val snackbarView = snackbar.view
//        val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams
//
//        params.setMargins(
//                params.leftMargin + marginSide,
//                params.topMargin,
//                params.rightMargin + marginSide,
//                params.bottomMargin + marginBottom
//        )
//
//        snackbarView.layoutParams = params
//        snackbar.show()
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
//                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }

}
