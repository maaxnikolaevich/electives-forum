package electiviesforumbackend.platform.dto;

import electiviesforumbackend.platform.entity.Author;
import electiviesforumbackend.platform.entity.Elective;
import electiviesforumbackend.platform.entity.Minor;
import electiviesforumbackend.platform.entity.Tag;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.*;

@Data
public class ElectiveResponseModel {

    private Long Id;

    private String title;

    private String shortDescription;

    private String fullDescription;

    private String minor;

    private List<AuthorResponseModel> authors;

    private List<String> tags;

    public void toElectiveResponseModel(Elective currentElective){
        Minor currentMinor = currentElective.getMinor();
        Set<Author> currentAuthors = currentElective.getAuthors();
        Set<Tag> currentTags = currentElective.getTags();

        this.Id = currentElective.getId();
        this.fullDescription = currentElective.getFullDescription();
        this.shortDescription = currentElective.getShortDescription();
        this.title = currentElective.getTitle();
        if (currentMinor != null){
            this.minor = currentMinor.getTitle();
        }
        if (currentAuthors != null){
            List <AuthorResponseModel> electiveAuthors = new ArrayList<>();
            AuthorResponseModel currentAuthor = new AuthorResponseModel();
            currentAuthors.forEach(currentObjAuthor -> {
                        currentAuthor.setName(currentObjAuthor.getName());
                        currentAuthor.setDescription(currentObjAuthor.getDescription());
                        electiveAuthors.add(currentAuthor);
                    }
            );
            this.authors = electiveAuthors;
        }
        if (currentTags != null) {
            List<String> electiveTags = new ArrayList<>();
            currentTags.forEach(currentTag ->
                    electiveTags.add(currentTag.getTitle()));
            this.tags = electiveTags;
        }
    }
    public List<ElectiveResponseModel> toElectivesResponseModelList(Page <Elective> response){
        List<ElectiveResponseModel> electives = new ArrayList<>();
        response.forEach(elective -> {
            ElectiveResponseModel electiveResponseModel = new ElectiveResponseModel();
            electiveResponseModel.toElectiveResponseModel(elective);
            electives.add(electiveResponseModel);
        });
        return electives;
    }

}
