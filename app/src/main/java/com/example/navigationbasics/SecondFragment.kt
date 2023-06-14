package com.example.navigationbasics

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationbasics.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var bundleNameStringParam: String? = null
    private var bundleEmailStringParam: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            bundleNameStringParam = it!!.getString("text_name")
            bundleEmailStringParam = it!!.getString("text_email")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        if(TextUtils.isEmpty(bundleNameStringParam)){
            binding.textViewName.text = "Text Name Empty!!!"
        }else{
            binding.textViewName.text = bundleNameStringParam
        }

        if(TextUtils.isEmpty(bundleEmailStringParam)){
            binding.textViewEmail.text = "Text Email Empty!!!"
        }else{
            binding.textViewEmail.text = bundleEmailStringParam
        }

        binding.buttonSecondTerms.setOnClickListener{
            it.findNavController().navigate(R.id.action_secondFragment_to_termsFragment)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment()
    }
}