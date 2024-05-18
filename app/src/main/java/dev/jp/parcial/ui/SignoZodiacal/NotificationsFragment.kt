package dev.jp.parcial.ui.SignoZodiacal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.jp.parcial.LogInA
import dev.jp.parcial.databinding.FragmentNotificationsBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnConsultar.setOnClickListener {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val edad = Edadresult(sdf.parse(binding.Datetxt.text.toString()))
            val signo = SignoResult(sdf.parse(binding.Datetxt.text.toString()))
            binding.EdadRes.text = edad.toString()
            binding.SigRes.text =  signo
        }
        binding.btnregresar.setOnClickListener {
            val intent = Intent(requireContext(),LogInA::class.java)
            startActivity(intent)
        }

        return root
    }

    private fun Edadresult(birthDate: Date): Int{
        val today = Calendar.getInstance()
        val birth = Calendar.getInstance()
        birth.time = birthDate
        var age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)){
            age--
        }
        return age
    }

    private fun SignoResult(birthDate: Date): String{
        val calendar = Calendar.getInstance()
        calendar.time = birthDate
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)+1

        return when (month) {
            1 -> if (day < 20) "Capricornio" else "Acuario"
            2 -> if (day < 19) "Acuario" else "Piscis"
            3 -> if (day < 21) "Piscis" else "Aries"
            4 -> if (day < 20) "Aries" else "Tauro"
            5 -> if (day < 21) "Tauro" else "Géminis"
            6 -> if (day < 21) "Géminis" else "Cáncer"
            7 -> if (day < 23) "Cáncer" else "Leo"
            8 -> if (day < 23) "Leo" else "Virgo"
            9 -> if (day < 23) "Virgo" else "Libra"
            10 -> if (day < 23) "Libra" else "Escorpio"
            11 -> if (day < 22) "Escorpio" else "Sagitario"
            12 -> if (day < 22) "Sagitario" else "Capricornio"
            else -> "0"

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
