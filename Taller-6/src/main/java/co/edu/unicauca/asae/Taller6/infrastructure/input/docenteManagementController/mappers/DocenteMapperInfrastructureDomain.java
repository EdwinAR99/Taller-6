package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers;

import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTOResponse.DocenteDTOResponse;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.RespuestaDTOResponse;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfrastructureDomain {


  RespuestaDTOResponse map(Respuesta respuesta);

  List<RespuestaDTOResponse> mapList(List<Respuesta> respuestas);
  
  Docente mapperOfRequestToDocente(DocenteDTORequest request);

  DocenteDTOResponse mapperOfResponseToDocente(Docente objDocente);

  List<DocenteDTOResponse> mapperOfResponseToDocentes(List<Docente> docentes);
}
