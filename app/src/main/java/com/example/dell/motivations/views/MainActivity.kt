package com.example.dell.motivations.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dell.motivations.R
import com.example.dell.motivations.mock.Mock
import com.example.dell.motivations.util.Constants
import com.example.dell.motivations.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = Constants.PHRASE_FILTER.ALL
    private lateinit var mSecurityPreferences: SecurityPreferences
    private val mMock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSecurityPreferences = SecurityPreferences(this)
        setListener()

        handleFilter(R.id.imageAll)
        refreshPrase()
        verifyUserNme()
    }


    override fun onClick(view: View) {
        val id = view.id

        val listId = listOf(R.id.imageAll, R.id.imageSun, R.id.imageHappy)
        if (id in listId) {
            handleFilter(id)
        } else if (id == R.id.buttonNewPhrase){
            refreshPrase()
        }
    }

    private fun refreshPrase() {
        textPhrase.text = mMock.getPhrase(mFilter)
    }

    private fun handleFilter(id: Int) {
        imageAll.setImageResource(R.drawable.ic_all_unselected)
        imageSun.setImageResource(R.drawable.ic_sunny_unselected)
        imageHappy.setImageResource(R.drawable.ic_happy_unselected)

        if (id == R.id.imageAll) {
            mFilter = Constants.PHRASE_FILTER.ALL
            imageAll.setImageResource(R.drawable.ic_all_selected)

        } else if (id == R.id.imageSun) {
            mFilter = Constants.PHRASE_FILTER.SUN
            imageSun.setImageResource(R.drawable.ic_sunny_selected)

        } else {
            mFilter = Constants.PHRASE_FILTER.HAPPY
            imageHappy.setImageResource(R.drawable.ic_happy_selected)
        }
    }

    private fun setListener() {
        imageAll.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)
    }

    private fun verifyUserNme() {
        textUsername.text = mSecurityPreferences.getStoredString(Constants.key.PERSON_NAME)
    }



}
