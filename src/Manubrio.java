public class Manubrio {
    private String material;
    private String molde;
    private boolean estado; //0-desarmado | 1-armado

    public Manubrio(){
        material="aluminio";
        molde="mountanbike";
        estado=false;
    }

    public void fabricar(){
        estado=true;
        System.out.println("Se fabrica MANUBRIO de "+material+" para "+molde+".");
    }

    public String getMolde(){
        return molde;
    }

}
