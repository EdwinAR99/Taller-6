package co.edu.unicauca.asae.Taller6.application.output.managementGateway;

import java.util.List;

import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;

public interface RespuestaManagementGatewayIntPort {

   // Validar que antes de registrar una respuesta exista el id del docente en la
   // base de datos.
   boolean returnResponseErrorIdDocenteNoExiste(int id);

   // Validar que antes de registrar una respuesta exista el id del cuestionario en
    // la base de datos.
   boolean returnResponseErrorIdCuestionarioNoExiste(int id);

   // Validar que antes de registrar una respuesta exista el id de la pregunta en
    // la base de datos.
    boolean returnResponseErrorIdPreguntaNoExiste(int id);

   // Respuesta guardar(Respuesta objRespuesta);

   List<Respuesta> guardarRespuestas(List<Respuesta> objRespuestas);

   List<Respuesta> listar();
}
