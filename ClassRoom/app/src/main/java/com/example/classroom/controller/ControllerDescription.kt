package com.example.classroom.controller

class ControllerDescription: Controller() {

    override fun getData(): MutableList<String> {
        val listDescription : MutableList<String> = ArrayList()
        while (hasMore()) {
            listDescription.add(getNext())
        }
        return listDescription
    }

    override fun getNext(): String {
        return if (hasMore()) {
            position += 1
            getDescription(position -1)
        } else {
            reset()
            getNext()
        }
    }

    private fun getDescription(position: Int): String = listMock.getItem(position).description
}