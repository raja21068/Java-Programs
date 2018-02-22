javac *.java
rmic CalcImp
start rmiregistry
start rmid -J-Djava.security.policy=sachal.policy
java -Djava.security.policy=sachal.policy Setup
pause..