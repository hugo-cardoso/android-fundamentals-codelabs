package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Hugo Cardoso");
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.editInfosButton.setOnClickListener { openEditInfos() }
        binding.doneButton.setOnClickListener { saveEditInfos(it) }
    }

    private fun openEditInfos() {
        binding.apply {
            infos.visibility = View.GONE
            infosEdit.visibility = View.VISIBLE
        }
    }

    private fun saveEditInfos(view: View) {
        binding.apply {
            myName?.name = nameEdit.text.toString()
            invalidateAll()
            infosEdit.visibility = View.GONE
            infos.visibility = View.VISIBLE
        }

        hideKeyboard(view)
        showToast("Nome Atualizado")
    }

    private fun showToast(message: String) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    private fun hideKeyboard(view: View) {
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}