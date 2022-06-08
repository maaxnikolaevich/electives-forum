package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Minor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MinorRepositoryIml implements MinorRepository{

    private final MinorDao minorDao;

    @Override
    public Minor findMinorById(Long id) {
        return minorDao.findById(id).orElse(null);
    }
}
