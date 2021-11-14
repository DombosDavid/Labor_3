package rep;

import Uni.stud;

import java.util.ArrayList;
import java.util.List;

public class studrep implements CrudRepository<stud> {
    private final List<stud> studentList=new ArrayList<>();
    @Override
    public stud findOne(Long studentID)
    {

        for(stud student:studentList){
            if (student.getStudentID().equals(studentID))
                return student;
        }
        return null;
    }
    @Override
    public Iterable<stud> findAll()
    {
        return studentList;
    }
    @Override
    public stud save(stud newStudent)
    {
        for (stud student:studentList)
        {
            if(student.equals(newStudent))
                return student;
        }
        studentList.add(newStudent);
        return null;
    }
    @Override
    public stud delete(Long id)
    {
        stud student=findOne(id);
        if (student!= null)
        {
            studentList.remove(student);
            return student;
        }
        return null;
    }
    @Override
    public stud update (stud newStudent)
    {
        for(stud student:studentList)
        {
            if (student.getStudentID().equals(newStudent.getStudentID()))
            {
                student=newStudent;
                return null;
            }
        }
        return newStudent;
    }
}