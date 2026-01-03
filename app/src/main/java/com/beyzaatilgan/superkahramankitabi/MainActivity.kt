package com.beyzaatilgan.superkahramankitabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyzaatilgan.superkahramankitabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superKahramanListesi :  ArrayList<superKahraman>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val superman = superKahraman("Superman", "gazeteci", R.drawable.superman)
        val batman = superKahraman("Batman", "patron", R.drawable.batman)
        val ironman = superKahraman("Iron Man", "holding sahibi", R.drawable.ironman)
        val aquaman = superKahraman("Aquaman", "kral", R.drawable.aquaman)

        superKahramanListesi = arrayListOf(superman,batman, ironman, aquaman)


        //adapter ı main activityde bu şekilde initialize edebiliriz.
        val adapter = superKahramanAdapter(superKahramanListesi)

        binding.superKahramanRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.superKahramanRecyclerView.adapter = adapter

    }

}