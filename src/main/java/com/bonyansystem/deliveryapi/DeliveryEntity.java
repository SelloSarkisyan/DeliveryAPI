package com.bonyansystem.deliveryapi;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity

@Table(name = "sp_delivery_tab")
public class DeliveryEntity implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int daykey;
    private int delid;
    private int msisdn;
    private int part;
    private int opstat;
    private String status;

    public DeliveryEntity(int id, int daykey, int delid, int msisdn,
                          int part, int opstat, String status) {
        super();
        this.daykey = daykey;
        this.id = id;
        this.delid = delid;
        this.status = status;
        this.msisdn = msisdn;
        this.part = part;

        this.opstat = opstat;
    }

    public DeliveryEntity() {
        super();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDaykey() {
        return daykey;
    }

    public void setDaykey(int daykey) {
        this.daykey = daykey;
    }

    public int getDelid() {
        return delid;
    }

    public void setDelid(int delid) {
        this.delid = delid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public int getOpStat() {
        return opstat;
    }

    public void setOpStat(int opstat) {
        this.opstat = opstat;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }
}