package com.example.auth.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.auth.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_bottom_navigation_drawer.*
import javax.inject.Inject

class BottomNavigationDrawerFragment: BottomSheetDialogFragment() {

    @Inject
    lateinit var mAuth: FirebaseAuth

    lateinit var mImageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false)

        mImageView = view.findViewById(R.id.image_view_toolbar)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        App.getAppComponent().inject(this)

//        navigation_view.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.item_log_out -> onLogOut()
//                R.id.item_settings -> showMessage("Settings...")
//                R.id.item_profile -> showMessage("Your profile...")
//            }
//            true
//        }

//        disableNavigationViewScrollbars(navigation_view)

        initUserView()
    }

    private fun initUserView(){

        text_view_name_user.text = mAuth.currentUser!!.displayName.toString()
        text_view_email_user.text = mAuth.currentUser!!.email.toString()

        Picasso.get()
                .load(mAuth.currentUser!!.photoUrl)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(mImageView)
    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
//
//        dialog.setOnShowListener { listener ->
//            val d = listener as BottomSheetDialog
//
//            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
//            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
//            bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
//                override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                    if (slideOffset > 0.5) {
//                    }
//                }
//                override fun onStateChanged(bottomSheet: View, newState: Int) {
//                    when (newState) {
//                        BottomSheetBehavior.STATE_HIDDEN-> dismiss()
//                    }
//                }
//            })
//        }
//        return dialog
//    }

//    private fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
//        val navigationMenuView = navigationView?.getChildAt(0) as NavigationMenuView
//        navigationMenuView.isVerticalScrollBarEnabled = false
//    }

    private fun onLogOut() {
        try {
            mAuth.signOut()
        } catch (e: Exception) {
        }
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
        this.dismiss()
    }

}