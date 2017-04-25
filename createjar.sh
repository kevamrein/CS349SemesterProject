#!/bin/bash

jar cvfm PossibleGame.jar *.mf application/*.class characters/*.class io/*.class io/*.png io/*.wav physics/*.class title/*.class utilities/*.class

cp PossibleGame.jar ~/Desktop/PossibleGame.jar

scp PossibleGame.jar amreinkh@stu.cs.jmu.edu:~/www/CS349/
