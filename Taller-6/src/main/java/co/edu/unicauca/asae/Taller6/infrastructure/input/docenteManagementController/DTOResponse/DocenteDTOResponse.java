package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse.RespuestaDTOResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DocenteDTOResponse extends PersonaDTOResponse {

    private String correo;
    private String vinculacion;
    private TelefonoDTOResponse objTelefono;
    private List<DepartamentoDTOResponse> listaDepartamentos;
    private List<RespuestaDTOResponse> listaRespuestas;
    public DocenteDTOResponse(int idPersona, String tipoIdentificacion,
            String numeroIdentificacion,
            String nombres,
            String apellidos) {
        super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos);

    }
}
