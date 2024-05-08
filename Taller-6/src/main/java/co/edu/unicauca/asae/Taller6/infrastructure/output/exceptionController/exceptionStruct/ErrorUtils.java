package co.edu.unicauca.asae.Taller6.infrastructure.output.exceptionController.exceptionStruct;

public final class ErrorUtils {

   ErrorUtils() {

   }

   /**
    * Crea un nuevo objeto de <code>Error</code>
    *
    * @param errorCode
    * @param llaveMensaje
    * @param codigoHttp
    * @return - Objeto creado
    */
   public static Error crearError(final String errorCode, final String llaveMensaje, final Integer codigoHttp) {
      final Error error = new Error();
      error.setErrorCode(errorCode);
      error.setMensaje(llaveMensaje);
      error.setCodigoHttp(codigoHttp);
      return error;
   }

}
