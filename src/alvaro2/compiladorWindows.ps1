cls

# Escreva a mensagem inicial
Write-Host "Iniciando Compilador PowerShell"

Remove-Item .\*\*.class -ErrorAction SilentlyContinue

# Compile todos os arquivos Java na pasta atual e subpastas
javac .\Lexico\*.java
javac .\Sintatico\*.java
javac .\projeto\*.java

# Execute o arquivo Java e redirecione a saída para um novo arquivo Java na pasta raiz
java .\projeto\Main.java > Main.java

# Compile o novo arquivo Java
# javac Main.java

# Execute o novo arquivo Java
# java -cp "$(pwd | Select-String [A-Z].*)" Main