package EndToEndScenario;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class example {
	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		ResultSet result = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root")
		.createStatement()
		.executeQuery("select * from project");
		
		while(result.next()) {
			System.out.println(result.getString("project_name"));
		}
	}

}
