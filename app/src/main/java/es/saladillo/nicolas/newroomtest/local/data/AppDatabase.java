package es.saladillo.nicolas.newroomtest.local.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import es.saladillo.nicolas.newroomtest.local.data.model.Student;

@Database(entities = {Student.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDAO studentDAO();

    private static final String DATABASE_NAME = "database-name";

    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance =
                            Room.databaseBuilder(
                                    context.getApplicationContext(), AppDatabase.class,
                                    DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }
}
