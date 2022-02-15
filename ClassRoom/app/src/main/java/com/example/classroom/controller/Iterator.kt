package com.example.classroom.controller

interface Iterator {
    var position: Int

    fun reset()

    fun getNext(): String

    fun hasMore(): Boolean
}