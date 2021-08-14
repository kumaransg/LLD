package com.system.design.lld.jobscheduling;

import lombok.Builder;
import lombok.Data;
import sun.reflect.generics.tree.Tree;

import javax.crypto.Mac;
import java.util.TreeSet;
import java.util.concurrent.Future;
// https://leetcode.com/discuss/interview-question/system-design/431023/Google-or-Onsite-or-Get-all-logs-between-times
@Data
@Builder
public class Scheduler<T> {
//        final TreeSet<Machine> machinePool = new TreeSet<>((a, b) ->
//                a.cpu != b.cpu ? a.cpu.get() - b.cpu.get() :
//                        (a.ram != b.ram ? a.ram.get() - b.ram.get() : a.core.get() - b.core.get()));
//
//    public Future<T> submit(Task task) {
//        Machine required = new Machine(task.cpu, task.ram, 1);
//        Machine found = machinePool.ceiling(required);
//        if (found == null) throw new RuntimeException("All machine busy");
//        Future<T> future = found.submit(task);
//        machinePool.remove(found);
//        machinePool.add(found);    // reorder
//        return future;
//    }
//    public void addMachine( Machine machine) {
//        machinePool.add( machine);
//    }
}
