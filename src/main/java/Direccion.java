/**
 * Created by al342052 on 21/02/2017.
 */
public class Direccion {
    private String cp;
    private String provincia;
    private String poblacion;

    public Direccion(String cp, String provincia, String poblacion){
        this.cp=cp;
        this.provincia=provincia;
        this.poblacion=poblacion;
    }

    public String getCp(){
        return cp;
    }
    public String getProvincia(){
        return provincia;
    }
    public String getPoblacion(){
        return poblacion;
    }
}
