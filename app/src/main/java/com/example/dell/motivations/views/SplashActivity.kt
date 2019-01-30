package com.example.dell.motivations.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dell.motivations.R
import com.example.dell.motivations.util.Constants
import com.example.dell.motivations.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurity = SecurityPreferences(this)
        verifyUserName()

        button_salvar.setOnClickListener {
            handleSave()
        }

    }

    private fun verifyUserName() {
        val userName = mSecurity.getStoredString(Constants.key.PERSON_NAME)
        if (userName != "" ){
            startActivity(Intent(this, MainActivity::class.java))
        }
        editText_name.setText(userName)
    }

    private fun handleSave() {
        val name: String = editText_name.text.toString()
        if (name == "") {
            Toast.makeText(this, getString(R.string.informe_nome), Toast.LENGTH_LONG).show()
        } else {
            mSecurity.storeString(Constants.key.PERSON_NAME, name)

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
