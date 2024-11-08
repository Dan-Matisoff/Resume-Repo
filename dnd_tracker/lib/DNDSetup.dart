import 'package:collection/collection.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:provider/provider.dart';

import 'main.dart';

class DNDSetup extends StatefulWidget {
  const DNDSetup({super.key});


  @override
  State<DNDSetup> createState() => _DNDSetupState();
}

class _DNDSetupState extends State<DNDSetup> {
  final _nameTextController = TextEditingController();

  final _hpNumberController = TextEditingController();

  final _acNumberController = TextEditingController();

  final _levelNumberController = TextEditingController();

  final _spellSlotNumberController = TextEditingController();
  final List<TextEditingController> _spellSlotMultiController = [];

  @override
  Widget build(BuildContext context) {
    var appState = context.watch<MyAppState>();

    Widget getFields() {
      for (int i = 0; i< appState.level; i++) {
        _spellSlotMultiController.add(TextEditingController());
        appState.spellSlotAmounts.add(0);
        _spellSlotMultiController[i].text = appState.spellSlotAmounts[i].toString();
        appState.multiCheckboxStates.add(BoolList.empty());
      }
      return appState.multiSlot ? Expanded(
          child: ListView.builder(
              shrinkWrap: true,
              itemCount: appState.level,
              itemBuilder: (BuildContext context, int index) {return TextField(
                controller: _spellSlotMultiController.elementAt(index),
                decoration: InputDecoration(hintText: '${appState.spellSlotAmounts[index]}', labelText: 'Level ${index + 1} Slot Amount'),
                onChanged: (text) {
                  appState.spellSlotAmounts[index] = int.tryParse(text) ?? 0;
                  appState.multiCheckboxStates[index].clear();
                  for (int i = 0; i < appState.spellSlotAmounts[index]; i++)
                  {
                    appState.multiCheckboxStates[index].add(false);
                  }
                },
                keyboardType: TextInputType.number,
                inputFormatters: <TextInputFormatter>[
                  FilteringTextInputFormatter.digitsOnly
                ],
              );})) : TextField(
        controller: _spellSlotNumberController,
        decoration: InputDecoration(hintText: '${appState.spellSlotAmount}', labelText: 'Spell Slot Amount'),
        onChanged: (text) {
          appState.spellSlotAmount = int.tryParse(text) ?? 0;
          appState.nonMultiCheckboxStates.clear();
          for (int i = 0; i < appState.spellSlotAmount; i++) {
            appState.nonMultiCheckboxStates.add(false);
          }
        },
        keyboardType: TextInputType.number,
        inputFormatters: <TextInputFormatter>[
          FilteringTextInputFormatter.digitsOnly
        ],
      );
    }

    _nameTextController.text = appState.charName;
    _levelNumberController.text = appState.level.toString();
    _hpNumberController.text = appState.hp.toString();
    _acNumberController.text = appState.ac.toString();
    _spellSlotNumberController.text = appState.spellSlotAmount.toString();

    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: const Text('Insert Data Here'),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(vertical: 2.0,horizontal: 8.0,),
        child: Center(
          child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                TextFormField(
                  controller: _nameTextController,
                  decoration: InputDecoration(hintText: appState.charName, labelText: 'Character Name'),
                  onChanged: (text) {
                    appState.saveName(text);
                  },
                ),
                TextField(
                  controller: _hpNumberController,
                  decoration: InputDecoration(hintText: '${appState.hp}', labelText: 'Health Points'),
                  onChanged: (text) {
                    appState.saveHP(text);
                  },
                  keyboardType: TextInputType.number,
                  inputFormatters: <TextInputFormatter>[
                    FilteringTextInputFormatter.digitsOnly
                  ],
                ),
                TextField(
                  controller: _acNumberController,
                  decoration: InputDecoration(hintText: '${appState.ac}', labelText: 'Armor Class'),
                  onChanged: (text) {
                    appState.saveAC(text);
                  },
                  keyboardType: TextInputType.number,
                  inputFormatters: <TextInputFormatter>[
                    FilteringTextInputFormatter.digitsOnly
                  ],
                ),
                CheckboxListTile(
                  title: const Text('Do you need multiple slots per level?'),
                  value: appState.multiSlot,
                  onChanged: (bool? newVal) {setState(() {
                    appState.multiSlotToggle(newVal);
                  });},
                ),
                const Padding(
                  padding: EdgeInsets.all(20),
                  child: Text('Spell Slot Information'),
                ),
                TextField(
                  controller: _levelNumberController,
                  decoration: InputDecoration(hintText: '${appState.level}', labelText: 'Level'),
                  onChanged: (text) {
                    appState.level = int.tryParse(text) ?? 0;
                    setState(() {});
                  },
                  keyboardType: TextInputType.number,
                  inputFormatters: <TextInputFormatter>[
                    FilteringTextInputFormatter.digitsOnly
                  ],
                ),
                getFields(),
              ]
          ),
        ),
      ),
    );
  }
}