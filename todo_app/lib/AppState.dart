


import 'package:todo_app/Model/to_do_model.dart';

class AppState {
  final List<ToDo> toDoList;

  AppState({
    this.toDoList = const [],
  });

  factory AppState.initialState() {
    return AppState(
        toDoList: []
    );
  }

  AppState copyWith({required List<ToDo> toDoList}) {
    return AppState(
      toDoList: toDoList,
    );
  }
}

