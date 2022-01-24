import 'package:flutter/material.dart';
import 'package:flutter_redux/flutter_redux.dart';
import 'package:todo_app/AppState.dart';
import 'package:todo_app/Model/to_do_model.dart';
import 'package:todo_app/Redux/actions/actions.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  HomePage createState() => HomePage();
}

class HomePage extends State<Home> {

  final _toDoController = TextEditingController();

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text("ToDo APP"),
        backgroundColor: Colors.lightBlueAccent,
        centerTitle: true,
      ),
      body: StoreConnector<AppState, List<ToDo>>(
        converter: (store) => store.state.toDoList,
        builder: (context, state){
         // print(state.length);
          return Column(
            children: <Widget>[
              Container(
                padding: EdgeInsets.fromLTRB(16, 8, 16, 8),
                child: Row(
                  children: <Widget>[
                    Expanded(
                        child: TextField(
                          controller: _toDoController,
                          decoration: const InputDecoration(
                              labelText: "New Task",
                              labelStyle: TextStyle(color: Colors.lightBlueAccent)
                          ),
                        )
                    ),
                    ElevatedButton(
                      onPressed: (){
                        StoreProvider.of<AppState>(context).dispatch(
                          AddToDoAction(ToDo("1", _toDoController.text)),
                          );
                        _toDoController.text = "";
                      },
                      child: const Text('ADD'),

                    ),
                  ],
                ),
              ),

              //list todos
              Expanded(child: ListView.builder(
                padding: const EdgeInsets.only(top: 8),
                itemCount: state.length,
                itemBuilder: biuldItem,

              ),

              )],
          );
        }),

    );
  }

  Widget biuldItem(context, index) {
    return StoreConnector<AppState, List<ToDo>>(
        converter: (store) => store.state.toDoList,
        builder: (context, state){
          return Dismissible(
            key: UniqueKey(),
            background: Container(
              color: Colors.red,
              child: const Align(
                alignment: Alignment(-0.9, 0.0),
                child: Icon(Icons.delete, color: Colors.white,),
              ),
            ),
            direction: DismissDirection.startToEnd, child: CheckboxListTile(
              title: Text(state[index].title),
              value: state[index].done,

              secondary: CircleAvatar(child: Icon(
                state[index].done ? Icons.check : Icons.error),),
            onChanged: (status) {
                //state[index].Change();
                StoreProvider.of<AppState>(context).dispatch(
                  ChangeToDoAction(state[index], index),
                );
            },),
    onDismissed: (direction){
      StoreProvider.of<AppState>(context).dispatch(
          DeleteToDoAction(state[index].id),
      );
          //_lastRemoved = Map.from(_toDoList[index]);
         // _lastRemovedPos = index;
          //_saveData();

          /*final snack = SnackBar(content: Text("Tarefa \"${_lastRemoved["title"]}\" removida!"),
            action: SnackBarAction(label: "Desfazer", onPressed: () {
              setState(() {
                _toDoList.insert(_lastRemovedPos, _lastRemoved);
                // _saveData();
              }
              );
            },
            ),
            duration: Duration(seconds: 2),
          );
          Scaffold.of(context).showSnackBar(snack);
        );*/
      },);
    });
  }



/*  Future<File> _getFile() async {
    final directory = await getApplicationDocumentsDirectory();
    return File("${directory.path}/data.json");
  }

  Future<File> _saveData() async {
    String data = json.encode(_toDoList);

    final file = await _getFile();
    return file.writeAsString(data);
  }

  Future<String?> _readData() async {
    try {
      final file = await _getFile();

      return file.readAsString();
    } catch (e) {
      return null;
    }
  }*/
}