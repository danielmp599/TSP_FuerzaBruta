package newpackage;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationSimple {

    private static final int tam = 8; //Variable global con el tamaño de la matriz 
    Set<String> results = new HashSet<>(0);

    public PermutationSimple() {
        // TODO Auto-generated constructor stub
    }
    //Este metodo sirve para generar las permutaciones n!
    public static List<String> generatePermutations(Set<Integer> availableNumbers) { //Método que retorna una lista con las permutaciones sin repeticion
        List<String> permutations = new LinkedList<>(); //Aqui vamos a almacenar las permutaciones nuevas
        for (Integer number : availableNumbers) { //Un for para almacenar el numero de permutacioens
            Set<Integer> numbers = new HashSet<>(availableNumbers);
            numbers.remove(number);
            if (!numbers.isEmpty()) {//Si está vacio
                List<String> childPermutations = generatePermutations(numbers); //Llamado recursivo 
                for (String childPermutation : childPermutations) {
                    String permutation = number + childPermutation;
                    permutations.add(permutation);//Agregamos la suma de las permutaciones
                }
            } else {
                permutations.add(number.toString());
            }
        }

        return permutations;
    }

    //Clase main
    public static void main(String[] args) {
        Set<Integer> availableNumbers = new HashSet<>(0); //Almacena los primeros numeros 
        Set<Integer> nulos = new HashSet<>(0);//Almacena cada que en cierta fila encuentre algun valor nulo, almacena el indice
        int suma;// Variable auxiliar para sumar los costos
        //Generamos matriz puede ser aleatoria o ingresarla de forma manual
        System.out.println("Tabla de costos");
        //Descomentar la sig linea si quieres los numeros aleatorios y comentar la manual 
//        int[][] grafos = new int[tam][tam];
        int[][] grafos = {{0, 8 ,0, 9, 4, 7,4,6},{3,0,9,3,1,0,4,4},{5,7,0,2,4,4,7,3},
            {2,6,2,0,0,3,2,0},{5,4,3,3,0,4,8,9},{3,0,5,4,8,0,3,9},{6,4,8,0,5,9,0,3},{3,5,9,3,2,2,6,0}}; //Aqui se ingresa los valores para la matriz de costos
        for (int i = 0; i < tam; i++) {//Ciclo para imprimir o asignar numeros aleatorios, para numeros aleatorios descomentar la linea 50 y 53 
            for (int j = 0; j < tam; j++) {
                if (i == j) {
//                    grafos[i][j] = 0;
                    System.out.print(" " + grafos[i][j] + " ");
                } else {
//                    grafos[i][j] = (int) Math.floor(Math.random() * 9 + 0);
                    System.out.print(" " + grafos[i][j] + " ");
                }
            }
            System.out.println("");
        }

        for (int i = 0; i < tam; i++) {// Se agrega para calcular su factorial
            availableNumbers.add(i);
        }

        List<String> permutations = generatePermutations(availableNumbers); // Se llama al metodo que regresa las permutaciones en formato String
        System.out.println(permutations);//Imprime la lista permutaciones

        System.out.println("");
        int indice = permutations.size();//Variable auxiliar con el tamaño de la lista
        int[] aux = new int[permutations.get(0).length()]; // Vector auxiliar para almacenar los indices de las permutaciones
        System.out.println("");
        System.out.println("Permutaciones: " + permutations.size()); //Se imprime el total de permutaciones, usualmente es n!
        System.out.println("****Ciclo Hamilton****=======***Costo***");
        for (int i = 0; i < indice; i++) {
            nulos.clear();//Se limpia la lista nulos
            suma = 0;//inicializa suma en  0 para calcular cada posible camino
            for (int j = 0; j < permutations.get(i).length(); j++) {
                aux[j] = Character.getNumericValue(permutations.get(i).charAt(j));//Se extrae el j caracter de la lista posicion i para posterior converit a entero
                System.out.print(aux[j] + " , ");//Se imprime el camino de la permutacion
            }

            for (int j = 0; j < permutations.get(i).length() - 1; j++) {
                suma = suma + grafos[aux[j]][aux[j + 1]]; //se acumula la suma para cada posible camino
                if (grafos[aux[j]][aux[j + 1]] == 0) { // si de un nodo a otro el camino es inf (representado por 0) incrementa nulos
                    nulos.add(j);//nulos se agrega el contenido j
                }
            }
            if (nulos.size() != 0) { //Para imprimir, si nulos es diferente de 0, significa que hay caminos nulos entre nodos por lo que el costo es inf
                System.out.print("  =========   inf");
                System.out.println("");
            } else { // de no ser asi significa que no hay caminos nulos y por lo tanto si hay camino entre nodos
                System.out.print("  =========   " + suma); 
                System.out.println("");
            }

        }

    }
}
