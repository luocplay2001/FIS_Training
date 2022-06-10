package fis.sprint02.model;

import lombok.Data;

@Data
public class Storage extends AbstractEntity {
    String name;
    String location;

    public Storage() {
    }


}
