package com.example.saakshi.mystocks;

/**
 * Created by navendu on 8/10/17.
 */

public class flight {
    int id;
    int fid;
    String source;
    String destination;
    String stime;
    String dtime;

    public flight(int id,int fid, String source, String destination, String stime, String dtime) {
        this.id=id;
        this.fid = fid;
        this.source = source;
        this.destination = destination;
        this.stime = stime;
        this.dtime = dtime;
    }

    public int getFid() {
        return fid;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getStime() {
        return stime;
    }

    public String getDtime() {
        return dtime;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }
}
