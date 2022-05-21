package com.example.proyecto.tablas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R
import kotlin.random.Random

class FragmentTablas : Fragment() {
    private lateinit var tvFactor1:TextView
    private lateinit var tvFactor2: TextView
    lateinit var etRespuesta: EditText
    lateinit var btnVerificar: Button
    private lateinit var volver:Button
    var factor1:Int = 0
    var factor2:Int = 0
    var producto:Int = 0
    var respuestaCorrecta = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_tablas, container, false)
        tvFactor1 = vista.findViewById(R.id.tvFactor1)
        tvFactor2 = vista.findViewById(R.id.tvFactor2)
        etRespuesta = vista.findViewById(R.id.etRespuesta)
        btnVerificar = vista.findViewById(R.id.btnVerificar)
        generaMultiplicacion()
        btnVerificar.setOnClickListener {
            val strRespuesta = etRespuesta.text.toString()
            if(strRespuesta == ""){
                Toast.makeText(requireContext(),"Dejaste el campo vacio", Toast.LENGTH_LONG).show()
            }else{

                if(strRespuesta.toInt() == producto){
                    generaMultiplicacion()
                    findNavController().navigate(R.id.action_fragmentTablas2_to_fragmentResultado)
                }
               else {
                    generaMultiplicacion()
                    findNavController().navigate(R.id.action_fragmentTablas2_to_fragmentResultado2)
               }
            }
        }
        volver = vista.findViewById(R.id.btnVolver)
        volver.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentTablas2_to_fragmentPresentacion)

        }
        return vista
    }


    fun generaMultiplicacion(){
        factor1 = Random.nextInt(0,10)
        factor2 = Random.nextInt(0,10)
        producto = factor1*factor2
        tvFactor1.text = "$factor1"
        tvFactor2.text = "$factor2"
        etRespuesta.text.clear()
    }
}