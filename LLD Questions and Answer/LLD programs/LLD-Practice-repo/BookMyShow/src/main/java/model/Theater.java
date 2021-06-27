package model;

import lombok.Data;

import java.util.List;

@Data
public class Theater {
    Long id;
    String name;
    List<Screen> screens;
}
