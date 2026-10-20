//sondeo lineal

class Hash{
    private String[] datos;
    private int tam;

    public Hash(int tam){
        this.tam=tam;
        this.datos= new String[tam];
    }

    public int hashing(String n){
        int suma=0;
        for(int i =0; i<n.length();i++){
            suma+=n.charAt(i);
        }
        return suma%tam;
    }

    public void ingresar(String n){
        int pos = hashing(n);
        if(datos[pos]!=null){
            System.out.println("hay colision");
            while(datos[pos]!=null){
                pos++;
                if(pos==tam){
                    System.out.println("llegamos al limite");
                    return;
                }
            }

        }
        datos[pos]=n;
    }
    
    
    public void eliminar(String n){
        int pos = hashing(n);

        
        if(datos[pos]!=n){
            while (pos < tam && datos[pos]!=null) {
                if (datos[pos]==n) {
                    datos[pos]=null;
                    return;
                }
                pos++;
            }
        }
        datos[pos]=null;
    }

    public int buscar(String n) {
    int pos = hashing(n);

    while (pos < tam && datos[pos] != null) {
        if (datos[pos]==(n)) {
            System.out.printf("Está en la posición %d\n", pos);
            return pos;
        }
        pos++;
    }

    System.out.println("No se encontró");
    return -1;
}

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