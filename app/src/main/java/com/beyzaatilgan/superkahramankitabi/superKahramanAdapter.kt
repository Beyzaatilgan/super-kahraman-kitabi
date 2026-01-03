package com.beyzaatilgan.superkahramankitabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beyzaatilgan.superkahramankitabi.databinding.ActivityMainBinding
import com.beyzaatilgan.superkahramankitabi.databinding.RecyclerRowBinding

class superKahramanAdapter(val superKahramanListesi : ArrayList<superKahraman>) : RecyclerView.Adapter<superKahramanAdapter.superKahramanViewHolder>() {
    class superKahramanViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    // recycleview row bindingini initialize eder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): superKahramanViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return superKahramanViewHolder(binding)
    }

    // oluşturulan recycler row dan kaç tane yapmak isteriz?
    override fun getItemCount(): Int {
        return superKahramanListesi.size
    }

    //esas önemli kısım işlemler bitince ne yapacağız? tıklama,gösterme vb.
    override fun onBindViewHolder(holder: superKahramanViewHolder, position: Int) {
        holder.binding.textViewRecyclerView.text = superKahramanListesi[position].isim

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, tanitimAktivitesi::class.java)
            MySingleton.secilensuperKahraman = superKahramanListesi[position]
            //intent.putExtra("secilenKahraman",superKahramanListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }

}