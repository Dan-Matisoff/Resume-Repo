import 'package:collection/collection.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:provider/provider.dart';

import 'main.dart';

class CharacterInfo extends StatefulWidget {
  const CharacterInfo({super.key});

  @override
  State<CharacterInfo> createState() => _CharacterInfoState();
}

class _CharacterInfoState extends State<CharacterInfo> {
  @override
  Widget build(BuildContext context) {
    var appState = context.watch<MyAppState>();
    var tempHP = appState.tempHP;
    var textTheme = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        // The top bar of the app. Consistent across all pages.
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text(appState.charName),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(
          vertical: 2.0,
          horizontal: 8.0,
        ),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Card(
                shape: const ContinuousRectangleBorder(),
                child: Row(
                  // To put HP and text
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    const Text(
                      'Health Points: ',
                      style: TextStyle(fontSize: 24),
                    ),
                    Text('${appState.hp}', style: const TextStyle(fontSize: 24))
                  ],
                ),
              ),
              Text(
                'TempHP',
                style: textTheme.bodyMedium,
              ),
              FractionallySizedBox(
                widthFactor: 0.9,
                child: Row(
                  //Temp HP Display and interaction
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    if (MediaQuery.of(context).size.width > 400)
                      IconButton.outlined(
                        onPressed: () {
                          setState(() {
                            appState.modTempHP(-5);
                          });
                        },
                        icon: const Icon(FontAwesomeIcons.five),
                        iconSize: MediaQuery.of(context).size.width <= 400
                            ? MediaQuery.of(context).size.width * 0.05
                            : 20,
                      ),
                    IconButton.outlined(
                        onPressed: () {
                          setState(() {
                            appState.modTempHP(-1);
                          });
                        },
                        icon: const Icon(Icons.exposure_minus_1)),
                    SizedBox(
                      //width: 107,
                      child: Center(
                        child: Card(
                          color: Theme.of(context).primaryColor,
                          child: Text(
                            '$tempHP',
                            style: TextStyle(
                                color: Colors.white,
                                fontStyle: textTheme.displayMedium?.fontStyle,
                                fontSize: textTheme.displayMedium?.fontSize),
                          ),
                        ),
                      ),
                    ),
                    IconButton.outlined(
                        onPressed: () {
                          setState(() {
                            appState.modTempHP(1);
                          });
                        },
                        icon: const Icon(Icons.exposure_plus_1)),
                    if (MediaQuery.of(context).size.width > 400)
                      IconButton.outlined(
                        onPressed: () {
                          setState(() {
                            appState.modTempHP(5);
                          });
                        },
                        icon: const Icon(FontAwesomeIcons.five),
                        iconSize: MediaQuery.of(context).size.width <= 400
                            ? MediaQuery.of(context).size.width * 0.05
                            : 20,
                      ),
                  ],
                ),
              ),
              TextButton(
                  onPressed: () {
                    setState(() {
                      appState.resetTempHP();
                    });
                  },
                  child: const Text('Reset')),
              Card(
                shape: const ContinuousRectangleBorder(),
                child: Row(
                  // To put HP and text
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    const Text(
                      'Armor Class: ',
                      style: TextStyle(fontSize: 24),
                    ),
                    Text(
                      '${appState.ac}',
                      style: const TextStyle(fontSize: 24),
                    )
                  ],
                ),
              ),
              const Text('Spell Slots:'),
            ],
          ),
        ),
      ),
    );
  }
}
