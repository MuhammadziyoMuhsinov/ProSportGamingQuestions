package uz.muhammadziyo.prosportgamingquestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.muhammadziyo.prosportgamingquestions.databinding.FragmentStartBinding


class FragmentStart : Fragment() {

    private lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
       binding = FragmentStartBinding.inflate(layoutInflater)

        binding.btnStart.setOnClickListener {
            val name = binding.edtName.text.toString()
            val lastname = binding.edtLastname.text.toString()
            if (name.isNotEmpty()&&lastname.isNotEmpty()){
                Mydata.name = name
                Mydata.lastname = lastname
                findNavController().navigate(R.id.fragmentMain)
            }else{
                Toast.makeText(binding.root.context, "Empty!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}