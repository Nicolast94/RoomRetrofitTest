package es.saladillo.nicolas.newroomtest.local.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "age")
    public String age;
    @ColumnInfo(name = "fav_sw_character")
    public String fav_sw_character;

    public Student (long id, String name, String age, String fav_sw_character){
        this.id = id;
        this.name = name;
        this.age = age;
        this.fav_sw_character = fav_sw_character;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFav_sw_character() {
        return fav_sw_character;
    }

    public void setFav_sw_character(String fav_sw_character) {
        this.fav_sw_character = fav_sw_character;
    }
}
