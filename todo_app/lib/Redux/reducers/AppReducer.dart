
import 'package:todo_app/AppState.dart';

import 'ToDoReducer.dart';

AppState appReducers(AppState state, action){
  return AppState(
    toDoList: todoReducers(state.toDoList, action),
  );
}