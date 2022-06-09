package electiviesforumbackend.platform.controller;


import java.util.*;

import electiviesforumbackend.platform.dto.ElectiveResponseModel;
import electiviesforumbackend.platform.dto.ElectiveResponseModelFull;
import electiviesforumbackend.platform.dto.InstituteResponseModel;
import electiviesforumbackend.platform.dto.ReviewModel;
import electiviesforumbackend.platform.entity.*;
import electiviesforumbackend.platform.exeptions.AddingCommentException;
import electiviesforumbackend.platform.exeptions.GetElectiveException;
import electiviesforumbackend.platform.service.ElectiveService;
import electiviesforumbackend.platform.service.instituteService.InstituteService;
import electiviesforumbackend.platform.service.reviewService.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PlatformController {

    private final ElectiveService electiveService;

    private final InstituteService instituteService;

    @GetMapping(path = "institutes")
    public ResponseEntity<List<InstituteResponseModel>> listInstitutes(){
        List<Institute> instituteList = instituteService.getInstitutes();
        InstituteResponseModel instituteResponseModel = new InstituteResponseModel();
        List<InstituteResponseModel> responseModel =
                instituteResponseModel.toInstituteResponseModelList(instituteList);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping(path = "electives/{id}")
    public ResponseEntity<?> getElective(@PathVariable Long id) throws GetElectiveException {
        try{
            Elective elective = electiveService.getById(id);
            ElectiveResponseModelFull electiveDto = new ElectiveResponseModelFull();
            if (elective == null){
                return new ResponseEntity<>(String.format(
                        "Elective with id - %s, not found!",id), HttpStatus.NOT_FOUND);
            }
            electiveDto.toElectiveResponseModelFull(elective);
            return new ResponseEntity<>(electiveDto, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new GetElectiveException("Error receiving electives");
        }

    }
    @GetMapping(path = "electives")
    public ResponseEntity<?> listElectives(@PageableDefault(value = 20, page = 0) Pageable
                                                       pageable) {
        try {
            Page<Elective> response = electiveService.getElectives(pageable);
            ElectiveResponseModel electives = new ElectiveResponseModel();
            return new ResponseEntity<>(electives.
                    toElectivesResponseModelList(response), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error while getting data",HttpStatus.BAD_REQUEST);
        }
    }

    private final ReviewService reviewService;
    @PostMapping(path = "review")
    public ResponseEntity<?> saveReview(@RequestBody ReviewModel review)
            throws AddingCommentException{
        try{
            reviewService.saveReview(review);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception ex){
        throw new AddingCommentException("Error review adding");}
    }

}
