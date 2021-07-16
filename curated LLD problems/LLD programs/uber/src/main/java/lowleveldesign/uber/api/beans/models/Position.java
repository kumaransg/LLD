package lowleveldesign.uber.api.beans.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    float latitude;
    float longitude;
}
