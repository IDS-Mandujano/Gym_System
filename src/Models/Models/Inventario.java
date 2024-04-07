package Models;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Excepciones;
import utils.Menus;
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
        String listaTipo [] = {"0","Sección de Cardio","Sección de Piernas","Sección de Brazos","Sección de Espalda","Sección de Hombros","Sección de Abdominales","Sección de pechos"};
        String listaStatus[] = {"0","FUNCIONA :) ","NO FUNCIONA :( "};
        String listaSeccion [] = { "0","Mancuerna","Disco","Barras"};
        Messages msm = new Messages();
        System.out.println("Máquinas en inventario:");
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
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        int opc = 0;
        int aparato;

        do{
            menu.menuBusquedaAparato();
            aparato= exs.validarDatoEntrada();

            while (aparato<=0 || aparato>2) {
                msm.mensageErrorRango();
                aparato = exs.validarDatoEntrada();
            }

            if(aparato == 1){
                verMaquinaPorId();
            }
            else{
                verEquipoPorId();
            }
            System.out.println("Busqueda realizada correctamente");
            System.out.println("¿Desea realizar una busqueda nueva?\n1.- Si\n2.- No");
            opc = exs.validarDatoEntrada();

            while (opc <= 0 || opc > 2){
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
        }while(opc != 2);
    }

    public void verMaquinaPorId() {
        String listaTipo[] = {"0", "Sección de Cardio", "Sección de Piernas", "Sección de Brazos", "Sección de Espalda", "Sección de Hombros", "Sección de Abdominales", "Sección de pechos"};
        String listaStatus[] = {"0", "FUNCIONA :) ", "NO FUNCIONA :( "};
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();
    
        msm.buscarMaquina();
        int idMaquinaBuscar = exs.validarDatoEntrada();
        boolean encontrada = false;
    
        for (int i = 0; i < listaMaquinas.size(); i++) {
            Maquinas maquina = listaMaquinas.get(i);
            if (maquina.getId() == idMaquinaBuscar) {
                encontrada = true;
                System.out.println("Detalles de la máquina:");
                System.out.println("ID: " + maquina.getId());
                System.out.println("Tipo: " + listaTipo[maquina.getTipo()]);
                System.out.println("Nombre: " + maquina.getNombre());
                System.out.println("Estatus: " + listaStatus[maquina.getEstatus()]);
                msm.separador();

            }
        }
    
        if (!encontrada) {
            System.out.println("La máquina con el ID " + idMaquinaBuscar + " no fue encontrada en el inventario.");
        }
    }

    public void verEquipoPorId() {
        String listaSeccion[] = {"0", "Mancuerna", "Disco", "Barras"};
        String listaStatus[] = {"0", "FUNCIONA :) ", "NO FUNCIONA :( "};
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();
    
        msm.buscarEquipo();
        int idEquipoBuscar = exs.validarDatoEntrada();
        boolean encontrada = false;
    
        for (int i = 0; i < listaEquipos.size(); i++) {
            Equipo equipo = listaEquipos.get(i);
            if (equipo.getId() == idEquipoBuscar) {
                encontrada = true;
                System.out.println("Detalles del equipo:");
                System.out.println("ID: " + equipo.getId());
                System.out.println("Sección: " + listaSeccion[equipo.getSeccion()]);
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Peso (kg): " + equipo.getPeso());
                System.out.println("Estatus: " + listaStatus[equipo.getEstatus()]);
                msm.separador();
            }
        }
    
        if (!encontrada) {
            System.out.println("El equipo con el ID " + idEquipoBuscar + " no fue encontrado en el inventario.");
        }
    }

    public void editarEstatusAparatos() {
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();
        Menus menu = new Menus();
        int opcion;
        int opc;

        do{

        menu.menuEditarAparato();
        opcion = exs.validarDatoEntrada();
        while (opcion<=0 || opcion>2) {
            msm.mensageErrorRango();
            opcion = exs.validarDatoEntrada();
        }
        if (opcion == 1) {
            editarMaquina();
        }
        else{
            editarEquipo();
        }

            System.out.println("¿Desea editar otro aparato?\n1.- Si\n2.- No");
            opc = exs.validarDatoEntrada();

            while (opc <= 0 || opc > 2){
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
        
        }while(opc == 1);
    }

    public void editarMaquina() {
        String listaTipo[] = {"0", "Sección de Cardio", "Sección de Piernas", "Sección de Brazos", "Sección de Espalda", "Sección de Hombros", "Sección de Abdominales", "Sección de pechos"};
        String listaStatus[] = {"0", "FUNCIONA :) ", "NO FUNCIONA :( "};
        Scanner read = new Scanner(System.in);
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        int idBuscar;
        boolean encontrada = false;

        msm.idMaquinaEditar();
        idBuscar = exs.validarDatoEntrada();
        while (idBuscar <= 0) {
            msm.mensageErrorRango();
            idBuscar = exs.validarDatoEntrada();
        }
        for (int i = 0; i < listaMaquinas.size(); i++) {
            Maquinas maquina = listaMaquinas.get(i);
            if (maquina.getId() == idBuscar) {
                encontrada = true;
                msm.separador();
                System.out.println("Detalles de la máquina a editar:");
                System.out.println("ID: " + maquina.getId());
                System.out.println("Tipo: " + listaTipo[maquina.getTipo()]);
                System.out.println("Nombre: " + maquina.getNombre());
                System.out.println("Estatus actual: " + listaStatus[maquina.getEstatus()]);
                msm.separador();
    
                menu.editarOpcion();
                int opcionEditar = exs.validarDatoEntrada();
                while (opcionEditar < 1 || opcionEditar > 2) {
                    msm.mensageErrorRango();
                    opcionEditar = exs.validarDatoEntrada();
                }

                for (int j = 0; j < 2; j++) {
                    if (opcionEditar == 1) { 
                        msm.nuevoNombre();
                        String nuevoNombre = read.nextLine();
                        maquina.setNombre(nuevoNombre);
                        System.out.println("¡Nombre de la máquina actualizado correctamente!");
                        break;
                    } else if (opcionEditar == 2) { 
                        menu.editarEstatus();
                        int nuevoEstatus = exs.validarDatoEntrada();
                        while (nuevoEstatus <= 0 || nuevoEstatus > 2) {
                            msm.mensageErrorRango();
                            nuevoEstatus = exs.validarDatoEntrada();
                        }
                        maquina.setEstatus(nuevoEstatus);
                        System.out.println("¡Estatus de la máquina actualizado correctamente!");
                        break;
                    }
                }
                msm.separador();
            }
        }
    
        if (!encontrada) {
            System.out.println("La máquina con el ID " + idBuscar + " no fue encontrada en el inventario.");
        }
    }

    public void editarEquipo() {
        String listaSeccion[] = {"0", "Mancuerna", "Disco", "Barras"};
        String listaStatus[] = {"0", "FUNCIONA :) ", "NO FUNCIONA :( "};
        Scanner read = new Scanner(System.in);
        Menus menu = new Menus();
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();
        boolean encontrada = false;
        int idBuscar;
    
        msm.idEquipoEditar();
        idBuscar = exs.validarDatoEntrada();
        while (idBuscar <= 0) {
            msm.mensageErrorRango();
            idBuscar = exs.validarDatoEntrada();
        }
    
        for (int i = 0; i < listaEquipos.size(); i++) {
            Equipo equipo = listaEquipos.get(i);
            if (equipo.getId() == idBuscar) {
                encontrada = true;
                msm.separador();
                System.out.println("Detalles del equipo a editar:");
                System.out.println("ID: " + equipo.getId());
                System.out.println("Sección: " + listaSeccion[equipo.getSeccion()]);
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Peso (kg): " + equipo.getPeso());
                System.out.println("Estatus actual: " + listaStatus[equipo.getEstatus()]);
                msm.separador();

                menu.editarOpcion();
                int opcionEditar = exs.validarDatoEntrada();
                while (opcionEditar<1 || opcionEditar>2) {
                    msm.mensageErrorRango();
                    opcionEditar = exs.validarDatoEntrada();
                }
 
                    if (opcionEditar == 1) {
                        msm.nuevoNombre();
                        String nuevoNombre = read.nextLine();
                        equipo.setNombre(nuevoNombre);
                        System.out.println("¡Nombre del equipo actualizado correctamente!");
                    } else if (opcionEditar == 2) {
                        menu.editarEstatus();
                        int nuevoEstatus = exs.validarDatoEntrada();
                        while (nuevoEstatus <= 0 || nuevoEstatus > 2) {
                            msm.mensageErrorRango();
                            nuevoEstatus = exs.validarDatoEntrada();
                        }
                        equipo.setEstatus(nuevoEstatus);
                        System.out.println("¡Estatus del equipo actualizado correctamente!");

                    }
                }
                msm.separador();

            }
        if (!encontrada) {
            System.out.println("El equipo con el ID " + idBuscar + " no fue encontrado en el inventario.");
        }
    }

    public void eliminarAparatos() {
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();
        Menus menu = new Menus();
        int opcion;
        int opc;

        do{
            
            menu.menuEliminarAparato();
            opcion = exs.validarDatoEntrada();
            while (opcion<=0 || opcion>2) {
                msm.mensageErrorRango();
                opcion = exs.validarDatoEntrada();
            }

            if (opcion == 1) {
                eliminarMaquinas();
            }
            else if(opcion == 2){
                eliminarEquipo();
            }

            System.out.println("¿Desea eliminar otro aparato?\n1.- Si\n2.- No");
            opc = exs.validarDatoEntrada();
            while (opc <= 0 || opc > 2){
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
        }while(opc == 1 );
    }
    public void eliminarMaquinas(){
        Menus menu = new Menus();
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();
        boolean encontrada = false;
        int idEliminar;

        msm.idMaquinaEliminar();
        idEliminar = exs.validarDatoEntrada();

        for (int i = 0; i < listaMaquinas.size(); i++) {
            Maquinas maquina = listaMaquinas.get(i);
            if (maquina.getId() == idEliminar) {
                encontrada = true;
                listaMaquinas.remove(i);
                System.out.println("¡Máquina eliminada correctamente!");
            }
        }
    
        if (!encontrada) {
            System.out.println("La máquina con el ID " + idEliminar + " no fue encontrada en el inventario.");
        }
    }
    public void eliminarEquipo(){
        Menus menu = new Menus();
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();
        boolean encontrada = false;
        int idEliminar;

        msm.idEquipoEliminar();
        idEliminar = exs.validarDatoEntrada();

        for (int i = 0; i < listaEquipos.size(); i++) {
            Equipo equipo = listaEquipos.get(i);
            if (equipo.getId() == idEliminar) {
                encontrada = true;
                listaEquipos.remove(i);
                System.out.println("¡Equipo eliminado correctamente!");
            }
        }
    
        if (!encontrada) {
            System.out.println("El equipo con el ID " + idEliminar + " no fue encontrado en el inventario.");
        }

    }
}
