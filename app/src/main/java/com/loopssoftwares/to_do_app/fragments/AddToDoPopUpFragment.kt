package com.loopssoftwares.to_do_app.fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.loopssoftwares.to_do_app.R
import com.loopssoftwares.to_do_app.databinding.FragmentAddToDoPopUpBinding


class AddToDoPopUpFragment : DialogFragment() {

    private lateinit var binding : FragmentAddToDoPopUpBinding
    private lateinit var listener : DialogNextBtnClickListener

    fun setListener(listener : DialogNextBtnClickListener){
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddToDoPopUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerEvents()
    }

    private fun registerEvents(){
        binding.todoNextBtn.setOnClickListener {
            val todoTask = binding.todoEt.text.toString()
            if (todoTask.isNotEmpty()){
                listener.onSaveTask(todoTask , binding.todoEt)
            } else{
                Toast.makeText(context, "Por favor, digite sua tarefa" , Toast.LENGTH_SHORT).show()
            }
        }

        binding.todoClose.setOnClickListener {
            dismiss()
        }
    }

    interface  DialogNextBtnClickListener{
        fun onSaveTask(todo: String , todoEt : TextInputEditText)
    }
}