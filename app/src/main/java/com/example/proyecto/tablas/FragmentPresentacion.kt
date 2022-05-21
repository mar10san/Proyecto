package com.example.proyecto.tablas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R

class FragmentPresentacion : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var btnPracticar: Button
        val vista  = inflater.inflate(R.layout.fragment_presentacion, container, false)
        btnPracticar = vista.findViewById(R.id.btnIrAPracticar)
        btnPracticar.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentPresentacion_to_fragmentTablas2)
        }
        return vista
    }

}