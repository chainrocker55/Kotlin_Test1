package buu.informatics.s59160545.parking


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160545.parking.databinding.FragmentLoginBinding

import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,container,false)
        binding.apply {
            userNotMatch.visibility = View.GONE
            btnLogin.setOnClickListener {
                LoginCheck(it)
            }
        }
        setHasOptionsMenu(true)
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val inputMethodManager = activity!!.getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity!!.getCurrentFocus()!!.getWindowToken(), 0
        )
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)

    }


    private fun LoginCheck(view: View){
        binding.apply {
            val usernameValue:String = binding.username.text.toString()
            val passwordValue:String = binding.password.text.toString()
            if (usernameValue.equals("admin")&&passwordValue.equals("password")){
                userNotMatch.visibility = View.GONE
                hideKeyboard(view)
                view.findNavController().navigate(R.id.action_loginFragment_to_parkCarFragment)
            }else{
                userNotMatch.visibility = View.VISIBLE
                    hideKeyboard(view)
            }

        }

    }
    fun Fragment.hideKeyboard(view: View) {
        activity!!.hideKeyboard(view)
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }



}
