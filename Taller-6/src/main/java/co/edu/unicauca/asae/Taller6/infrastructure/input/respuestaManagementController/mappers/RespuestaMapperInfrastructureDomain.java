package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.RespuestaDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.RespuestaDTOResponse;

@Mapper(componentModel = "spring", uses = { DocenteMapperInfrastructureDomainRespuesta.class,
        PreguntaMapperInfrastructureDomainRespuesta.class })
public interface RespuestaMapperInfrastructureDomain {

    @Mapping(target = "idRespuesta", ignore = true)
    Respuesta requestToRespuesta(RespuestaDTORequest respuesta);

    RespuestaDTOResponse respuestaToResponse(Respuesta respuesta);

    List<RespuestaDTOResponse> respuestasToResponses(List<Respuesta> respuestas);
}
