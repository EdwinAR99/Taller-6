
package co.edu.unicauca.asae.Taller6.infrastructure.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CuestionarioMapper {

   @Bean
   public ModelMapper crearCuestionarioMapper() {
      return new ModelMapper();
   }
}
