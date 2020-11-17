import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList
{
    //creating an arraylist of task item objects
    ArrayList<TaskItem> tasks;

    //constructor
    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    //adding the task item data to the list of tasks
    public void add(TaskItem data)
    {
        tasks.add(data);
    }

    //getting the size of the tasks
    public int sizeOfTaskList()
    {
        return tasks.size();
    }

    //checking whether the list is empty
    public boolean ListIsEmpty()
    {
        return tasks.isEmpty();
    }

    //removing a task item from the list of tasks
    public void remove(TaskItem data)
    {
        tasks.remove(data);
    }

    //checking whether the index is valid
    public boolean indexIsValid(int userIndex)
    {
        return (userIndex >= 0 && userIndex < tasks.size());
    }

    /* OPTION1: VIEW THE LIST*/

    //displaying the current tasks
    public void displayCurrentTasks()
    {
        System.out.println("Current Tasks");
        System.out.println("--------------");
        for (int i = 0; i < tasks.size(); i++)
        {
            TaskItem data = tasks.get(i);

            if((data.getCompletionStatus() == " "))
            {
                System.out.format("%d) [%s] %s: %s %n", i, data.getDate(), data.getTitle(), data.getDescription());
            }
            if(data.getCompletionStatus() != " ")
            {
                System.out.format("%d) %s [%s] %s: %s %n", i,data.getCompletionStatus(), data.getDate(), data.getTitle(), data.getDescription());
            }

        }
    }

    /*OPTION3: EDIT AN ITEM*/

    public void editTaskTitle(String title, int userIndex)
    {
        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            data.setTitle(title);
        }
        else throw new InvalidIndexException("Index is Invalid");
    }

    public void editTaskDescription(String description, int userIndex)
    {
        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            data.setDescription(description);
        }
        else throw new InvalidIndexException("Index is Invalid");
    }

    public void editTaskDate(String date, int userIndex)
    {
        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            data.setDate(date);
        }
        else throw new InvalidIndexException("Index is Invalid");
    }

    /*OPTION 4: REMOVE AN ITEM*/

    //checking whether the index is valid and performing the remove operation
    public void removeTaskItem(int userIndex)
    {
        if(indexIsValid(userIndex) && (!ListIsEmpty()))
        {
            remove(tasks.get(userIndex));
        }
        else throw new InvalidIndexException("Index is not valid");
    }

    /*OPTION5: MARK AN ITEM AS COMPLETED*/

    //displaying the uncompleted tasks
    public void displayUncompletedTasks()
    {
        System.out.println("Uncompleted Tasks\n");
        System.out.println("-----------------");
        for (int i = 0; i < tasks.size(); i++)
        {
            TaskItem data = tasks.get(i);

            if (data.getCompletionStatus() == " ")
            {
                System.out.format("%d) [%s] %s: %s %n", i, data.getDate(), data.getTitle(), data.getDescription());
            }
        }
    }

    public void markingTaskCompleted(int userIndex)
    {
        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            data.setCompletionStatus("*** ");
        }
        else throw new InvalidIndexException("Index is Invalid");
    }

    /*OPTION 6: UNMARK AN ITEM AS COMPLETED*/

    //displaying the completed tasks
    public void displayCompletedTasks()
    {
        System.out.println("Completed Tasks\n");
        System.out.println("-----------------");
        for (int i = 0; i < tasks.size(); i++)
        {
            TaskItem data = tasks.get(i);

            if (data.getCompletionStatus() !=  " ")
            {
                System.out.format("%d) [%s] %s: %s %n", i, data.getDate(), data.getTitle(), data.getDescription());
            }
        }
    }

    public void unmarkingTaskAsUncompleted(int userIndex)
    {
        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            data.setCompletionStatus(" ");
        }
        else throw new InvalidIndexException("Index is Invalid");
    }

    /*OPTION 7: SAVE THE LIST*/

    public void writeTaskdata(String fileName)
    {
        while(true)
        {
            try(Formatter output = new Formatter(fileName))
            {
                for (int i = 0; i < tasks.size(); i++)
                {
                    TaskItem data = tasks.get(i);

                    output.format("%s %s %s %s %n",data.getTitle(),data.getDescription(), data.getDate(), data.getCompletionStatus());
                }
                break;
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("Warning: Unable to find the file. Please try again");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void readTasks(String fileName)
    {
        try
        {
            File input = new File(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine())
            {
                String taskData = scanner.nextLine();
                String[] values = taskData.split(" ");

                String statusOfCompletion;

                if(values.length <= 3)
                {
                    statusOfCompletion = " ";
                }
                else {
                    statusOfCompletion = values[3];
                }

                TaskItem task = new TaskItem(values[0], values[1], values[2], statusOfCompletion);
                tasks.add(task);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Warning: Unable to find the file. Please try again");
        }
    }

    //getting task title of particular index
    public String getTaskTitle(int userIndex)
    {
        String title = "";

        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            if(!(data.getTitle().isEmpty()))
            {
                title = data.getTitle();
            }
        }
        else throw new InvalidIndexException("Index is Invalid");
        return title;
    }

    //getting task description of particular index
    public String getTaskDescription(int userIndex)
    {
        String description = "";

        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            if(!(data.getDescription().isEmpty()))
            {
                description = data.getDescription();
            }
            return description;
        }
        else throw new InvalidIndexException("Index is Invalid");

    }

    //getting task date of particular index
    public String getTaskDate(int userIndex)
    {
        String date = "";

        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            if(!(data.getDate().isEmpty()))
            {
                date = data.getDate();
            }
        }
        else throw new InvalidIndexException("Index is Invalid");
        return date;
    }

    //getting the completionStatus of particular index
    public String getMark(int userIndex)
    {
        String completionMark;

        if(indexIsValid(userIndex))
        {
            TaskItem data = tasks.get(userIndex);

            completionMark = data.getCompletionStatus();
            return completionMark;
        }
        else throw new InvalidIndexException("Index is Invalid");

    }
}

class InvalidIndexException extends IndexOutOfBoundsException
{
    public InvalidIndexException(String msg)
    {
        super(msg);
    }

}


