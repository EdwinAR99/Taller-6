package co.edu.unicauca.asae.Taller6.infrastructure.output.formatter;

import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.DocenteFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions.EntidadYaExisteException;

public class DocenteFormatterResponseImplAdapter
  implements DocenteFormatterResponseIntPort {

  @Override
  public void returnResponseErrorExistID(String mensaje) {
    EntidadYaExisteException objException = new EntidadYaExisteException(
      mensaje
    );
    throw objException;
  }

  @Override
  public void returnResponseErrorUseCase(String mensaje) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'returnResponseErrorUseCase'"
    );
  }

  @Override
  public void returnResponseErrorExistEmail(String mensaje) {
    EntidadYaExisteException objException = new EntidadYaExisteException(
      mensaje
    );
    throw objException;
  }
}
