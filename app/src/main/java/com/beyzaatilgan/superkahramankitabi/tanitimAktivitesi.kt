package com.beyzaatilgan.superkahramankitabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.beyzaatilgan.superkahramankitabi.databinding.ActivityMainBinding
import com.beyzaatilgan.superkahramankitabi.databinding.ActivityTanitimAktivitesiBinding

class tanitimAktivitesi : AppCompatActivity() {
    private lateinit var binding: ActivityTanitimAktivitesiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val adapterdenGelenIntent = intent
        //val secilen Kahraman = adapterdenGelenIntent.getSerializableExtra("secilenKahraman", superKahraman::class.java)
        //val secilenKahraman = adapterdenGelenIntent.getSerializableExtra("secilenKahraman") as superKahraman
        //intent ile uğraşmadan objeleri singleton ile de yollayabilirim.
        val secilenKahraman = MySingleton.secilensuperKahraman
        secilenKahraman?.let {
            binding.imageView.setImageResource(secilenKahraman.gorsel)
            binding.isimTextView.text = secilenKahraman.isim
            binding.meslekTextView.text = secilenKahraman.meslek

        }



    }
}