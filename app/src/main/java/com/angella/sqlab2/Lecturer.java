package com.angella.sqlab2;

/**
 * Created by HP on 10/20/2017.
 */

public class Lecturer {
    int LecId;
    String LecName;

    public Lecturer() {

    }

    public Lecturer(int LecId, String LecName) {

        this.LecId = LecId;
        this.LecName = LecName;

    }

    public Lecturer(String LecName) {

        this.LecName = LecName;

    }

    // Id
    public int getLecId() {
        return this.LecId;
    }

    public void setLecId(int LecId) {
        this.LecId = LecId;
    }

    // Name
    public String getLecName() {
        return this.LecName;
    }

    public void setLecName(String LecName) {
        this.LecName = LecName;
    }

}
