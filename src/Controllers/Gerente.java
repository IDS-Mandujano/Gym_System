package Controllers;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


import Models.Cliente;
import Models.Plan;
import utils.*;

public class Gerente extends Usuario {

    private String rol = "Gerente";

    public Gerente() {
        this.user = "Victor.escobarb";
        this.pass = "Bonilla$24";
    }

    public String getRol() {
        return rol;
    }

    public void agregarCliente() {
        @SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
        Excepciones exs = new Excepciones();
        int opc = 0;

        do {
            
        System.out.print("Nombre: ");
        String nombre = read.next();

        System.out.print("Apellido (P o M): ");
        String apellido = read.next();

        Cliente cliente = new Cliente(nombre,apellido);
        Cliente.agregarCliente(cliente);
        Cliente.agregarPlan(agregarPlan());

        do{
        System.out.println("Cliente agregado correctamente.");
        System.out.println("Desea agregar otro cliente?\n1.- Si\n2.- No");
        opc = exs.validarDatoEntrada();
        }while(opc<=0 || opc>2);

        } while (opc !=2);

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

    public void editarCliente(){
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();
        int opc = 0;
        
            do {
                menu.opcionesCliente();
                opc = exs.validarDatoEntrada();
                while (opc<=0||opc>4) {
                    msm.mensageErrorRango();
                    opc = exs.validarDatoEntrada();
                }
                
                switch (opc) {
                    case 1:
                        editarNombre();
                        break;
                    case 2:
                        editarApellido();
                        break;
                    case 3:
                        editarMensualidad();
                        break;
                    case 4:
                        break;
                }
            } while (opc!=4);
        }

    public void eliminarCliente() {
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();
        
        List<Cliente> listaClientes = Cliente.getListaClientes();
        List<Plan> listaPlanes = Cliente.getPlanCliente();
    
        msm.eliminar();
        int idCliente = buscarCliente();
    
        for (int i = 0; i < listaClientes.size(); i++) {
            if (idCliente == listaClientes.get(i).getId()) {
                System.out.println("¿Desea eliminar a este cliente? \n1.- Si\n2.- No");
                int opc = exs.validarDatoEntrada();
                while (opc<=0||opc>2) {
                    msm.mensageErrorRango();
                    opc = exs.validarDatoEntrada();
                }
                if (opc==1) {
                    listaClientes.remove(i);
                    listaPlanes.remove(i);
                    System.out.println("Cliente eliminado correctamente.");
                } else {
                    System.out.println("Operacion cancelada. El cliente no fue eliminado.");
                }
                break;
            }
        }
    }
    
    public Plan agregarPlan(){
        Excepciones exs = new Excepciones();
        Calendar fecha = Calendar.getInstance();
        Plan plan = null;

        String listaPlan [] = {"Semanal","Mensual","Anual"};
        int montoPlan [] = {175,250,800};
        int opc,monto;
        String fechaInicio,fechaFinal,tipoPlan;

        do {
            System.out.println("Elija su Plan.");
            for(int i=0;i<listaPlan.length;i++){
                System.out.println(i+1+".- "+listaPlan[i]+" $"+montoPlan[i]);
            }
            opc = exs.validarDatoEntrada();
        } while (opc <=0 || opc>3);

        switch (opc) {
            case 1:
                tipoPlan = listaPlan[opc-1];
                monto = montoPlan[opc-1];
                fechaInicio = fecha.getTime().toString();
                fecha.add(Calendar.WEEK_OF_MONTH, 1);
                fechaFinal = fecha.getTime().toString();
                plan = new Plan(tipoPlan,fechaInicio,fechaFinal,monto);
                break;
            case 2:
                tipoPlan = listaPlan[opc-1];
                monto = montoPlan[opc-1];
                fechaInicio = fecha.getTime().toString();
                fecha.add(Calendar.MONTH, 1);
                fechaFinal = fecha.getTime().toString();
                plan = new Plan(tipoPlan,fechaInicio,fechaFinal,monto);
                break;
            case 3:
                tipoPlan = listaPlan[opc-1];
                monto = montoPlan[opc-1];
                fechaInicio = fecha.getTime().toString();
                fecha.add(Calendar.YEAR, 1);
                fechaFinal = fecha.getTime().toString();
                plan = new Plan(tipoPlan,fechaInicio,fechaFinal,monto);
                break;
        }
        return plan;
    }

    public void editarMensualidad(){
        List<Cliente> listaClientes = Cliente.getListaClientes();
        List<Plan> listaPlanes = Cliente.getPlanCliente();
        
        Messages msm = new Messages();
        Excepciones exs = new Excepciones();

        msm.editar();
        int idCliente = buscarCliente();

        for (int i = 0; i < listaClientes.size(); i++) {
            if (idCliente == listaClientes.get(i).getId()) {
                System.out.println("¿Desea editar este plan?\n1.- Si\n2.- No");
                int opc = exs.validarDatoEntrada();
                while (opc<=0||opc>2) {
                    msm.mensageErrorRango();
                    opc = exs.validarDatoEntrada();
                }
                if (opc==1) {
                    listaPlanes.remove(i);
                    Cliente.agregarPlan(agregarPlan());
                    System.out.println("Plan del cliente editado correctamente.");
                }else{
                    System.out.println("Operacion cancelada. El plan no fue editado.");
                }
                break;
            }
        }
    }

   public void editarNombre(){
    Scanner read = new Scanner(System.in);
    List<Cliente> listaClientes = Cliente.getListaClientes();
    Messages msm = new Messages();
    Excepciones exs = new Excepciones();
    msm.editar();
    int idCliente = buscarCliente();
    for(int i = 0;i<listaClientes.size(); i++ ){
        if (idCliente==listaClientes.get(i).getId()) {
            System.out.println("¿Desea editar el nombre?");
            System.out.println("1._ Si \n2._ No");
            int opc = exs.validarDatoEntrada();
            while (opc <=0 || opc> 2) {
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
            if (opc == 1) {
                System.out.println("Ingrese el nuevo nombre.");
                String nuevoNombre = read.nextLine();
                Cliente nuevoCliente = new Cliente(nuevoNombre, listaClientes.get(i).getApellido());
                nuevoCliente.setId(listaClientes.get(i).getId()); 
                listaClientes.set(i, nuevoCliente);
                System.out.println("Nombre actualizado");
            } else {System.out.println("Operacion cancelada el nombre no fue cambiado");}
            break;
        }

    }


    }

///////////////////////////////////////////////////////////////////////////77
    public void editarApellido(){
     Scanner read = new Scanner(System.in);
    List<Cliente> listaClientes = Cliente.getListaClientes();
    Messages msm = new Messages();
    Excepciones exs = new Excepciones();
    msm.editar();
    int idCliente = buscarCliente();

    for(int i = 0;i<listaClientes.size(); i++ ){
        if (idCliente==listaClientes.get(i).getId()) {
            System.out.println("¿Desea editar el apellido?");
            System.out.println("1._ Si\n2._ No");
            int opc = exs.validarDatoEntrada();
            while (opc <=0 || opc> 2) {
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
            if (opc == 1) {
                System.out.println("ingrese el nuevo apellido");
                String nuevoApellido = read.nextLine();
                Cliente nuevoCliente = new Cliente( listaClientes.get(i).getNombre(),nuevoApellido );
                nuevoCliente.setId(listaClientes.get(i).getId()); 
                listaClientes.set(i, nuevoCliente);
                System.out.println("Apellido actualizado");
            } else { System.out.println("Operacion cancelada el apellido no fue cambiado");}
            
        }


    }
}

}

