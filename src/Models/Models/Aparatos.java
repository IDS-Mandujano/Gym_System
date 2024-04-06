package Models;

public abstract class Aparatos {
    private static int ultimoId = 0;
    protected int id;
    protected String nombre;
    protected int estatus;

    public static int getUltimoId() {
        return ultimoId;
    }
    public static void setUltimoId(int ultimoId) {
        Aparatos.ultimoId = ultimoId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEstatus() {
        return estatus;
    }
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Aparatos() {
    }

    public Aparatos(String nombre, int estatus, int id) {
        this.id = ++ultimoId;
        this.estatus = estatus;
        this.nombre = nombre;
    }

    public abstract void agregarAparatos();
}
