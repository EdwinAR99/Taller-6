package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTORequest {

    private int idDepartamento;
   @NotEmpty(message = "{departamento.nombre.empty}")
    private String nombreDep;
   @NotEmpty(message = "{departamento.descripcion.empty}")
    private String descripcion;

    private List<DocenteDTORequest> listaDocentes;

    
}
