package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;

    @BeforeEach
    void setUp() {
        course = new Course("Computer","Diploma", 1006);
    }

    @Test
    void setCourseName() {
        course.setCourseName("Computer");
        assertEquals("Computer", course.getCourseName());
    }

    @Test
    void setFirstNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName(" "));
    }

    @Test
    void setFirstNameInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("Computer123"));
    }

    @Test
    void setFirstNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("123Computer"));
    }

    @Test
    void setCourseType() {
        course.setCourseName("Diploma");
        assertEquals("Diploma", course.getCourseName());
    }

    @Test
    void setCourseTypeInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName(" "));
    }

    @Test
    void setCourseTypeInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("Diploma123"));
    }

    @Test
    void setCourseTypeNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("123Diploma"));
    }
}