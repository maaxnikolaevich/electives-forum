package electiviesforumbackend.platform.repository.instituteRepository;

import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Institute;
import electiviesforumbackend.platform.entity.Review;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InstituteRepository {
    Institute getInstituteById(Long id);
    List<Institute> findAll();
}