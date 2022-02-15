package com.example.classroom.controller

class ControllerName: Controller() {
    override fun getData(): MutableList<String> {
        val listName : MutableList<String> = ArrayList()
        while (hasMore()) {
            listName.add(getNext())
        }
        return listName
    }

    override fun getNext(): String {
        return if (hasMore()) {
            position += 1
            getName(position -1)
        } else {
            reset()
            getNext()
        }
    }

    private fun getName(position: Int): String = listMock.getItem(position).name
}