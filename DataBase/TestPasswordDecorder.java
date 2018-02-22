
import java.sql.*;
import java.util.*;
public class TestPasswordDecorder{

    public static void main(String[] args) throws Exception {
		String password = "jaykumar";
		String decoded = AESEditor1.encrypt(password);
		System.out.println(decoded);
		System.out.println(AESEditor1.decrypt(decoded));
	}

}