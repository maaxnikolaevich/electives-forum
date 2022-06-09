package electiviesforumbackend.platform.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "institute")
@Getter
@Setter
public class Institute extends BaseEntity {
    
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "institute")
    private List<User> users = new ArrayList<>();
}
