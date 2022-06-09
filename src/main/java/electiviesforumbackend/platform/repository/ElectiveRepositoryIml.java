package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Elective;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ElectiveRepositoryIml implements ElectiveRepository {

    private final ElectiveDao electiveDao;

    @Override
    public Page<Elective> findAll(Pageable pageable) {
//        Pageable p = Pageable.ofSize(size);
        return electiveDao.findAll(pageable);
    }

    @Override
    public Elective getById(Long id) {
        return electiveDao.findById(id).orElse(null);
    }

}
