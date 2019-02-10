package es.saladillo.nicolas.newroomtest.local;

import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import es.saladillo.nicolas.newroomtest.base.Resource;
import es.saladillo.nicolas.newroomtest.local.data.StudentDAO;
import es.saladillo.nicolas.newroomtest.local.data.model.Student;

class RepositoryImpl implements Repository {

    private StudentDAO studentDAO;

    public RepositoryImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public LiveData<Student> queryStudent(long studentId) {
        return studentDAO.queryStudent(studentId);
    }

    @Override
    public LiveData<Student> queryLastStudent() {
        return studentDAO.queryLastStudent();
    }

    @Override
    public LiveData<Resource<Integer>> getStudentCount() {
        return null;
    }

    @Override
    public LiveData<List<Student>> queryStudents() {
        return null;
    }

    @Override
    public LiveData<Resource<Long>> insert(Student student) {

    }

    @Override
    public LiveData<Resource<Integer>> update(Student student) {
        MutableLiveData<Resource<Integer>> result = new MutableLiveData<>();

        AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> {
            result.postValue(Resource.loading());
            try {
                int updated = studentDAO.update(student);
                result.postValue(Resource.success(updated));
            } catch (Exception e) {
                result.postValue(Resource.error(e));
            }
        });
        return result;
    }

    @Override
    public LiveData<Resource<Integer>> delete(Student student) {
        return null;
    }
}
