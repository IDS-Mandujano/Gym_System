package Models;

import java.util.Scanner;
import utils.*;

public class Maquinas extends Aparatos {

    private int tipo;

    public Maquinas() {}

    public Maquinas(String nombre, int estatus, int tipo, int id) {
        super(nombre, estatus, id);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void agregarAparatos() {
        Messages msm = new Messages();
        Menus menu = new Menus();

        Inventario inventario = Inventario.obtenerInstancia();
        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        Excepciones exs = new Excepciones();
        int opc = 0;

        do {
            menu.menuMaquinas();
            tipo = exs.validarDatoEntrada();
            while (tipo<=0||tipo>7) {
                msm.mensageErrorRango();
                tipo = exs.validarDatoEntrada();
            }

            System.out.print("Nombre del aparato: ");
            nombre = read.next();
            read.nextLine();

            menu.statusInventario();
            estatus = exs.validarDatoEntrada();
            
            while (estatus <= 0 || estatus > 2){
                msm.mensageErrorRango();
                estatus = exs.validarDatoEntrada();
            }

            Maquinas maquina = new Maquinas(nombre, estatus, tipo, Aparatos.getUltimoId());
            inventario.setListaMaquinas(maquina);

            System.out.println("Máquina agregada correctamente");
            System.out.println("¿Desea agregar otra máquina?\n1.- Si\n2.- No");
            opc = exs.validarDatoEntrada();

             while (opc <= 0 || opc > 2){
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
             }

        } while (opc != 2);
    }
}
