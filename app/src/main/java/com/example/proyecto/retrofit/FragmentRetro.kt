package com.example.proyecto.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentRetroBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FragmentRetro : Fragment() {
    //private lateinit var binding: FragmentRetroBinding
    private lateinit var adapter: AdapterRetro
    lateinit var sv:EditText
    lateinit var btnbuscar:Button
    private lateinit var miRecycler: RecyclerView
    private val images1= mutableListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_retro, container, false)
        adapter = AdapterRetro(images1)
        miRecycler = vista.findViewById(R.id.rvdog)
        miRecycler.layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        miRecycler.adapter=adapter
        sv = vista.findViewById(R.id.etbuscar)
        btnbuscar = vista.findViewById(R.id.ir_buscar)
        val query = sv.text
        btnbuscar.setOnClickListener {
            searchByName(query.toString().lowercase())
            sv.setText("")
        }

        return vista
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()
            requireActivity().runOnUiThread {
                if(call.isSuccessful){
                    val images = puppies?.images ?: emptyList()
                    images1.clear()
                    images1.addAll(images)
                    adapter.notifyDataSetChanged()
                    showAccion()
                }else{
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireContext(),"Estamos teniendo  un error", Toast.LENGTH_SHORT).show()
    }

    private fun showAccion() {
        Toast.makeText(requireContext(),"Consulta realizada", Toast.LENGTH_SHORT).show()
    }


}