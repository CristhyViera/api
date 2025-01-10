package alura.foroHub.api.repository;

import aj.org.objectweb.asm.commons.Remapper;
import alura.foroHub.api.model.Topicos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicosRepository extends JpaRepository<Topicos, Long> {

    Page <Topicos> findByStatusTrue(Pageable paginacion);
}
