package electiviesforumbackend.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@Table(name = "minor")
public class Minor extends BaseEntity {
    @OneToMany(mappedBy = "minor", fetch = FetchType.LAZY)
    private Set<Elective> elective = new HashSet<>();
}
