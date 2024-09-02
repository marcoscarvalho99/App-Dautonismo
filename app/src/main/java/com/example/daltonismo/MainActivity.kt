package com.example.daltonismo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.daltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val codigo_Teste1 = 1
    val codigo_Teste2 = 2
    val codigo_Teste3 = 3
    lateinit var binding: ActivityMainBinding

    var dadosMain = DadosMainActivity()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.dados = dadosMain
        val intent = Intent(this, MainActivity2::class.java)
        val param = Bundle()
        binding.button1.setOnClickListener({
            param.putInt("testeDautonismo" , codigo_Teste1)
            intent.putExtras(param)
            startActivityForResult(intent,codigo_Teste1)
        })
        binding.button2.setOnClickListener({
            param.putInt("testeDautonismo" , 2)
            intent.putExtras(param)
            startActivityForResult(intent, codigo_Teste2)
        })
        binding.button3.setOnClickListener({
            param.putInt("testeDautonismo" , 3)
            intent.putExtras(param)
            startActivityForResult(intent,codigo_Teste3)
        })
        binding.ButtonVerificarResultado.setOnClickListener{
            if(binding.dados!!.teste1.equals("74")  && binding.dados!!.teste2.equals("12") && binding.dados!!.teste3.equals("45") ){
                binding.textViewResultadoFinal.text = "Voce não tem daltonismo"
            }
            else if(binding.dados!!.teste1.equals("R1")  && binding.dados!!.teste2.equals("R2") && binding.dados!!.teste3.equals("R3")){
                binding.textViewResultadoFinal.text = "Voce não preencheu todos os campos"
            }
            else{
                binding.textViewResultadoFinal.text = "Voce  tem daltonismo procure um medico"

            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode){
            RESULT_OK->{
                val resultado = data!!.getStringExtra("resultado")
                when(requestCode){

                    codigo_Teste1 ->{
                        binding.dados!!.teste1 = resultado.toString()
                    }
                    codigo_Teste2 ->{
                        binding.dados!!.teste3 = resultado.toString()                    }
                    codigo_Teste3 ->{
                        binding.dados!!.teste2 = resultado.toString()
                    }

                }
                binding.invalidateAll()
            }
            RESULT_CANCELED ->{

            }

        }
    }
}