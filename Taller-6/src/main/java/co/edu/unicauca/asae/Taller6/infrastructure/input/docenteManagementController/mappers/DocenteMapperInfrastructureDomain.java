package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers;


import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.DocenteDTORequest;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {DepartamentoMapperInfraestructureDomain.class,TelefonoMapperInfraestructureDomain.class} )
public interface DocenteMapperInfrastructureDomain {
  
  //RespuestaDTOResponse map(Respuesta respuesta);

  //List<RespuestaDTOResponse> mapList(List<Respuesta> respuestas);
  @Mapping(target = "listaRespuestas", ignore = true)
  Docente mapperOfRequestToDocente(DocenteDTORequest docente);
  
 // Docente mapperOfResponseToDocente(DocenteDTOResponse docente);
  DocenteDTORequest mapperOfResponseToDocente(Docente objDocente);

  List<DocenteDTORequest> mapperOfResponseToDocentes(List<Docente> docentes);

}

