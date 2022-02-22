package com.example.classroom.model

abstract class MockData{
    abstract var name: String
    abstract var date: String
    abstract var deadLine: String
    abstract var description: String
}

class MockDataIssue: MockData() {
    override var description: String = "Slides da aula"

    override var name: String = "apresentar projeto"
    override var date: String = "10/02/2022"
    override var deadLine: String = "18/02/2022"
}

class MockDataFiles: MockData() {
    override var deadLine: String = "None"

    override var name: String = "slides"
    override var date: String = "08/02/2022"
    override var description: String = "Slides da aula"
}

class MockDataPeople: MockData(){
    override var date: String = "None"
    override var deadLine: String = "None"
    override var description: String = "None"

    override var name: String = "Vini Jr"
}
