package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Stephanie","clarke", LocalDate.of(2002,6,17));
    }


    @Test
    void setFirstName() {
        student.setFirstName("Mahir");
        assertEquals("Mahir", student.getFirstName());
    }

    @Test
    void setFirstNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setFirstName(" "));
    }

    @Test
    void setFirstNameInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setFirstName("Mah123"));
    }

    @Test
    void setFirstNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setFirstName("123Mah"));
    }

    @Test
    void setLastName() {
        student.setLastName("Patel");
        assertEquals("Patel", student.getLastName());
    }

    @Test
    void setLastNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setLastName(" "));
    }

    @Test
    void setLastNameInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setLastName("Patel123"));
    }

    @Test
    void setLastNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setLastName("123Patel"));
    }

    @Test
    void setBirthday() {
        student.setBirthday(LocalDate.of(2001,4,17));
        assertEquals(LocalDate.of(2001,4,17), student.getBirthday());
    }

    @Test
    void setInvalidBirthdayFuture() {
        assertThrows(IllegalArgumentException.class, ()->
                student.setBirthday(LocalDate.of(2025,11,19)));
    }

    @Test
    void getAge() {
        assertEquals(18, student.getAge());
    }
}