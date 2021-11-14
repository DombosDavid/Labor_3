package Test;

import java.util.ArrayList;

import Uni.course;
import Uni.stud;
import Uni.teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    private ArrayList<stud> studentsList = new ArrayList();
    private ArrayList<course> courseTeacher = new ArrayList();

    @BeforeEach
    void init() {
        this.studentsList = new ArrayList();
        ArrayList<course> studentCourse = new ArrayList();
        stud student1 = new stud("David", "Dombos", 304L, 30,studentCourse);
        stud student2 = new stud("Cosmin", "Neamtiu", 323L, 30,studentCourse);
        this.studentsList.add(student1);
        this.studentsList.add(student2);
    }

    @Test
    void findOne() {
        teacher map = new teacher("Madalina", "Dicu",15L,this.courseTeacher);
        course course = new course(155L, "MAP", map, 10, this.studentsList, 30);
        assertEquals(this.studentsList.get(0), course.findOne(304L));
    }

    @Test
    void findAll() {
        teacher map = new teacher("Madalina", "Dicu",15L,this.courseTeacher);
        course course = new course(155L, "MAP", map, 10, this.studentsList, 30);
        assertEquals(this.studentsList, course.findAll());
    }

    @Test
    void save() {
        ArrayList<course> coursesTest = new ArrayList();
        teacher map = new teacher("Madalina", "Dicu",15L,this.courseTeacher);
        course course = new course(155L, "MAP", map, 10, this.studentsList, 30);
        stud student = new stud( "David", "Dombos", 399L, 30,coursesTest);
        assertEquals((Object)null, course.save(student));
    }

    @Test
    void update() {
        ArrayList<course> studentCourse = new ArrayList();
        teacher map = new teacher("Madalina", "Dicu",15L,this.courseTeacher);
        course course = new course(155L, "MAP", map, 10, this.studentsList, 30);
        stud student = new stud( "David", "Dombos", 399L, 30,coursesTest);
        assertEquals(this.studentsList.get(0), course.update(student));
        assertEquals("Imre", ((Student)this.studentsList.get(0)).getFirstName());
    }
}