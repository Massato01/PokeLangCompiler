cls

echo "Compilando"

javac ../Lexico/*.java
javac ../Sintatico/*.java
javac *.java

java -cp "$(pwd | Select-String [A-Z].*)" Main > Main.java

echo "Analisador Lexico Terminado"