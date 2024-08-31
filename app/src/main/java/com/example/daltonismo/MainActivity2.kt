package com.example.daltonismo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.daltonismo.databinding.ActivityMain2Binding
import com.example.daltonismo.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)
         val  tipo_teste =  intent.getIntExtra("testeDautonismo",1)

        when(tipo_teste){
            1 -> {
                binding.imageViewTeste.setImageResource(R.drawable.dal1)


            }
            3 ->{
                binding.imageViewTeste.setImageResource(R.drawable.img)


            }
            2 ->{
                binding.imageViewTeste.setImageResource(R.drawable.img_1)
            }
        }
        binding.buttonCancelar.setOnClickListener{
            setResult(RESULT_CANCELED)
            finish()
        }
        binding.buttonConfirm.setOnClickListener{

            if(binding.editTextNumber.text.isNullOrBlank() || binding.editTextNumber.text.isNullOrEmpty()){
                binding.textView2.text = "Digite um numero"
            }else{

                val intent = Intent()
                intent.putExtra("resultado", binding.editTextNumber.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }

        }



    }
}