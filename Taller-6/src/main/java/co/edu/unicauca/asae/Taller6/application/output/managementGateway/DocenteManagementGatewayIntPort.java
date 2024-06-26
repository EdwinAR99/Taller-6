package co.edu.unicauca.asae.Taller6.application.output.managementGateway;

import co.edu.unicauca.asae.Taller6.domain.models.Departamento;
import co.edu.unicauca.asae.Taller6.domain.models.Docente;

public interface DocenteManagementGatewayIntPort {
  public boolean existDocenteForNumberId(String numeroIdentificacion);

  public boolean existDocenteForEmail(String correo);

  public Docente saveDocente(Docente objDocente);

  public Docente getDocente(Integer id);

  public Departamento getDepartamento(Integer id);
}
