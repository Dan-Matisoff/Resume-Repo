import keyboard
import mouse
import time

### Program to automate deleting Zoom Phone SMS messages
### Optimized for a computer at 1920x1080 resolution, with Zoom in fullscreen.
### Please use the Mouse Macro version (in progress) if this one does not work for you

mouseActive = False #Toggles whether to do the macro
counter = 0         #Timer to add delay

while True:
    if keyboard.is_pressed("shift+m") and counter == 0: #When Shift and M are pressed and the delay is done
        mouseActive = not mouseActive                   #Change macro flag
        counter = 5                                     #Begin delay
    elif counter > 0:                                   #Decrement Delay
        counter = counter - 1
        time.sleep(0.2)
    if mouseActive:                                     #Do Macro
        mouse.move(320, 196, absolute = True, duration = 0.2)   #Move to first point (First SMS Message)
        mouse.click('right')                                    #Right Click
        mouse.move(411, 388, absolute=True, duration=0.2)       #Move to second point (Delete Button in Menu)
        mouse.click('left')                                     #Left Click
        mouse.move(889, 480, absolute=True, duration=0.2)       #Move to third point (Click Confirm)
        mouse.click('left')                                     #Left Click
    time.sleep(0.2)                                             #Add small delay
    if keyboard.is_pressed("esc"):                      #When escape key pressed, stop program
        break



keyboard.unhook_all