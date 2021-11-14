package Test;

import java.util.ArrayList;

import Uni.stud;
import Uni.course;
import Uni.teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudTest
{
    private ArrayList<course> coursesTest = new ArrayList();
    private ArrayList<course> teacherCourses = new ArrayList();


    @BeforeEach
    void init()
    {
        this.coursesTest = new ArrayList();
        ArrayList<stud> studentsList = new ArrayList();
        ArrayList<course> teacherCourses = new ArrayList();
        teacher map = new teacher("Madalina", "Dicu",15L,this.teacherCourses);
        course course2 = new course(155L, "MAP", map, 10, studentsList, 124L);
        this.coursesTest.add(map);
        this.coursesTest.add(course2);
    }

    @Test
    void findOne()
    {
        stud student1 = new stud("David", "Dombos", 304L, 30,this.coursesTest);
        assertEquals(this.coursesTest.get(1), student1.findOne(124L));
    }
    @Test
    void findAll()
    {
        stud student1 = new stud("David", "Dombos", 304L, 30,this.coursesTest);
        assertEquals(this.coursesTest, student.getEnrolledCourses());
    }
}