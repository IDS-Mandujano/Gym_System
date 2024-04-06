package Models;
import java.util.ArrayList;
import utils.Messages;
public class Inventario {
    private static Inventario instancia = null;
    private static ArrayList<Maquinas> listaMaquinas = new ArrayList<>();
    private static ArrayList<Equipo> listaEquipos = new ArrayList<>();
    String listaTipo [] = {"0","Sección de Cardio","Sección de Piernas","Sección de Brazos","Sección de Espalda","Sección de Hombros","Seccion de Abdominales","Seccion de pechos"};
    String listaStatus[] = {"0","FUNCIONA :) ","NO FUNCIONA :( "};
    String listaSeccion [] = { "0","Mancuerna","Disco","Barras"};
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
            for (int i = 0; i < listaMaquinas.size(); i++) {
                Maquinas maquina = listaMaquinas.get(i);
                System.out.println(
                        "ID: " + maquina.getId() + "\n" +
                        "Tipo: " + listaTipo[maquina.getTipo()] + "\n" +
                        "Nombre: " + maquina.getNombre() + "\n" +
                        "Estatus: " + listaStatus[maquina.getEstatus()]
                );
                msm.separador();
            }
        }
        msm.separador();
        System.out.println("Equipos en inventario:");
        if (listaEquipos.size() == 0) {
            System.out.println("No hay equipos en el inventario.");
        } else {
            for (int i = 0; i < listaEquipos.size(); i++) {
                Equipo equipo = listaEquipos.get(i);
                System.out.println(
                        "ID: " + equipo.getId() + "\n" +
                        "Sección: " + listaSeccion[equipo.getSeccion()] + "\n" +
                        "Nombre: " + equipo.getNombre() + "\n" +
                        "Peso (kg): " + equipo.getPeso() + "\n" +
                        "Estatus: " + listaStatus[equipo.getEstatus()]
                );
                msm.separador();
            }
        }
    }
    
    public void buscarAparatos() {
    
    }

    public void editarInventario() {
       
    }

    public void eliminarInventario() {
        
    }
}
