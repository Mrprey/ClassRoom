package com.example.classroom.model

interface Iterator {
    var position: Int

    fun reset()

    fun getNext(): MockData

    fun hasMore(): Boolean
}