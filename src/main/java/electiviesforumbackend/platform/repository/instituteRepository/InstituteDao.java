package electiviesforumbackend.platform.repository.instituteRepository;
import electiviesforumbackend.platform.entity.Institute;
import electiviesforumbackend.platform.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface InstituteDao extends JpaRepository<Institute, Long>, JpaSpecificationExecutor<Institute> {}

