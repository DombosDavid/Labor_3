package rep;

import Uni.course;

import java.util.ArrayList;
import java.util.List;

public class courserep implements CrudRepository<course> {

    private final List<course> courseList=new ArrayList<>();
    @Override
    public course findOne(Long courseID)
    {

        for(course course:courseList){
            if (course.getCourseID().equals(courseID))
                return course;
        }
        return null;
    }
    @Override
    public Iterable<course> findAll()
    {
        return courseList;
    }
    @Override
    public course save(course newCourse)
    {
        for (course course:courseList)
        {
            if (findOne(newCourse.getCourseID())!=null)
            {
                return newCourse;
            }
        }
        courseList.add(newCourse);
        return null;
    }
    @Override
    public course delete(Long id)
    {
        course course=findOne(id);
        if (course!= null)
        {
            courseList.remove(course);
            return course;
        }
        return null;
    }
    @Override
    public course update (course newCourse)
    {
        for(course course:courseList)
        {
            if (course.getCourseID().equals(newCourse.getCourseID()))
            {
                courseList.remove(course);
                courseList.add(newCourse);
                return null;
            }
        }
        return newCourse;
    }
}
