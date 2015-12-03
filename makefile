BUILD=./build
SRC=./src
CFLAGS=-d $(BUILD) -cp $(BUILD) -Xlint
CFLAGS2=-cp $(BUILD)

EXEC= run
COMPILE=compile

default: $(COMPILE)

compile: $(SRC)/menu.java
	javac $(CFLAGS) $^

compileTest: $(SRC)/menuPerso.java $(SRC)/Fenetre.java
	javac $(CFLAGS) $^

compileTest2: $(SRC)/menu_test1.java $(SRC)/Fenetre1.java $(SRC)/menu_test1Info.java
	javac $(CFLAGS) $^

compileProg: $(SRC)/menuPrincipal.java $(SRC)/FenetrePrincipal.java $(SRC)/menuPrincipalInfoRecette.java
	javac $(CFLAGS) $^


test2: compileTest2
	java $(CFLAGS2) Fenetre1

test: compileTest
	java $(CFLAGS2) Fenetre

run: compile
	java $(CFLAGS2) menu

prog: compileProg
	java $(CFLAGS2) FenetrePrincipal

clean:
	rm -rf $(BUILD)/*
