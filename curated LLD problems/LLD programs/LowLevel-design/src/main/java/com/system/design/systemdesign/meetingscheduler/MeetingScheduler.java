package com.system.design.systemdesign.meetingscheduler;

import javafx.collections.transformation.SortedList;
import sun.reflect.generics.tree.Tree;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//https://www.careercup.com/question?id=15555745
//https://stackoverflow.com/questions/15150188/amazon-interview-design-meeting-scheduler
public class MeetingScheduler {
    Set<Meeting> meetingTreeSet = new TreeSet<>();
    public void bookRoom( Meeting meeting){
        if( !checkCollision(meeting)){
            meetingTreeSet.add(meeting);
        }
    }
    private boolean checkCollision( Meeting  meeting){
        if( meetingTreeSet.size() == 0 ){
            return false;
        }
        return false;
    }
}
