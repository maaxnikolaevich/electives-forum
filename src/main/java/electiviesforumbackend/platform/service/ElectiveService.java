package electiviesforumbackend.platform.service;

import electiviesforumbackend.platform.entity.Elective;

import java.util.List;

public interface ElectiveService {
    List<Elective> getElectives();
    Elective getById(Long id);
}


