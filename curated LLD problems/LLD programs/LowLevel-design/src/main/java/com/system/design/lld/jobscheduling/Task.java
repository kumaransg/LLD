package com.system.design.lld.jobscheduling;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    public int cpu, ram; // required CPU, RAM for this task

    @Override
    public String call() throws Exception { // execute the task and return the computed result of type T
        return "Task";
    }

}
