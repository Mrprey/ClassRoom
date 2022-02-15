package com.example.classroom.model

import kotlin.Exception as Exception

class ListMock: StrategyAdd {
    private var listMock : MutableList<MockData> = ArrayList()
    private var next = 0

    fun setList(data: MockData, num: Int) {
        super.setList(data, num, this.listMock)
    }

    fun setList(data: List<MockData>){
        super.setList(data, this.listMock)
    }

    fun setList(data: MockData){
        super.setList(data, this.listMock)
    }

    fun getList() = listMock

    fun getItem(index: Int) = listMock[index]

    fun Size() = listMock.size

}