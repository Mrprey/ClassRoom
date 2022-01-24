import 'dart:convert';
import 'dart:developer';
import 'package:normalize/utils.dart';
import 'package:flutter/material.dart';
import 'package:graphql_flutter/graphql_flutter.dart';
import 'package:redux/redux.dart';
import 'package:todo_app/AppState.dart';
import 'package:todo_app/Model/to_do_model.dart';
import 'package:todo_app/Redux/actions/actions.dart';
import "package:http/http.dart" as http;
import 'package:logger/logger.dart';


class LoggableHttpClient extends http.BaseClient {
  final http.Client _delegate;
  final Logger _logger;

  LoggableHttpClient(this._delegate, this._logger);

  @override
  void close() {
    _delegate.close();
  }

  @override
  Future<http.StreamedResponse> send(http.BaseRequest request) async {
    //var bodies = "{\"query\":\"query { records { data { id } } }\"}";
    var originalBody = (request as http.Request).body;

    var jsonBody = jsonDecode(originalBody);

    var query = assembleQuery(jsonBody["query"]);

    var variables = assembleVarieble(jsonBody["variables"]);

    var newBody = "{\"query\":\"${query}\", \"variables\":  ${variables} }";
    //print("request => ${newBody}");
/*    var bodies =
        "{\"query\":\"${getRecordsSimple()}\", \"variable"
        "s\": { \"sheetId\": \"61dccfb4381edf010f2fef3d\" } }";
    print("request => ${bodies}");*/
    (request as http.Request).body = newBody;

    // ------------------------------------------------
    // LOG BEGIN
    // ------------------------------------------------
    String s = "${request.method} ${request.url} -->";
    s += "\nheader: ${request.headers}";
    if (request is http.Request && request.body.length > 0) {
      s += "\nbody: ${request.body}";
    }
    _logger.i(s);
    final response = await _delegate.send(request);
    s = "${request.method} ${request.url} <--";
    s += "\nheader: ${response.headers}";
    final List<int> bytes = await response.stream.toBytes();
    s += "\nbody: ${await utf8.decode(bytes)}";

     //Simple request
    // if(request is Request) {
    //   _logger.i(s);
    //
       return http.StreamedResponse(
          http.ByteStream.fromBytes(bytes),
          response.statusCode,
           contentLength: response.contentLength,
           request: request,
           headers: response.headers,
           isRedirect: response.isRedirect,
           persistentConnection: response.persistentConnection,
           reasonPhrase: response.reasonPhrase
       );
  }
}

String assembleQuery(query){
  query = query.replaceAll("__typename", "");
  return query.replaceAll("\n", "");
}

String assembleVarieble(variables){
  String vars = "{";
  int numVariables = variables.keys.length;
  print(numVariables);
  for(var keys in variables.keys){
    if(variables[keys] is String) {
      vars += "\"$keys\": \"${variables[keys]}\"";
    }else if(variables[keys] is Map<String,dynamic>) {
      vars += "\"$keys\": ${assembleVarieble(variables[keys])}";
    }else{
      vars += "\"$keys\": ${variables[keys]}";
    }
    if(numVariables > 1){
      vars += ",";
      numVariables -= 1;
    }
  }
  return vars+="}";
}

class MiddlewareToDo implements MiddlewareClass<AppState> {
  final AuthLink authLink = AuthLink(
    getToken: () async => "wbbwc3Yeaa9e5Yal3aTr9xdu1qYKiPWToQMGcLUwKMs",
  );

  final HttpLink httpLink = HttpLink('https://pocket.oxeanbits.com/graphql',
      defaultHeaders: {
        "Authorization": "wbbwc3Yeaa9e5Yal3aTr9xdu1qYKiPWToQMGcLUwKMs",
      },
      httpClient:
          LoggableHttpClient(http.Client(), Logger(printer: PrettyPrinter())));

  @override
  void call(store, dynamic action, NextDispatcher next) async {
    log('LOG REDUX - ${new DateTime.now()}: $action');
    GraphQLClient graphQLClient = GraphQLClient(
      link: httpLink,
      cache: GraphQLCache(store: HiveStore(), ),
    );

   if (action is LoadToDoAction){
      QueryResult result = await graphQLClient.query(
        QueryOptions(
            document: gql(getRecords()),
            variables: {"sheetId": "61dccfb4381edf010f2fef3d"}
        ),
     );
      store.dispatch(ResultLoadAction(
        ToDo.getBatchMap(result.data?["records"]["data"])
      ));
   }
   else if(action is AddToDoAction){
     QueryResult result = await graphQLClient.query(
       QueryOptions(
           document: gql(createRecord()),
           variables: {"projectId": "610413e0381edf014cec68cc",
             "sheetId": "61dccfb4381edf010f2fef3d",
           "hash": {"name": "${action.toDo.title}", "done": action.toDo.done}},
           operationName: "createRecord"
             ),
     );
     if(result.data != null) {
       store.dispatch(HitAddToDoAction(ToDo.withoutActive(
           result.data!["createRecord"]["id"],
           result.data!["createRecord"]["dynamicFields"]["name"],
           result.data!["createRecord"]["dynamicFields"]["done"])
       ));
     }
   }
   else if(action is ChangeToDoAction){
     QueryResult result = await graphQLClient.query(
         QueryOptions(
             document: gql(updateRecord()),
           variables: {"Id": "${action.toDo.id}", "hash": {"name": "${action.toDo.title}", "done": !action.toDo.done}},
         ),
     );
     store.dispatch(LoadToDoAction());
   }

    next(action);
  }
}


String getRecords() => """
query records(\$sheetId: ID){
  records(where: { sheetId: \$sheetId }, order: {updatedAt: ASC}, limit: 100) {
    data {
      id
      dynamicFields
      sheetId
      createdAt
      updatedAt
    }
  }
}
"""
    .replaceAll("\n", " ");

String createRecord() => """
  mutation createRecord(\$projectId: ID, \$sheetId: ID, \$hash: Hash) {
    createRecord(data: {
      projectId: \$projectId,
      sheetId: \$sheetId,
      dynamicFields: \$hash
    })
    {
      id
      sheetId
      dynamicFields
      createdAt
      updatedAt
    }
  }
  """.replaceAll("\n", " ");

String countRecordsBySheet = """
  query records(\$sheetId) {
    records(where: { sheetId: \$sheetId }) {
      count
    }
  }
  """.replaceAll("\n", " ");

String updateRecord() => """
  mutation updateRecord(\$Id: ID!, \$dynamicFields: Hash) {
  updateRecord(id: \$Id, data:{
    dynamicFields: \$dynamicFields
  })
  {
    id
    sheetId
    dynamicFields
  }
}
  """;

String deleteRecord() => """
  mutation deleteRecord(\$id: ID!) { 
    deleteRecord(id: \$id)
    {
      id
    }    
  }
  """;