package buu.informatics.s59160545.parking


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160545.parking.databinding.FragmentParkCarBinding


/**
 * A simple [Fragment] subclass.
 */
class ParkCarFragment : Fragment() {
    private lateinit var binding: FragmentParkCarBinding
    private val park1:ParkCar = ParkCar(0)
    private val park2:ParkCar = ParkCar(1)
    private val park3:ParkCar = ParkCar(2)
    private  val park = arrayOf(park1,park2,park3)
    private  var flagCar = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate<FragmentParkCarBinding>(inflater,R.layout.fragment_park_car,container,false)
        binding.apply {
            cars = this@ParkCarFragment.park
            car = park?.get(flagCar)
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

        setHasOptionsMenu(true)
        return  binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
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
        hideKeyboard(view)
        binding.invalidateAll()
    }
    private  fun Save(view:View){
        val car = park?.get(flagCar)
        car.empty = false
        hideKeyboard(view)
        binding.invalidateAll()
    }
    fun Fragment.hideKeyboard(view: View) {
        activity!!.hideKeyboard(view)
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }




}
