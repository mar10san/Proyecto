package com.example.proyecto.tablas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.proyecto.R

class FragmentResultado : Fragment() {
    private lateinit var animView:LottieAnimationView
    private lateinit var btnRegresar:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_resultado, container, false)

        btnRegresar = vista.findViewById(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResultado_to_fragmentTablas2)
        }
        animView = vista.findViewById(R.id.animation_view)
        animView.setAnimation(R.raw.correcto)
        Toast.makeText(requireContext(),"Verdadero", Toast.LENGTH_LONG).show()

        return vista
    }

}