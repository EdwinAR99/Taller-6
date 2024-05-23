package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.controller;

import co.edu.unicauca.asae.Taller6.application.input.DocenteManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.mappers.DocenteMapperInfrastructureDomain;
import jakarta.validation.Valid;
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
@RequestMapping("/docente")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {

  private final DocenteManagementCUIntPort objManageDocenteCUInt;
  private final DocenteMapperInfrastructureDomain objMapper;

  @GetMapping("/{id}")
  public ResponseEntity<DocenteDTORequest> getDocente(
    @PathVariable Integer id
  ) {
    ResponseEntity<DocenteDTORequest> objRespuesta = new ResponseEntity<DocenteDTORequest>(
      objMapper.mapperOfResponseToDocente(
        this.objManageDocenteCUInt.getDocente(id)
      ),
      HttpStatus.OK
    );
    return objRespuesta;
  }

  @PostMapping("/")
  public ResponseEntity<DocenteDTORequest> create(@Valid
    @RequestBody DocenteDTORequest objDocente
  ) {
    Docente objDocenteCreate = objMapper.mapperOfRequestToDocente(objDocente);
    Docente objDocenteCreated = objManageDocenteCUInt.createDocente(
      objDocenteCreate
    );
    ResponseEntity<DocenteDTORequest> objResponse = new ResponseEntity<DocenteDTORequest>(
      objMapper.mapperOfResponseToDocente(objDocenteCreated),
      HttpStatus.CREATED
    );
    return objResponse;
  }
}
