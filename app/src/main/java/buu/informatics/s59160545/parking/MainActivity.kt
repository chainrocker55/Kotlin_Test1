package buu.informatics.s59160545.parking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160545.parking.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val park1:ParkCar = ParkCar(0)
    private val park2:ParkCar = ParkCar(1)
    private val park3:ParkCar = ParkCar(2)
    private  val park = arrayOf(park1,park2,park3)
    private  var flagCar = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.apply {
            cars = this@MainActivity.park
            carone.setOnClickListener {
                SelectPark(it)
            }
            cartwo.setOnClickListener {
                SelectPark(it)
            }
            cartree.setOnClickListener {
                SelectPark(it)
            }
            delete.setOnClickListener {
                Delete(it)
            }
            save.setOnClickListener {
                Save(it)
            }
        }
    }
    private fun getCarIdFormView(view:View):Int {
        when(view.id) {
            R.id.carone -> return 0
            R.id.cartwo -> return 1
            R.id.cartree -> return 2
        }
        return -1
    }
    private fun SelectPark(view: View) {
        binding.apply {
            flagCar = getCarIdFormView(view)
            car = park?.get(flagCar)
            invalidateAll()
        }
    }

    private  fun Delete(view:View){
        val car = park?.get(flagCar)
        car.empty = true
        car.number = ""
        car.model = ""
        car.name = ""
        binding.invalidateAll()
    }
    private  fun Save(view:View){
        val car = park?.get(flagCar)
        car.empty = false
        binding.invalidateAll()
    }



}
