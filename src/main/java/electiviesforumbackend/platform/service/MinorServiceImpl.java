package electiviesforumbackend.platform.service;

import electiviesforumbackend.platform.entity.Minor;
import electiviesforumbackend.platform.repository.MinorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MinorServiceImpl implements MinorService {

    private final MinorRepository repository;

    @Override
    public Minor findMinorById(Long id) {
        return repository.findMinorById(id);
    }
}
