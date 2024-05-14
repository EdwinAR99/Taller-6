package co.edu.unicauca.asae.Taller6.application.output.managementGateway;

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;

import java.util.List;

public interface CuestionarioManagementGatewayIntPort {

   boolean existeCuestionarioPorId(int id);

   Cuestionario guardar(Cuestionario objCuestionario);

   List<Cuestionario> listar();
}
