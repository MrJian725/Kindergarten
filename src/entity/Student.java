package entity;

import java.io.Serializable;

/**
 * 
 * @TableName student
 */
public class Student implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String classname;

    private static final long serialVersionUID = 1L;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age, String classname) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classname = classname;
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
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public String getSex() {
        return sex;
    }

    /**
     * 
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     */
    public String getClassname() {
        return classname;
    }

    /**
     * 
     */
    public void setClassname(String classname) {
        this.classname = classname;
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
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", classname=").append(classname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}