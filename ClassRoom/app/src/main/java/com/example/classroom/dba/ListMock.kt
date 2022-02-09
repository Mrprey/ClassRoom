package com.example.classroom.dba

class ListMock {
    protected var listMock : MutableList<MockData> = ArrayList()

    fun setList(data: MockData) {listMock.add(data)}

    fun getList() = listMock
}