package Models;

import java.util.Scanner;
import utils.*;

public class Equipo extends Aparatos {

    private int peso;
    private int seccion;

    public Equipo() {}

    public Equipo(int peso, int seccion, String nombre, int estatus, int id) {
        super(nombre, estatus, id);
        this.seccion = seccion;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public void agregarAparatos() {
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();

        Inventario inventario = Inventario.obtenerInstancia();
        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        int opc = 0;

        do {
            menu.menuEquipo();
            seccion = exs.validarDatoEntrada();
            while (seccion<=0||seccion>3) {
                msm.mensageErrorRango();
                seccion = exs.validarDatoEntrada();
            }

            System.out.print("Nombre del aparato: ");
            nombre = read.next();
            read.nextLine();

            System.out.println("Peso del equipo a agregar (kg)");
            peso = exs.validarDatoEntrada();

            while (peso<=0 || peso>50) {
                peso = exs.validarDatoEntrada();
                msm.mensajePeso();
            }

            //Menu desde la clase Menus
            menu.statusInventario();
            estatus = exs.validarDatoEntrada();
            //CAMBIO DE DO-WHILE A WHILE
            while (estatus <= 0 || estatus > 2){
                msm.mensageErrorRango();
                estatus = exs.validarDatoEntrada();
            }

            Equipo equipo = new Equipo(peso, seccion, nombre, estatus, Aparatos.getUltimoId());
            inventario.setListaEquipos(equipo);

            
            System.out.println("Equipo agregado correctamente");
            System.out.println("¿Desea agregar otro equipo?\n1.- Si\n2.- No");
            opc = exs.validarDatoEntrada();
            //CAMBIO DE DO-WHILE A WHILE
            while (opc <= 0 || opc > 2){
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }

        } while (opc != 2);
    }
}
