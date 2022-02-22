package com.example.classroom.view.mural

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R
import com.example.classroom.controller.Controller
import com.example.classroom.databinding.FragmentMuralBinding
import com.example.classroom.model.MockDataFiles
import com.example.classroom.model.MockDataIssue
import com.example.classroom.view.dataView.dataAdapters.AdapterMural
import com.example.classroom.view.screen_fragment.ScreenFragment

class MuralFragment : ScreenFragment() {

    private var _binding: FragmentMuralBinding? = null
    private val binding get() = _binding!!
    override var controlData: Controller = Controller()
    override lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMuralBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupData(20)
        setupRecyclerView()
        return root
    }

    override fun setupRecyclerView() {
        this.recyclerView = binding.root.findViewById(R.id.rv_main)
        this.recyclerView.adapter = AdapterMural(this.controlData)
        this.recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
    }

    override fun setupData(size: Int) {
        controlData.setData(MockDataFiles(), size)
        controlData.setData(MockDataIssue(), size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}