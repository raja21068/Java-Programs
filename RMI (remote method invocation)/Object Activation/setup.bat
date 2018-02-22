javac *.java
rmic ActivatableImplementation
start rmiregistry
start rmid -J-Djava.security.policy=sachal.policy
pause..