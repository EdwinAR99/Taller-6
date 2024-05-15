package co.edu.unicauca.asae.Taller6.application.input;

import co.edu.unicauca.asae.Taller6.domain.models.Docente;

public interface DocenteManagementCUIntPort {
  public Docente createDocente(Docente objDocente);

  public Docente getDocente(Integer idPersona);
}
