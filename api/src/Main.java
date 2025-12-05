import casosPrueba.CargaDatos;
import webservices.publicadorEvento;
import webservices.publicadorImagenes;
import webservices.publicadorUsuario;

public class Main {
    public static void main(String[] args) {
        publicadorEvento pubEvento = new publicadorEvento();
		publicadorUsuario pubUsuario = new publicadorUsuario();
		publicadorImagenes pubImagenes = new publicadorImagenes();
        try {
            CargaDatos.cargarDatos(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		pubEvento.publicar();
		pubUsuario.publicar();
		pubImagenes.publicar();
    }
}
