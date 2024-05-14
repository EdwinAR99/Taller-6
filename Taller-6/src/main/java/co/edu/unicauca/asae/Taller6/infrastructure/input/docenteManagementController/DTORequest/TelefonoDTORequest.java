package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TelefonoDTORequest {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    private DocenteDTORequest objDocente;
}
