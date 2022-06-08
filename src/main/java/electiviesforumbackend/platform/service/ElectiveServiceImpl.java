package electiviesforumbackend.platform.service;

import java.util.List;

import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.repository.ElectiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ElectiveServiceImpl implements ElectiveService {

    private final ElectiveRepository repository;
    public List<Elective> getElectives() {
        return repository.findAll();
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
