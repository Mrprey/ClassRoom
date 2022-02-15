package com.example.classroom.controller

import com.example.classroom.model.ListMock
import com.example.classroom.model.MockData

abstract class Controller: Iterator{
    override var position: Int = 0
    protected val listMock = ListMock()

    abstract fun getData(): MutableList<String>

    override fun hasMore(): Boolean {
        return position < listMock.Size()
    }

    override fun reset() {
        position = 0
    }

    fun setData(data: MockData, num: Int) {
        listMock.setList(data, num)
    }
}