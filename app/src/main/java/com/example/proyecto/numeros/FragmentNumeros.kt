package com.example.proyecto.numeros

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R

class FragmentNumeros : Fragment() {
    lateinit var btnIniciar:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_numeros, container, false)
        btnIniciar = vista.findViewById(R.id.btnComenzar)

        btnIniciar.setOnClickListener { findNavController().navigate(R.id.action_fragmentNumeros_to_fragmentJuego) }
        return vista
    }

}