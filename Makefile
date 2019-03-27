
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES= \
	Liste.java \
	ChoixDeGrille.java \
	Colori.java \
	Controleur.java \
	Fenetre.java \
	LectureDoc.java \
	Partie.java \
	Jeu.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM).class
