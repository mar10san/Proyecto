package com.example.proyecto.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R

class FragmentInicioRetro : Fragment() {
    lateinit var btnit:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_inicio_retro, container, false)
        btnit = vista.findViewById(R.id.ir_retro)
        btnit.setOnClickListener {
            findNavController().navigate((R.id.action_fragmentInicioRetro_to_fragmentRetro))
        }
        return vista
    }
}