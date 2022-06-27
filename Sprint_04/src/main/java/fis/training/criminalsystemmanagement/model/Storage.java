package fis.training.criminalsystemmanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_storage")
public class Storage extends AbstractEntity {
    private String name;
    private String location;

    @OneToMany(mappedBy = "storage")
    @JsonManagedReference(value="evidence-storage")
    private Set<Evidence> evidences;

//    @Override
//    public String toString() {
//        return "Storage{" +
//                "name='" + name + '\'' +
//                ", location='" + location + '\'' +
////                ", evidences=" + evidences +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        if (!super.equals(o)) return false;
        Storage storage = (Storage) o;
        return name.equals(storage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
