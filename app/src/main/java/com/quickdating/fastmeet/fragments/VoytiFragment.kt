package com.quickdating.fastmeet.fragments


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.quickdating.fastmeet.db.AppDatabase
import com.quickdating.fastmeet.R
import com.quickdating.fastmeet.TvoyProfilActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class VoytiFragment : Fragment() {

    private lateinit var db: AppDatabase
    private lateinit var the_emailEditText: EditText
    private lateinit var the_passEditText: EditText
    private lateinit var the_logInButton: Button
    private lateinit var the_intent1: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_voyti, container, false)

        db = AppDatabase.getInstance(this.requireContext()) as AppDatabase
        the_emailEditText = view.findViewById(R.id.pochta_edit)
        the_passEditText = view.findViewById(R.id.parol_edit)
        the_logInButton = view.findViewById(R.id.voyti_knopka)

        the_logInButton.setOnClickListener {
            isUserInDb(the_emailEditText.text.toString(), the_passEditText.text.toString())
        }

        return view
    }

    @SuppressLint("CheckResult")
    fun isUserInDb(email: String, password: String) {

        Observable.fromCallable{ db.userDao().verifaicate(email,password) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it>0) {
                    the_intent1 = Intent(this.requireContext(), TvoyProfilActivity::class.java)
                    the_intent1.putExtra("log_in", email)
                    the_intent1.putExtra("reg", 0)
                    startActivity(the_intent1)
                } else {
                    Toast.makeText(this.requireContext(), "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
                }
            }

    }




}
