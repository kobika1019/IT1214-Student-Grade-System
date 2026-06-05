import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagement
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do
        {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice)
            {
				 case 1:

				System.out.print("Enter Student ID: ");
				int id = sc.nextInt();

				boolean exists = false;

				for(Student s : students)
				{
					if(s.getStudentId() == id)
					{
						exists = true;
						break;
					}
				}

				if(exists)
				{
					System.out.println("Student ID already exists!");
				}
				else
				{
					sc.nextLine();

					System.out.print("Enter Student Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Marks: ");
					double marks = sc.nextDouble();

					Student student = new Student(id, name, marks);
					students.add(student);

					System.out.println("Student Added Successfully!");
				}

				break;

                case 2:

                    if(students.isEmpty())
                    {
                        System.out.println("No Student Records Found!");
                    }
                    else
                    {
                        System.out.println("\nStudent Records");

                        for(Student s : students)
                        {
                            s.displayStudent();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for(Student s : students)
                    {
                        if(s.getStudentId() == searchId)
                        {
                            System.out.println("\nStudent Found");
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }

                    if(!found)
                    {
                        System.out.println("Student Not Found!");
                    }

                    break;

                case 4:

                    if(students.isEmpty())
                    {
                        System.out.println("No Student Records Available!");
                    }
                    else
                    {
                        double total = 0;

                        for(Student s : students)
                        {
                            total += s.getMarks();
                        }

                        double average = total / students.size();

                        System.out.printf("Average Marks = %.2f\n", average);
                    }

                    break;

                case 5:

                    System.out.println("Program Terminated.");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while(choice != 5);

        sc.close();
    }
}