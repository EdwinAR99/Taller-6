package co.edu.unicauca.asae.Taller6.application.output.formatterResponse;

public interface RespuestaFormatterResponseIntPort {

    // Validar que antes de responder un cuestionario, un docente no debe haber
    // contestado el cuestionario.
    void returnResponseErrorCuestionarioContestado(String mensaje);

    // Validar que antes de registrar una respuesta exista el id del cuestionario en
    // la base de datos.
    void returnResponseErrorIdCuestionarioNoExiste(String mensaje);

    // Validar que antes de registrar una respuesta exista el id del docente en la
    // base de datos.
    void returnResponseErrorIdDocenteNoExiste(String mensaje);

    void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
