BUILD=./build
SRC=./src
CFLAGS=-d $(BUILD) -cp $(BUILD)
CFLAGS2=-cp $(BUILD)

EXEC= run
COMPILE=compile

default: $(COMPILE)

compile: $(SRC)/programme_recette.java
	javac $(CFLAGS) $^


run: compile
	java $(CFLAGS2) ./$(BUILD)/programme_recette
