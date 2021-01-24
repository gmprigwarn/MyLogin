package com.stou.mylogin6096007544

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    var builder: AlertDialog.Builder? = null
    var txt_login: EditText? = null
    var pass:EditText? = null
    var login_fail : TextView?=null
    var countLogin = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txt_login = findViewById(R.id.username)
        pass = findViewById(R.id.password)
        login_fail = findViewById(R.id.login_fail)
        val login: Button = findViewById(R.id.login)
        login.setOnClickListener {
            if (validateData(txt_login!!, pass!!)){
                if ( Login(txt_login!!,pass!!)){
                    val intent = Intent(this, WelcomeAcitivity::class.java)
                    intent.putExtra("username", txt_login!!.text.toString())
                    startActivity(intent)
                }else{
                    countLogin--
                    if (countLogin==0){
                        val intent = Intent(this, ErrorActivity::class.java)

                        startActivity(intent)
                    }else {
                        login_fail!!.text = "No. of attempts remaining :$countLogin"
                    }
                }
            }
        }
    }
    private  fun Login(name: EditText, pass: EditText) :Boolean{
        if (name.text.toString() != "admin"){
            showDialog("ชื่อผู้ใช้ไม่ถูกต้อง..!!!!")
            name.requestFocus()
            return false
        }
        if (pass.text.toString()!="1234"){
            showDialog("password ไม่ถูกต้อง")
            pass.requestFocus()
            return false
        }
        return true

    }

    private  fun validateData(name: EditText, pass: EditText) :Boolean{
        if (name.text.isEmpty()){
            showDialog("กรุณากรอก username")
            name.requestFocus()
            return false
        }
        if (pass.text.isEmpty()){
            showDialog("กรุณาระบุ password")
            pass.requestFocus()
            return false
        }
        return true
    }
    private  fun showDialog(data: String){
        builder = AlertDialog.Builder(this)
        builder!!.setMessage(data)
            .setCancelable(false)
            .setPositiveButton("ตกลง") { _, _ ->
            }
        val alert = builder!!.create()
        alert.setTitle("Error...!!!!!")
        alert.show()
    }
}