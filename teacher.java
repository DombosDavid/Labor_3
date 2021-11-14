package Uni;

import java.util.List;

public class teacher extends Person {
    public List<course>courses;
    private Long teacherID;

    public teacher (String firstName,String name,Long teacherID,List<course>courses)
    {
        super.setFirstName(firstName);
        super.setLastName(name);
        this.teacherID=teacherID;
        this.courses=courses;
    }
    public List<course> getCourses() {
        return courses;
    }
    public void setCourses(List<course> courses) {
        this.courses = courses;
    }

    public Long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Long teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Teacher{"+ super.toString() +
                ", teacherID=" + teacherID +
                '}';
    }
}