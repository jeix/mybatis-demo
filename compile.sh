#!/bin/sh

mkdir bin
mkdir bin/main
mkdir bin/test

MAIN_DST_PATH="bin/main"
MAIN_CLS_PATH="bin/main"
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/domain/*.java
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/mappers/*.java
MAIN_CLS_PATH="$MAIN_CLS_PATH:lib/mybatis-3.2.7.jar"
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/mappers/ann/sql/*.java
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/mappers/ann/*.java
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/util/*.java
MAIN_CLS_PATH="$MAIN_CLS_PATH:lib/slf4j-api-1.7.5.jar"
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/services/*.java
javac -cp "$MAIN_CLS_PATH" -d $MAIN_DST_PATH src/mybatis3/services/ann/*.java
TEST_CLS_PATH="bin/main:bin/test:lib/junit-4.11.jar"
TEST_DST_PATH="bin/test"
javac -cp $TEST_CLS_PATH -d $TEST_DST_PATH test/mybatis3/services/*.java
javac -cp $TEST_CLS_PATH -d $TEST_DST_PATH test/mybatis3/services/ann/*.java
javac -cp "bin/main:bin/test:lib/junit-4.11.jar" -d bin/test test/mybatis3/services/ann/*.java

cp res/*.properties $MAIN_DST_PATH
cp res/*.xml $MAIN_DST_PATH
cp res/mybatis3/mappers/*.xml $MAIN_DST_PATH/mybatis3/mappers
