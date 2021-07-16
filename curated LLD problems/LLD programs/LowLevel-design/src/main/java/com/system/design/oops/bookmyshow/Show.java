package com.system.design.oops.bookmyshow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    private String showId;
    private String movieId;
    private String startTime;
    private String endTime;
    private String hallId;
}
