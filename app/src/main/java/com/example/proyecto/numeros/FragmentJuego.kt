package com.example.proyecto.numeros

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyecto.R
import kotlin.random.Random

class FragmentJuego : Fragment() {
    lateinit var musicaFondo: MediaPlayer
    lateinit var respuestaUsuario: EditText
    lateinit var btnRespuesta: Button
    lateinit var sonidoRespuestaCorrecta:MediaPlayer
    lateinit var sonidoRespuestaIncorrecta:MediaPlayer
    var numeroGenerado = 0
    var numeroUsuario = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_juego, container, false)
        musicaFondo = MediaPlayer.create(requireContext(), R.raw.cancion)
        sonidoRespuestaCorrecta = MediaPlayer.create(requireContext(),R.raw.correcto_1)
        sonidoRespuestaIncorrecta = MediaPlayer.create(requireContext(),R.raw.error)
        reproduceMusica()
        generaNumero()
        btnRespuesta = vista.findViewById(R.id.btnComprobar)
        respuestaUsuario = vista.findViewById(R.id.etEntradaUsuario)
        btnRespuesta.setOnClickListener {
            val respuesta = respuestaUsuario.text.toString()
            if (respuesta == ""){
                Toast.makeText(requireContext(), "Ingrese un valor", Toast.LENGTH_LONG).show()
                sonidoIncorrecto()
            }else{
                numeroUsuario = respuesta.toInt()
                if(numeroGenerado==numeroUsuario){
                    sonidoCorrecto()
                    Toast.makeText(requireContext(), "Advininaste la esfera escondida por GOKU",Toast.LENGTH_SHORT).show()
                }else{
                    sonidoIncorrecto()
                    Toast.makeText(requireContext(), "La esfera escondida es de $numeroGenerado estrellas",Toast.LENGTH_SHORT).show()

                }
                generaNumero()
            }
        }
    return vista
    }
    override fun onStop() {
        super.onStop()
        musicaFondo.release()
        sonidoRespuestaCorrecta.release()
        sonidoRespuestaIncorrecta.release()
    }
    fun reproduceMusica(){
        musicaFondo.isLooping = true
        musicaFondo.setVolume(0.5f,0.5f)
        musicaFondo.start() // no need to call prepare(); create() does that for you
    }
    fun sonidoCorrecto(){
        sonidoRespuestaCorrecta.start()
        sonidoRespuestaCorrecta.setVolume(0.5f,0.5f)
    }
    fun sonidoIncorrecto(){
        sonidoRespuestaIncorrecta.start()
        sonidoRespuestaIncorrecta.setVolume(0.5f,0.5f)
    }

    fun generaNumero(){
        numeroGenerado = Random.nextInt(1,7)
    }
}