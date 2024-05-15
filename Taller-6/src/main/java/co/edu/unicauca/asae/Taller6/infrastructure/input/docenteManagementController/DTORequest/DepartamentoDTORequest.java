package co.edu.unicauca.asae.Taller6.infrastructure.input.docenteManagementController.DTORequest;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DepartamentoDTORequest {
    private int idDepartamento;
    private String nombreDep;
    private String descripcion;
    private List<DocenteDTORequest> listaDocentes;
}
