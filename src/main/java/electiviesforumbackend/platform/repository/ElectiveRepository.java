package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Elective;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElectiveRepository {
    Page<Elective> findAll(Pageable pageable);
    Elective getById(Long id);
}
