package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DBConnection {

	public static void main(String[] args) throws SQLException, InterruptedException {// TODO Auto-generated method stub

		String host="localhost";

		String port= "3306";

		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "Shravan@21345*");

		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("select * from Employeeinfo where location ='chennai'");

		while(rs.next())

		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\slok8\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();

			driver.get("https://www.google.com/");

			driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(rs.getString("name"));
			Thread.sleep(2000);

		//	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
			
			//System.out.println(rs.getString("name"));
			//System.out.println(rs.getString("age"));
			driver.quit();
		}

	}
	

}
