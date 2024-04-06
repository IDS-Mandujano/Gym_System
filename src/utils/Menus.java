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
            "Que deseas editar?\n"+
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
            "1.-Agregar Maquinas\n"+
            "2.-Agregar Equipo\n"+
            "3.-Salir"
        );
    }

    public void menuMaquinas(){
        System.out.println("Tipo de maquina:\n" +
                    "1.-Sección de Cardio\n" +
                    "2.-Sección de Piernas\n" +
                    "3.-Sección de Brazos\n" +
                    "4.-Sección de Espalda\n" +
                    "5.-Sección de Hombros\n" +
                    "6.-Seccion de Abdominales\n" +
                    "7.-Seccion de pechos"
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
                    "3.-Barras"
            );
    }
}
