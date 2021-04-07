package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    Subject subject;

    @BeforeEach
    void setUp() {
        subject = new Subject("Java", 10001, "Numeric");
    }

    @Test
    void setSubjectName() {
        subject.setSubjectName("Java");
        assertEquals("Java", subject.getSubjectName());
    }

    @Test
    void setSubjectNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                subject.setSubjectName(" "));
    }

    @Test
    void setSubjectNameInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                subject.setSubjectName("Java123"));
    }

    @Test
    void setSubjectNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                subject.setSubjectName("123Java"));
    }

    @Test
    void setGradeType() {
        subject.setGradeType("Numeric");
        assertEquals("Numeric", subject.getGradeType());
    }

    @Test
    void setGradeTypeInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                subject.setGradeType(" "));
    }

    @Test
    void setGradeTypeInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                subject.setGradeType("Numeric123"));
    }

    @Test
    void setGradeTypeInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                subject.setGradeType("123Numeric"));
    }
}