package electiviesforumbackend.platform.repository;

import electiviesforumbackend.platform.entity.Minor;

import java.util.Optional;


public interface MinorRepository {
    Minor findMinorById(Long id);
}