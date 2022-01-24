
import 'package:meta/meta.dart';

@immutable
class ToDo{
  final String id;
  final String title;
  bool done = false;

  ToDo(this.id, this.title);

  ToDo.withoutActive(this.id, this.title, this.done);

  ToDo.fromMap(Map<String, dynamic> map):
      id = map["id"],
      title = map["dynamicFields"]["name"],
      done = map["dynamicFields"]["done"];

  static List<ToDo> getBatchMap(List<dynamic> dataList){
    return dataList.map((item) => ToDo.fromMap(item)).toList();
  }

  void Change(){
    done = !done;
  }
}