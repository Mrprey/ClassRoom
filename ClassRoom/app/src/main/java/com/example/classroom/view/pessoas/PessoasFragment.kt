package com.example.classroom.view.pessoas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R
import com.example.classroom.databinding.FragmentPessoasBinding
import com.example.classroom.model.MockDataPeople
import com.example.classroom.view.dataView.dataAdapters.AdapterPessoas
import com.example.classroom.view.screen_fragment.ScreenFragment
import com.example.classroom.controller.Controller as Controller

class PessoasFragment : ScreenFragment() {

    private var _binding: FragmentPessoasBinding? = null
    private val binding get() = _binding!!
    override val controlData = Controller()
    override lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPessoasBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupData(10)
        setupRecyclerView()
        return root
    }

    override fun setupRecyclerView() {
        this.recyclerView = binding.root.findViewById(R.id.rv_main)
        this.recyclerView.adapter = AdapterPessoas(this.controlData)
        this.recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
    }

    override fun setupData(size: Int) {
        controlData.setData(MockDataPeople(), size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}