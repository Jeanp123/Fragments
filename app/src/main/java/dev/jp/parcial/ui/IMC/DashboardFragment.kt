package dev.jp.parcial.ui.IMC

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.jp.parcial.LogInA
import dev.jp.parcial.R
import dev.jp.parcial.databinding.FragmentDashboardBinding
import java.util.zip.Inflater

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnCalcular.setOnClickListener {
            val peso =  calcularIMC(binding.pesoKG.text.toString().toDouble(),binding.estaturaM.text.toString().toDouble())
            val metros = calcularCat(peso)
            binding.ResultKG.text = peso.toString()
            binding.ResultCat.text = metros
        }
        binding.btnRegresarMenu.setOnClickListener {
            val intent = Intent(requireContext(),LogInA::class.java)
            startActivity(intent)
        }

        return root
    }
    private fun calcularIMC(peso: Double,estatura: Double):Double{
        return peso / (estatura * estatura)
    }
    private fun calcularCat(imc: Double):String{
        return when{
            imc < 18.5 -> "Bajo peso"
            imc in 18.5..24.9->"Peso saludable"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}