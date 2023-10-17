#!/bin/bash

if [ "$1" == build ]; then
  echo "Building project..."
  mvn clean
  mvn compile
  mvn package
else
  java -cp ./target/pokergame-1.0.jar org.demo.simple.Main
fi