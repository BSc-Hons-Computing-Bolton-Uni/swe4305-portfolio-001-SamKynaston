package Objects;

import Core.Main;
import Core.Repository;
import Interfaces.ExtendedT;

import java.util.ArrayList;

public class Student implements ExtendedT {
    private static int nextID = 1000;
    private int ID;
    private boolean IsIDSet = false;

    private String Forename;
    private String Surname;

    private final ArrayList<Course> Courses;
    private final ArrayList<Mark> Marks;

    public Student() {
        System.out.println("Student Created.");

        SetID(nextID++);

        this.Courses = new ArrayList<Course>();
        this.Marks = new ArrayList<Mark>();

        // Add to the main Students ArrayList
        Repository.AddStudent(this);
    }

    // Set Functions
    public boolean SetID(int ID) {
        if (this.IsIDSet) { return false; } // If the student's ID has already been set, then ignore by returning false

        this.ID = ID; // Set the ID
        this.IsIDSet = true; // Set the IsIDSet flag to true

        return true; // Return true to signify completion
    }

    public void SetForename(String forename) {
        this.Forename = forename; // Set the student's forename
    }

    public void SetSurname(String surname) {
        this.Surname = surname; // Set the student's surname
    }

    public int GetID() {
        return this.ID; // Get the student's ID and return it
    }

    public String GetForename() {
        return this.Forename; // Get the student's forename and return it
    }

    public String GetSurname() {
        return this.Surname; // Get the student's surname and return it
    }

    public ArrayList<Mark> GetMarks() {
        return this.Marks;
    }

    public boolean AddMark(Mark mark) {
        if (GetMarks().contains(mark)) { return false; } // If the student already has a mark that matches the input, then return false
        if (mark.GetStudent() != this) { return false; }

        this.Marks.add(mark);

        return true;
    }

    public boolean RemoveMark(Mark mark) {
        if (GetMarks().contains(mark)) { return false; } // If the student already has a mark that matches the input, then return false
        if (mark.GetStudent() != this) { return false; }

        this.Marks.remove(mark);
        mark.GetModule().RemoveMark(this);

        return true;
    }

    public boolean AddCourse(Course course) {
        if (GetCourses().contains(course)) { return false; } // If the student is already a member of the provided course, then return false and close the function

        this.Courses.add(course); // Add the course to the student's course list
        course.AddStudent(this);

        return true; // Return true to signify completion
    }

    public boolean RemoveCourse(Course course) {
        if (!this.Courses.contains(course)) { return false; } // If the course doesn't exist in the student's courses or has already been removed, then return false and close the function

        this.Courses.remove(course); // Remove the course
        course.RemoveStudent(this);

        return true; // Return true to signify completion
    }

    public ArrayList<Course> GetCourses() {
        return this.Courses;
    }

    public String Print() {
        return GetForename() + " " + GetSurname() + " (" + GetID() + ")";
    }
}
