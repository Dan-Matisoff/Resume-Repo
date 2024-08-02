import keyboard
import mouse
import time

### Program to automate deleting Zoom Phone SMS messages
### Optimized for a computer at 1920x1080 resolution
### Please use the Mouse Macro version if this one does not work for you

mouseActive = False #Toggles whether to do the macro
counter = 0         #Timer to add delay

while True:
    if keyboard.is_pressed("shift+m") and counter == 0: #When Shift and M are pressed and the delay is done
        mouseActive = not mouseActive                   #Change macro flag
        counter = 5                                     #Begin delay
    elif counter > 0:                                   #Decrement Delay
        counter = counter - 1
    if mouseActive:                                     #Do Macro
        mouse.play(events[:-1])
        time.sleep(0.2)
    elif keyboard.is_pressed("r"):                      #If record key pressed, record macro
        events = mouse.record()          #Stops on right click
    time.sleep(0.2)                                             #Add small delay
    if keyboard.is_pressed("esc"):                      #When escape key pressed, stop program
        break



keyboard.unhook_all