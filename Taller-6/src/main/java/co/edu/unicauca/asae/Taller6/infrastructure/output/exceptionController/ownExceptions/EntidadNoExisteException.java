package co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions;

import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.exceptionStruct.ErrorCode;
import lombok.Getter;

@Getter
public class EntidadNoExisteException extends RuntimeException {

  private final String llaveMensaje;
  private final String codigo;

  public EntidadNoExisteException(ErrorCode code) {
    super(code.getCodigo());
    this.llaveMensaje = code.getLlaveMensaje();
    this.codigo = code.getCodigo();
  }

  public EntidadNoExisteException(final String message) {
    super(message);
    this.llaveMensaje = ErrorCode.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje();
    this.codigo = ErrorCode.ENTIDAD_NO_ENCONTRADA.getCodigo();
  }
}
