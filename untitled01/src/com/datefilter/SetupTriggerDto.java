package com.datefilter;

import java.io.Serializable;
import java.util.Date;

public class SetupTriggerDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String triggerName;
    private Date prevRun;
    private Date nextRun;

    public SetupTriggerDto(String triggerName, Date prevRun, Date nextRun) {
        this.triggerName = triggerName;
        this.prevRun = prevRun;
        this.nextRun = nextRun;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public Date getPrevRun() {
        return prevRun;
    }

    public void setPrevRun(Date prevRun) {
        this.prevRun = prevRun;
    }

    public Date getNextRun() {
        return nextRun;
    }

    public void setNextRun(Date nextRun) {
        this.nextRun = nextRun;
    }

    @Override
    public String toString() {
        return "SetupTriggerDto{" +
                "triggerName='" + triggerName + '\'' +
                ", prevRun=" + prevRun +
                '}';
    }
}

