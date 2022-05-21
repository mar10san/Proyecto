package com.example.proyecto.tablas

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.proyecto.R

class FragmentResultado2 : Fragment() {
    private lateinit var animView: LottieAnimationView
    private lateinit var btnRegresar: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_resultado2, container, false)

        btnRegresar = vista.findViewById(R.id.btnRegresar)
        btnRegresar.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentResultado2_to_fragmentTablas2)
        }
        animView = vista.findViewById(R.id.animation_view)
        animView.setAnimation(R.raw.opops)
        Toast.makeText(requireContext(),"falso", Toast.LENGTH_LONG).show()
        return vista
    }

}