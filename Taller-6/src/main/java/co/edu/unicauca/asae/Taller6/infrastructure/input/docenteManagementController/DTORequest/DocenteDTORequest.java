package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;

import co.edu.unicauca.asae.Taller6.domain.models.Telefono;
import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.RespuestaDTORequest;
import java.util.List;

public class DocenteDTORequest extends PersonaDTORequest {

  private String correo;
  private String vinculacion;
  private Telefono objTelefono;
  private List<DepartamentoDTORequest> listaDepartamentos;
  private List<RespuestaDTORequest> listaRespuestas;
}
