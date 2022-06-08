package electiviesforumbackend.platform.repository.instituteRepository;

import electiviesforumbackend.platform.entity.Institute;
import electiviesforumbackend.platform.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InstituteRepositoryIml implements InstituteRepository {
    private final InstituteDao instituteDao;

    @Override
    public Institute getInstituteById(Long id) {
        return instituteDao.findById(id).orElse(null);
    }

    @Override
    public List<Institute> findAll() {
        return instituteDao.findAll();
    }
}
