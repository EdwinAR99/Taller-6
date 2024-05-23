package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers;


import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTOResponse.DocenteDTOResponse;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.RespuestaDTOResponse;

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
  @Mapping(target = "listaRespuestas", ignore = true)
  DocenteDTORequest mapperOfResponseToDocente(Docente objDocente);

  @Mapping(target = "listaRespuestas", ignore = true)
  List<DocenteDTORequest> mapperOfResponseToDocentes(List<Docente> docentes);

}

