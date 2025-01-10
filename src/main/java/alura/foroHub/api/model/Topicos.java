package alura.foroHub.api.model;

import alura.foroHub.api.dto.DatosUpdateTopicosDto;
import alura.foroHub.api.dto.TopicosDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicostabla")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topicos {

          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          private long id;
          private String titulo;
          private String mensaje;
          private String fechaDeCreacion;
          private Boolean status;
          private String autor;
          private String curso;

          public Topicos(TopicosDto topicosDto){
              this.titulo = topicosDto.titulo();
              this.mensaje = topicosDto.mensaje();
              this.status = true;
              this.autor = topicosDto.autor();
              this.curso = topicosDto.curso();
          }

    public void actualizarDatosTopicos(DatosUpdateTopicosDto datosUpdateTopicosDto) {
           if(datosUpdateTopicosDto.titulo() !=null){
               this.titulo=datosUpdateTopicosDto.titulo();
           }
           if (datosUpdateTopicosDto.mensaje() !=null){
               this.mensaje=datosUpdateTopicosDto.mensaje();
           }
           if (datosUpdateTopicosDto.autor() !=null){
               this.autor=datosUpdateTopicosDto.autor();
           }
           if (datosUpdateTopicosDto.curso() !=null) {
               this.curso = datosUpdateTopicosDto.curso();
           }

    }

    public void desactivarTopico() {
              this.status = false;

    }
}
