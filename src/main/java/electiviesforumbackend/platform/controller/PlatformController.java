package electiviesforumbackend.platform.controller;


import java.util.*;

import electiviesforumbackend.platform.dto.ElectiveResponseModel;
import electiviesforumbackend.platform.dto.InstituteResponseModel;
import electiviesforumbackend.platform.dto.ReviewModel;
import electiviesforumbackend.platform.entity.*;
import electiviesforumbackend.platform.service.ElectiveService;
import electiviesforumbackend.platform.service.instituteService.InstituteService;
import electiviesforumbackend.platform.service.reviewService.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PlatformController {

    private final ElectiveService electiveService;

    private final InstituteService instituteService;

    @GetMapping(path = "institutes")
    public ResponseEntity<List<InstituteResponseModel>> listInstitutes(){
        List<Institute> instituteList = instituteService.getInstitutes();
        List<InstituteResponseModel> responseModelList = new ArrayList<>();
        instituteList.forEach(currentInst-> {
            InstituteResponseModel instituteResponseModel = new InstituteResponseModel();
            instituteResponseModel.setValue(currentInst.getId());
            instituteResponseModel.setLabel(currentInst.getTitle());
            responseModelList.add(instituteResponseModel);
        });
        return new ResponseEntity<>(responseModelList, HttpStatus.OK);
    }

    @GetMapping(path = "electives/{id}")
    public ResponseEntity<ElectiveResponseModel> getElective(@PathVariable Long id){
        Elective electiveDto= electiveService.getById(id);
        ElectiveResponseModel elective = new ElectiveResponseModel();
        if (electiveDto != null){
            elective.toElective(electiveDto);
        }
        return new ResponseEntity<>(elective, HttpStatus.OK);
    }
    @GetMapping(path = "electives")
    public ResponseEntity<List<ElectiveResponseModel>> listElectives() {
        List<Elective> response = electiveService.getElectives();
        List<ElectiveResponseModel> electives = new ArrayList<>();
        response.forEach(elective -> {
            ElectiveResponseModel electiveResponseModel = new ElectiveResponseModel();
            electiveResponseModel.toElective(elective);
            electives.add(electiveResponseModel);
        });
        return new ResponseEntity<>(electives, HttpStatus.OK);
    }

    private final ReviewService reviewService;
    @PostMapping(path = "review")
    public ResponseEntity<?> saveReview(@RequestBody ReviewModel review) {
        Boolean isSave = reviewService.saveReview(review);
        if (isSave){return new ResponseEntity<>(HttpStatus.OK);}
        else {
            throw new EntityNotFoundException("Add error, elective or user not found");
        }
    }

}
