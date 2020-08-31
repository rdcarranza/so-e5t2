public class Cuadro {
    private String material;
    private String molde;
    private boolean estado; //0-desarmado | 1-armado

    public Cuadro(){
        material="aluminio";
        molde="mountanbike";
        estado=false;
    }

    public void fabricar(){
        estado=true;
        System.out.println("Se fabrica CUADRO "+molde+" de "+material+".");
    }

    public String getMaterial(){
        return material;
    }

}
