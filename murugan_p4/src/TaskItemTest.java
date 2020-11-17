import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest
{
    /*Test 1*/
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("My First Task", "Programming Assignment 4", "01-02-2020", " "));
    }

    /*Test 2*/
    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "Programming Assignment 4", "2020-11-20", " "));
    }

    /*Test 3*/
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(() -> new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " "));
    }

    /*Test 4*/
    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " "));
    }

    /*Test 5*/
    @Test
    public void settingTaskItemDueDateFailsWithInValidDate()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");

        assertThrows(InvalidDateException.class, () -> data.setDate(""));
    }

    /*Task 6*/
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");

        assertDoesNotThrow(() -> data.setDate("2020-11-22"));
    }

    /*Task 7*/
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");

        assertThrows(InvalidTitleException.class, () -> data.setTitle(""));
    }

    /*Task 8*/
    @Test
    public void settingTaskItemTitleSucceedsWithValidtitle()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");

        assertDoesNotThrow(() -> data.setTitle("My First Task"));
    }

    /*ADDED SIX NEW TEST CASES*/

    @Test
    public void creatingTaskItemFailsWithInvalidDueDateWrongFormat()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("My First Task", "Programming Assignment 4", "01-02-2020", " "));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDateNoInput()
    {
        assertThrows(InvalidDateException.class, () -> new TaskItem("My First Task", "Programming Assignment 4", " ", " "));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitleUsingAssertEquals() throws InvalidTitleException
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");
        try
        {
            data.setTitle("");
        }
        catch(InvalidTitleException e)
        {
            assertNotEquals("", data.getTitle());
        }
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitleUsingAssertEquals()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");
        data.setTitle("Updated first task");
        assertEquals("Updated first task", data.getTitle());

    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDateUsingAssertEquals()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");

        try
        {
            data.setDate(" ");
        }
        catch(InvalidDateException e)
        {
            assertEquals("2020-11-20", data.getDate());
        }
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDateUsingAssertEquals()
    {
        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");
        data.setDate("2020-12-24");
        assertEquals("2020-12-24", data.getDate());
    }
}