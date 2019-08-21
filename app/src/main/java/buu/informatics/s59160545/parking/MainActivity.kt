package buu.informatics.s59160545.parking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160545.parking.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val park1:ParkCar = ParkCar("1234","sdfsdf","sdfsdf")
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

        }
    }

    private fun SelectCarOne(view:View) {
        flagCar = 1

        binding.apply {
            number.setText(park1.number)
            model.setText(park1.model)
            name.setText(park1.name)
        }

    }
    private fun SelectCarTwo(view: View){
        flagCar = 2
        binding.apply {
            number.setText(park2.number)
            model.setText(park2.model)
            name.setText(park2.name)
        }
    }
    private fun SelectCarTree(view: View){
        flagCar = 3
        binding.apply {
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

            ResetText()
        }else if(flagCar==2){
            park2.number=""
            park2.model=""
            park2.name=""
            ResetText()
        }else{
            park3.number=""
            park3.model=""
            park3.name=""
            ResetText()
        }
    }
    private  fun Update(view:View){
        if (flagCar==1){
            park1.number=""
            park1.model=""
            park1.name=""

            ResetText()
        }else if(flagCar==2){
            park2.number=""
            park2.model=""
            park2.name=""
            ResetText()
        }else{
            park3.number=""
            park3.model=""
            park3.name=""
            ResetText()
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
