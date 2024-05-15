package co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.controller;

import co.edu.unicauca.asae.Taller6.application.input.CuestionarioManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTORequest.CuestionarioDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.DTOResponse.CuestionarioDTOResponse;
import co.edu.unicauca.asae.Taller6.infrastructure.input.cuestionarioManagementController.mappers.CuestionarioMapperInfrastructureDomain;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuestionario")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

   private final CuestionarioManagementCUIntPort objCuestionarioCUInt;
   private final CuestionarioMapperInfrastructureDomain objMapper;

   @PostMapping("/")
   public ResponseEntity<CuestionarioDTOResponse> create(@Valid @RequestBody CuestionarioDTORequest objCuestionario) {
      Cuestionario objCuestionarioRequest = objMapper.requestToCuestionario(objCuestionario);
      Cuestionario objCuestionarioCreate = objCuestionarioCUInt.crear(objCuestionarioRequest);
      ResponseEntity<CuestionarioDTOResponse> objResponse = new ResponseEntity<CuestionarioDTOResponse>(
              objMapper.cuestionarioToResponse(objCuestionarioCreate),
              HttpStatus.CREATED);
      return objResponse;
   }

   @GetMapping("/")
   public ResponseEntity<List<CuestionarioDTOResponse>> listar() {
      ResponseEntity<List<CuestionarioDTOResponse>> listaResponse = new ResponseEntity<List<CuestionarioDTOResponse>>(
              objMapper.cuestionariosToResponses(this.objCuestionarioCUInt.listar()),
              HttpStatus.OK);
      return listaResponse;
   }

   @GetMapping("/{titulo}")
   public ResponseEntity<List<CuestionarioDTOResponse>> listarPorTitulo(@PathVariable String titulo) {
      List<Cuestionario> cuestionariosPorTitulo = objCuestionarioCUInt.listarPorTitulo(titulo);
      List<CuestionarioDTOResponse> cuestionariosDTO = objMapper.cuestionariosToResponses(cuestionariosPorTitulo);
      return new ResponseEntity<>(cuestionariosDTO, HttpStatus.OK);
   }

}
