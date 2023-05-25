package com.example.pruebatecnicacity.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pruebatecnicacity.databinding.FragmentFirstCardBinding
import com.example.pruebatecnicacity.interfaces.FirstCardInterface
import com.example.pruebatecnicacity.model.Colaborador

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FirstCard.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstCard : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentFirstCardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var firstCardInterface: FirstCardInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.firstCardInterface = context as FirstCardInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentFirstCardBinding = FragmentFirstCardBinding.inflate(inflater, container, false)
        //set variables in Binding

        val sendDataTextWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val usernameInput: String = binding.userName.text.toString().trim()
                val birthdayInput: String = binding.userBirthday.text.toString().trim()
                val positionInput: String = binding.userPosition.text.toString().trim()
                binding.buttonSend.isEnabled = usernameInput.isNotEmpty() && birthdayInput.isNotEmpty() && positionInput.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable) {}
        }

        with(binding){
            userName.addTextChangedListener(sendDataTextWatcher)
            userBirthday.addTextChangedListener(sendDataTextWatcher)
            userPosition.addTextChangedListener(sendDataTextWatcher)

            buttonSend.setOnClickListener(){
                val colaborador = Colaborador(
                    userName.text.toString().trim(),
                    userBirthday.text.toString().trim(),
                    userPosition.text.toString().trim())

                firstCardInterface.onSendButtonClicked(colaborador)
            }
        }



        //set variables in Binding
        return binding.root




    }




}