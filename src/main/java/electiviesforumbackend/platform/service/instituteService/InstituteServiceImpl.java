package electiviesforumbackend.platform.service.instituteService;

import electiviesforumbackend.platform.entity.Institute;
import electiviesforumbackend.platform.repository.instituteRepository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InstituteServiceImpl implements InstituteService {

    private final InstituteRepository repository;

    @Override
    public Institute getInstituteById(Long id) {
        return repository.getInstituteById(id);
    }

    @Override
    public List<Institute> getInstitutes() {
        return repository.findAll();
    }

}
