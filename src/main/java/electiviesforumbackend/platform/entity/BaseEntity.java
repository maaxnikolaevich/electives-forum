package electiviesforumbackend.platform.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotNull
    private String title;

}
