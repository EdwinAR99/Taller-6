package co.edu.unicauca.asae.Taller6.infrastructure.output.formatter;

import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.RespuestaFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions.BusinessRuleException;

import org.springframework.stereotype.Service;

@Service
public class RespuestaFormatterResponseImplAdapter implements RespuestaFormatterResponseIntPort {

    @Override
    public void returnResponseErrorCuestionarioContestado(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnResponseErrorCuestionarioContestado'");
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        BusinessRuleException objException = new BusinessRuleException(mensaje);
        throw objException;
    }
}
