package co.edu.unicauca.asae.Taller6.application.output.formatterResponse;

import co.edu.unicauca.asae.Taller6.domain.models.Cuestionario;

import java.util.List;

public interface CuestionarioFormatterResponseIntPort {

   void retornarRespuestaErrorEntidadExiste(String mensaje);

   void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
