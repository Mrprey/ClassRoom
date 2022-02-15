package com.example.classroom.view.arquivos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R
import com.example.classroom.controller.Controller
import com.example.classroom.controller.ControllerDescription
import com.example.classroom.databinding.FragmentArquivosBinding
import com.example.classroom.model.MockData
import com.example.classroom.view.dataAdapter.DataAdapter
import com.example.classroom.view.screen_fragment.ScreenFragment

class ArquivosFragment : ScreenFragment() {

    private var _binding: FragmentArquivosBinding? = null
    private val binding get() = _binding!!
    override var controlData: Controller = ControllerDescription()
    override lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentArquivosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupController(10)
        setupRecyclerView()
        return root
    }

    override fun setupRecyclerView() {
        this.recyclerView = binding.root.findViewById(R.id.rv_main)
        this.recyclerView.adapter = DataAdapter(this.controlData.getData())
        this.recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
    }

    override fun setupController(size: Int) {
        controlData.setData(MockData(), size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}