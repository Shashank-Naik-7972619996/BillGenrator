package Super11.Super11ScoringAllScenarios;

import Resources.Base;
import Resources.commonFunctions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.MatchList;
import PageObjects.b2b_Page;
import PageObjects.loginPage;

public class allB2BScenarios extends Base {

	public WebDriver driver;
	b2b_Page b2bPage;
	commonFunctions cf;
	public String SelectedStriker, SelectedNonStriker, SelectedBowler;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage loginPage = new loginPage(driver);
		loginPage.UserName().sendKeys(prop.getProperty("username"));
		loginPage.Password().sendKeys(prop.getProperty("password"));
		driver.manage().window().maximize();
		loginPage.SignInButton().click();
		driver.get(prop.getProperty("url1"));

	}

	@BeforeMethod
	public void beforeEverytest() {

		cf = new commonFunctions(driver);
		b2bPage = new b2b_Page(driver);
		Select bowler = new Select(b2bPage.Bowler());
		Select striker = new Select(b2bPage.Striker());
		Select nonstriker = new Select(b2bPage.NonStriker());
		if (bowler.getFirstSelectedOption().isSelected()) {
			b2bPage.EditBowler().click();
			bowler.selectByIndex(1);
			SelectedBowler = bowler.getFirstSelectedOption().getText();
			

		}
		if (striker.getFirstSelectedOption().isSelected()) {
			b2bPage.EditStriker().click();
			striker.selectByIndex(1);
			SelectedStriker = striker.getFirstSelectedOption().getText();
		}
		if (nonstriker.getFirstSelectedOption().isSelected()) {
			b2bPage.EditNonStriker().click();
			nonstriker.selectByIndex(2);
			SelectedNonStriker = nonstriker.getFirstSelectedOption().getText();
		}
	}

	@Test
	public void verify_OnStrike_Position() throws InterruptedException {

		b2bPage.ScoreSix().click();
		b2bPage.SubmitScoreButton().click();

		String OverInLastBallText = b2bPage.getLastDetails().getText().split("-")[0].trim();
		Float OverInLastBall = Float.parseFloat(OverInLastBallText);
		double ExpectedOverCount = cf.getTeamAInning1Overs() + 0.1;
		Float ExpOvCount = (float) ExpectedOverCount;
		Assert.assertEquals(OverInLastBall, ExpOvCount);
		
		String BowlerNameInLastBall = b2bPage.getLastDetails().getText().split("-")[1].split("to")[0].trim();
		Assert.assertEquals(BowlerNameInLastBall, SelectedBowler);
		String StrikerNameInLastBall = b2bPage.getLastDetails().getText().split("to")[1].split(",")[0].trim();
		Assert.assertEquals(StrikerNameInLastBall, SelectedStriker);

		b2bPage.ApproveLastBallButton().click();
		b2bPage.ConfirmButton().click();
		Thread.sleep(3000l);
		String StrikerName = b2bPage.getPlayer1Name().getText().trim();
		Assert.assertEquals(StrikerName, StrikerNameInLastBall);

	}

	@AfterMethod
	public void printAllScore() throws InterruptedException {
		Thread.sleep(3000l);
		try {
			cf.getAllScoreData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeinstance() throws InterruptedException {
		cf.printAllScoreInConsole();
		/*
		 * Thread.sleep(9000l); driver.quit();
		 */
	}
}