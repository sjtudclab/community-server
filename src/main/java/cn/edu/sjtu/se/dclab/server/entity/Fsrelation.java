package cn.edu.sjtu.se.dclab.server.entity;

public class Fsrelation {
    private Integer id;

    private String actp;

    private String passp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActp() {
        return actp;
    }

    public void setActp(String actp) {
        this.actp = actp == null ? null : actp.trim();
    }

    public String getPassp() {
        return passp;
    }

    public void setPassp(String passp) {
        this.passp = passp == null ? null : passp.trim();
    }
}