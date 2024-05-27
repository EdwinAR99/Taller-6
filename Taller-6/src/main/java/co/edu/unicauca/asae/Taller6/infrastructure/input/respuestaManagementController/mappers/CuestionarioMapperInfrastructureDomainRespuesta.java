package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.CuestionarioDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.CuestionarioDTOResponse;

@Mapper(componentModel = "spring")
public interface CuestionarioMapperInfrastructureDomainRespuesta {
    Cuestionario requestToCuestionario(CuestionarioDTORequest cuestionario);

    CuestionarioDTOResponse respuestaToResponse(Cuestionario cuestionario);

    List<CuestionarioDTOResponse> respuestasToResponses(List<Cuestionario> cuestionarios);
}
