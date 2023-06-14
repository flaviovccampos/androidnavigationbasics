package com.example.navigationbasics

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationbasics.databinding.FragmentEmailBinding
import com.example.navigationbasics.databinding.FragmentSecondBinding

class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding
    private var bundleNameStringParam: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            bundleNameStringParam = it!!.getString("text_name")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        binding.buttonFinish.setOnClickListener {
            val bundle = bundleOf(
                "text_email" to binding.editTextEmail.text.toString(),
                "text_name" to bundleNameStringParam
            )
            it.findNavController().navigate(R.id.action_emailFragment_to_secondFragment, bundle)
        }

        return binding.root
    }
}