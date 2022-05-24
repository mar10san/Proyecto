package com.example.proyecto.volley

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R

class FragmentVolley : Fragment() {
    private lateinit var boton1: Button  //variables para los botones
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_volley, container, false)
        //variables de los botones
        boton1 = vista.findViewById(R.id.btn_ir_perros)
        boton1.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentVolley_to_fragmentLista) //cuando el boton se ejecuta corresponde a una accion
        }
        return vista
    }

}