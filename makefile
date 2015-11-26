BUILD=./build
SRC=./src
CFLAGS=-d $(BUILD) -cp $(BUILD)
CFLAGS2=-cp $(BUILD)

EXEC= run
COMPILE=compile

default: $(COMPILE)

compile: $(SRC)/menu.java
	javac $(CFLAGS) $^


run: compile
	java $(CFLAGS2) menu

clean:
	rm -rf $(BUILD)/*
