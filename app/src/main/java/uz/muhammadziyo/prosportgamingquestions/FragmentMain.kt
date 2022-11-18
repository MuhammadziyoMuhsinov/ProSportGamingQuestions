package uz.muhammadziyo.prosportgamingquestions

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.muhammadziyo.prosportgamingquestions.databinding.FragmentMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class FragmentMain : Fragment() {

   private lateinit var binding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val myDateObj = LocalDateTime.now()
                val myFormatObj: DateTimeFormatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")

                val formattedDate = myDateObj.format(myFormatObj)
                binding.date.setText(formattedDate)

            }
        }

        binding.name.setText("Hello, ${Mydata.lastname}  ${Mydata.name} !")
        binding.cardview.setOnClickListener {
            findNavController().navigate(R.id.fragmentQuestion)
        }

        return binding.root
    }


}