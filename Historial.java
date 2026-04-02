public class Historial {
    NodoDoble actual;

    public void agregarEstado(String texto) {
        EstadoDocumento estado = new EstadoDocumento(texto);
        NodoDoble nuevo = new NodoDoble(estado);

        if (actual != null) {
            actual.siguiente = null;
            nuevo.anterior = actual;
            actual.siguiente = nuevo;
        }

        actual = nuevo;
    }

    public void undo() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        }
    }

    public void redo() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        }
    }

    public void mostrar() {
        if (actual != null) {
            System.out.println("Texto: " + actual.dato.texto);
        }
    }
}