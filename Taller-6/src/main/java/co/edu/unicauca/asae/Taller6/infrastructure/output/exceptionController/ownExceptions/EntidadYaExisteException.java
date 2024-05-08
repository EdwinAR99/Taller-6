package co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions;

import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.exceptionStruct.ErrorCode;
import lombok.Getter;

@Getter
public class EntidadYaExisteException extends RuntimeException {

  private final String llaveMensaje;
  private final String codigo;

  public EntidadYaExisteException(ErrorCode code) {
    super(code.getCodigo());
    this.llaveMensaje = code.getLlaveMensaje();
    this.codigo = code.getCodigo();
  }

  public EntidadYaExisteException(final String message) {
    super(message);
    this.llaveMensaje = ErrorCode.ENTIDAD_YA_EXISTE.getLlaveMensaje();
    this.codigo = ErrorCode.ENTIDAD_YA_EXISTE.getCodigo();
  }
}
