package co.edu.unicauca.asae.Taller6.infrastructure.output.formatter;

import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.CuestionarioFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions.BusinessRuleException;
import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions.EntidadYaExisteException;
import org.springframework.stereotype.Service;

@Service
public class CuestionarioFormatterResponseImplAdapter implements CuestionarioFormatterResponseIntPort {
   @Override
   public void retornarRespuestaErrorEntidadExiste(String mensaje) {
      EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
      throw objException;
   }

   @Override
   public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
      BusinessRuleException objException = new BusinessRuleException(mensaje);
      throw objException;
   }
}
