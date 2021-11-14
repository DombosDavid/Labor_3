package Uni;


import java.util.List;
import java.util.Objects;

public class stud extends Person {
    private Long studentID;
    private int totalCredits;
    private List<course>enrolledCourses;

    public stud (String firstname,String name ,Long studentID,int totalCredits,List<course>enrolledCourses)
    {
        super.setLastName(name);
        super.setFirstName(firstname);
        this.studentID=studentID;
        this.totalCredits=totalCredits;
        this.enrolledCourses=enrolledCourses;
    }
    public void addCourse(course newCourse)
    {
        enrolledCourses.add(newCourse);
        int newTotalCredits=totalCredits+newCourse.getCredits();
        setTotalCredits(newTotalCredits);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stud student = (stud) o;
        return totalCredits == student.totalCredits && Objects.equals(studentID, student.studentID) && Objects.equals(enrolledCourses, student.enrolledCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, totalCredits, enrolledCourses);
    }
    public Long getStudentID() {
        return studentID;
    }
    public int getTotalCredits() {
        return totalCredits;
    }
    public List<course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }
    public void setEnrolledCourses(List<course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }
    @Override
    public String toString() {
        return "Student{" +super.toString()+
                "studentID=" + studentID +
                ", totalCredits=" + totalCredits +
                '}';
    }
}