package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.Taller6.domain.models.Pregunta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.PreguntaDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.PreguntaDTOResponse;

@Mapper(componentModel = "spring", uses = { CuestionarioMapperInfrastructureDomainRespuesta.class })
public interface PreguntaMapperInfrastructureDomainRespuesta {

    Pregunta requestToRespuesta(PreguntaDTORequest pregunta);

    PreguntaDTOResponse respuestaToResponse(Pregunta pregunta);

    List<PreguntaDTOResponse> respuestasToResponses(List<Pregunta> preguntas);
}
