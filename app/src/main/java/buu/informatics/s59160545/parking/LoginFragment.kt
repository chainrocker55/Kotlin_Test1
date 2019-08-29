package buu.informatics.s59160545.parking


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160545.parking.databinding.FragmentLoginBinding

import android.view.ViewGroup



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
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun LoginCheck(view: View){
        binding.apply {
            val usernameValue:String = binding.username.text.toString()
            val passwordValue:String = binding.password.text.toString()
            if (usernameValue.equals("admin")&&passwordValue.equals("admin")){
                userNotMatch.visibility = View.GONE
                view.findNavController().navigate(R.id.action_loginFragment_to_parkCarFragment)
            }else{
                userNotMatch.visibility = View.VISIBLE
            }
        }

    }



}
