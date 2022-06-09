package electiviesforumbackend.platform.service;

import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.repository.ElectiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ElectiveServiceImpl implements ElectiveService {

    private final ElectiveRepository repository;
    public Page<Elective> getElectives(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Elective getById(Long id) {
        return repository.getById(id);
    }

//    public Users saveUser(Elective elective) {
//        users.setId(new Random().nextInt());
//        return usersRepository.save(users);
//    }

}
