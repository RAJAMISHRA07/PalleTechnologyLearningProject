package com.example.admin.palletechnologylearningproject;

/**
 * Created by Admin on 12/13/2016.
 */
public class Videos {
    private String sno, vname, vduration;

    public Videos(String sno, String vname, String vduration) {
        this.sno = sno;
        this.vname = vname;
        this.vduration = vduration;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVduration() {
        return vduration;
    }

    public void setVduration(String vduration) {
        this.vduration = vduration;
    }
}


