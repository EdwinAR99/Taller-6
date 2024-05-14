package co.edu.unicauca.asae.Taller6.domain.useCases;

import co.edu.unicauca.asae.Taller6.application.input.CuestionarioManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.CuestionarioFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.application.output.managementGateway.CuestionarioManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;

import java.util.List;

public class CuestionarioManagementCUAdapter implements CuestionarioManagementCUIntPort {

   private final CuestionarioManagementGatewayIntPort objCuestionarioManagementGateway;
   private final CuestionarioFormatterResponseIntPort objCuestionarioFormatterResponse;

   public CuestionarioManagementCUAdapter(
           CuestionarioManagementGatewayIntPort objCuestionarioManagementGateway,
           CuestionarioFormatterResponseIntPort objCuestionarioFormatterResponse) {
      this.objCuestionarioManagementGateway = objCuestionarioManagementGateway;
      this.objCuestionarioFormatterResponse = objCuestionarioFormatterResponse;
   }

   @Override
   public Cuestionario crear(Cuestionario objCuestionario) {
      return null;
   }

   @Override
   public List<Cuestionario> listar() {
      return List.of();
   }
}
