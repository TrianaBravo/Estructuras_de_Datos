//codigo basico de sondeo lineal, en este metodo si hay colision se mueve el dato a la siguiente casilla mas cercano

public class HashSondeoLinenal {
    //atributos
    private String[] datos;
    private int tam;
   

    //constructor
    public HashSondeoLinenal(int tam) {
        this.tam = tam;
        this.datos = new String[tam];
        
    }

    //función hash, hace una suma de la posicion dentro del arreglo del string y retona el indice de el arreglo 
    public int hashing(String n) {
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            result += n.charAt(i);
        }
        return result % tam;
    }

    public void ingresar(String n) {
        
        //manda el numero del indice en pos
        int pos = hashing(n);
        
        // Sondeo lineal con resolución circular usando % tam
        //recorre el arreglo hasta encontrar la posicion del arreglo, si es distinto de null significa que esta ocupado y hay colision
        while (datos[pos] != null) {
            // Evitar duplicados exactos si ya existe
            //si el dato que queremos guardar ya existe entonces lo dejamos 
            if (datos[pos].equals(n)) {
                System.out.println(" El elemento '" + n + "' ya existe en la tabla.");
                return;
            }
            //como hay una colision busca el siguiente indice vacio mas cercano
            System.out.println("Colisión en índice " + pos + " para el valor '" + n + "'. Buscando siguiente...");
            pos ++; // Da la vuelta al llegar al final
            
            //si se llega al final no hay espacio
            if (pos== tam) {
                System.out.println("No hay espacio disponible.");
                return;
            }
        }
        //si se encuentra espacio se agrega al arreglo
        datos[pos] = n;
        System.out.println("Insertado '" + n + "' en el índice " + pos);
    }

   

    public void mostrar(int pos){
        System.out.println(this.datos[pos]);
    }

    public void mostrar_todos(){
        for (int i = 0; i<tam; i++){
            if (datos[i]!=null) {
                System.out.println(datos[i]);
            } else {
                System.out.println("0");
            }
        }
    }
}