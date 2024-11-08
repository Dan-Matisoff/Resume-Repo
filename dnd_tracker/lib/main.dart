import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:collection/collection.dart';
import 'package:material_symbols_icons/symbols.dart';

import 'CharacterInfo.dart';
import 'DNDSetup.dart';
import 'InfoDisplay.dart';
import 'SpellList.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => MyAppState(),
      child: MaterialApp(
        title: 'DND Tracker',
        theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
        ),
        home: const MyHomePage(),
      ),
    );
  }
}

class MyAppState extends ChangeNotifier {
  // Storage of Global Variables
  /// Character Name
  var charName = 'Stephen Swordslash';
  /// The number of total Health Points.
  var hp = 0;
  /// The number of temporary Health Points.
  var tempHP = 0;
  /// The current Armor Class of the character.
  var ac = 0;
  /// Whether you need multiple spell slots per level.
  bool multiSlot = false;
  /// The current level of the character.
  var level = 0;
  /// Amount of Spell Slots when [multiSlot] is false.
  var spellSlotAmount = 0;
  /// Array of Spell Slot Amounts for when [multiSlot] is true.
  var spellSlotAmounts = [];
  /// List of boolean values for the state of each checkbox when [multiSlot] is false.
  List<bool> nonMultiCheckboxStates = [];
  /// List of lists of boolean values for the state of each checkbox when [multiSlot] is true.
  List<BoolList> multiCheckboxStates = [];

  /// Function to turn all multi-spell slot checkbox states false
  void multiCheckboxReset() {
    for (int i = 0; i < multiCheckboxStates.length; i++)
      {
        for (int k = 0; k < multiCheckboxStates[i].length; k++)
          {
            multiCheckboxStates[i][k] = false;
          }
      }
  }

  /// Function to turn all non multi-spell slot checkbox states false
  void nonMultiCheckboxReset() {
    for (int i = 0; i < nonMultiCheckboxStates.length; i++)
      {
        nonMultiCheckboxStates[i] = false;
      }
  }

  /// Function to change whether there are multiple spell slot levels
  void multiSlotToggle(bool? newVal) {
    multiSlot = newVal!;
    if (!multiSlot) spellSlotAmount = 1;
    notifyListeners();
  }

  /// Sets the Level variable
  void setLevel(int newLevel) {
    level = newLevel;
    notifyListeners();
  }

  /// Sets the Spell Slot Amount variable
  void setSlotAmount(int slotAmount) {
    spellSlotAmount = slotAmount;
    notifyListeners();
  }

  /// Sets the Name variable
  void saveName(String name) {
    charName = name;
    notifyListeners();
  }

  /// Sets the Health Points variable
  void saveHP(String health) {
    hp = int.parse(health);
    resetTempHP();
    notifyListeners();
  }

  /// Sets the Armor Class variable
  void saveAC(String armor) {
    ac = int.parse(armor);
    notifyListeners();
  }

  /// Changes the Temporary Health variable to equal the HP variable
 void resetTempHP() {
    tempHP = hp;
    notifyListeners();
 }

 /// Alters the Temporary Health variable by [health]
 void modTempHP(int health){
    tempHP += health;
    notifyListeners();
  }
}


class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

/// General Setup for the App
class _MyHomePageState extends State<MyHomePage> {
  int selectedIndex = 0;

  @override
  Widget build(BuildContext context) {
    Widget page;
    switch (selectedIndex) {
      case 0:
        page = const DNDSetup();
      case 1:
        page = const InfoDisplay();
      case 2:
        page = const CharacterInfo();
      case 3:
        page = const SpellList();
      default:
        throw UnimplementedError('No widget for $selectedIndex');
    }

    return LayoutBuilder(
      builder: (context, constraints) {
        return Scaffold(
          body: Row(
            children: [
              SafeArea(
                child: NavigationRail(
                  labelType: NavigationRailLabelType.all,
                  backgroundColor: Theme.of(context).colorScheme.inversePrimary,
                  //extended: constraints.maxWidth >= 600,
                  destinations: const [
                    NavigationRailDestination(
                      icon: Icon(Icons.create),
                      label: Text('Setup'),
                    ),
                    NavigationRailDestination(
                      icon: Icon(Icons.stars),
                      label: Text('Spell Slots'),
                    ),
                    NavigationRailDestination(
                        icon: Icon(Icons.person),
                        label: Text('Character Info')
                    ),
                    NavigationRailDestination(
                        icon: Icon(Symbols.book_4_spark),
                        label: Text('Spell List'),
                    )
                  ],
                  selectedIndex: selectedIndex,
                  onDestinationSelected: (value) {
                    setState(() {
                      selectedIndex = value;
                    });
                  },
                ),
              ),
              Expanded(
                child: Container(
                  color: Theme.of(context).colorScheme.primaryContainer,
                  child: page,
                ),
              ),
            ],
          ),
        );
      },
    );
  }
}
