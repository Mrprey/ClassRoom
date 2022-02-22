package com.example.classroom.model


class ListMock: StrategyAdd, Iterator {
    private var listMock : MutableList<MockData> = ArrayList()
    override var position: Int = 0;

    fun setList(data: MockData, num: Int) {
        super.setList(data, num, this.listMock)
    }

    fun setList(data: List<MockData>){
        super.setList(data, this.listMock)
    }

    fun setList(data: MockData){
        super.setList(data, this.listMock)
    }

    fun Size() = listMock.size

    override fun reset() {
        position = 0
    }

    override fun getNext(): MockData {
        return listMock[position]
    }

    override fun hasMore(): Boolean {
        position += 1
        return position < Size()
    }

}