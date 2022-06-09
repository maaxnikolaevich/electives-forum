package electiviesforumbackend.platform.service;

import electiviesforumbackend.platform.entity.Elective;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ElectiveService {
    Page<Elective> getElectives(Pageable pageable);
    Elective getById(Long id);
}


