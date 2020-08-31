public class Bicicleta {
    private Rueda ruedaDelantera;
    private Rueda ruedaTrasera;
    private Cuadro cuadro;
    private Manubrio manubrio;
    private boolean estado;

    public Bicicleta(Rueda r1, Rueda r2, Cuadro c, Manubrio m){
        ruedaDelantera=r1;
        ruedaTrasera=r2;
        cuadro=c;
        manubrio=m;
        estado=false;
    }

    public void montar(){
        estado=true;
        System.out.println("Se arma una BICICLETA "+manubrio.getMolde()+" de "+cuadro.getMaterial()+" rodado: "+ruedaTrasera.getRodado()+".");
    }

}
