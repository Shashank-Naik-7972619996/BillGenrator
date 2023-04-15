package Functions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Functions.Excel_Data ExcelData;
		Functions.PropertiesCaller Obj;
		Functions.DriverCall drivercall;
		
		drivercall = new Functions.DriverCall();
        WebDriver driver = drivercall.setDriver();
        ExcelData = new Excel_Data();     
        Obj = new PropertiesCaller();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://forms.gle/h4acMi8bTMRZtKo86");
        driver.manage().window().maximize();
        //https://forms.gle/h4acMi8bTMRZtKo86
        WebElement UserName = driver.findElements(By.xpath(Obj.Properties("Login"))).get(0);
        WebElement Password = driver.findElements(By.xpath(Obj.Properties("Login"))).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(UserName));
        UserName.sendKeys("Shashank Naik");
        Password.sendKeys("123456789");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'https:')]")));
        driver.findElement(By.xpath("//a[contains(text(),'https:')]")).click();
        
        Set <String> ids = driver.getWindowHandles();
        java.util.Iterator<String> it= ids.iterator();
        String Parent = it.next();
        String Child = it.next();
        driver.switchTo().window(Child);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Obj.Properties("CandidateName"))));
        int SubmitedNow=0, Starting;
        Starting=1909;
        System.out.println("Starting from "+ Starting);
        int Ending=2001;
        
        for(int r=Starting;r<=Ending;r++)
        {
        	WebElement CandidateName=driver.findElement(By.xpath(Obj.Properties("CandidateName1")));
            WebElement EmailId=driver.findElement(By.xpath(Obj.Properties("EmailId1")));
            WebElement ContactNumber=driver.findElement(By.xpath(Obj.Properties("ContactNumber1")));
            WebElement City=driver.findElement(By.xpath(Obj.Properties("City1")));
            WebElement Locality=driver.findElement(By.xpath(Obj.Properties("Locality1")));
            WebElement DateOfTransfer=driver.findElement(By.xpath(Obj.Properties("DateOfTransfer1")));
            WebElement Role=driver.findElement(By.xpath(Obj.Properties("Role1")));
            WebElement LanguagesKnown=driver.findElement(By.xpath(Obj.Properties("LanguagesKnown1")));
            WebElement AddressProof=driver.findElement(By.xpath(Obj.Properties("AddressProof1")));
            WebElement Stream=driver.findElement(By.xpath(Obj.Properties("Stream1")));
            WebElement Natioality=driver.findElement(By.xpath(Obj.Properties("Natioality1")));
            WebElement Passport=driver.findElement(By.xpath(Obj.Properties("Passport1")));
            WebElement Level=driver.findElement(By.xpath(Obj.Properties("Level1")));
            WebElement Qualification=driver.findElement(By.xpath(Obj.Properties("Qualification1")));
            WebElement AdvanceExcel=driver.findElement(By.xpath(Obj.Properties("AdvanceExcel1")));
        	wait.until(ExpectedConditions.elementToBeClickable(CandidateName));
        	System.out.println("Submitting row: "+r);
        	System.out.println("CandidateName: "+ExcelData.getData(0, r-1, 0).getStringCellValue() +
        	"      Email Id: "+ExcelData.getData(0, r-1, 1).getStringCellValue() +
        	"      ContactNumber: "+ ExcelData.getData(0, r-1, 2).getRawValue()+
        	"      City: "+ ExcelData.getData(0, r-1, 3).getStringCellValue()+
        	"      Locality: "+ ExcelData.getData(0, r-1, 4).getStringCellValue()+
        	"      DateOfTransfer: " + ExcelData.getDate(0, r-1, 5)+
        	"      Role: " + ExcelData.getData(0, r-1, 6).getStringCellValue()+
        	"      LanguagesKnown: "+ExcelData.getData(0, r-1, 7).getStringCellValue()+
        	"      AddressProof: "+ExcelData.getData(0, r-1, 8).getStringCellValue()+
        	"      Stream: "+ExcelData.getData(0, r-1, 9).getStringCellValue()+
        	"      Natioality: "+ExcelData.getData(0, r-1, 10).getStringCellValue()+
        	"      Passport: "+ExcelData.getData(0, r-1, 11).getStringCellValue()+
        	"      Level: "+ExcelData.getData(0, r-1, 12).getRawValue()+
        	"      Qualification: "+ExcelData.getData(0, r-1, 13).getStringCellValue()+
        	"      AdvanceExcel: "+ExcelData.getData(0, r-1, 14).getStringCellValue());
        	
     
        	CandidateName.sendKeys(ExcelData.getData(0, r-1, 0).getStringCellValue());
        	EmailId.sendKeys(ExcelData.getData(0, r-1, 1).getStringCellValue());
        	ContactNumber.sendKeys(ExcelData.getData(0, r-1, 2).getRawValue());
        	City.sendKeys(ExcelData.getData(0, r-1, 3).getStringCellValue());
        	Locality.sendKeys(ExcelData.getData(0, r-1, 4).getStringCellValue());
        	DateOfTransfer.sendKeys(ExcelData.getDate(0, r-1, 5));
        	Role.sendKeys(ExcelData.getData(0, r-1, 6).getStringCellValue());
        	LanguagesKnown.sendKeys(ExcelData.getData(0, r-1, 7).getStringCellValue());
        	AddressProof.sendKeys(ExcelData.getData(0, r-1, 8).getStringCellValue());
        	Stream.sendKeys(ExcelData.getData(0, r-1, 9).getStringCellValue());
        	Natioality.sendKeys(ExcelData.getData(0, r-1, 10).getStringCellValue());
        	Passport.sendKeys(ExcelData.getData(0, r-1, 11).getStringCellValue());
        	Level.sendKeys(ExcelData.getData(0, r-1, 12).getRawValue());
        	Qualification.sendKeys(ExcelData.getData(0, r-1, 13).getStringCellValue());
        	AdvanceExcel.sendKeys(ExcelData.getData(0, r-1, 14).getStringCellValue());
        	
        	if(r==Ending){break;}
        	if(SubmitedNow!=0)
        	{
        		Thread.sleep(RandomSleep1.getMillis());
        	}
        	/*String a = null,b = null;
        	if(SubmitedNow!=0)
        	{
        		b= CurrentDateTime.getCurrentTime();
        		System.out.println("Time difference:"+CurrentDateTime.timeDifference(a,b)+"\n ");
        	}*/	
        	
        	driver.findElement(By.xpath(Obj.Properties("FormSubmit"))).click();
        	//a = CurrentDateTime.getCurrentTime();
        	
        	System.out.println(" Completed at: "+CurrentDateTime.getCurrentTime());
        	SubmitedNow++;
        	System.out.println(driver.findElement(By.xpath(Obj.Properties("SuccessMsg"))).getText()+" Row "+r+" submited successfully.");
        	System.out.println("Total records submited now:"+SubmitedNow);
        	driver.findElement(By.linkText("Submit another response")).click();
	}
	}
}