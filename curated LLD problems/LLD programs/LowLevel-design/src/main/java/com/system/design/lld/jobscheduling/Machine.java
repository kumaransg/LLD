package com.system.design.lld.jobscheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Machine<T> {
//    public final AtomicInteger cpu, ram, core;  // available cpu/ram
//    public final int cfgCPU, cfgRAM, cfgCore;// default configured CPU/RAM
    private final ExecutorService executor = Executors.newCachedThreadPool();

//    public Machine(int cpu, int ram, int core) {
//        this.cpu = new AtomicInteger(this.cfgCPU = cpu);
//        this.ram = new AtomicInteger(this.cfgRAM = ram);
//        this.core = new AtomicInteger(this.cfgCore = core);
//    }
//
//    public Future<T> submit(final Task task) {
//        if (this.cpu.get() < task.cpu || this.ram.get() < task.ram) {
//            throw new RuntimeException("Not enough resource");
//        }
//        this.cpu.set(this.cpu.get() - task.cpu);
//        this.ram.set(this.ram.get() - task.ram);
//        this.core.getAndDecrement();
//        return executor.submit(() -> {
////            T res = task.call();
//            this.cpu.set(this.cpu.get() + task.cpu);
//            this.ram.set(this.ram.get() + task.ram);
//            this.core.incrementAndGet();
////            return res;
//        });
//    }
}
