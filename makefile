BUILD=./build
SRC=./src
CFLAGS=-d $(BUILD) -cp $(BUILD):$(SRC) -Xlint
CFLAGS2=-cp $(BUILD):$$CLASSPATH
FLAGS=-cp $(BUILD):$$CLASSPATH -d $(BUILD)

EXEC= run
COMPILE=compile

default: $(COMPILE)

compile: $(SRC)/menu.java
	javac $(CFLAGS) $^

compileTest:$(SRC)/ModelTable.java $(SRC)/Fenetre.java $(SRC)/TableComponent.java $(SRC)/ButtonEditor.java $(SRC)/ButtonRenderer.java
	javac $(CFLAGS) $^

compileTest2: $(SRC)/menu_test1.java $(SRC)/Fenetre1.java $(SRC)/menu_test1Info.java
	javac $(CFLAGS) $^

compileProg: $(SRC)/FenetrePrincipal.java $(SRC)/menuPrincipalInfoRecette.java $(SRC)/ButtonRenderer.java $(SRC)/ModelTable.java $(SRC)/TableComponent.java $(SRC)/ButtonEditor.java $(SRC)/RecetteInfo.java $(SRC)/DialogDetailRecette.java $(SRC)/DialogStat.java $(SRC)/DialogEleve.java $(SRC)/ResultatEleve.java	$(SRC)/DialogMesRecettes.java $(SRC)/ResultatMesRecettes.java $(SRC)/ResultatStat.java $(SRC)/DialogNote.java $(SRC)/ResultatNote.java $(SRC)/DialogAdd.java
	javac $(CFLAGS) -nowarn $^


test2: compileTest2
	java $(CFLAGS2) Fenetre1

test: compileTest
	java $(CFLAGS2) Fenetre

run: compile
	java $(CFLAGS2) menu

prog: compileProg
	java $(CFLAGS2) FenetrePrincipal

expl: cmplEx
	java $(CFLAGS2) Exemple

cmplEx:$(SRC)/Exemple.java $(SRC)/Requete.java
	javac $(FLAGS) $^

clean:
	rm -rf $(BUILD)/*
