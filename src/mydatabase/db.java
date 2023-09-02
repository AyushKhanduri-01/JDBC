package mydatabase;

import java.sql.SQLException;
import java.util.Scanner;

public class db {
    public static void main(String arg[]) throws SQLException {
        CreateConnection createconnection = new CreateConnection();

        int opt;
        while (true) {
            System.out.println("----------------------------------------------------------");
            System.out.println("\t\t1. FOR INSERT\n\t\t2. FOR READ\n\t\t3. FOR UPDATE\n\t\t4. FOR DELETE\n\t\t5. FOR EXIT");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();
            if (opt == 1) {
                System.out.println("Enter Student_Id, Name , Course :-");
                int id = sc.nextInt();
                String name = sc.next();
                String course = sc.next();
                DbOperation data = new DbOperation();
                data.insertData(id, name, course);
            }

            if(opt == 2){
                 DbOperation data = new DbOperation();
                 data.readData();
            }

            if(opt==3){
                System.out.println("Enter old id  and new values(id,name,course)");
                int oid,nid;
                String name,course;
                oid=sc.nextInt();
                nid=sc.nextInt();
                name=sc.next();
                course=sc.next();
                DbOperation data = new DbOperation();
                data.updateData(oid,nid,name,course);
            }

            if(opt == 4){
                System.out.println("Enter Student id to delete :-");
                int id=sc.nextInt();
                DbOperation data=new DbOperation();
                data.deleteData(id);
            }
            if(opt == 5){
                DbOperation data=new DbOperation();
                data.closeConnection();
                return;
            }

        }

    }
}
