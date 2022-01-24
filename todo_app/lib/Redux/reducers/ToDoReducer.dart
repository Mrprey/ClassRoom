import 'package:redux/redux.dart';
import 'package:todo_app/Model/to_do_model.dart';
import 'package:todo_app/Redux/actions/actions.dart';


final todoReducers = combineReducers<List<ToDo>>([
  TypedReducer<List<ToDo>, HitAddToDoAction>(_hitAddToDo),
/*  TypedReducer<List<ToDo>, DeleteToDoAction>(_deleteToDo),*/
  TypedReducer<List<ToDo>, ResultLoadAction>(_resultLoadToDo)
]);


List<ToDo> _resultLoadToDo(List<ToDo> toDos, ResultLoadAction action) {
  //print(toDos.length);
  return toDos = action.toDoList;
}

List<ToDo> _hitAddToDo(List<ToDo> toDos, HitAddToDoAction action) {
  print(toDos.length);
  return List.from(toDos)..add(action.toDo);
}

/*
List<ToDo> _deleteToDo(List<ToDo> toDos, DeleteToDoAction action){
  //print(toDo.last.title);
  toDos.removeAt(action.index);
  return List.from(toDos);
}
*/
