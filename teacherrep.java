package rep;

import Uni.teacher;

import java.util.ArrayList;
import java.util.List;
public class teacherrep implements CrudRepository<teacher> {
    private List<teacher> teacherList=new ArrayList<teacher>();
    @Override
    public teacher findOne(Long teacherID)
    {

        for(teacher Teacher:teacherList){
            if (Teacher.getTeacherID().equals(teacherID))
                return Teacher;
        }
        return null;
    }
    @Override
    public Iterable<teacher> findAll()
    {
        return teacherList;
    }
    @Override
    public teacher save(teacher newTeacher)
    {
        for (teacher Teacher:teacherList)
        {
            if(Teacher.equals(newTeacher))
                return Teacher;
        }
        teacherList.add(newTeacher);
        return null;
    }

    @Override
    public teacher delete(Long id)
    {
        teacher Teacher=findOne(id);
        if (Teacher!= null)
        {
            teacherList.remove(Teacher);
            return Teacher;
        }
        return null;
    }

    @Override
    public teacher update (teacher newTeacher)
    {
        for(teacher Teacher:teacherList)
        {
            if (Teacher.getTeacherID().equals(newTeacher.getTeacherID()))
            {
                teacherList.remove(Teacher);
                teacherList.add(newTeacher);
                return null;
            }
        }
        return newTeacher;
    }


}