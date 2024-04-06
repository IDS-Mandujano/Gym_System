package Controllers;
import java.util.Scanner;

public class Usuario {

    protected String user;
    protected String pass;

    public String getUser() {
        return user;
    }
    public String getPass() {
        return pass;
    }

    public String iniciarSesion(){
        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        Gerente g = new Gerente();
        Administrador a = new Administrador();
        
        String rol = null;
        int intentos = 3;
        Boolean success = false;

        do {
            
            System.out.println("Intentos disponibles: "+intentos);
            System.out.print("Ingrese su usuario: ");
            this.user = read.next();
            System.out.print("Ingrese su contraseña: ");
            this.pass = read.next();

            if (
                (!this.pass.equals(g.getPass()) && !this.pass.equals(a.getPass())) && 
                (!this.user.equals(g.getUser()) && !this.user.equals(a.getUser()))) {
                System.out.println("Usuario y contraseña incorrectas");
                intentos -=1;
            }else if (!this.user.equals(g.getUser()) && !this.user.equals(a.getUser())) {
                System.out.println("Usuario Incorrecto");
                intentos -= 1;
            }else if (!this.pass.equals(g.getPass()) && !this.pass.equals(a.getPass())) {
                System.out.println("Contraseña incorrecta");
                intentos -=1;
            }

            if (this.user.equals(g.getUser()) && this.pass.equals(g.getPass())) {
                success = true;
                rol = g.getRol();
            }else if (this.user.equals(a.getUser()) && this.pass.equals(a.getPass())) {
                success = true;
                rol = a.getRol();
            }

        } while (intentos!=0 && success != true);
        
        return rol;
    }
}
