package electiviesforumbackend.platform.service.instituteService;

import electiviesforumbackend.platform.entity.Institute;

import java.util.List;

public interface InstituteService {
    Institute getInstituteById(Long id);
    List<Institute> getInstitutes();
}


