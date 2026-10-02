# Ejercicio: Playlist Musical
Contexto
Una aplicaci´on de streaming necesita gestionar la lista de reproducci´on (playlist) actual de un
usuario. Dado que las canciones pueden ser agregadas, eliminadas o modificadas de posici´on en
cualquier momento, se utilizar´a una lista simplemente enlazada para representar la playlist.
Cada nodo de la lista representa una canci´on y contiene la siguiente informaci´on:
T´ıtulo (string)
Artista (string)
Duraci´on (int), expresada en segundos.
3
Estado inicial
Al iniciar el programa, la playlist deber´a cargarse din´amicamente con las siguientes canciones:
[Gritos.mp3] −→ [zipzipzipremix] −→ [NeverGonnaGiveY ouUp] −→ [BohemianRhapsody] −→ NULL
Los datos correspondientes al artista y duraci´on de cada canci´on pueden ser definidos por el
estudiante.
Requerimientos de implementaci´on
Dise˜ne e implemente un men´u interactivo que permita al usuario realizar las siguientes operaciones:
1. agregarCancionFinal(...)
Permite agregar una nueva canci´on al final de la playlist.
2. insertarDespuesDe(...)
Solicita el t´ıtulo de una canci´on existente y los datos de una nueva canci´on. La nueva canci´on
deber´a ser insertada inmediatamente despu´es de la canci´on indicada.
Si la canci´on buscada no existe, se deber´a informar al usuario.
3. buscarCancion(...)
Busca una canci´on a partir de su t´ıtulo y muestra sus datos:
T´ıtulo
Artista
Duraci´on
La duraci´on deber´a mostrarse en formato minutos:segundos. Por ejemplo, una canci´on de
225 segundos deber´a mostrarse como 3:45.
4. mostrarPlaylist(...)
Recorre la lista desde el primer nodo hasta el ´ultimo e imprime todas las canciones en el
orden actual de reproducci´on.
5. duracionTotal(...)
Recorre la playlist y calcula la duraci´on total de todas las canciones almacenadas.
El resultado deber´a mostrarse en segundos y/o en formato minutos:segundos.
6. eliminarCancion(...)
Busca una canci´on por su t´ıtulo y la elimina de la lista.
La operaci´on deber´a actualizar correctamente los enlaces de la lista y liberar la memoria
asociada al nodo eliminado.
4
Desaf´ıos
Una vez implementadas las operaciones anteriores, agregue las siguientes funcionalidades.
7. moverAdelante(titulo) Permite adelantar una canci´on una posici´on dentro de la playlist.
Para realizar esta operaci´on, se debe buscar la canci´on indicada y modificar los enlaces necesarios para intercambiar su posici´on con el nodo que la precede.
Por ejemplo, dada la siguiente playlist:
[A] −→ [B] −→ [C] −→ NULL
al solicitar:
moverAdelante("C")
el resultado deber´a ser:
[A] −→ [C] −→ [B] −→ NULL
Se debe considerar especialmente el caso en que la canci´on seleccionada sea la primera de la
lista.
8. modoCaos(duracionMinima) Implemente una funci´on que elimine de la playlist todas las
canciones cuya duraci´on sea menor al valor l´ımite X recibido como par´ametro.
La funci´on deber´a recorrer la lista completa y eliminar todos los nodos que cumplan la condici´on:
duracion < X ´
Se deben considerar correctamente todos los casos posibles, incluyendo:
La primera canci´on de la lista debe ser eliminada.
La ´ultima canci´on debe ser eliminada.
Dos o m´as canciones consecutivas deben ser eliminadas.
Todas las canciones de la lista cumplen la condici´on.
Ninguna canci´on cumple la condici´on.
Ejemplo de ejecuci´on
Considere la siguiente playlist:
[A (210s)] −→ [B (120s)] −→ [C (90s)] −→ [D (240s)] −→ [E (150s)] −→ NULL
Al ejecutar:
modoCaos(180)
se deber´an eliminar todas las canciones cuya duraci´on sea menor a 180 segundos.
El resultado esperado ser´a:
[A (210s)] −→ [D (240s)] −→ NULL
5
Consideraciones
La playlist debe implementarse utilizando una lista simplemente enlazada.
No se permite utilizar estructuras como ArrayList, arreglos u otras estructuras para reemplazar la lista enlazada.
Las operaciones de inserci´on y eliminaci´on deben realizarse modificando los enlaces entre los
nodos.
Toda memoria reservada din´amicamente deber´a ser liberada cuando corresponda.
El programa debe manejar correctamente una playlist vac´ıa.
El programa debe manejar correctamente los casos en que una canci´on no exista.
