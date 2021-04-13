package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;

    @BeforeEach
    void setUp() {
        course = new Course("Java", 1006);
    }

    @Test
    void setCourseName() {
        course.setCourseName("Java");
        assertEquals("Java", course.getCourseName());
    }

    @Test
    void setCourseNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName(" "));
    }

    @Test
    void setCourseNameInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("Java123"));
    }

    @Test
    void setCourseNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("123Java"));
    }
}