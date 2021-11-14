package Uni;

import java.util.List;
public class course {
    private String name;
    private Person teacher;
    private int maxEnrollment;
    private final Long courseID;
    private List<stud>studentsEnrolled;
    private int credits;
    public course (Long courseID,String name,Person teacher,int maxEnrollment,List<stud>studentsEnrolled,int credits)

    {
        this.courseID=courseID;
        this.name=name;
        this.teacher=teacher;
        this.maxEnrollment=maxEnrollment;
        this.studentsEnrolled=studentsEnrolled;
        this.credits=credits;
    }
    public void addStudent(stud newStudent){
        if  (maxEnrollment>studentsEnrolled.size())

        {
            studentsEnrolled.add(newStudent);
        }

    }
    public int getNrOfEnrolledStudents()
    {
        return studentsEnrolled.size();
    }
    public String getName() {
        return name;
    }
    public Person getTeacher() {
        return teacher;
    }
    public List<stud> getStudentsEnrolled() {
        return studentsEnrolled;
    }
    public int getMaxEnrollment() {
        return maxEnrollment;
    }
    public Long getCourseID() {
        return courseID;
    }
    public int getCredits() {
        return credits;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public void setStudentsEnrolled(List<stud> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name +" " +
                ", teacher=" + teacher +
                ", maxEnrollment=" + maxEnrollment +
                ", courseID=" + courseID +
                ", studentsEnrolled=" + studentsEnrolled +
                ", credits=" + credits +
                '}';
    }
}