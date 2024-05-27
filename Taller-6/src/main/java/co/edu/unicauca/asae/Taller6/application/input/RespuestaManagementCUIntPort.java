package co.edu.unicauca.asae.Taller6.application.input;

import java.util.List;

import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;

public interface RespuestaManagementCUIntPort {

    //Respuesta crear(Respuesta objRespuesta);

    List<Respuesta> crearRespuestas(List<Respuesta> objRespuesta);

    List<Respuesta> listarRespuestas();

}
