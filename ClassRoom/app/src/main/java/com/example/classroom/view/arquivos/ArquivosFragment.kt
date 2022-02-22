package com.example.classroom.view.arquivos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R
import com.example.classroom.controller.Controller
import com.example.classroom.databinding.FragmentArquivosBinding
import com.example.classroom.model.MockDataFiles
import com.example.classroom.view.dataView.dataAdapters.AdapterArquivos
import com.example.classroom.view.screen_fragment.ScreenFragment

class ArquivosFragment : ScreenFragment() {

    private var _binding: FragmentArquivosBinding? = null
    private val binding get() = _binding!!
    override var controlData: Controller = Controller()
    override lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentArquivosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupData(10)
        setupRecyclerView()
        return root
    }

    override fun setupRecyclerView() {
        this.recyclerView = binding.root.findViewById(R.id.rv_main)
        this.recyclerView.adapter = AdapterArquivos(this.controlData)
        this.recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
    }

    override fun setupData(size: Int) {
        controlData.setData(MockDataFiles(), size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}