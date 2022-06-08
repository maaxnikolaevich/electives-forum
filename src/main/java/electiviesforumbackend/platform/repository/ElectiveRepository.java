package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Elective;

import java.util.List;

public interface ElectiveRepository {
    List<Elective> findAll();
    Elective getById(Long id);
}
