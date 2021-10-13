# TSP_FuerzaBruta
El objetivo de este programa es unicamente mostrar una solución por medio de fuerza bruta para el problema más común en el mundo de las matematicas y la computación.
Este es TSP (Traveling Salesman Problem) o también conocido como el problema del agente viajero.
Como se sabe existen muchas soluciones propuestas que optimizan el costo computacional que el problema requiere.
El problema consiste en que el algoritmo debe de recorrer todos los nodos y determinar el costo mas bajo entre los recorridos.
La complejidad del algoritmo es de O(n!) pues la forma de encontrar la solución es hallar todas las posibilidades para todos los nodos, es decir, si tenemos 5 nodos, la complejidad será de 5!. Por cada nodo que se agregue aumenta notoriamente su complejidad y por lo tanto su tiempo de ejecución. 
Resolver el problema para 25 nodos se estima que tarde cerca de 10 años en resolverse en algún ordenador promedio de uso domestico con buen procesamiento, pues el numero de permutaciones es extremadamente alto. 
El algoritmo deja de ser efectivo con numeros grandes, como se mencionó en un principio, existen diferentes soluciones echas para resolver el coste computacional que este problema implica pero para fines de enseñanza, el objetivo es resolverlo por medio de fuerza bruta.
