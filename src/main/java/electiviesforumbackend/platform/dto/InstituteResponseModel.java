package electiviesforumbackend.platform.dto;

import electiviesforumbackend.platform.entity.Institute;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InstituteResponseModel {
    Long value;
    String label;

    public List<InstituteResponseModel> toInstituteResponseModelList(List<Institute> institutes){
        List<InstituteResponseModel> responseModelList = new ArrayList<>();
        institutes.forEach(currentInst-> {
            InstituteResponseModel instituteResponseModel = new InstituteResponseModel();
            instituteResponseModel.setValue(currentInst.getId());
            instituteResponseModel.setLabel(currentInst.getTitle());
            responseModelList.add(instituteResponseModel);
        });
        return responseModelList;
    }
}
