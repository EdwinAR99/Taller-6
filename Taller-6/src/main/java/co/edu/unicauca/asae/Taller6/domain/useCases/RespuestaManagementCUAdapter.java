package co.edu.unicauca.asae.Taller6.domain.useCases;

import java.util.List;

import co.edu.unicauca.asae.Taller6.application.input.RespuestaManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.RespuestaFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.application.output.managementGateway.RespuestaManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Respuesta;

public class RespuestaManagementCUAdapter implements RespuestaManagementCUIntPort {

    private final RespuestaManagementGatewayIntPort objRespuestaManagementGateway;
    private final RespuestaFormatterResponseIntPort objRespuestaFormatterResponse;

    public RespuestaManagementCUAdapter(
            RespuestaManagementGatewayIntPort objRespuestaManagementGateway,
            RespuestaFormatterResponseIntPort objRespuestaFormatterResponse) {
        this.objRespuestaManagementGateway = objRespuestaManagementGateway;
        this.objRespuestaFormatterResponse = objRespuestaFormatterResponse;
    }

    @Override
    public List<Respuesta> crearRespuestas(List<Respuesta> objRespuesta) {
        System.out.println("Agregando una nueva respuesta");

        if (objRespuesta == null || objRespuesta.isEmpty()) {
            throw new IllegalArgumentException("La lista de respuestas no puede estar vacía");
        }

        // Validar todas las entidades necesarias
        for (Respuesta respuesta : objRespuesta) {
            validarExistenciaDeEntidades(respuesta);
        }

        List<Respuesta> objRespuestaCreate = null;
        objRespuestaCreate = objRespuestaManagementGateway.guardarRespuestas(objRespuesta);
        return objRespuestaCreate;
    }

    @Override
    public List<Respuesta> listarRespuestas() {
        return objRespuestaManagementGateway.listar();
    }

    private void validarExistenciaDeEntidades(Respuesta respuesta) {
        int idDocente = respuesta.getObjPersona().getIdPersona();
        int idCuestionario = respuesta.getObjPregunta().getObjCuestionario().getIdCuestionario();
        int idPregunta = respuesta.getObjPregunta().getIdPregunta();

        if (this.objRespuestaManagementGateway.returnResponseErrorIdDocenteNoExiste(idDocente)) {
            this.objRespuestaFormatterResponse
                    .retornarRespuestaErrorReglaDeNegocio("Error, el idPersona " + idDocente + " no existe...");
        }
        if (this.objRespuestaManagementGateway.returnResponseErrorIdCuestionarioNoExiste(idCuestionario)) {
            this.objRespuestaFormatterResponse.retornarRespuestaErrorReglaDeNegocio(
                    "Error, el idCuestionario " + idCuestionario + " no existe...");
        }
        if (this.objRespuestaManagementGateway.returnResponseErrorIdPreguntaNoExiste(idPregunta)) {
            this.objRespuestaFormatterResponse
                    .retornarRespuestaErrorReglaDeNegocio("Error, el idPregunta " + idPregunta + " no existe...");
        }
    }
}
