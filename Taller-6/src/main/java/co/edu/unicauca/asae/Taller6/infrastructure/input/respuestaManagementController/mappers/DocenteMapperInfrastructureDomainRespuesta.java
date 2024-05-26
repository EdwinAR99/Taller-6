package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.DocenteDTOResponse;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfrastructureDomainRespuesta {

    Docente requestToDocente(DocenteDTORequest docente);

    DocenteDTOResponse docenteToResponse(Docente docente);

    List<DocenteDTOResponse> respuestasToResponses(List<Docente> respuestas);
}
