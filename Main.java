import Controllers.Administrador;
import Controllers.Gerente;
import Models.Equipo;
import Models.Inventario;
import Models.Maquinas;
import utils.*;


public class Main {

    public static void main(String[] args) {
        validarOpcion();
    }

    public static void validarOpcion(){
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();

        int opc;

    do {
        menu.menuPrincipal();
        opc = exs.validarDatoEntrada();
        while (opc<=0||opc>2) {
            msm.mensageErrorRango();
            opc = exs.validarDatoEntrada();
        }

        switch (opc) {
            case 1:
                validarRol(exs.validarNull());
                break;
            case 2:
                msm.mensajeSalida();
                break;
        }

        } while (opc!=2);
    }

    public static void validarRol(String rol){
        if (rol.equals("Gerente")) {
            verMenuGerente();
        }else if(rol.equals("Admin")){
            verMenuAdmin();
        }
    }

    public static void verMenuGerente(){
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();

        int opc = 0;
        do {
            msm.separador();
            menu.menuPrincipalGerente();
            opc = exs.validarDatoEntrada();
            validarOpcion(opc);
            while (opc <=0 || opc >3) {
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
        } while (opc!=3);
        
    }

    public static void validarOpcion(int opc){
        Messages msm = new Messages();
        switch (opc) {
            case 1:
                msm.separador();
                verMenuCliente();
                msm.separador();;
                break;
            case 2:
                msm.separador();
                verMenuInventario();
                msm.separador();
                break;
            case 3:
                msm.mensajeSalida();
                break;
        }
    }

    public static void verMenuCliente(){
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        int opc = 0;
        do {
            menu.menuCliente();
            opc = exs.validarDatoEntrada();
                while (opc <=0 || opc >6) {
                    msm.mensageErrorRango();
                    opc = exs.validarDatoEntrada();
                }
                validarOpcionCliente(opc);
        } while (opc != 6);
    }

    public static void validarOpcionCliente(int opc){
        Messages msm = new Messages();

        Gerente g = new Gerente();
        switch (opc) {
            case 1:
                msm.separador();
                g.agregarCliente();
                msm.separador();
                break;
            case 2:
                msm.separador();
                g.verClientePorID();
                msm.separador();
                break;
            case 3:
                msm.separador();
                g.verClientes();
                msm.separador();
                break;
            case 4:
                msm.separador();
                g.editarCliente();
                msm.separador();
                break;
            case 5:
                msm.separador();
                g.eliminarCliente();
                msm.separador();
                break;
            case 6:
                 msm.mensajeSalida();   
                break;
        }
    }

    public static void verMenuInventario(){
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();

        int opc = 0;
        do {
            menu.menuInventario();
            opc = exs.validarDatoEntrada();
                while (opc <=0 || opc >6) {
                    msm.mensageErrorRango();
                    opc = exs.validarDatoEntrada();
                }
                validarOpcionInventario(opc);
        } while (opc != 6);
    }

    public static void validarOpcionInventario(int opc){
        Inventario a = new Inventario();
        Messages msm = new Messages();
        switch (opc) {
            case 1:
                msm.separador();
                verMenuAgregarAparato();
                msm.separador();
                break;
            case 2:
                msm.separador();
                a.buscarAparatos();
                msm.separador();
                break;
            case 3:
                msm.separador();
                a.verInventario();
                msm.separador();
                break;
            case 4:
                msm.separador();
                a.editarEstatusAparatos();
                msm.separador();
                break;
            case 5:
                msm.separador();
                a.eliminarAparatos();
                msm.separador();
                break;
            case 6:
                msm.separador();
                msm.mensajeSalida(); 
                break;
            default:
                break;
        }
    }

    public static void verMenuAgregarAparato(){
        Messages msm = new Messages();
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        int opc = 0;
        do {
            menu.menuAgregarAparatos();
            opc = exs.validarDatoEntrada();
                while (opc <=0 || opc >3) {
                    msm.mensageErrorRango();
                    opc = exs.validarDatoEntrada();
                }
                validarOpcionAgregarInventario(opc);
        } while (opc != 3);
    }

    public static void validarOpcionAgregarInventario(int opc){
        Messages msm = new Messages();
        Equipo e = new Equipo();  
        Maquinas m = new Maquinas();

        switch (opc) {
            case 1:
                msm.separador();
                m.agregarAparatos();
                msm.separador();
                break;
            case 2:
                msm.separador();
                e.agregarAparatos();
                msm.separador();
                break;
            case 3:
                msm.separador();
                msm.mensajeSalida(); 
                msm.separador();
                break;
        }
    }

    public static void verMenuAdmin(){
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();

        int opc;
        do {
            menu.menuPrincipalAdmin();
            opc = exs.validarDatoEntrada();
            while (opc<=0||opc>3) {
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
            validarOpcionAdmin(opc);
        } while (opc!=3);
    }

    public static void validarOpcionAdmin(int opc){
        Messages msm = new Messages();

        switch (opc) {
            case 1:
                msm.separador();
                verMenuClienteAdmin();
                msm.separador();
                break;
            case 2:
                msm.separador();
                verMenuInventarioAdmin();
                msm.separador();
                break;
            case 3:
                msm.mensajeSalida();
                break;
        }
    }

    public static void verMenuClienteAdmin(){
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();

        int opc;
        do{
            menu.menuClienteAdmin();
            opc = exs.validarDatoEntrada();
            while (opc<=0||opc>3) {
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
            validarMenuClienteAdmin(opc);
        }while(opc!=3);
    }

    public static void verMenuInventarioAdmin(){
        Menus menu = new Menus();
        Excepciones exs = new Excepciones();
        Messages msm = new Messages();

        int opc;
        do{
            menu.menuInventarioAdmin();
            opc = exs.validarDatoEntrada();
            while (opc<=0||opc>3) {
                msm.mensageErrorRango();
                opc = exs.validarDatoEntrada();
            }
            validarMenuInventarioAdmin(opc);
        }while(opc!=3);
    }

    public static void validarMenuClienteAdmin(int opc){
        Administrador admin = new Administrador();
        Messages msm = new Messages();

        switch (opc) {
            case 1:
                msm.separador();
                admin.verClientes();
                msm.separador();
                break;
            case 2:
                msm.separador();
                admin.verClientePorID();
                msm.separador();
                break;
            case 3:
                msm.mensajeSalida();
                break;
        }
    }

    public static void validarMenuInventarioAdmin(int opc){
        Administrador admin = new Administrador();
        Messages msm = new Messages();

        switch (opc) {
            case 1:
                msm.separador();
                admin.verInventario();
                msm.separador();
                break;
            case 2:
                msm.separador();
                admin.buscarAparatos();
                msm.separador();
                break;
            case 3:
                msm.mensajeSalida();
                break;
        }
    }
}