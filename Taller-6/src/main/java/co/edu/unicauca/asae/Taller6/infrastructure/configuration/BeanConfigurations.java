package co.edu.unicauca.asae.Taller6.infrastructure.configuration;

import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.CuestionarioFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.application.output.managementGateway.CuestionarioManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.useCases.CuestionarioManagementCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

  /*@Bean
   public DocenteManagementCUAdapter crearDocenteManagementCUInt(
           DocenteManagementGatewayIntPort objDocenteManagementGateway,
           DocenteFormatterResponseIntPort objDocenteFormatterResponse) {
      DocenteManagementCUAdapter objDocenteManagementCU = new DocenteManagementCUAdapter(objDocenteManagementGateway, objDocenteFormatterResponse);
      return objDocenteManagementCU;
   }*/

  // TO DO crear los beans respuestas
  @Bean
  public CuestionarioManagementCUAdapter crearCuestionarioManagementCUInt(
    CuestionarioManagementGatewayIntPort objCuestionarioManagementGateway,
    CuestionarioFormatterResponseIntPort objCuestionarioFormatterResponse
  ) {
    return new CuestionarioManagementCUAdapter(
      objCuestionarioManagementGateway,
      objCuestionarioFormatterResponse
    );
  }
}
