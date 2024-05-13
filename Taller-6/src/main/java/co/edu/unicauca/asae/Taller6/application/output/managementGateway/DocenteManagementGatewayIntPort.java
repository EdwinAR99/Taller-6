package co.edu.unicauca.asae.Taller6.application.output.managementGateway;

import co.edu.unicauca.asae.Taller6.domain.models.Docente;

public interface DocenteManagementGatewayIntPort {
  public boolean existDocenteForNumberId(String numeroIdentificacion);

  public Docente saveDocente(Docente objDocente);

  public Docente getDocente(Integer id);
}
