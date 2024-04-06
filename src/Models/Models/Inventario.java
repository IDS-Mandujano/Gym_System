package Models;

import java.util.ArrayList;
import utils.Messages;

public class Inventario {
    private static Inventario instancia = null;
    private static ArrayList<Maquinas> listaMaquinas = new ArrayList<>();
    private static ArrayList<Equipo> listaEquipos = new ArrayList<>();

    public Inventario() {}

    public static Inventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    public ArrayList<Maquinas> getListaMaquinas() {
        return listaMaquinas;
    }

    public void setListaMaquinas(Maquinas maquinas) {
        listaMaquinas.add(maquinas);
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    public void verInventario() {
        Messages msm = new Messages();
        System.out.println("Maquinas en inventario:");
        if (listaMaquinas.size() == 0) {
            System.out.println("No hay máquinas en el inventario.");
        } else {
            for (Maquinas maquina : listaMaquinas) {
                System.out.println(
                        "Nombre: " + maquina.getNombre() + "\n" +
                        "Estatus: " + maquina.getEstatus() + "\n" +
                        "Tipo: " + maquina.getTipo()
                );
                msm.separador();
            }
        }
        msm.separador();
        System.out.println("Equipos en inventario:");
        if (listaEquipos.size() == 0) {
            System.out.println("No hay equipos en el inventario.");
        } else {
            for (Equipo equipo : listaEquipos) {
                System.out.println(
                        "Sección: " + equipo.getSeccion() + "\n" +
                        "Nombre: " + equipo.getNombre() + "\n" +
                        "Peso (kg): " + equipo.getPeso() + "\n" +
                        "Estatus: " + equipo.getEstatus()
                );
                msm.separador();
            }
        }
    }

    //AAAAAAAAAA
    public void buscarAparatos() {
    
    }

    public void editarInventario() {
       
    }

    public void eliminarInventario() {
        
    }
}
