package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.mappers;

import java.util.List;

import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.RespuestaDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.RespuestaDTOResponse;

public interface RespuestaMapperInfrastructureDomain {

    Respuesta mapperOfRequestToRespuesta(RespuestaDTORequest respuesta);
   
    RespuestaDTOResponse mapperOfResponseToRespuesta(Respuesta objRespuesta);
   
     List<RespuestaDTOResponse> mapperOfResponseToRespuesta(List<Respuesta> respuesta);
}
