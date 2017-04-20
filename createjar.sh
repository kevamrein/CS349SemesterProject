#!/bin/bash

jar cvfm PossibleGame.jar *.mf application/*.class characters/*.class io/*.class io/*.png io/*.wav physics/*.class Title/*.class utilities/*.class

mv PossibleGame.jar ~/Desktop/PossibleGame.jar
