package electiviesforumbackend.platform.entity;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "elective")
@Getter
@Setter
public class Elective extends BaseEntity {

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @ManyToOne
    @JoinColumn(name = "minor_id")
    private Minor minor;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tag_elective",
            joinColumns = @JoinColumn(name = "elective_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Fetch(FetchMode.SELECT)
    private Set<Tag> tags = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "author_elective",
            joinColumns = @JoinColumn(name = "elective_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @Fetch(FetchMode.SELECT)
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "elective",fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();
}