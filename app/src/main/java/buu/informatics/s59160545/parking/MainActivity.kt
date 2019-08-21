package buu.informatics.s59160545.parking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160545.parking.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val park1:ParkCar = ParkCar()
    private val park2:ParkCar = ParkCar()
    private val park3:ParkCar = ParkCar()
    private  var flagCar:Number = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            carone.setOnClickListener {
                SelectCarOne(it)
            }
            cartwo.setOnClickListener {
                SelectCarTwo(it)
            }
            cartree.setOnClickListener {
                SelectCarTree(it)
            }
            delete.setOnClickListener {
                Delete(it)
            }
            update.setOnClickListener {
                Update(it)
            }
            selected.text = "Selected : "+flagCar

        }
    }

    private fun SelectCarOne(view:View) {
        flagCar = 1

        binding.apply {
            selected.text = "Selected : "+flagCar
            number.setText(park1.number)
            model.setText(park1.model)
            name.setText(park1.name)
        }

    }
    private fun SelectCarTwo(view: View){
        flagCar = 2

        binding.apply {
            selected.text = "Selected : "+flagCar
            number.setText(park2.number)
            model.setText(park2.model)
            name.setText(park2.name)
        }
    }
    private fun SelectCarTree(view: View){
        flagCar = 3

        binding.apply {
            selected.text = "Selected : "+flagCar
            number.setText(park3.number)
            model.setText(park3.model)
            name.setText(park3.name)
        }
    }
    private  fun Delete(view:View){
        if (flagCar==1){
            park1.number=""
            park1.model=""
            park1.name=""
            binding.carone.text = "Free"
            binding.carone.setBackgroundColor(Color.GREEN)
            ResetText()
        }else if(flagCar==2){
            park2.number=""
            park2.model=""
            park2.name=""
            binding.cartwo.text = "Free"
            binding.cartwo.setBackgroundColor(Color.GREEN)
            ResetText()
        }else{
            park3.number=""
            park3.model=""
            park3.name=""
            binding.cartree.text = "Free"
            binding.cartwo.setBackgroundColor(Color.GREEN)
            ResetText()
        }
    }
    private  fun Update(view:View){
        if (flagCar==1 &&
            park1.number.isBlank()&&
            park1.model.isBlank()&&
            park1.name.isBlank())
        {
            binding.apply {
                park1.number = number.text.toString()
                park1.model = model.text.toString()
                park1.name = name.text.toString()
                carone.text = "Not Free"
                carone.setBackgroundColor(Color.RED)

            }
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()

        }else if(flagCar==2 &&
            park2.number.isBlank()&&
            park2.model.isBlank()&&
            park2.name.isBlank())
        {
            binding.apply {
                park2.number = number.text.toString()
                park2.model = model.text.toString()
                park2.name = name.text.toString()
                cartwo.text = "Not Free"
                cartwo.setBackgroundColor(Color.RED)
            }
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
        }else if(   park3.number.isBlank()&&
                    park3.model.isBlank()&&
                    park3.name.isBlank())

        {
            binding.apply {
                park3.number = number.text.toString()
                park3.model = model.text.toString()
                park3.name = name.text.toString()
                cartree.text = "Not Free"
                cartree.setBackgroundColor(Color.RED)
            }
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext,"Not Free",Toast.LENGTH_SHORT).show()
        }
    }
    private fun ResetText(){
        binding.apply {
            number.setText("")
            model.setText("")
            name.setText("")
        }
    }


}
