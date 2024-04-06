package Controllers;

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

}