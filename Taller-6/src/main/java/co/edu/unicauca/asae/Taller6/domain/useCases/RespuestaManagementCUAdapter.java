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
        // pendiente hacer validaciones
        List<Respuesta> objRespuestaCreate = null;
        objRespuestaCreate = objRespuestaManagementGateway.guardarRespuestas(objRespuesta);
        return objRespuestaCreate;
    }

    @Override
    public List<Respuesta> listarRespuestas() {
        return objRespuestaManagementGateway.listar();
    }
}
