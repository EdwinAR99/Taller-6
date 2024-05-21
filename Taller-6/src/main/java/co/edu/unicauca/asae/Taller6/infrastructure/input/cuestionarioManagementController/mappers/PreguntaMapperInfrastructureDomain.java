package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.Taller6.domain.models.Pregunta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest.PreguntaDTORequest;

@Mapper(componentModel = "spring", uses = {TipoPreguntaMapperInfraestructureDomain.class})
public interface PreguntaMapperInfrastructureDomain {

    @Mapping(target = "objCuestionario", ignore = true)
    PreguntaDTORequest preguntaToPreguntaDTORequest(Pregunta pregunta);

    @Mapping(target = "objCuestionario", ignore = true)
    List<PreguntaDTORequest> preguntasToPreguntaDTORequests(List<Pregunta> preguntas);

    @Mapping(target = "objCuestionario", ignore = true)
    Pregunta preguntaDTORequestToPregunta(PreguntaDTORequest preguntaDTORequest);
}