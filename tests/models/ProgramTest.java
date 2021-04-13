package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    Program program;

    @BeforeEach
    void setUp() {
        program = new Program("Civil","Diploma", 12);
    }

    @Test
    void setProgramName() {
        program.setProgramName("Civil");
        assertEquals("Civil", program.getProgramName());
    }

    @Test
    void setProgramNameInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                program.setProgramName(" "));
    }

    @Test
    void setProgramNameInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                program.setProgramName("Civil123"));
    }

    @Test
    void setProgramNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                program.setProgramName("123Civil"));
    }

    @Test
    void setProgramType() {
        program.setProgramType("Diploma");
        assertEquals("Diploma", program.getProgramType());
    }

    @Test
    void setProgramTypeInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                program.setProgramType(" "));
    }

    @Test
    void setProgramTypeInvalidNumbersEnd() {
        assertThrows(IllegalArgumentException.class, ()->
                program.setProgramType("Diploma123"));
    }

    @Test
    void setProgramTypeNameInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                program.setProgramType("123Diploma"));
    }
}