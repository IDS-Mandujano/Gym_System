package Models;


public class Plan {

    private String tipoPlan;
    private int monto;
    private String fechaInicio;
    private String fechaFinal;

    public Plan(String plan,String fechaInicio,String fechaFinal,int monto){
        this.tipoPlan = plan;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
    
    public String getTipoPlan() {
        return tipoPlan;
    }
    public int getMonto() {
        return monto;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public String getFechaFinal() {
        return fechaFinal;
    }
}
        