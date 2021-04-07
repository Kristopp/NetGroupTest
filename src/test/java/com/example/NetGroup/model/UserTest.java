package com.example.NetGroup.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testConstructor() {
        User actualUser = new User("janedoe", "jane.doe@example.org", "iloveyou");
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("janedoe", actualUser.getName());
        System.out.println(actualUser);
    }

    @Test
    public void testGetId() {
        assertEquals(123L, (new User("janedoe", "jane.doe@example.org", "iloveyou")).getId(123L).longValue());
    }

    @Test
    public void testSetName() {
        User user = new User("janedoe", "jane.doe@example.org", "iloveyou");
        user.setName("foo");
        assertEquals("janedoe", user.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("jane.doe@example.org", (new User("janedoe", "jane.doe@example.org", "iloveyou")).getEmail());
    }

    @Test
    public void testSetEmail() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        (new User("janedoe", "jane.doe@example.org", "iloveyou")).setEmail("foo");
    }

    @Test
    public void testSetCreatedAt() {
        User user = new User("janedoe", "jane.doe@example.org", "iloveyou");
        user.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        assertEquals("Users{ id=null, name janedoe', password iloveyou', created_at 0001-01-01T01:01', adminfalse'}",
                user.toString());
    }

    @Test
    public void testSetPassword() {
        User user = new User("janedoe", "jane.doe@example.org", "iloveyou");
        user.setPassword("Encode");
        assertEquals("iloveyou", user.getPassword());
    }

    @Test
    public void testSetAdmin() {
        User user = new User("janedoe", "jane.doe@example.org", "iloveyou");
        user.setAdmin();
        assertFalse(user.getAdmin());
    }

    @Test
    public void testToString() {
        assertEquals("Users{ id=null, name janedoe', password iloveyou', created_at null', adminfalse'}",
                (new User("janedoe", "jane.doe@example.org", "iloveyou")).toString());
    }
}

