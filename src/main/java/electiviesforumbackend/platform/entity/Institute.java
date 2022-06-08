package electiviesforumbackend.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "institute")
@Data
public class Institute extends BaseEntity {
    @OneToMany(mappedBy = "institute",fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
}
