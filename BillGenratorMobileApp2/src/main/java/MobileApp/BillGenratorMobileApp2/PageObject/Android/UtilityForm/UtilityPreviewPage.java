package MobileApp.BillGenratorMobileApp2.PageObject.Android.UtilityForm;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import MobileApp.BillGenratorMobileApp2.Utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UtilityPreviewPage extends ReusableMethods{
	public UtilityPreviewPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		// TODO Auto-generated constructor stub
	}
	AndroidDriver driver;
	UtilityPreviewPage UtilityPreviewPageObj;
	@AndroidFindBys({@AndroidBy(className = "android.widget.TextView")})
	private List<WebElement> TextView;
	
	@AndroidFindBy(xpath="//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View[1]")
	private WebElement companyname;
	@AndroidFindBy(xpath="//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View[2]")
	private WebElement URL1;
	//android.view.View[3]/android.view.View[2]/android.view.View[2]
	@AndroidFindBy(xpath="//android.view.View[@text='Statement Date:']/following-sibling::android.view.View[contains(@text,'/')]")
	private WebElement StatementDate;
	@AndroidFindBy(xpath="//android.view.View[@text='Due Date:']/following-sibling::android.view.View[contains(@text,'/')]")
	private WebElement DueDate;
	@AndroidFindBy(xpath="//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View[5]")
	private WebElement YourDetails;
	@AndroidFindBy(xpath="//android.view.View[@text='Amount Due on Previous Statement']/following-sibling::android.view.View[contains(@text,'$')]")
	private WebElement PreviousState1;
	@AndroidFindBy(xpath="//android.view.View[@text='Payment(s) Received Since Last Statement']/following-sibling::android.view.View[contains(@text,'$')]")
	private WebElement PreviousState2;
	@AndroidFindBy(xpath="//android.view.View[@text='Current PG&E Electric Delivery Charges']/following-sibling::android.view.View[contains(@text,'$')]")
	private WebElement Deliverycharg;
	@AndroidFindBy(xpath="//android.view.View[@text='Silicon Valley Clean Energy Electric Generation Charges']/following-sibling::android.view.View[contains(@text,'$')]")
	private WebElement ElectricCharge;
	@AndroidFindBy(xpath="(//android.view.View[contains(@text,'Total Amount Due by')])[3]")
	private WebElement TotalAmountDueDate;
	@AndroidFindBy(xpath="(//android.view.View[contains(@text,'Total Amount Due by')])[3]/following-sibling::android.view.View")
	private WebElement TotalAmountPString;
	@AndroidFindBy(xpath="//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View[10]")
	private WebElement QuestionAboutBillURL2P;
	@AndroidFindBy(xpath="//android.widget.Image[@text='draft-watermark']/../following-sibling::android.view.View[12]")
	private WebElement WayToPayURL3P;
	@AndroidFindBy(xpath="(//android.view.View[contains(@text,'Important Messages')]/../following-sibling::android.view.View/android.view.View)[1]")
	private WebElement ImpMsg1P;
	@AndroidFindBy(xpath="(//android.view.View[contains(@text,'Important Messages')]/../following-sibling::android.view.View/android.view.View)[2]")
	private WebElement ImpMsg2P;
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Due Date:')]/../following-sibling::android.view.View/android.view.View[2]")
	private WebElement DueDateBottom;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Total Amount Due:')]/../following-sibling::android.view.View/android.view.View[3]")
	private WebElement TotalDueAmoutBottomPString;
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Amount Enclosed:')]/../../../following-sibling::android.view.View/android.view.View/android.view.View[2]")
	private WebElement CompanyAddBottomP;
	
	
	public String getCompanyName()
	{
		return companyname.getText();
	}
	public String getURL1()
	{
		return URL1.getText();
	}
	public String getStatementDate()
	{
		return StatementDate.getText();
	}
	public String getDueDate()
	{
		return DueDate.getText();
	}
	public String getYourAddDetails()
	{
		return YourDetails.getText();
	}
	public String getPreviousState1()
	{
		return PreviousState1.getText();
	}
	public String getPreviousState2()
	{
		return PreviousState2.getText();
	}
	public Double getDeliverycharg()
	{
		String deleverychargeinstring = Deliverycharg.getText();
		String remove$1 = deleverychargeinstring.replace("$", "");
		Double DeliverychargammountP = Double.parseDouble(remove$1);
		return DeliverychargammountP;
	}
	public Double getElectricCharge()
	{
		String ElecricChargeinString = ElectricCharge.getText();
		String remove$2 = ElecricChargeinString.replace("$", "");
		Double ElectricchargammountP = Double.parseDouble(remove$2);
		return ElectricchargammountP;
	}
	public String getTotalAmountDueDate()
	{
		return TotalAmountDueDate.getText();
	}
	public Double getTotalAmount()
	{
		String TotalAmountPString1 = TotalAmountPString.getText();
		String remove$3 = TotalAmountPString1.replace("$", "");
		Double TotalAmountP = Double.parseDouble(remove$3);
		return TotalAmountP;
	}
	public String getQuestionAboutBillURL2P()
	{
		return QuestionAboutBillURL2P.getText();
	}
	public String getWayToPayURL3P()
	{
		//return WayToPayURL3P.getText();
		return WayToPayURL3P.getText();
	}
	public String getImpMsg1P()
	{
		return ImpMsg1P.getText();
	}
	public String getImpMsg2P()
	{
		return ImpMsg2P.getText();
	}
	public String getDueDateBottom()
	{
		return DueDateBottom.getText();
	}
	public Double getTotalDueAmoutBottomPString()
	{
		String remove$4 = TotalDueAmoutBottomPString.getText().replace("$", "");
		Double TotalDueAmoutBottomP = Double.parseDouble(remove$4);
		return TotalDueAmoutBottomP;
	}
	public String getCompanyAddBottomP()
	{
		return CompanyAddBottomP.getText();
	}
}
