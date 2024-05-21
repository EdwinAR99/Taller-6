package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.Taller6.domain.models.TipoPregunta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest.TipoPreguntaDTORequest;

@Mapper(componentModel = "spring")
public interface TipoPreguntaMapperInfraestructureDomain {

    @Mapping(target = "listaPreguntas", ignore = true)
    TipoPreguntaDTORequest tipoPreguntaToTipoPreguntaDTORequest(TipoPregunta tipoPregunta);

    @Mapping(target = "listaPreguntas", ignore = true)
    TipoPregunta tipoPreguntaDTORequestToTipoPregunta(TipoPreguntaDTORequest tipoPreguntaDTORequest);
}
