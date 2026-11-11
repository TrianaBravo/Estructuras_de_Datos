//sondeo lineal
//atributos
class Hash{
    private String[] datos;
    private int tam;
    //constructor 
    public Hash(int tam){
        this.tam=tam;
        this.datos= new String[tam];
    }

    //hace suma de todo el arreglo y lo divide por el tamaño para sacar el numero del indice 
    public int hashing(String n){
        int suma=0;
        for(int i =0; i<n.length();i++){
            suma+=n.charAt(i);
        }
        return suma%tam;
    }
    //
    public void ingresar(String n){
        //dependiendo del la posicion del arreglo que nos dio la funcion hashing, hacemos un bucle hasta llegar ahi
        int posicion = hashing(n);
        if(datos[posicion]!=null){
            //si la posicion esta ocupada hay colision y recorremos el arreglo hasta encontrar una posicion vacia
            System.out.println("hay colision");
            while(datos[posicion]!=null){
                posicion++;
                //si no hay espacios vacios al llegar al final significa ue ni hay espacio en el arreglo
                if(posicion==tam){
                    System.out.println("llegamos al limite");
                    return;
                }
            }
        }
        datos[posicion]=n;
    }
    
    
    public void eliminar(String n){
        int posicion = hashing(n);
        if(datos[posicion]!=n){
            //recorrer el arreglo si esta dentro del tamaño del arreglo y que la posicion tenga algo dentro
            while (posicion < tam && datos[posicion]!=null) {
                //si la posicion llega al indice
                if (datos[posicion]==n) {
                    //borra el dato dejando ese espacio vacio
                    System.out.println("has sacado: " + datos[posicion]);
                    datos[posicion]=null;
                    return;
                }
                posicion++;
            }
        }
        datos[posicion]=null;
    }

    public int buscar(String n) {
    int posicion = hashing(n);
        //
    while (posicion < tam && datos[posicion] != null) {
        //si lo que buscamos es lo mismo nos devuelve la posicion
        if (datos[posicion]==(n)) {
            System.out.printf("Está en la posición %d\n", posicion);
            return posicion;
        }
        posicion++;
    }
    System.out.println("No se encontró");
    return -1;
}
    //
    public void mostrar(){
        for(int i =0; i<tam; i++){
            if(datos[i]!=null){
                System.out.println(datos[i]);
            }else{
                System.out.println("0");
            }
        }
    }

}