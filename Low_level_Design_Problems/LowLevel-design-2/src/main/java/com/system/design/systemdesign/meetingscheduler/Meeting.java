package com.system.design.systemdesign.meetingscheduler;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meeting implements Comparable<Meeting> {
    private int startTime;
    private int endTime;
    private int duration;

    @Override
    public int compareTo(Meeting o) {
        if( this.startTime < o.startTime){
            return -1;
        }else if( this.startTime == o.startTime){
            return 0;
        }else{
            return 1;
        }
    }
}
