package com.example.proyecto.volley.adaptador


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R
import com.example.proyecto.volley.modelo.Personaje
import com.squareup.picasso.Picasso


class PersonajeAdapter(private val listaPersonajes:ArrayList<Personaje>): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vista_propia,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get()
            .load(listaPersonajes[position].foto)
            .into(holder.ivFoto)
        holder.tvtitulo.text="Titulo: "+listaPersonajes[position].nombre
        holder.tvdescripcion.text=listaPersonajes[position].descripcion
        holder.tvgenero.text="Genero: "+listaPersonajes[position].genero
        holder.tvplataforma.text="Plataforma: "+listaPersonajes[position].plataforma
        holder.tvurl.text=listaPersonajes[position].url
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){

        val ivFoto:ImageView = vista.findViewById(R.id.imaPersonaje)
        val tvtitulo:TextView = vista.findViewById(R.id.tvTitulo)
        val tvdescripcion:TextView = vista.findViewById(R.id.tvDescripcion)
        val tvgenero:TextView = vista.findViewById(R.id.tvGenero)
        val tvplataforma:TextView = vista.findViewById(R.id.tvPlataforma)
        val tvurl:TextView = vista.findViewById(R.id.tvUrl)
    }
}