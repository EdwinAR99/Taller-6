package co.edu.unicauca.asae.Taller6.infrastructure.output.formatter;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.DocenteFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions.EntidadYaExisteException;

@Service
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
  public void returnResponseErrorExistEmail(String mensaje) {
    EntidadYaExisteException objException = new EntidadYaExisteException(
      mensaje
    );
    throw objException;
  }


  @Override
  public Departamento returnResponseErrorUseCase(Integer idDepartamento) {
   return null;
  }
}
