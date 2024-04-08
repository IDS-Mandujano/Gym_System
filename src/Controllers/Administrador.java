package Controllers;
import java.util.List;

import Models.*;
import utils.*;

public class Administrador extends Usuario{

    private String rol = "Admin";

    public Administrador(){
        this.user = "Lizeth.egordillo";
        this.pass = "Estrada@24";
    }

    public String getUser() {
        return super.getUser();
    }
    public String getPass() {
        return super.getPass();
    }

    public String getRol() {
        return rol;
    }

    public void verClientes(){
        Messages msm = new Messages();
        List<Cliente> listaClientes = Cliente.getListaClientes();
        List<Plan> listaPlanes = Cliente.getPlanCliente();
    
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            Plan plan = listaPlanes.get(i);
        
            msm.separador();
            System.out.println(
                "ID-Cliente: "+cliente.getId()+
                "\nNombre: "+cliente.getNombre()+
                "\nApellido: "+cliente.getApellido()
                );
            System.out.println("------- [PLAN] -------");
            System.out.println(
                "Tipo de Plan: "+plan.getTipoPlan()+
                "\nFecha de inicio: "+plan.getFechaInicio()+
                "\nFecha de termino: "+plan.getFechaFinal()+
                "\nMonto: $"+plan.getMonto());
            msm.separador();
        }
    }

    public void verClientePorID(){
        Messages msm = new Messages();
        msm.buscar();
        buscarCliente();
    }

    public int buscarCliente() {
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();
        
        List<Cliente> listaClientes = Cliente.getListaClientes();
        List<Plan> listaPlanes = Cliente.getPlanCliente();
        boolean encontrado = false;
            int idCliente = exs.validarDatoEntrada();

            for(int i=0;i<listaClientes.size();i++){
                Cliente cliente = listaClientes.get(i);
                Plan plan = listaPlanes.get(i);
                if (cliente.getId()==idCliente) {
                    msm.separador();
                    System.out.println(
                        "ID-Cliente: " + cliente.getId() +
                        "\nNombre: " + cliente.getNombre() +
                        "\nApellido: " + cliente.getApellido()
                    );
                    System.out.println("------- [PLAN] -------");
                    System.out.println(
                        "Tipo de Plan: " + plan.getTipoPlan() +
                        "\nFecha de inicio: " + plan.getFechaInicio() +
                        "\nFecha de termino: " + plan.getFechaFinal() + 
                        "\nMonto: $" + plan.getMonto());
                        encontrado = true;
            }
        }

        if (encontrado) {
            return idCliente;
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
        return 0;
    }

    public void verInventario() {
        List<Maquinas> listaMaquinas = Inventario.getListaMaquinas();
        List<Equipo> listaEquipos = Inventario.getListaEquipos();

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
        List<Maquinas> listaMaquinas = Inventario.getListaMaquinas();

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
        List<Equipo> listaEquipos = Inventario.getListaEquipos();

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

}