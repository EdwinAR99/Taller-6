package co.edu.unicauca.asae.Taller6.application.output.formatterResponse;

import co.edu.unicauca.asae.Taller6.domain.models.Departamento;

public interface DocenteFormatterResponseIntPort {
  public void returnResponseErrorExistID(String mensaje);

  public void returnResponseErrorExistEmail(String mensaje);

  public Departamento returnResponseErrorUseCase(Integer idDepartamento);
}
