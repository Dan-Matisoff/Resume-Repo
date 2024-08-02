Directions for using the Zoom SMS Delete Scripts.
Created by Daniel Matisoff

As of 8/1/2024, Only MouseAutoScript.py works correctly.
This has only been tested on a 1920x1080 resolution. 

First, make sure time, Mouse, and Keyboard are installed on your system. follow the directions on pypi.org or similar websites. Install these at your own risk. 
I installed both Mouse and Keyboard using "pip install mouse" and "pip install keyboard". Time was already installed for me.

To use, run MouseAutoScript.py. Run Zoom and pull up whatever SMS message log you wish to delete.
Make sure Zoom is in fullscreen (specifically that the window takes up the full screen)
hold the Shift key and the M key. This should start the macro. If it doesn't, try running script again.
The Macro should Right Click the top SMS Message, click the delete button, and click confirm. 

In order to stop the program, hold the Shift and M keys after the third click (after clicking the confirm button). 
You should have ~1 second to stop holding the keys once the Macro has stopped before it starts again.
Once you finish using the macro, choose another set of SMS messages or kill the program.

=====

To alter the coordinates as you wish: 
The three points (Right clicking the message, left clicking the delete button, and left clicking the confirm button) have been documented in the comments of the file.
To find the right coordinates for your machine, run a python shell, and import Keyboard. 
Place the mouse where you want for the specific point. Run "mouse.get_position()" to get the coordinates of that point.
The first two integers in "mouse.move()" are the X and Y positions of the mouse. Note that the "absolute" value must be true for this to work.
Replace these X and Y values with your new points.

This may fix any issues with changes in resolution. If the macro does not work, attempt to replace the coordinates with ones specific for your machine.