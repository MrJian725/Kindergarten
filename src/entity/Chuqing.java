package entity;

import java.io.Serializable;

/**
 * 
 * @TableName chuqing
 */
public class Chuqing implements Serializable {
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
    private String statue;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Chuqing() {
    }

    public Chuqing(Integer id, Integer sid, String time, String statue) {
        this.id = id;
        this.sid = sid;
        this.time = time;
        this.statue = statue;
    }

    private static final long serialVersionUID = 1L;

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
    public String getStatue() {
        return statue;
    }

    /**
     * 
     */
    public void setStatue(String statue) {
        this.statue = statue;
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
        Chuqing other = (Chuqing) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getStatue() == null ? other.getStatue() == null : this.getStatue().equals(other.getStatue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getStatue() == null) ? 0 : getStatue().hashCode());
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
        sb.append(", statue=").append(statue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}