package co.edu.unicauca.asae.Taller6.application.output.managementGateway;

import java.util.List;

import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;

public interface RespuestaManagementGatewayIntPort {

   //Respuesta guardar(Respuesta objRespuesta);

   List<Respuesta> guardarRespuestas(List<Respuesta> objRespuestas);

   List<Respuesta> listar();
}
