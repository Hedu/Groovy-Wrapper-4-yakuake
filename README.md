# Groovy Wrapper for Yakuake

# Which is the purpose of this project?
Create a groovy wrapper for the yakuake qdbus commands.

# What's Yakuake?
Yakuake is a terminal emulator based on KDE: https://www.kde.org/applications/system/yakuake/
Yakuake let you create multiple tabs and divide each one on multiple terminals

# What are those qdbus commands?
Yakuake allows the possibility of create new tabs, rename existing tabs, create new terminals... using its interface, but it also is possible to realize those actions executing some commandos on the terminal (the qdbus commands)
This is specially usefull if you want to create a script in order to initialize always some terminals on the computer startup

# So.... once more, which is the purpose of this project?
This project is just a wrapper, the goal is to manage this "API" using groovy instead of the qdbus commands

## Instructions
You just need to replace the content of the Groovy-Wrapper-4-yakuake/src/app/YakuakeConfig.groovy file with your own configuration and execute it on your computer startup:
- https://docs.kde.org/trunk5/en/kde-workspace/kcontrol/autostart/
- https://wiki.archlinux.org/index.php/KDE#Autostarting_applications
