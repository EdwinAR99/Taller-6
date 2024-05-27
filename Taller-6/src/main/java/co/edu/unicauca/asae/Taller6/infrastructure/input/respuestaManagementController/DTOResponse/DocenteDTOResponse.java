package co.edu.unicauca.asae.Taller6.infrastructure.input.respuestaManagementController.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTOResponse extends PersonaDTOResponse {

    private String correo;
    private String vinculacion;

    /*
     * public DocenteDTOResponse(int idPersona, String tipoIdentificacion, String
     * numeroIdentificacion, String nombres,
     * String apellidos, String correo, String vinculacion) {
     * super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres,
     * apellidos);
     * this.correo = correo;
     * this.vinculacion = vinculacion;
     * }
     */

}
