package com.example.classroom.view.screen_fragment

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.classroom.controller.Controller

abstract class ScreenFragment : Fragment() {
    abstract var controlData : Controller
    abstract var recyclerView: RecyclerView

    abstract fun setupRecyclerView()

    abstract fun setupController(size: Int)
}