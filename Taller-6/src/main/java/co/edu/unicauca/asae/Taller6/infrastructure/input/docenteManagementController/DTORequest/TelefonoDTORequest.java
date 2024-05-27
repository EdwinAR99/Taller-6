package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoDTORequest {


    private int idTelefono;
    @NotNull(message = "{telefono.tipo.empty}")
    private String tipoTelefono;
    @Pattern(regexp = "^3.*$", message = "El número debe comenzar con 3")
    @Valid
    private String numero;

    private DocenteDTORequest objDocente;
}
