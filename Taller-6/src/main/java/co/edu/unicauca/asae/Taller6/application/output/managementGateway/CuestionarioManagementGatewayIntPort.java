package co.edu.unicauca.asae.Taller6.application.output.managementGateway;

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;

import java.util.List;

public interface CuestionarioManagementGatewayIntPort {

   boolean existeCuestionarioPorTitulo(String titulo);

   Cuestionario guardar(Cuestionario objCuestionario);

   List<Cuestionario> listar();

   List<Cuestionario> listarPorTitulo(String patron);
}
