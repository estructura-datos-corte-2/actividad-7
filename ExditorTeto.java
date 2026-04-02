public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Historial h = new Historial();

        while (true) {
            String entrada = sc.nextLine();

            if (entrada.equals(":u")) {
                h.undo();
            } else if (entrada.equals(":r")) {
                h.redo();
            } else if (entrada.equals(":q")) {
                break;
            } else {
                h.agregarEstado(entrada);
            }

            h.mostrar();
        }
    }
}