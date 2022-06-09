package electiviesforumbackend.platform.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "institute")
@Data
public class Institute extends BaseEntity {
    @OneToMany(mappedBy = "institute",fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}
