package com.sbk.kotlingezegenkilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val kilo_to_pound =2.2045
    val Mars = 0.38
    val pound_to_kilo = 0.4536

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var kullanicikg = edKilo.text

       btnKg.setOnClickListener {
          var kullaniciAgirlikPound = kiloToPound(kullanicikg.toString().toDouble())

          var marstaAgirlikPound=kullaniciAgirlikPound*Mars

          var marstaAgirlikKio=poundToKilo(marstaAgirlikPound)

           txtSonuc.text=marstaAgirlikKio.formatla(4)


           }

    }

    fun kiloToPound(kilo: Double): Double{

        return kilo*kilo_to_pound
    }

    fun poundToKilo(pound : Double):Double{
        return pound*pound_to_kilo
    }

    fun Double.formatla(kacRakam:Int)=java.lang.String.format("%.${kacRakam}f",this)
}
