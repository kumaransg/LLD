package com.swiggy.order.stateslamonitor.jobs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public abstract class BaseJob extends QuartzJobBean {

    protected static final Logger LOG = LoggerFactory.getLogger("SFP-JOB");

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getDescription();
        String runId = context.getFireInstanceId();
        Date thisFireTime = context.getFireTime();
        Date prvFireTime = context.getPreviousFireTime();
        Date nextFireTime = context.getNextFireTime();
        boolean recovering = context.isRecovering();
        boolean error = false;
        long st = System.currentTimeMillis();
        try {
            LOG.info("[jobName={}] [RUNID={}] [START] [RECOVER={}] [CFT={}] [PFT={}]", jobName, runId, recovering, logDate(thisFireTime), logDate(prvFireTime));
            executeJob(context.getMergedJobDataMap().getWrappedMap());
        } catch (Throwable t) {
            error = true;
            LOG.error("Exception in base Job execute Job Internal - {}", t);
        } finally {
            LOG.info("[{jobName}] [RUNID={}] [END] [RECOVER={}] [SUCCESS={}] [CFT={}] [PFT={}] [NFT={}] [ET={}sec]", jobName, runId, recovering, error, logDate(thisFireTime),
                    logDate(prvFireTime), logDate(nextFireTime), time(st));
        }
    }

    private long time(long st) {
        long t = System.currentTimeMillis() - st;
        return t;
    }

    private String logDate(Date date) {
        try {
            DateFormat df = new SimpleDateFormat("k:mm:s");
            return df.format(date);
        } catch (Exception e) {
            LOG.error("Exception whil converting date to particular format - {}", date);
            return "";
        }
    }

    protected abstract void executeJob(Map<String, Object> data) throws Exception;
}
