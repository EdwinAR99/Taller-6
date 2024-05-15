package co.edu.unicauca.asae.Taller6.application.output.formatterResponse;

public interface DocenteFormatterResponseIntPort {
  public void returnResponseErrorExistID(String mensaje);

  public void returnResponseErrorExistEmail(String mensaje);

  public void returnResponseErrorUseCase(String mensaje);
}
