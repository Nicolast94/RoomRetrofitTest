package es.saladillo.nicolas.newroomtest.local.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Query;
import es.saladillo.nicolas.newroomtest.base.BaseDao;
import es.saladillo.nicolas.newroomtest.local.data.model.Student;

public interface StudentDAO extends BaseDao<Student> {

    @Query("SELECT * FROM Student WHERE id = :studentId")
    LiveData<Student> queryStudent(long studentId);

    @Query("SELECT * FROM Student ORDER BY id DESC LIMIT 1")
    LiveData<Student> queryLastStudent();

    @Query("SELECT COUNT(*) FROM student")
    int getStudentCount();

    @Query("SELECT * FROM Student ORDER BY name")
    LiveData<List<Student>> queryStudents();



}
