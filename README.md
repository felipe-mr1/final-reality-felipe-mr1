Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

This project is built using gradle, javafx,  java 11 and it's tested with JUnit 5.4.

Game
---

This consist in battle with turns between the user and computer. You start by choosing 4 players bewtween the 5:
Emily, Karol, Tata, Waldo, and Emo. Each one of these characters has a particular class, which can equip different
types of weapons and could, potentially, use magics (not implemented). The user will encounter a random set of
enemies between 1 and 4, and the game will finish once all the enemies are dead or all the user's players are dead.

During each turn the user can see their party info, inventory (where one can decide to equip a weapon in their inventory)
and select a target to attack. Once it's the enemy turn the user has to click 'next' to continue the game and the
computer will attack a random enemy.

It's important to note that once you pick a team and select start the computer will load the game for about six
seconds, it's NOT bugged.


Jerarquia de Clases (Spanish)
---

Siguiendo los principios SOLID se diseña un código donde aquellas clases que tengan comportamientos comunes
sean subclases de una clase abstracta la cual comprende aquellos comportamientos. En el caso de los distintos
personajes y clases es posible notar que estas comparten un conjunto de acciones y solo se diferencian en
algunos puntos, por ejemplo, el uso de magias.

Es así como cada clase de personaje es una subclase de 'Abstract Player Character', la cual contiene los metedos 'equals',
'hashcode' y 'equip', y esta es subclase de 'Abstract Character'. Un aspecto a considerar fue que si bien tanto enemigos como
personajes comparten ciertos metodos, existen ciertas diferencias como que los enemigos no pueden equipar armas y, también, da
lugar a la idea a que pueden existir otras diferencias por lo que la clase 'Enemies' es directamente subclase de
'Abstract Character'.

Para el paquete 'Weapons' se sigue la misma idea, donde tenemos una clase para cada arma que son subclases de 'Abstract Weapon'.
Esto se hace con la idea de que si a futuro tienen atributos especificos para cada tipo solo es necesario escribir
codigo y no modificar lo que ya esta escrito. Esto tambien se hace con el objeto de verificar si un personaje
en particular puede equipar un cierto tipo de arma.

Modelo (Spanish)
---

El modelo de este proyecto contempla a los personajes del juego, los cuales unos corresponden a aquellos que el usuario puede
controlar y los enemigos que intentan atacar a los personajes del jugador. Ademas, se cuentan con las armas que puede equipar cada
personaje donde los enemigos no las pueden equipar. En esta sección se aplican diversos patrones de diseño de tal forma de ordenar
el código.


Controlador (Spanish)
---

Se implementa el controlador el cual es el intermediario entre el usuario y los objetos del modelo. El controlador
contiene los metodos que permiten que los objetos interactuen entre sí. Cuenta con los métodos getters con el fin de que el usuario
pueda conocer en todo momento datos como la vida de los personajes, enemigos, armas en el inventario, entre otos. Por otra parte,
el controlador permite saber cuando han quedado fuera de juego, como observador, los personajes del usuario tanto como los enemigos para así mandar un
mensaje de "Game Over".


Vista (Spanish)
---


Se utiliza la libreria javaFX para realizar la interfaz grafica del juego. Se utilizan labels para mostrar información
importante del juego y botones para recibir la decision del usuario y asi llevarlo a las distintas fases del juego.
Se toma en cuenta el input del usuario para saber a que enemigo atacar, que arma equipar y los personajes que desea utilizar.

El GUI se comunica directamente con el controlador que maneja los objetos del juego con lo que se obtiene la dinamica para
realizar una partida de principio a fin.

El juego consiste en elegir cuatro personajes que corresponden al grupo con que se va a jugar. Se generan una cantidad de enemigos
al azar entre 1 y 4. El juego termina cuando todos los enemigos mueran o todos los del grupo mueran.


Limitaciones (Spanish)
---


1. No se alcanzó a implementar el uso de magias ni los efectos adversos que se tenia previsto hacer.

2. Para la interfaz grafica se optó por elegir personajes predispuestos, de otra forma habría que contemplar una gran cantidad de inputs por parte del usuario
para generar un juego a su gusto. Por motivos de no complicar y extender la fase de creacion se decide dar a elegir los personajes a utilizar y generar una cantidad
al azar de enemigos (maximo 4).
