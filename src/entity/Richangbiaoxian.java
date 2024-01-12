package entity;

import java.io.Serializable;

/**
 * 
 * @TableName richangbiaoxian
 */
public class Richangbiaoxian implements Serializable {
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
    private String info;

    /**
     * 
     */
    private String grade;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Richangbiaoxian() {
    }

    public Richangbiaoxian(Integer id, Integer sid, String time, String info, String grade) {
        this.id = id;
        this.sid = sid;
        this.time = time;
        this.info = info;
        this.grade = grade;
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
    public String getInfo() {
        return info;
    }

    /**
     * 
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 
     */
    public void setGrade(String grade) {
        this.grade = grade;
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
        Richangbiaoxian other = (Richangbiaoxian) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
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
        sb.append(", info=").append(info);
        sb.append(", grade=").append(grade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}