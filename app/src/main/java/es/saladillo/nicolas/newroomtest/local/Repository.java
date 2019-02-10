package es.saladillo.nicolas.newroomtest.local;

import java.util.List;

import androidx.lifecycle.LiveData;
import es.saladillo.nicolas.newroomtest.base.Resource;
import es.saladillo.nicolas.newroomtest.local.data.model.Student;

public interface Repository {

    LiveData<Student> queryStudent(long studentId);

    LiveData<Student> queryLastStudent();

    LiveData<Resource<Integer>> getStudentCount();

    LiveData<List<Student>> queryStudents();

    LiveData<Resource<Long>> insert(Student student);

    LiveData<Resource<Integer>> update(Student student);

    LiveData<Resource<Integer>> delete(Student student);

}
