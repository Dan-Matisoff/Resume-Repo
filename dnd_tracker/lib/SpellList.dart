import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SpellList extends StatefulWidget {
  const SpellList({super.key});

  @override
  State<SpellList> createState() => _SpellListState();
}

class _SpellListState extends State<SpellList> {
  SpellRowManager srm = SpellRowManager();


  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Padding(
          padding: EdgeInsets.all(5.0),
          child: ListView.builder(
              shrinkWrap: true,
              itemCount: srm.getList().length,
              itemBuilder: (BuildContext context, int index) {
                return srm.getList()[index];
              }),
        ),
        IconButton(
          onPressed: () => setState(() {
            srm.addRow();
          }),
          icon: Icon(Icons.add, color: Colors.white,),
          style: IconButton.styleFrom(backgroundColor: Colors.blueAccent),
        )
      ],
    ));
  }
}

class SpellRowManager /*extends StatefulWidget {
  const SpellRowManager({super.key});
  
  @override
  State<SpellRowManager> createState() => _SpellRowManagerState();
}

class _SpellRowManagerState extends State<SpellRowManager> */{
  //var _callback;
  List<Padding> Spells = [];
  List<List<String>> RowInfo = [];
  SpellRowManager(/*void Function(VoidCallback) deleteCallback,*/ [List<Padding>? inputList]) {
    Spells = inputList ?? [];
    //_callback = deleteCallback;
  }

  List<Padding> getList() {
    return Spells;
  }

  void addRow() {
    String level = "1";
    String name = "Spell Name";
    String desc = "Spell Description";
    List<String> insert = [];
    insert.addAll({level, name, desc});
    RowInfo.add(insert);
    Spells.add(Padding(
      padding: EdgeInsets.only(bottom: 3.0),
      child: Row(
        children: [
          Expanded(
              flex: 1,
              child: Text(RowInfo[RowInfo.length - 1][0]),),
          Expanded(
              flex: 2,
              child: Text(RowInfo[RowInfo.length - 1][1]),),
          Expanded(
              flex: 3,
              child: Text(RowInfo[RowInfo.length - 1][2]),),
          IconButton(
              onPressed: (){/*_callback(deleteRow(RowInfo.length - 1));*/},
              icon: const Icon(Icons.cancel),
          )
        ],
      ),
    ));
  }

  /// rowNumber is 0 based
  void modifyRow(int rowNumber, String level, String name, String desc) {
    List<String> currentRow = RowInfo[rowNumber];
    currentRow[0] = level;
    currentRow[1] = name;
    currentRow[2] = desc;
  }

  void deleteRow(int rowNumber) {
    RowInfo.removeAt(rowNumber);
  }

  /*
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    throw UnimplementedError();
  }*/
}
