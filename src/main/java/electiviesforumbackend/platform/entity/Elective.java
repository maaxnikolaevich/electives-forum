package electiviesforumbackend.platform.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "elective")
@Data
public class Elective extends BaseEntity {

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
//    @Fetch(FetchMode.JOIN)
    @ManyToOne
    @JoinColumn(name = "minor_id")
    private Minor minor;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
//    @Fetch(FetchMode.JOIN)
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tag_elective",
            joinColumns = @JoinColumn(name = "elective_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

//    @Fetch(FetchMode.JOIN)
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "author_elective",
            joinColumns = @JoinColumn(name = "elective_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "elective",fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();
}