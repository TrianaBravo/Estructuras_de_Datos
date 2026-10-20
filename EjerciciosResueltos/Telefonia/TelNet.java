public class TelNet {
    public static void main(String[] args) {
        System.out.println("Sistema de registro telefonico");

        //creamos tabla hash pequeña
        Hash TelNet = new Hash(10);

        //insercion numeros: 
        System.out.println("Registrando lineas telefonicas");
        TelNet.ingresar("+56911112222");
        TelNet.ingresar("+56933334444");
        TelNet.ingresar("+56955556666");
        TelNet.ingresar("+56977778888");
        //numero que colisionaria
        TelNet.ingresar("+56999990000");

        TelNet.mostrar();

        String telefonoBuscado = "+56955556666";
        System.out.println("Buscando: " + telefonoBuscado);
        int posicion = TelNet.buscar(telefonoBuscado);

        if (posicion != -1) {
            System.out.println(" ¡Línea encontrada! El abonado está registrado en la posición " + posicion);
        } else {
            System.out.println(" El telefono buscado no existe.");
        }
        
    }
    
}
