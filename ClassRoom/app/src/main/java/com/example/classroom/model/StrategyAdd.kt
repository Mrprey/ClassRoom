package com.example.classroom.model

interface StrategyAdd {

    //mock de dados com apenas 1 item
    fun setList(data: MockData, list: MutableList<MockData>) {
        list.add(data)
    }
    //mock de dados com uma lista de itens
    fun setList(data: List<MockData>, list: MutableList<MockData>) {
        list.addAll(data)
    }
    //mock de dados com o mesmo item varias vezes
    fun setList(data: MockData, num: Int, list: MutableList<MockData>) {
        for (i in 0 until num) list.add(data)
    }
}