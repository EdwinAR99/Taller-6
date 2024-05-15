package co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.ownExceptions;

import co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.exceptionStruct.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public abstract class ManagementRuntimeException extends RuntimeException {

   protected ErrorCode errorCode;

   public abstract String formatException();
}
