package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    
    public int validarDatoEntrada() {
        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        boolean bandera;
        int num = 0;
        
        do {
            try {
                num = read.nextInt();
                bandera = false;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese caracteres numéricos");
                read.next();
                bandera = true;
            }
        } while (bandera);

        return num;
    }
}
