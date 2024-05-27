package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;

import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTORequest.RespuestaDTORequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class DocenteDTORequest extends PersonaDTORequest {
  @Email(message = "El correo electrónico debe ser válido")
  private String correo;
  @NotEmpty(message = "{docente.vinculacion.empty}")
  private String vinculacion;
  @NotNull(message = "{docente.telefono.empty}")
  @Valid
  private TelefonoDTORequest objTelefono;
  @Valid
  private List<DepartamentoDTORequest> listaDepartamentos;
  @Valid
  private List<RespuestaDTORequest> listaRespuestas;
/* 
  public DocenteDTORequest(int idPersona, String tipoIdentificacion, String numeroIdentificacion, String nombres,
      String apellidos) {
    super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);

  }
  */
}
