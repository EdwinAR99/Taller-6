package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.controller;

import co.edu.unicauca.asae.Taller6.application.input.DocenteManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTOResponse.DocenteDTOResponse;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers.DocenteMapperInfrastructureDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {

  private final DocenteManagementCUIntPort objManageDocenteCUInt;
  private final DocenteMapperInfrastructureDomain objMapper;

  @GetMapping("/docente/{id}")
  public ResponseEntity<DocenteDTOResponse> getDocente(
    @PathVariable Integer id
  ) {
    System.out.println(id);
    ResponseEntity<DocenteDTOResponse> objRespuesta = new ResponseEntity<DocenteDTOResponse>(
      objMapper.mapperOfResponseToDocente(
        this.objManageDocenteCUInt.getDocente(id)
      ),
      HttpStatus.OK
    );
    return objRespuesta;
  }

  @PostMapping("/docente")
  public ResponseEntity<DocenteDTOResponse> create(
    @RequestBody DocenteDTORequest objDocente
  ) {
    Docente objDocenteCreate = objMapper.mapperOfRequestToDocente(objDocente);
    Docente objDocenteCreated = objManageDocenteCUInt.createDocente(
      objDocenteCreate
    );
    ResponseEntity<DocenteDTOResponse> objResponse = new ResponseEntity<DocenteDTOResponse>(
      objMapper.mapperOfResponseToDocente(objDocenteCreated),
      HttpStatus.CREATED
    );
    return objResponse;
  }
}
