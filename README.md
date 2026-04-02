# actividad-7#  Editor de Texto con Deshacer/Rehacer (Lista Doblemente Enlazada)

##  Descripción

Este proyecto implementa un **editor de texto en consola** que permite gestionar un historial de cambios mediante una **lista doblemente enlazada**.

El sistema permite navegar entre versiones del documento usando las operaciones de:

* Deshacer (**Undo**)
* Rehacer (**Redo**)

Simulando así el comportamiento de la memoria de versiones en aplicaciones modernas.

---

##  Objetivo

Aplicar el concepto de **listas doblemente enlazadas** para construir un sistema de historial bidireccional que permita:

* Navegar entre estados anteriores y futuros
* Gestionar versiones de texto eficientemente
* Implementar truncamiento de historial

---

##  Concepto Teórico

Una **lista doblemente enlazada** es una estructura de datos donde cada nodo contiene:

* Un valor (en este caso, el estado del documento)
* Un puntero al nodo anterior
* Un puntero al nodo siguiente

Esto permite recorrer la lista en ambas direcciones:

```
[Estado1] ⇄ [Estado2] ⇄ [Estado3]
```

---

##  Funcionamiento del Sistema

###  Guardar Estado

Cada vez que el usuario ingresa texto, se crea un nuevo nodo en la lista.

---

###  Deshacer (Undo)

El puntero actual se mueve al nodo anterior:

```
actual = actual.anterior
```

---

###  Rehacer (Redo)

El puntero actual se mueve al nodo siguiente:

```
actual = actual.siguiente
```

---

###  Truncamiento del Historial (IMPORTANTE)

Cuando el usuario:

1. Realiza un **deshacer**
2. Luego escribe un nuevo estado

👉 Se eliminan todos los estados futuros

Ejemplo:

Antes:

```
Estado1 → Estado2 → Estado3
              ↑
           actual
```

Después de deshacer y escribir:

```
Estado1 → Estado2 → EstadoNuevo
```

✔ Se elimina `Estado3` porque ya no es válido

---

##  Estructura del Proyecto

```
/proyecto
│── EstadoDocumento.java
│── NodoDoble.java
│── Historial.java
│── EditorTexto.java
```

---

##  Clases Principales

###  EstadoDocumento

Representa el contenido del texto en un momento específico.

---

###  NodoDoble

Nodo de la lista que contiene:

* Estado del documento
* Referencia al nodo anterior
* Referencia al nodo siguiente

---

###  Historial

Gestiona toda la lista:

* Inserción de estados
* Deshacer y rehacer
* Control del nodo actual
* Truncamiento del historial

---

###  EditorTexto

Interfaz en consola que permite interactuar con el usuario.

---

##  Instrucciones de Uso

1. Ejecutar el programa
2. Escribir texto para guardar un estado
3. Usar comandos especiales:

| Comando | Acción   |
| ------- | -------- |
| `:u`    | Deshacer |
| `:r`    | Rehacer  |
| `:q`    | Salir    |

---

##  Ejemplo de Ejecución

```
Editor de texto

>> Hola
>> Hola mundo
>> :u
Texto actual: Hola
>> :r
Texto actual: Hola mundo
```

---

##  Relación con Aplicaciones Reales

Este sistema simula cómo funcionan aplicaciones como:

* Editores de texto (Word, Google Docs)
* IDEs (VS Code, IntelliJ)

Estas utilizan estructuras similares para manejar el historial de cambios.

---

##  Sustentación (Guía para el Video)

En el video se debe explicar:

1. Cómo funciona la lista doblemente enlazada
2. Cómo se mueve el puntero actual
3. Qué ocurre en el truncamiento
4. Demostración en ejecución:

   * Escribir texto
   * Deshacer
   * Rehacer
   * Crear nueva rama (truncamiento)

---

##  Referencia Bibliográfica

Knuth, D. E. (1997).
*The Art of Computer Programming, Volume 1: Fundamental Algorithms* (3rd ed.).
Addison-Wesley Professional.

---

##  Autor

Nombre: [juan camilo puentes lara]
Código: [202528001615]

---

##  Conclusión

El uso de listas doblemente enlazadas permite implementar de manera eficiente sistemas de historial dinámicos, ofreciendo navegación bidireccional y control sobre versiones, elementos fundamentales en el desarrollo de software moderno.
