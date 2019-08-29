package buu.informatics.s59160545.parking


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160545.parking.databinding.FragmentLoginBinding


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
        return binding.root

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
