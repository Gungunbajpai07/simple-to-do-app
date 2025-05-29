import java.util.ArrayList;
import java.util.Scanner;

class ToDoApp
{ 
  public static void main(String args[])
  {
      Scanner sc= new Scanner(System.in);
      ArrayList<Task>tasks=new ArrayList<>();//tasks is a list of Task objects
      while(true)
      {
          System.out.println("/n===TO-D0 MENU===");
          System.out.println("1,ADD TASK");
          System.out.println("2,VIEW TASK");
          System.out.println("3,MARK TASK AS DONE");
          System.out.println("4,DELETE TASK");
          System.out.println("5,EXIT");
          System.out.println("CHOOSE AN OPTION");
          int ch=sc.nextInt();
              sc.nextLine();// clears the input buffer
         switch(ch)
         {
             case 1:
                 System.out.println("enter task description");
                 String desc=sc.nextLine();
                 tasks.add(new Task(desc));//SYNTAX:-list.add(item);
                 System.out.println("task added");
                 break;
             case 2:
                 System.out.println("/n---YOUR TASKS---");
                 for(int i=0;i<tasks.size();i++)
                 {
                     Task t= tasks.get(i);
                     String status = t.isDone ?"✅":"❌";
                     System.out.println((i+1)+"."+t.des+"["+status+"]");
                 }
                 break;
             case 3:
                 System.out.print("enter the task number to be mark as done");
                 int done=sc.nextInt();
                 done=done-1;
                 if(done>=0&&done<tasks.size())
                 {
                     tasks.get(done).isDone=true;
                     System.out.println("Task marked as done");
                 }
                 else
                 {
                   System.out.println("INVALID TASK NUMBER"); 
                 }
                 break;
             case 4:
                  System.out.println("ENTER THE TASK NUMBER TO DELETE:"); 
                  int del=sc.nextInt();
                  del=del-1;
                  if(del>=0&&del<tasks.size())
                  {
                      tasks.remove(del);
                      System.out.println("task deleted"); 
                  }
                  else
                  {
                      System.out.println("INVALID TASK NUMBER");
                  }
                  break;
             case 5:
                  System.out.println("you chose to exit!!");
                  return;
             default:
                   System.out.println("INVALID CHOICE"); 
         }
      }  
  }
}
 class Task
{ 
    String des;
    boolean isDone;
    Task(String des) //constructor to create a new task with description
    {
        this.des=des;
        this.isDone=false; //task is not done at first
    }
    void markDone()// method to mark task as done
    {
        isDone=true;
    }
    public String toString()//when we print the task,show like:-[✅] Task name
    {
      return(isDone ? "[✅]" : "[]")+des;  
    }
}   

