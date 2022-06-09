package electiviesforumbackend.platform.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tag")
@Data
public class Tag extends BaseEntity {
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    Set<Elective> electives = new HashSet<>();
}
