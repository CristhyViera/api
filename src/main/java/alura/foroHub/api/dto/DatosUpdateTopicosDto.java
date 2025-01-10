package alura.foroHub.api.dto;

import alura.foroHub.api.model.Topicos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUpdateTopicosDto(
                                    @NotNull
                                    Long Id,

                                    String titulo,

                                    String mensaje,

                                    String autor,

                                    String curso) {
    public DatosUpdateTopicosDto(Topicos topicos){
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensaje(), topicos.getAutor(), topicos.getCurso());
    }
}
