package entity;

import java.io.Serializable;

/**
 * 
 * @TableName tijian
 */
public class Tijian implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer sid;

    /**
     * 
     */
    private String time;

    /**
     * 
     */
    private String height;

    /**
     * 
     */
    private String width;

    /**
     * 
     */
    private String eent;

    /**
     * 
     */
    private String other;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private static final long serialVersionUID = 1L;


    public Tijian() {
    }

    public Tijian(Integer id, Integer sid, String time, String height, String width, String eent, String other) {
        this.id = id;
        this.sid = sid;
        this.time = time;
        this.height = height;
        this.width = width;
        this.eent = eent;
        this.other = other;
    }

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * 
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * 
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     */
    public String getHeight() {
        return height;
    }

    /**
     * 
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 
     */
    public String getWidth() {
        return width;
    }

    /**
     * 
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 
     */
    public String getEent() {
        return eent;
    }

    /**
     * 
     */
    public void setEent(String eent) {
        this.eent = eent;
    }

    /**
     * 
     */
    public String getOther() {
        return other;
    }

    /**
     * 
     */
    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Tijian other = (Tijian) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getEent() == null ? other.getEent() == null : this.getEent().equals(other.getEent()))
            && (this.getOther() == null ? other.getOther() == null : this.getOther().equals(other.getOther()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getEent() == null) ? 0 : getEent().hashCode());
        result = prime * result + ((getOther() == null) ? 0 : getOther().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sid=").append(sid);
        sb.append(", time=").append(time);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", eent=").append(eent);
        sb.append(", other=").append(other);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}