import casosPrueba.CargaDatos;
import jakarta.xml.ws.Endpoint;
import webservices.publicadorEvento;
import webservices.publicadorImagenes;
import webservices.publicadorUsuario;

public class Main {
    public static void main(String[] args) {
        publicadorEvento pubEvento = new publicadorEvento();
		publicadorUsuario pubUsuario = new publicadorUsuario();
		publicadorImagenes pubImagenes = new publicadorImagenes();

        System.out.println("Cargando datos de prueba...");

        try {
            CargaDatos.cargarDatos(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Iniciando publicacion de Web Services...");

        String host = System.getenv().getOrDefault("WS_HOST", "0.0.0.0");
        String port = System.getenv().getOrDefault("WS_PORT", "8080");
        String url = "http://" + host + ":" + port;

        System.out.println("Publicando WS en: " + url);

        Endpoint.publish(url + "/publicadorEvento", pubEvento);
        Endpoint.publish(url + "/publicadorUsuario", pubUsuario);
        Endpoint.publish(url + "/publicadorImagenes", pubImagenes);

        System.out.println("WS de Evento, Usuario e Imagenes publicados correctamente.");
        
    }
}
