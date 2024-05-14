package co.edu.unicauca.asae.Taller6.application.input;

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;

import java.util.List;

public interface CuestionarioManagementCUIntPort {

   Cuestionario crear(Cuestionario objCuestionario);

   List<Cuestionario> listar();
}
