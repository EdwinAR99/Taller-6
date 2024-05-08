package co.edu.unicauca.asae.Taller6.infrastructure.configuration;

import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.DocenteFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.application.output.managementGateway.DocenteManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.useCases.DocenteManagementCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

   /*@Bean
   public DocenteManagementCUAdapter crearDocenteManagementCUInt(
           DocenteManagementGatewayIntPort objDocenteManagementGateway,
           DocenteFormatterResponseIntPort objDocenteFormatterResponse) {
      DocenteManagementCUAdapter objDocenteManagementCU = new DocenteManagementCUAdapter(objDocenteManagementGateway, objDocenteFormatterResponse);
      return objDocenteManagementCU;
   }*/

   // TO DO crear los beans para cuestionario y respuestas

}
