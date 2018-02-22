import java.io.*;

public class TestObjectsInFile {
        public static void main(String[] args) throws Exception {
                FileInputStream fis = new FileInputStream("students.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                Student st = (Student) ois.readObject();
                System.out.println(st.toString());

                ois.close();
        }
}