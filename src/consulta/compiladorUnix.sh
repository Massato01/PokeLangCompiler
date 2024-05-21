#!/bin/bash

# Limpe o terminal
clear

# Escreva a mensagem inicial
echo "Iniciando Compilador Unix"

# Compile todos os arquivos Java na pasta atual e subpastas
find . -name "*.java" -print | xargs javac

# Execute o arquivo Java e redirecione a saída para um novo arquivo Java na pasta raiz
java -cp /workspaces/Projeto_Compiladores projeto.Main > Main.java

# Compile o novo arquivo Java
javac Main.java

# Execute o novo arquivo Java
java Main