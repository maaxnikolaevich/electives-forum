package electiviesforumbackend.platform.entity;

import lombok.*;

import javax.persistence.*;

import java.util.HashSet;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "minor")
public class Minor extends BaseEntity {

    @OneToMany(mappedBy = "minor", fetch = FetchType.LAZY)
    private Set<Elective> elective = new HashSet<>();
}
