import 'package:todo_app/Model/to_do_model.dart';


class ChangeToDoAction{
  final int index;
  final ToDo toDo;

  ChangeToDoAction(this.toDo, this.index);
}

class DeleteToDoAction{
  final String id;

  DeleteToDoAction(this.id);
}

class UndoDeleteAction{

}

class NewToDoAction{
  final ToDo toDo;

  NewToDoAction(this.toDo);
}

class AddToDoAction{
  final ToDo toDo;

  AddToDoAction(this.toDo);
}

class HitAddToDoAction{
  final ToDo toDo;

  HitAddToDoAction(this.toDo);
}

class ResultLoadAction{
  final List<ToDo> toDoList;

  ResultLoadAction(this.toDoList);
}

class LoadToDoAction{}

class UpDateToDoAction{}