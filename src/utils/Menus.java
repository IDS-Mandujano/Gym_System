package utils;

public class Menus {

    public void menuPrincipal(){
        System.out.println(
            "1.- Iniciar Sesión\n"+
            "2.- Salir");
    }
    
    public void menuPrincipalGerente(){
        System.out.println(
            "1.- Cliente\n"+
            "2.- Inventario\n"+
            "3.- Cerrar sesión");
    }

    public void menuPrincipalAdmin(){
        System.out.println(
            "1.- Ver clientes"+
            "\n2.- Ver inventario"+
            "\n3.- Cerrar sesión");
    }
    
    public void menuCliente(){
        System.out.println(
            "1.- Agregar cliente\n"+
            "2.- Ver cliente por ID\n"+
            "3.- Ver clientes existentes\n"+
            "4.- Editar cliente\n"+
            "5.- Eliminar cliente\n"+
            "6.- Salir");
    }

    public void opcionesCliente(){
        System.out.println(
            "¿Qué deseas editar?\n"+
            "1.- Nombre\n"+
            "2.- Apellido\n"+
            "3.- Mensualidad\n"+
            "4.- Salir");
    }
    public void menuInventario(){
        System.out.println(
            "1.-Agregar aparatos al inventario\n"+
            "2.-Ver Inventario por tipo de aparatos.\n"+
            "3.-Ver inventario existente\n"+
            "4.-Editar inventario\n"+
            "5.-Eliminar Aparatos\n"+
            "6.-Salir\n"
        );
    }
    public void menuAgregarAparatos(){
        System.out.println(
            "1.-Agregar Máquinas\n"+
            "2.-Agregar Equipo\n"+
            "3.-Salir"
        );
    }

    public void menuMaquinas(){
        System.out.println("Tipo de maquina:\n" +
                    "1.-Máquina de Cardio\n" +
                    "2.-Máquina de Piernas\n" +
                    "3.-Máquina de Brazos\n" +
                    "4.-Máquina de Espalda\n" +
                    "5.-Máquina de Hombros\n" +
                    "6.-Máquina de Abdominales\n" +
                    "7.-Máquina de pecho"
            );
    }

    public void statusInventario(){
        System.out.print("Ingrese su Estatus :\n" +
                "1.-FUNCIONA\n" +
                "2.-NO FUNCIONA\n");
    }

    public void menuEquipo(){
        System.out.println("Ingrese la seccion de Equipo:\n" +
                    "1.-Mancuerna\n" +
                    "2.-Disco\n" +
                    "3.-Barra"
            );
    }

    public void menuBusquedaAparato(){
        System.out.println(
            "Ingrese el tipo de aparato a buscar\n"+
            "1.-Maquina\n"+
            "2.-Equipo"
        );
    }
    public void menuEditarAparato(){
        System.out.println(
            "Ingrese el aparato a editar\n"+
            "1.-Maquina\n"+
            "2.-Equipo"
        );
    }
    public void editarOpcion() {
        System.out.println(
        "¿Qué desea editar?\n"+
        "1. Nombre\n"+
        "2. Estatus");
    }
    public void editarEstatus() {
        System.out.println(
        "Seleccione el nuevo estatus:\n"+
        "1.-FUNCIONA :) \n"+
        "2.-NO FUNCIONA :( "
        );
    }

    public void menuEliminarAparato(){
        System.out.println(
            "¿Qué desea eliminar?\n"+
            "1.-Máquinas\n"+
            "2.-Equipo"
        );
    }
}
