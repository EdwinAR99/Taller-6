package co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions;

import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.exceptionStruct.ErrorCode;

public class BusinessRuleException extends ManagementRuntimeException {

  private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

  private final String reglaNegocio;

  public BusinessRuleException(final String reglaNegocio) {
    super(ErrorCode.VIOLACION_REGLA_DE_NEGOCIO);
    this.reglaNegocio = reglaNegocio;
  }

  @Override
  public String formatException() {
    return String.format(FORMATO_EXCEPCION, errorCode.getCodigo(), reglaNegocio);
  }
}
