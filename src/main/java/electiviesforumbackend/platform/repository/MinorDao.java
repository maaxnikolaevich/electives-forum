package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Minor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MinorDao extends JpaRepository<Minor, Long>, JpaSpecificationExecutor<Minor> {}