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

Jerarquia de Clases

Siguiendo los principios SOLID se diseña un código donde aquellas clases que tengan comportamientos comunes
sean subclases de una clase abstracta la cual comprende aquellos comportamientos. En el caso de los distintos
personajes y clases es posible notar que estas comparten un conjunto de acciones y solo se diferencian en
algunos puntos, por ejemplo, el uso de magias.

Es así como cada clase de personaje es una subclase de 'Player Character', la cual contiene los metedos 'equals',
'hashcode' y 'equip', y esta es subclase de 'Abstract Character'. Un aspecto a considerar fue que si bien tanto enemigos como
personajes comparten ciertos metodos, existen ciertas diferencias como que los enemigos no pueden equipar armas y, también, da
lugar a la idea a que pueden existir otras diferencias por lo que la clase 'Enemies' es directamente subclase de
'Abstract Character'.

Para el paquete 'Weapons' se sigue la misma idea, donde tenemos una clase para cada arma que son subclases de 'Abstract Weapon'.
Esto se hace con la idea de que si a futuro tienen atributos especificos para cada tipo solo es necesario escribir
codigo y no modificar lo que ya esta escrito. Esto tambien se hace con el objeto de verificar si un personaje
en particular puede equipar un cierto tipo de arma.
