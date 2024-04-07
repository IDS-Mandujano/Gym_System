package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controllers.Usuario;

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

    public String validarNull() {
        Usuario user = new Usuario();
        String rol = null;
    
        do {
            rol = user.iniciarSesion();
            if (rol != null) {
                return rol;
            } else {
                System.out.println("Ingrese credenciales válidas");
            }
        } while (true);
    }
    

}
