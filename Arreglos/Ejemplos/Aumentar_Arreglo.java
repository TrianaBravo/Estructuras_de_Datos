//EJEMPLO SOBRE AUMENTAR EL TAMAÑO DE UN ARREGLO

public class Aumentar_Arreglo{
    public static void main(String[] args) {    
        //creamos un arreglo inicial

        int [] Arreglo_Original= {1,2,3,4,5};

        //Nuevo tamaño del arreglo

        int Nuevo_Tamanio=10;

        //Creamos un nuevo arreglo con el nuevo tamaño+
        
        int[] Nuevo_Arreglo = new int [Nuevo_Tamanio];

        //copiamos los elementos del arreglo original al nuevo arreglo
        for (int i=0; i<Arreglo_Original.length; i++){

            Nuevo_Arreglo[i]= Arreglo_Original[i];

        }

        Arreglo_Original=Nuevo_Arreglo;

        for (int elemento : Arreglo_Original){ 
            System.out.print(elemento + " ");
        }
    }
}