package org.stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

   public static void launchBrowser() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
	}
   public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void LaunchUrl(String url) {
		driver.get(url);
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public static void passText(WebElement ele,String value) {
		ele.sendKeys(value);
		
	}
	public static void moveToElement(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions action = new Actions(driver);
		action.dragAndDrop(from, to);
	}
	public static void doubleClick() {
		Actions action = new Actions(driver);
		action.doubleClick();
	}
	public static void contextClick() {
		Actions action = new Actions(driver);
		action.contextClick();
	}
	public static void pressDown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void pressUp() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
	public static void takeScreenshot(String location, String ssName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(location + "\\" + ssName+".png");
		Files.copy(ss, file);
	}
	public static void createExecelandSetValue(int row,int cell,String writeData) throws IOException {

		File file=new File("C:\\Users\\Pravin Rethinasamy\\eclipse-workspace\\MavenInmakes\\excel\\THENEW.xlsx");
		Workbook w=new XSSFWorkbook();
		Sheet s=w.createSheet("sheet");
		Row r=s.createRow(row);
		Cell c=r.createCell(cell);
		c.setCellValue(writeData);
		
		FileOutputStream fos=new FileOutputStream(file);
		w.write(fos);
	}
	public static void createCell(int row,int cell,String writeData) throws IOException {

		File file=new File("C:\\Users\\Pravin Rethinasamy\\eclipse-workspace\\MavenInmakes\\excel\\THENEW.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheetAt(0);
		Row r=s.getRow(row);
		Cell c=r.createCell(cell);
		c.setCellValue(writeData);
		FileOutputStream fos=new FileOutputStream(file);
		w.write(fos);
	}
	public static void createRow(int row,int cell,String writeData) throws IOException {

		File file=new File("C:\\Users\\Pravin Rethinasamy\\eclipse-workspace\\MavenInmakes\\excel\\THENEW.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheetAt(0);
		Row r=s.createRow(row);
		Cell c=r.createCell(cell);
		c.setCellValue(writeData);
		FileOutputStream fos=new FileOutputStream(file);
		w.write(fos);
	}
	

	public static void readAlldataFromExcel(String location, int sheetIndex) throws IOException {

		File file = new File(location);
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheetAt(sheetIndex);
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int value = c.getCellType();
				if (value == 1) {
					String s1 = c.getStringCellValue();
					System.out.println(s1);
				} else if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
					String date = simple.format(d);
					System.out.println(date);
				} else {
					double numericCellValue = c.getNumericCellValue();
					long l = (long) numericCellValue;
					System.out.println(l);
				}
			}
		}
	}
	public static void readParticularDataFromExel(String ExcelLocation,int sheetIndex,int row, int colum) throws IOException {
		File file=new File(ExcelLocation);
		FileInputStream fis=new FileInputStream(file);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet s=wb.getSheetAt(sheetIndex);
		Row r = s.getRow(row);
		Cell c=r.getCell(colum);
		int cellType = c.getCellType();
		if(cellType==1) {
			String value=c.getStringCellValue();
			System.out.println(value);
		}
		else if(DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat simple=new SimpleDateFormat("dd-MM-yyyy");
			String dat = simple.format(date);
			System.out.println(dat);
		}
		else {
			double num = c.getNumericCellValue();
			long l=(long)num;
			System.out.println(l);
		}
	}
	
}
