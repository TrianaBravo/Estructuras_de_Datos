# #Ejercicio 1: 
### Se tiene una pila de enteros positivos. Con las operaciones básicas de pilas y colas escribir un fragmento de código para poner todos los elementos que son par de la pila en la cola.

# #Ejercicio 2: 
### Un pequeño supermercado dispone en la salida de tres cajas de pago. En el local hay 25 carritos de compra. Escribir un programa que simule el funcionamiento, siguiendo las siguientes reglas:
- **Si cuando llega un cliente no hay ningún carrito disponible, espera a que lo haya.**
- **Ningún cliente se impacienta y abandona el supermercado sin pasar por alguna de las colas de las cajas.**
- **Cuando un cliente finaliza su compra, se coloca en la cola de la caja que hay menos gente, y no se cambia de cola.**
- **En el momento en que un cliente paga en la caja, su carrito de la compra queda disponible.** 

### Representar la lista de carritos de la compra y las cajas de salida mediante colas. 


# #Ejercicios 3: 
### En un archivo F están almacenados números enteros arbitrariamente grandes. La disposición es tal que hay un número entero por cada línea de F. 
### Escribir un programa que muestre por pantalla la suma de todos los números enteros. Al resolver el problema habrá que tener en cuenta que, al ser enteros grandes, no pueden almacenarse en variables numéricas.
### Utilizar dos pilas para guardar los dos primeros números enteros, almacenándose dígito a dígito. Al extraer los elementos de la pila, salen en orden inverso y, por tanto, de menor peso a mayor peso; se suman dígito con dígito y el resultado se guarda en una cola, también dígito a dígito. A partir de este primer paso se obtiene el siguiente número del archivo, se guarda en una pila y, a continuación, se suma dígito a dígito con el número que se encuentra en la cola; el resultado se guarda en otra cola. El proceso se repite, nuevo número del archivo se mete en la pila, que se suma con el número actual de la cola.

# #Ejercicio 4: 
### Una empresa de reparto de propaganda contrata a sus trabajadores por días. Cada repartidor puede trabajar varios días continuados o alternos. Los datos de los repartidores se almacenan en una lista enlazada. El programa a desarrollar contempla los siguientes puntos:

- **Crear una cola que guarde el número de la seguridad social de cada repartidor y la entidad anunciada en la propaganda para un único día de trabajo.** 
-  **Actualizar la lista citada anteriormente (que ya existe con contenido) a partir de los datos de la cola. La información de la lista es la siguiente:**
- -  **número de seguridad social**
- - **nombre**
- - **total de días trabajados.**
- - **Debe estar ordenada por el número de la seguridad social.**

- **Si el trabajador no está incluido en la lista, debe añadirse a la misma de tal manera
que siga ordenada.**

# #Ejercicio 5:

### El supermercado Esperanza quiere simular los tiempos de atención al cliente a la hora de pasar por la caja. Los supuestos de los que se parte para la simulación son los siguientes:

- **Los clientes forman una única fila. Si alguna caja está libre, el primer cliente de la fila es atendido. 
En el caso de que haya mas de un caja libre, la elección del número de caja por parte del cliente es aleatoria.**

- **El número de cajas del que se dispone para atención a los clientes es de tres, salvo que haya mas de 20 personas esperando en la fila; entonces se habilita una cuarta caja, que se cierra cuando no quedan clientes esperando. El tiempo de atención de cada una de las cajas está distribuido uniformemente: la caja 1 entre 1,5 y 2,5 minutos; la caja 2 entre 2 y 5 minutos, la caja 3 entre 2 y 4 minutos. La caja 4, cuando está abierta, tiene un tiempo de atención entre 2 y 4,5 minutos.**
- **Los clientes llegan a la salida en intervalos de tiempo distribuidos uniformemente, con un tiempo medio de 1 minuto.
El programa de simulación se debe realizar para 7 horas de trabajo. Se desea obtener una estadística con los siguientes datos:** 
- - Clientes atendidos durante la simulación.
- - Tamaño medio de la fila de clientes.
- - Tamaño máximo de la fila de clientes.
- - Tiempo máximo de espera de los clientes.
- - Tiempo en que está abierto la cuarta caja.