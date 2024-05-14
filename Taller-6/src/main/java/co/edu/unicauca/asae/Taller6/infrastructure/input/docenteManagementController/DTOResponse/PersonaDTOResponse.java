package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTOResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonaDTOResponse {
    private int idPersona;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
}
