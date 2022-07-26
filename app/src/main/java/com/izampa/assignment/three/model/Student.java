package com.izampa.assignment.three.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private String studentEmail;
    private String studentFirstName;
    private String studentLastName;
    private String studentProgram;
    private Long studentRegNumber;
    private Long studentYearOfStudy;

    public Student(String stdEmail,
                   String stdFirstName,
                   String stdLastName,
                   String stdProgram,
                   Long stdRegNumber, Long stdYearOfStudy) {
        studentEmail = stdEmail;
        studentFirstName = stdFirstName;
        studentLastName = stdLastName;
        studentProgram = stdProgram;
        studentRegNumber = stdRegNumber;
        studentYearOfStudy = stdYearOfStudy;
    }

    protected Student(Parcel in) {
        studentEmail = in.readString();
        studentFirstName = in.readString();
        studentLastName = in.readString();
        studentProgram = in.readString();
        if (in.readByte() == 0) {
            studentRegNumber = null;
        } else {
            studentRegNumber = in.readLong();
        }
        if (in.readByte() == 0) {
            studentYearOfStudy = null;
        } else {
            studentYearOfStudy = in.readLong();
        }
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentProgram() {
        return studentProgram;
    }

    public void setStudentProgram(String studentProgram) {
        this.studentProgram = studentProgram;
    }

    public Long getStudentRegNumber() {
        return studentRegNumber;
    }

    public void setStudentRegNumber(Long studentRegNumber) {
        this.studentRegNumber = studentRegNumber;
    }

    public Long getStudentYearOfStudy() {
        return studentYearOfStudy;
    }

    public void setStudentYearOfStudy(Long studentYearOfStudy) {
        this.studentYearOfStudy = studentYearOfStudy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(studentEmail);
        parcel.writeString(studentFirstName);
        parcel.writeString(studentLastName);
        parcel.writeString(studentProgram);
        if (studentRegNumber == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(studentRegNumber);
        }
        if (studentYearOfStudy == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(studentYearOfStudy);
        }
    }
}
