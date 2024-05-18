package dev.jp.parcial.ui.Generaciones

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jp.parcial.LogInA
import dev.jp.parcial.R
import dev.jp.parcial.ui.GenSub.GeneracionSub
import dev.jp.parcial.ui.GenSub.modelgen

class GeneracionesF : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View =  inflater.inflate(R.layout.fragment_generaciones, container, false)
        val button: Button = view.findViewById(R.id.btnregresar1)
        val rvGen: RecyclerView = view.findViewById(R.id.rvGen)

        rvGen.layoutManager = LinearLayoutManager(requireContext())
        rvGen.adapter = GeneracionSub(playList())

        button.setOnClickListener {
            val intent = Intent(requireContext(), LogInA::class.java)
            startActivity(intent)
        }

        return view


    }

    private fun playList(): List<modelgen>{
        var lstSong: ArrayList<modelgen> = ArrayList()

        lstSong.add(
            modelgen(R.drawable.korn1
                ,"A.D.I.D.A.S"
                ,"Korn")
        )
        lstSong.add(
            modelgen(R.drawable.korn2
                ,"Got the life"
                ,"Korn")
        )
        lstSong.add(
            modelgen(R.drawable.korn3
                ,"Freak on a leash"
                ,"Korn")
        )
        return lstSong
    }


}