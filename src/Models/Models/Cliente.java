package Models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private static int ultimoId = 0;
    private int id;
    private String nombre, apellido;
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static List<Plan> planCliente = new ArrayList<>();

    public Cliente(String nombre, String apellido) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public static void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void agregarPlan(Plan plan){
        planCliente.add(plan);
    }

    public static List<Plan> getPlanCliente() {
        return planCliente;
    }

}
