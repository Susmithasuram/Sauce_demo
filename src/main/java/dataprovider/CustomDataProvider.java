package dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider 
{
	@DataProvider(name="login")
	public static Object[][] getUserDetails()
	{
		System.out.println("LOG:INFO - Generating Test Data For The Test");
		
		Object[][]arr= ExcelReader.getDataFromExcel("Login");
		
		System.out.println("LOG:INFO - Test Data Generated");
		
		return arr;
	}
	
	@DataProvider(name="product")
	public static Object[][] newUserDetails()
	{
		System.out.println("LOG:INFO - Generating Test Data For The Test");
		
		Object[][]arr= ExcelReader.getDataFromExcel("Product");
		
		System.out.println("LOG:INFO - Test Data Generated");
		
		return arr;
	}
	
	@DataProvider(name="CourseInfo")
	public static Object[][] courseDetails()
	{
		System.out.println("LOG:INFO - Generating Test Data For The Test to add the Course");
		
		Object[][]arr= ExcelReader.getDataFromExcel("courses_details");
		
		System.out.println("LOG:INFO - Test Data Generated");
		
		return arr;
	}
	
	
	@DataProvider(name="AddCourseDetails")
	public static Object[][] addcourseDetails()
	{
		System.out.println("LOG:INFO - Generating Test Data For The Test to add the Course");
		
		Object[][]arr= ExcelReader.getDataFromExcel("addCourse_details");
		
		System.out.println("LOG:INFO - Test Data Generated");
		
		return arr;
	}
	
	
	
	

}
