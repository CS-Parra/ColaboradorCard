package com.example.pruebatecnicacity.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pruebatecnicacity.databinding.FragmentSecondCardBinding
import com.example.pruebatecnicacity.interfaces.SecondCardInterface
import com.example.pruebatecnicacity.model.Colaborador

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondCard.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondCard : Fragment() {

    private var _binding: FragmentSecondCardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var secondCardInterface: SecondCardInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.secondCardInterface = context as SecondCardInterface
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSecondCardBinding = FragmentSecondCardBinding.inflate(inflater, container, false)

        val bundle = arguments
        val colaborador  = bundle?.getSerializable("colaborador") as Colaborador
        with(binding){
            userNameCard.text = colaborador.name
            userBirthdayCard.text = colaborador.birthday
            userPositionCard.text = colaborador.position

            backButton.setOnClickListener{
                secondCardInterface.onReturnButtonClicked()
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}