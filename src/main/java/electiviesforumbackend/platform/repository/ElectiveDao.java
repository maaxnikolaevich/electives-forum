package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Elective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ElectiveDao extends JpaRepository<Elective, Long>, JpaSpecificationExecutor<Elective> {}