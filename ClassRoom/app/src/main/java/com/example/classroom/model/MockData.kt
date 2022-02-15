package com.example.classroom.model

data class MockData(
    var name: String = "Neymar Jr",
    var description: String = "Texto de mock para teste da aplicação"
)

data class MockDataIssue(
    var name: String = "apresentar projeto",
    var date: String = "10/02/2022",
    var deadLine: String = "18/02/2022",
)

data class MockDataFiles(
    var name: String = "slides",
    var date: String = "08/02/2022",
    var description: String = "Slides da aula"
)

data class MockDataPeople(
    var name: String = "Vini Jr"
)
