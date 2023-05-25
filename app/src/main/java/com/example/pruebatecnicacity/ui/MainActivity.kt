package com.example.pruebatecnicacity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebatecnicacity.R
import com.example.pruebatecnicacity.databinding.ActivityMainBinding
import com.example.pruebatecnicacity.interfaces.FirstCardInterface
import com.example.pruebatecnicacity.interfaces.SecondCardInterface
import com.example.pruebatecnicacity.model.Colaborador

class MainActivity : AppCompatActivity(), FirstCardInterface, SecondCardInterface {

    private lateinit var binding: ActivityMainBinding

    lateinit var secondCard: SecondCard
    lateinit var firstCard: FirstCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadFirstCard()
    }

    //endregion
    //UI Actions

    private fun loadFirstCard() {
        firstCard = FirstCard()
        supportFragmentManager.beginTransaction().replace(R.id.container, firstCard)
            .commit()
    }
    private fun loadSecondCard(colaborador: Colaborador) {
        secondCard = SecondCard()
        val bundle = Bundle()
        bundle.putSerializable("colaborador", colaborador)
        secondCard.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.container, secondCard)
            .commit()
    }


    override fun onSendButtonClicked(colaborador: Colaborador) {
        loadSecondCard(colaborador)
    }

    override fun onReturnButtonClicked() {
        loadFirstCard()
    }



}


