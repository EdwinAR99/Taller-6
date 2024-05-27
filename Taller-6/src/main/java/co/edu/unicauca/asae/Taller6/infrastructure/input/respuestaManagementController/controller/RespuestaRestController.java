package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.asae.Taller6.application.input.RespuestaManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.RespuestaDTORequest;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.RespuestaDTOResponse;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.mappers.RespuestaMapperInfrastructureDomain;

@RestController
@RequestMapping("/respuesta")
@RequiredArgsConstructor
@Validated
public class RespuestaRestController {

    private final RespuestaManagementCUIntPort objRespuestaCUInt;
    private final RespuestaMapperInfrastructureDomain objMapper;

    @PostMapping("/")
    public ResponseEntity<List<RespuestaDTOResponse>> create(
            @Valid @RequestBody List<RespuestaDTORequest> objRespuesta) {
        List<Respuesta> objRespuestasRequest = objRespuesta.stream().map(objMapper::requestToRespuesta)
                .collect(Collectors.toList());

        List<Respuesta> objRespuestasCreate = objRespuestaCUInt.crearRespuestas(objRespuestasRequest);

        List<RespuestaDTOResponse> objResponses = objRespuestasCreate.stream()
                .map(objMapper::respuestaToResponse)
                .collect(Collectors.toList());

        return new ResponseEntity<>(objResponses, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<RespuestaDTOResponse>> listar() {
        List<RespuestaDTOResponse> listaResponse = objMapper.respuestasToResponses(objRespuestaCUInt.listarRespuestas());
        return new ResponseEntity<>(listaResponse, HttpStatus.OK);
    }
}
