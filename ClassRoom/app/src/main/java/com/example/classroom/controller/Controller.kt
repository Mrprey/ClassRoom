package com.example.classroom.controller

import com.example.classroom.model.ListMock
import com.example.classroom.model.MockData

class Controller{
    private val listMock = ListMock()

    fun setData(data: MockData, num: Int) {
        listMock.setList(data, num)
    }

    fun getData(): MutableList<MockData> {
        val listName : MutableList<MockData> = ArrayList()
        while (listMock.hasMore()) {
            listName.add(listMock.getNext())
        }
        listMock.reset()
        return listName
    }

    fun getSize(): Int = listMock.Size()
}