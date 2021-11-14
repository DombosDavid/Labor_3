package Controller;

import Uni.course;
import Uni.stud;
import Uni.teacher;
import rep.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private final CrudRepository repository;
    public Controller(CrudRepository repository) {
        this.repository = repository;
    }


    public boolean register(stud student,course c)
    {

        if((c.getMaxEnrollment()-c.getNrOfEnrolledStudents())>0){
            if(student.getTotalCredits() + c.getCredits() <= 30) {
                c.addStudent(student);
                student.addCourse(c);
                return true;
            }
        }

        return false;
    }

    public Iterable<course> getAllCourses()
    {
        return  repository.findAll();
    }


    public List<course> retrieveCoursesWithFreePlaces()
    {
        List<course>couresWithAvailabelPlaces=new ArrayList<>();
        for(course course:getAllCourses())
        {
            if(course.getMaxEnrollment()-course.getStudentsEnrolled().size()>0)
            {
                couresWithAvailabelPlaces.add(course);
            }

        }
        return couresWithAvailabelPlaces;

    }

    public List<student> retrieveStudentsEnrolledForACourse(course c)
    {

        return c.getStudentsEnrolled();

    }

    public course deleteCourseByTeacher(course c, teacher teacher)
    {
        List<course>teachersCourses=teacher.getCourses();
        for (course teachersCourse:teachersCourses)
        {

            if (teachersCourse.getCourseID().equals(c.getcourseID()))
            {
                repository.delete(c.getcourseID());

                for (stud student:retrieveStudentsEnrolledForACourse(c))
                {
                    student.setTotalCredits(student.getTotalCredits() - c.getCredits());
                    List<course>updatedList=student.getEnrolledCourses();
                    updatedList.remove(c);
                    student.setEnrolledCourses(updatedList);

                }
                return c;
            }

        }
        return null;

    }

}