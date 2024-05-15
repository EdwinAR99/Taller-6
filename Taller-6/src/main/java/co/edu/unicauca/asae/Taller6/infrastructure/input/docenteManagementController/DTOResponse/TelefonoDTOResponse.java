package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTOResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelefonoDTOResponse {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    private DocenteDTOResponse objDocente;
}
