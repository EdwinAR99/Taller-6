package co.edu.unicauca.asae.Taller6.domain.useCases;

import co.edu.unicauca.asae.Taller6.application.input.DocenteManagementCUIntPort;
import co.edu.unicauca.asae.Taller6.application.output.formatterResponse.DocenteFormatterResponseIntPort;
import co.edu.unicauca.asae.Taller6.application.output.managementGateway.DocenteManagementGatewayIntPort;
import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;
import co.edu.unicauca.asae.Taller6.domain.models.Telefono;

public class DocenteManagementCUAdapter implements DocenteManagementCUIntPort {

  private final DocenteManagementGatewayIntPort objDocenteManagementGatewayIntPort;
  private final DocenteFormatterResponseIntPort objDocenteFormatterResponseIntPort;

  public DocenteManagementCUAdapter(
      DocenteManagementGatewayIntPort objDocenteManagementGateway,
      DocenteFormatterResponseIntPort objDocenteFormatterResponse) {
    this.objDocenteManagementGatewayIntPort = objDocenteManagementGateway;
    this.objDocenteFormatterResponseIntPort = objDocenteFormatterResponse;
  }

  @Override
  public Docente createDocente(Docente objDocente) {
    Docente objDocenteCreated = null;
    if (this.objDocenteManagementGatewayIntPort.existDocenteForNumberId(
        objDocente.getNumeroIdentificacion())) {
      this.objDocenteFormatterResponseIntPort.returnResponseErrorExistID(
          "Error, se encuentra en el sistema un docente registrado con ese numero de identificacion");
    } else {
      if (this.objDocenteManagementGatewayIntPort.existDocenteForEmail(
          objDocente.getCorreo())) {
        this.objDocenteFormatterResponseIntPort.returnResponseErrorExistEmail(
            "Error, se encuentra en el sistema un docente registrado con ese correo");
      } else {
        //Departamento dpto1 = new Departamento();
        //dpto1 = getDepartamento(objDocente.getListaDepartamentos().get(0).getIdDepartamento());
        //System.out.println(objDocente.getListaDepartamentos().get(0).getIdDepartamento());
        //objDocente.addDepartamento(dpto1);
        //System.out.println("este es el dpto" + dpto1);

        objDocenteCreated = this.objDocenteManagementGatewayIntPort.saveDocente(objDocente);
      }
    }
    return objDocenteCreated;
  }

  @Override
  public Docente getDocente(Integer idPersona) {
    Docente objDocenteCreated = null;
    objDocenteCreated = this.objDocenteManagementGatewayIntPort.getDocente(idPersona);
    return objDocenteCreated;
  }

  @Override
  public Departamento getDepartamento(Integer idDepartamento) {
    Departamento objDepartamento = null;
    objDepartamento = this.objDocenteManagementGatewayIntPort.getDepartamento(idDepartamento);
    return objDepartamento;
  }

}
