package com.sbk.kotlingezegenkilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    val kilo_to_pound =2.2045
    val Mars = 0.38
    val pound_to_kilo = 0.4536
    val Jupiiter =2.34
    val Venus = 0.91

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(R.drawable.gezegen).into(imageView) // resim yükleme

        txtSonuc.text=savedInstanceState?.getString("sonuc")//ekran döndüğünde text değerinin korunmasını sağlar

        chVenus.setOnClickListener(this)
        chMasr.setOnClickListener(this)
        chJupiter.setOnClickListener(this)


      /* btnKg.setOnClickListener {
          var kullaniciAgirlikPound = kiloToPound(kullanicikg.toString().toDouble())

          var marstaAgirlikPound=kullaniciAgirlikPound*Mars

          var marstaAgirlikKio=poundToKilo(marstaAgirlikPound)

           txtSonuc.text=marstaAgirlikKio.formatla(4)


           }*/

    }

    fun kiloToPound(kilo: Double): Double{

        return kilo*kilo_to_pound
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("sonuc",txtSonuc.text.toString())

//ekran döndüğünde text değerinin korunmasını sağlar
    }

    fun poundToKilo(pound : Double):Double{
        return pound*pound_to_kilo
    }

    fun Double.formatla(kacRakam:Int)=java.lang.String.format("%.${kacRakam}f",this)


    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked : Boolean =v.isChecked

        if(!TextUtils.isEmpty(edKilo.text.toString())){

            var kullaniciKilo=edKilo.text.toString().toDouble()
            var kullaniciPound=kiloToPound(kullaniciKilo)

            when(v.id){

                R.id.chMasr -> if(isChecked){
                    chJupiter.isChecked=false
                    chVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
                R.id.chJupiter -> if(isChecked){
                    chMasr.isChecked=false
                    chVenus.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
                R.id.chVenus -> if(isChecked){
                    chMasr.isChecked=false
                    chJupiter.isChecked=false
                    hesaplaAgirlikPound(kullaniciPound,v)
                }
            }

        }


    }
    fun hesaplaAgirlikPound(pound: Double,checkBox: CheckBox){
        var sonuc : Double =0.0
        when(checkBox.id){
            R.id.chMasr->sonuc=pound*Mars
            R.id.chJupiter->sonuc=pound*Jupiiter
            R.id.chVenus->sonuc=pound*Venus
            else -> sonuc=0.0
        }

        var sonucToKilo=poundToKilo(sonuc)
        txtSonuc.text=sonucToKilo.formatla(3)
    }

}
