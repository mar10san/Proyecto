package com.example.proyecto.volley

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto.R
import com.example.proyecto.volley.adaptador.PersonajeAdapter
import com.example.proyecto.volley.modelo.Personaje


class FragmentLista (): Fragment() {
    private lateinit var miRecycler: RecyclerView
    private lateinit var listaPersonajes:ArrayList<Personaje>
    private lateinit var adaptador: PersonajeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_lista, container, false)
        listaPersonajes = ArrayList()
        miRecycler = vista.findViewById(R.id.RecyclerPersonajes)
        adaptador = PersonajeAdapter(listaPersonajes)
        miRecycler.adapter = adaptador
        getPersonajes()
        miRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        return  vista
    }
    private fun getPersonajes(){
        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://www.freetogame.com/api/games"
        val objectRequest = JsonArrayRequest(
            Request.Method.GET,url,null,
            { respuesta ->
                for (indice in 0 until respuesta.length()){
                    val personajeIndJson = respuesta.getJSONObject(indice)
                    val personaje = Personaje(  personajeIndJson.getString("title"),
                                                personajeIndJson.getString("thumbnail"),
                                                personajeIndJson.getString("short_description"),
                                                personajeIndJson.getString("genre"),
                                                personajeIndJson.getString("platform"),
                                                personajeIndJson.getString("game_url"))
                    listaPersonajes.add(personaje)
                }

                adaptador.notifyDataSetChanged()
            },
            {
                Log.e("PersonajesApi", "Error")
            })

        queue.add(objectRequest)

    }
    }
