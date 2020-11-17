import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest
{
    /*Test 1*/
    @Test
    public void addingTaskItemsIncreasesSize()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertEquals(1, tasks.sizeOfTaskList());

        TaskItem data1 = new TaskItem("My second task", "Programming Assignment 5", "2020-11-24", " ");
        tasks.add(data1);

        assertEquals(2, tasks.sizeOfTaskList());
    }

    /*Test 2*/
    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My First Task", "Programming Assignment 3", "2020-11-22", " ");
        tasks.add(data);

        tasks.markingTaskCompleted(0);

        assertEquals("*** ", tasks.getMark(0));
    }

    /*Test 3*/
    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My First Task", "Programming Assignment 3", "2020-11-22", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.markingTaskCompleted(1));

    }

    /*Test 4*/
    @Test
    public void editingTaskItemChangesValues()
    {
        TaskList tasks = new TaskList();

        TaskItem Originaldata = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(Originaldata);

        TaskItem editedData = tasks.tasks.get(0);

        tasks.editTaskTitle("Updated New Task", 0);
        tasks.editTaskDescription("To-do list assignment", 0);
        tasks.editTaskTitle("2020-12-12", 0);

        assertEquals(true, editedData.equals(tasks.tasks.get(0)));
    }

    /*Test 5*/
    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        tasks.editTaskDescription("To-do list assignment", 0);

        assertEquals("To-do list assignment", tasks.getTaskDescription(0));
    }

    /*Test 6*/
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.editTaskDescription("To-do list assignment", 1));
    }

    /*Test 7*/
    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        tasks.editTaskDate("2020-12-12", 0);

        assertEquals("2020-12-12", tasks.getTaskDate(0));
    }

    /*Test 8*/
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.editTaskDate("2020-12-12", 1));
    }

    /*Test 9*/
    @Test
    public void editingTaskItemTitleChangesValue()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        tasks.editTaskTitle("Updated first task", 0);

        assertEquals("Updated first task", tasks.getTaskTitle(0));
    }

    /*Test 10*/
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.editTaskTitle("Updated First task", 1));
    }

    /*Test 11*/
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.getTaskDescription(1));
    }

    /*Test 12*/
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertDoesNotThrow(() -> tasks.getTaskDescription(0));
        assertEquals("Programming Assignment 4", tasks.getTaskDescription(0));
    }

    /*Test 13*/
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.getTaskDate(1));
    }

    /*Test 14*/
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertDoesNotThrow(() -> tasks.getTaskDate(0));
        assertEquals("2020-11-20", tasks.getTaskDate(0));
    }

    /*Test 15*/
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.getTaskTitle(1));
    }

    /*Test 16*/
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My First Task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertDoesNotThrow(() -> tasks.getTaskTitle(0));
        assertEquals("My First Task", tasks.getTaskTitle(0));
    }

    /*Test 17*/
    @Test
    public void newTaskListIsEmpty()
    {
        TaskList tasks = new TaskList();
        assertEquals(true, tasks.ListIsEmpty());
    }

    /*Test 18*/
    @Test
    public void removingTaskItemsDecreasesSize()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertEquals(1, tasks.sizeOfTaskList());

        tasks.remove(data);

        assertEquals(0,tasks.sizeOfTaskList());
    }

    /*Test 19*/
    @Test
    //passing negative value
    public void removeTaskItemsFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        assertThrows(InvalidIndexException.class, () -> tasks.removeTaskItem(-2));
    }

    /*Test 20*/
    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList tasklist = new TaskList();

        tasklist.writeTaskdata("FileCreatedToCheckWhetherSavedTaskListcanBeLoaded.txt");

        assertDoesNotThrow(() -> tasklist.readTasks("FileCreatedToCheckWhetherSavedTaskListcanBeLoaded.txt"));
    }

    /*Test 21*/
    @Test
    public void umcompletingTaskItemChangesStatus()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My First Task", "Programming Assignment 3", "2020-11-22", " ");
        tasks.add(data);

        tasks.unmarkingTaskAsUncompleted(0);

        assertEquals(" ", tasks.getMark(0));
    }

    /*Test 22*/
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My First Task", "Programming Assignment 3", "2020-11-22", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.unmarkingTaskAsUncompleted(1));

    }

    //Added two extra test case
    @Test
    //passing values exceeding the size of the arraylist
    public void removeTaskItemFailsWithInvalidIndexExceedingTheSize()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertThrows(InvalidIndexException.class, () -> tasks.removeTaskItem(1));
    }

    @Test
    public void removeTaskItemSucceedsWithValidTitle()
    {
        TaskList tasks = new TaskList();

        TaskItem data = new TaskItem("My first task", "Programming Assignment 4", "2020-11-20", " ");
        tasks.add(data);

        assertDoesNotThrow(() -> tasks.removeTaskItem(0));
    }

}