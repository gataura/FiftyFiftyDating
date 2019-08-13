package com.quickdating.fastmeet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quickdating.fastmeet.fragments.GlavnayaInfaFragment
import com.quickdating.fastmeet.fragments.ZaregatFragment
import com.quickdating.fastmeet.fragments.VoytiFragment

class CheAnketaCheLiActivity : AppCompatActivity() {


    private var fragmentMain = androidx.fragment.app.Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_che_anketa_che_li)

        if (intent.getStringExtra("action") == "registration") {
            fragmentMain = ZaregatFragment()
        }

        if (intent.getStringExtra("action") == "facebook_login"){
            fragmentMain = GlavnayaInfaFragment()
        }

        if (intent.getStringExtra("action") == "sign_in") {
            fragmentMain = VoytiFragment()
        }
        setFragment(fragmentMain)
    }

    private fun setFragment(f: androidx.fragment.app.Fragment) {

        val fm: androidx.fragment.app.FragmentManager = supportFragmentManager
        val ft: androidx.fragment.app.FragmentTransaction = fm.beginTransaction()

        ft.replace(R.id.question_container, f)
        ft.commit()

    }
}
