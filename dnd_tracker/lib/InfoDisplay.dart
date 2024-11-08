import 'package:collection/collection.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:provider/provider.dart';

import 'main.dart';

class InfoDisplay extends StatefulWidget {
  const InfoDisplay({super.key});

  @override
  State<InfoDisplay> createState() => _InfoDisplayState();
}

/// Displays the information set up in [DNDSetup.dart]
///
/// Displays information like Health Points, Armor Class, and
/// Level. Also displays a modifiable Temporary Health Counter,
/// and Checkboxes for counting spell slots.
class _InfoDisplayState extends State<InfoDisplay> {
  @override
  Widget build(BuildContext context) {
    // Variable to access global variables and functions
    var appState = context.watch<MyAppState>();
    List<bool> nonMultiCheckboxStates = appState.nonMultiCheckboxStates;  // Checkbox States for when [appState.multiSlot] is false
    List<BoolList> multiCheckboxStates = appState.multiCheckboxStates;  // Checkbox States for when [appState.multiSlot] is true

    /// Returns a widget with either one or multiple rows of checkboxes
    Widget getSlots() {
      return appState.multiSlot ? Expanded(
          child: ListView.builder(  // To store the rows of checkboxes
              shrinkWrap: true,
              itemCount: appState.level,  // All counts are done based on the level of the character
              itemBuilder: (BuildContext context, int index) {
                return Column(
                  children: [
                    Text('Level ${index + 1}'),
                    Table(
                      children: [
                        for (int i = 0; i < (appState.spellSlotAmounts[index] / 6); i++) TableRow(
                          children: [
                            for (int k = 0; k < 6; k++) if (i*6+k < appState.spellSlotAmounts[index]) StatefulBuilder(
                              builder: (BuildContext context, void Function(void Function()) setState) {return Checkbox(
                                value: multiCheckboxStates[index][i*6+k],
                                onChanged: (bool? value) {setState(() {multiCheckboxStates[index][i*6+k] = value!;});},
                              );},
                            )// IDK figure this out later. Making this a table.
                            else Container()
                          ],
                        )
                      ],
                    ),
                  ],
                );
              }))
          : Table(
        children: [
          for (int i = 0; i < (appState.spellSlotAmount / 6); i++) TableRow(
            children: [
              for (int k = 0; k < 6; k++) if (i*6+k < appState.spellSlotAmount)
                StatefulBuilder(
                  builder: (BuildContext context, void Function(void Function()) setState) {return Checkbox(
                   value: nonMultiCheckboxStates[i],
                   onChanged: (bool? value) {setState(() {nonMultiCheckboxStates[i] = value!;});},
                  );},
                )// IDK figure this out later. Making this a table.
              else Container()
            ],
          )
        ],
      );
    }

    var textTheme = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar( // The top bar of the app. Consistent across all pages.
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(appState.charName),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(vertical: 2.0,horizontal: 8.0,),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text('Spell Slots:'),
              getSlots(),
              IconButton(onPressed: () => setState(() {
                appState.nonMultiCheckboxReset();
                appState.multiCheckboxReset();
              }), icon: const Icon(Icons.loop))
            ],
          ),
        ),
      ),
    );
  }
}


// Scrollbar(  // widget for the singular set of checkboxes
//         controller: nonMultiScrollController,
//         interactive: true,
//         child: SingleChildScrollView( // If the boxes are too long, allows for scrolling
//           // Change to table?
//           controller: nonMultiScrollController,
//           scrollDirection: Axis.horizontal,
//           padding: const EdgeInsets.all(8.0),
//           child: Row(
//               children: [for (int i = 0; i < appState.spellSlotAmount; i++) StatefulBuilder(
//                 builder: (BuildContext context, void Function(void Function()) setState) {return Checkbox(
//                   value: nonMultiCheckboxStates[i],
//                   onChanged: (bool? value) {setState(() {nonMultiCheckboxStates[i] = value!;});},
//                 );},
//               )
//                 ,]),
//         ),
//       );