package service;

import model.Course;
import model.Student;

import java.util.*;

public class RegistrationSystem {
    private Map<String, Course> courseMap = new HashMap<>();
    private Map<String, Student> studentMap = new HashMap<>();

    public void addCourse(Course course) {
        courseMap.put(course.getCourseId(), course);
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public String registerStudent(String studentId, String courseId) {
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);
        if (student == null || course == null) return "Invalid student or course ID.";

        if (course.getEnrolledStudents().contains(student)) {
            return "Student already enrolled.";
        }

        if (course.getWaitlist().contains(student)) {
            return "Student already waitlisted.";
        }

        if (course.getEnrolledStudents().size() < course.getCapacity()) {
            course.getEnrolledStudents().add(student);
            return "Student enrolled successfully.";
        } else {
            course.getWaitlist().add(student);
            return "Course full. Student added to waitlist.";
        }
    }

    public String dropStudent(String studentId, String courseId) {
        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);
        if (student == null || course == null) return "Invalid student or course ID.";

        if (course.getEnrolledStudents().remove(student)) {
            // Promote from waitlist only if someone was dropped
            if (!course.getWaitlist().isEmpty()) {
                Student promoted = course.getWaitlist().poll();
                course.getEnrolledStudents().add(promoted);
            }
            return "Student dropped and next from waitlist (if any) promoted.";
        } else if (course.getWaitlist().remove(student)) {
            return "Student removed from waitlist.";
        } else {
            return "Student not found in course.";
        }
    }

    public List<Student> listStudentsInCourse(String courseId) {
        Course course = courseMap.get(courseId);
        if (course == null) return new ArrayList<>();

        List<Student> students = new ArrayList<>(course.getEnrolledStudents());
        students.sort(Comparator.comparing(Student::getName));
        return students;
    }

    public List<Student> listStudentsByBranch(String branch) {
        Set<Student> branchStudents = new HashSet<>();
        for (Course course : courseMap.values()) {
            for (Student student : course.getEnrolledStudents()) {
                if (student.getBranch().equalsIgnoreCase(branch)) {
                    branchStudents.add(student);
                }
            }
        }
        return new ArrayList<>(branchStudents);
    }

    public List<Course> listCoursesByEnrollment() {
        List<Course> courseList = new ArrayList<>(courseMap.values());
        courseList.sort((c1, c2) -> Integer.compare(c2.getEnrolledStudents().size(), c1.getEnrolledStudents().size()));
        return courseList;
    }

    public List<Course> filterCoursesByCredits(int minCredits) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseMap.values()) {
            if (course.getCredits() >= minCredits) {
                result.add(course);
            }
        }
        return result;
    }

    public List<Course> filterCoursesByInstructor(String instructorName) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseMap.values()) {
            if (course.getInstructorName().equalsIgnoreCase(instructorName)) {
                result.add(course);
            }
        }
        return result;
    }
}
