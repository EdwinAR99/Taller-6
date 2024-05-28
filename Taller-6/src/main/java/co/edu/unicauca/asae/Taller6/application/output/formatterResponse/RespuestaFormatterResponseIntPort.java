package co.edu.unicauca.asae.Taller6.application.output.formatterResponse;

public interface RespuestaFormatterResponseIntPort {

    // Validar que antes de responder un cuestionario, un docente no debe haber
    // contestado el cuestionario.
    void returnResponseErrorCuestionarioContestado(String mensaje);

    void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
