package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Elective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ElectiveRepositoryIml implements ElectiveRepository {

    private final ElectiveDao electiveDao;

    @Override
    public List<Elective> findAll() {
        return electiveDao.findAll();
    }

    @Override
    public Elective getById(Long id) {
        return electiveDao.findById(id).orElse(null);
    }

}
