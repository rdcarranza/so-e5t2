public class Rueda {
    private String material;
    private int diametroAro;
    private int cantidadRayos;
    private boolean estado;

    public Rueda(){
        material="aluminio";
        diametroAro=24;
        cantidadRayos=100;
        estado=false;
    }

    public void fabricar(){
        estado=true;
        System.out.println("Se fabrica RUEDA de "+material+" rodado: "+diametroAro+", con "+cantidadRayos+" rayos.");
    }

    public int getRodado(){
        return diametroAro;
    }


}
