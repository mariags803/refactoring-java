# Refactoring

## 1. Kata Cofres

### 1.1. Descripción

María es una joven que trabaja en una de las muchas oficinas de la gran ciudad. Un día, cansada del ruido y el estrés,
decide mudarse a la tranquila granja de su abuela para dedicarse a la agricultura y la ganadería. Allí, tiene un jardín
con un pequeño huerto, un gallinero y un corral, aunque no en muy buen estado. Va a necesitar muchos materiales para
poder mejorar las instalaciones.

Es entonces cuando María agarra su mochila y se dirige al bosque para recolectar madera, piedra, cobre, semillas,
frutas y cualquier cosa que pueda necesitar. No sin antes dejar construidos 3 cofres: uno para materiales, otro para
comida y otro para semillas.

Su mochila no es muy grande, sólo tiene 8 huecos para poner objetos. Por lo que, si se llena, tiene
que volver a casa para vaciarla. A María le gustan sus excursones al bosque y recolectar materiales, pero no le gusta
llegar a casa y tener que ordenar los cofres. Por eso, decide ir a visitar al brujo de la torre, cerca de la granja.
Éste le dice que le puede ayudar mediante un conjuro de ordenación, pero primero tiene que prepararlo. Así que María
vuelve feliz a su rutina diaria, sabiendo que pronto podrá ordenar sus cofres con un simple hechizo.

### 1.2. Requerimientos

Antes de irse, María le dejó al brujo una lista con los objetos que suele recolectar:

- Materiales de construcción:
    - Madera
    - Piedra
    - Carbón
    - Mena de cobre
    - Mena de hierro
- Semillas:
    - Semilla de trigo
    - Semilla de patata
    - Semilla de zanahora
    - Semilla de maíz
    - Semilla de col rizada
- Comida:
    - Frambuesa
    - Albaricoque
    - Cebolla silvestre
    - Seta
    - Trucha

Una vez el brujo tiene el conjuro preparado, se lo enseña a María, advirtiéndole de las siguientes reglas:

- La mochila se vaciará una vez los objetos se hayan ordenado en los cofres.
- Como cada cofre tiene una capacidad máxima de 16 objetos, si éste está lleno, no se podrá añadir más objetos. Estos
  objetos desaparecerán.
- Los objetos se ordenarán alfabéticamente, cada uno en su cofre correspondiente y por cantidad de mayor a menor.
- Si el objeto ya está en el cofre, se sumará la cantidad hasta llegar a 5, luego el objeto ocupará una nueva posición.

### 1.3. Ejemplo

María acaba de llegar a casa y tiene la mochila llena de objetos:

- 2 Madera
- 5 Madera
- 3 Piedra
- 1 Seta
- 4 Semilla de trigo
- 2 Semilla de patata
- 1 Trucha
- 3 Mena de cobre

Recita el conjuro y los objetos se ordenan en los cofres vacíos de la siguiente manera:

- Cofre de materiales:
    - 5 Madera
    - 2 Madera
    - 3 Mena de cobre
    - 3 Piedra
- Cofre de semillas:
    - 2 Semilla de patata
    - 4 Semilla de trigo
- Cofre de comida:
    - 1 Seta
    - 1 Trucha