public class App {
    public static void main(String[] args) throws Exception {
        long num = 0;
        int posicion = 0;
        int insertar = 0;

        boolean correcto = false;
        do {
            num = Integer.parseInt(System.console().readLine("Por favor, introduzca un número entero positivo: "));
            posicion = Integer.parseInt(System.console().readLine("Introduzca la posición donde quiere insertar: "));
            insertar = Integer.parseInt(System.console().readLine("Introduzca el dígito que quiere insertar: "));

            if (num <= 0)
                System.out.println("Introduce un numero mayor que 0");
            else
                correcto = true;

        } while (!correcto);

        long aux = num * 10 + 1;
        long invertido = 0;
        int numDigito = 0;
        while (aux > 0) {
            long digito = aux % 10;
            invertido = invertido * 10 + digito;
            numDigito++;
            aux /= 10;
        }
        numDigito--;
        long parte1 = 0;
        long parte2 = 0;
        int numParte2 = 0;
        for (int i = 1; i <= numDigito; i++) {

            long digito = invertido % 10;

            if (i < posicion) {
                parte1 = parte1 * 10 + digito;
            } else {
                parte2 = parte2 * 10 + digito;
                numParte2++;
            }
            invertido /= 10;
        }
        System.out.printf("Los números partidos son el %d y el %d.%n", parte1, parte2);

        long entro = (parte1 * 10 + insertar) * (int)(Math.pow(10, numParte2)) + parte2;
        System.out.printf("El número resultante es %d.", entro);
    }
}
