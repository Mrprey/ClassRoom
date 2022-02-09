package com.example.classroom.view.mural

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.R
import com.example.classroom.databinding.FragmentMuralBinding
import com.example.classroom.dba.ListMock
import com.example.classroom.dba.MockData
import com.example.classroom.view.DataAdapterView

class MuralFragment : Fragment() {

    private var _binding: FragmentMuralBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private var data = ListMock()

    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMuralBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupRecyclerView()
        return root
    }

    private fun setupRecyclerView() {
        for (i in 0 until 10) {
            data.setList(MockData())
        }
        recyclerView = binding.root.findViewById(R.id.rv_main)
        recyclerView.adapter = DataAdapterView(data.getList())
        recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}