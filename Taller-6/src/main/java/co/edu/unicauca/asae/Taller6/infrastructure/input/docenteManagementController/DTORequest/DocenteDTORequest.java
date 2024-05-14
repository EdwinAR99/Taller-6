package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;

import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.RespuestaDTORequest;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DocenteDTORequest extends PersonaDTORequest {

  private String correo;
  private String vinculacion;
  private TelefonoDTORequest objTelefono;
  private List<DepartamentoDTORequest> listaDepartamentos;
  private List<RespuestaDTORequest> listaRespuestas;

  public DocenteDTORequest(int idPersona, String tipoIdentificacion, String numeroIdentificacion, String nombres,
      String apellidos) {
    super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);

  }
}
