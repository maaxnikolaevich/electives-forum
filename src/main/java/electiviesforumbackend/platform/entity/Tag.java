package electiviesforumbackend.platform.entity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag extends BaseEntity {

    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    Set<Elective> electives = new HashSet<>();
}
