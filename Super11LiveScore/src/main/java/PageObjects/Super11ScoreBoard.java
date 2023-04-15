package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Super11ScoreBoard {
	
	public WebDriver driver;
	public Super11ScoreBoard(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By isMatchStarted = By.xpath("//*[@id='matchStartedBtn']");
	private By are_you_sure_Match_is_startedPressed_Yes = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	
	private By TeamAName = By.xpath("//h2[@class='mb-0']//span[@class='teamAName']");
	private By TeamAPressEdit = By.cssSelector("#teamAInning1Edit");
	private By teamABattingRedioButton = By.cssSelector("#teamAInning1IsBatting");
	private By teamAInning1IsCompletedRedioButton = By.cssSelector("#teamAInning1IsCompleted");
	private By teamAInning1Bye = By.cssSelector("#teamAInning1Bye");
	private By teamAInning1LegBye = By.cssSelector("#teamAInning1LegBye");
	private By teamAInning1NoBall = By.cssSelector("#teamAInning1NoBall");
	private By teamAInning1Wide = By.cssSelector("#teamAInning1Wide");
	private By teamAInning1Penalty = By.cssSelector("#teamAInning1Penalty");
	private By teamAInning1TotalScore = By.cssSelector("#teamAInning1TotalScore");
	private By teamAInning1TotalWickets = By.cssSelector("#teamAInning1TotalWickets");
	private By teamAInning1TotalOvers = By.cssSelector("#teamAInning1TotalOvers");
	private By teamAInning1RequiredRuns = By.cssSelector("#teamAInning1RequiredRuns");
	
	
	private By TeamBName = By.xpath("//h2[@class='mb-0']//span[@class='teamName']");
	private By TeamBPressEdit = By.cssSelector("#teamBInning1Edit");
	private By teamBBattingRedioButton = By.cssSelector("#teamBInning1IsBatting");
	private By teamBInning1IsCompletedRedioButton = By.cssSelector("#teamBInning1IsCompleted");
	private By teamBInning1Bye = By.cssSelector("#teamBInning1Bye");
	private By teamBInning1LegBye = By.cssSelector("#teamBInning1LegBye");
	private By teamBInning1NoBall = By.cssSelector("#teamBInning1NoBall");
	private By teamBInning1Wide = By.cssSelector("#teamBInning1Wide");
	private By teamBInning1Penalty = By.cssSelector("#teamBInning1Penalty");
	private By teamBInning1TotalScore = By.cssSelector("#teamBInning1TotalScore");
	private By teamBInning1TotalWickets = By.cssSelector("#teamBInning1TotalWickets");
	private By teamBInning1TotalOvers = By.cssSelector("#teamBInning1TotalOvers");
	private By teamBInning1RequiredRuns = By.cssSelector("#teamBInning1RequiredRuns");
	
	private By allInningScoreSave = By.cssSelector("#addAllInningScore");
	private By confirmSaveButtonAllInning = By.cssSelector("button[class='swal2-confirm swal2-styled']");
	
	private By TeamANameForAllPlayerDetails = By.xpath("//*[@id='headingOne']/h2/button/span");
	private By TeamBNameForAllPlayerDetails = By.xpath("//*[@id='headingTwo']/h2/button/span");
	
	private By TeamAPlayerscoreAllRows = By.xpath("//*[@class='teamAPlayerDetails']/form");
	private By TeamBPlayerscoreAllRows = By.xpath("//*[@class='teamBPlayerDetails']/form");
	//For player name   : //*[@class='teamAPlayerDetails']/form/div/div/span
	
	private By teamAplayerNames = By.xpath("//*[@class='teamAPlayerDetails']/form/div/div/span[@class='batsmanName']");
	private By teamBplayerNames = By.xpath("//*[@class='teamBPlayerDetails']/form/div/div/span[@class='batsmanName']");
	//For Wicket&Retire : //*[@class='teamAPlayerDetails']/form/div/div/span[2]/div/select
	//For batsmanRun    : //*[@class='teamAPlayerDetails']/form/div/div[2]/input[1]
	//For Batsmanball   : //*[@class='teamAPlayerDetails']/form/div/div[2]/input[2]
	//For Batsman4s 	: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[3]
	//For Batsman6s		: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[4]
	//For BowlerOvers	: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[5]
	//For BowlerMedian	: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[6]
	//For BowlerRun		: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[7]
	//For BowlerWicket	: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[8]
	//For CatchOut		: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[9]
	//For StumpOut		: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[10]
	//For RunOut		: //*[@class='teamAPlayerDetails']/form/div/div[2]/input[11]
	//For PlayerEditButton: //*[@class='teamAPlayerDetails']/form/div/div[2]/div/button
	
	private By TeamAPlayerBatsmanRun = By.xpath("//*[@class='teamAPlayerDetails']/form/div/div[2]/input[1]");
	private By TeamBPlayerBatsmanRun = By.xpath("//*[@class='teamBPlayerDetails']/form/div/div[2]/input[1]");
	
	private By TeamAPlayerEditButton = By.xpath("//*[@class='teamAPlayerDetails']/form/div/div[2]/div/button");
	private By TeamBPlayerEditButton = By.xpath("//*[@class='teamBPlayerDetails']/form/div/div[2]/div/button");
	
	private By SaveAllPlayerDataButton = By.xpath("//*[@id='addAllPlayerData']");
	private By teamAInning1Approve = By.xpath("//*[@id='teamAInning1Approve']");
	private By ConfirmButton = By.xpath("//div[@class='swal2-actions']/button[1]");
	
	private By teamBInning1Approve = By.xpath("//*[@id='teamBInning1Approve']");
	
	private By updateScoreInApp = By.cssSelector("#updateScoreInApp");
	private By team1playertableName = By.cssSelector("button[data-target='#collapseOne'] span[class='teamName']");
	private By team2playertableName = By.cssSelector("button[data-target='#collapseTwo'] span[class='teamName']");
	
	public WebElement ConfirmButton()
	{
		return driver.findElement(ConfirmButton); 
	}
	
	public List<WebElement> TeamBPlayerEditButton()
	{
		return driver.findElements(TeamBPlayerEditButton); 
	}
	
	
	public List<WebElement> TeamBPlayerBatsmanRun()
	{
		return driver.findElements(TeamBPlayerBatsmanRun); 
	}
	
	public List<WebElement> TeamAPlayerBatsmanRun()
	{
		return driver.findElements(TeamAPlayerBatsmanRun); 
	}
	
	
	public List<WebElement> TeamAPlayerEditButton()
	{
		return driver.findElements(TeamAPlayerEditButton); 
	}
	public List<WebElement> teamAplayerNames()
	{
		return driver.findElements(teamAplayerNames); 
	}
	public List<WebElement> teamBplayerNames()
	{
		return driver.findElements(teamBplayerNames); 
	}
	
	public WebElement team1playertable()
	{
		return driver.findElement(team1playertableName); 
	}
	
	public WebElement team2playertable()
	{
		return driver.findElement(team2playertableName); 
	}
	
	public WebElement updateScoreInApp()
	{
		return driver.findElement(updateScoreInApp); 
	}
	
	public WebElement confirmSaveButtonAllInning()
	{
		return driver.findElement(confirmSaveButtonAllInning); 
	}
	public WebElement teamAInning1Approve()
	{
		return driver.findElement(teamAInning1Approve); 
	}
	public WebElement allInningScoreSave()
	{
		return driver.findElement(allInningScoreSave); 
	}
	
	public WebElement teamBInning1Approve()
	{
		return driver.findElement(teamBInning1Approve); 
	}
	
	public WebElement TeamAName()
	{
		return driver.findElement(TeamAName); 
	}
	public WebElement TeamAPressEdit()
	{
		return driver.findElement(TeamAPressEdit); 
	}
	public WebElement teamABattingRedioButton()
	{
		return driver.findElement(teamABattingRedioButton); 
	}
	
	public WebElement teamAInning1IsCompletedRedioButton()
	{
		return driver.findElement(teamAInning1IsCompletedRedioButton); 
	}
	public WebElement teamAInning1Bye()
	{
		return driver.findElement(teamAInning1Bye); 
	}
	public WebElement teamAInning1LegBye()
	{
		return driver.findElement(teamAInning1LegBye); 
	}
	public WebElement teamAInning1NoBall()
	{
		return driver.findElement(teamAInning1NoBall); 
	}
	public WebElement teamAInning1Wide()
	{
		return driver.findElement(teamAInning1Wide); 
	}
	public WebElement teamAInning1Penalty()
	{
		return driver.findElement(teamAInning1Penalty); 
	}
	public WebElement teamAInning1TotalScore()
	{
		return driver.findElement(teamAInning1TotalScore); 
	}
	public WebElement teamAInning1TotalWickets()
	{
		return driver.findElement(teamAInning1TotalWickets); 
	}
	public WebElement teamAInning1TotalOvers()
	{
		return driver.findElement(teamAInning1TotalOvers); 
	}
	public WebElement teamAInning1RequiredRuns()
	{
		return driver.findElement(teamAInning1RequiredRuns); 
	}
	
	public WebElement TeamBName()
	{
		return driver.findElement(TeamBName); 
	}
	public WebElement TeamBPressEdit()
	{
		return driver.findElement(TeamBPressEdit); 
	}
	public WebElement teamBBattingRedioButton()
	{
		return driver.findElement(teamBBattingRedioButton); 
	}
	
	public WebElement teamBInning1IsCompletedRedioButton()
	{
		return driver.findElement(teamBInning1IsCompletedRedioButton); 
	}
	public WebElement teamBInning1Bye()
	{
		return driver.findElement(teamBInning1Bye); 
	}
	public WebElement teamBInning1LegBye()
	{
		return driver.findElement(teamBInning1LegBye); 
	}
	public WebElement teamBInning1NoBall()
	{
		return driver.findElement(teamBInning1NoBall); 
	}
	public WebElement teamBInning1Wide()
	{
		return driver.findElement(teamBInning1Wide); 
	}
	public WebElement teamBInning1Penalty()
	{
		return driver.findElement(teamBInning1Penalty); 
	}
	public WebElement teamBInning1TotalScore()
	{
		return driver.findElement(teamBInning1TotalScore); 
	}
	public WebElement teamBInning1TotalWickets()
	{
		return driver.findElement(teamBInning1TotalWickets); 
	}
	public WebElement teamBInning1TotalOvers()
	{
		return driver.findElement(teamBInning1TotalOvers); 
	}
	public WebElement teamBInning1RequiredRuns()
	{
		return driver.findElement(teamBInning1RequiredRuns); 
	}
	
	
	public WebElement isMatchStarted()
	{
		return driver.findElement(isMatchStarted); 
	}

	public WebElement are_you_sure_Match_is_startedPressed_Yes()
	{
		return driver.findElement(are_you_sure_Match_is_startedPressed_Yes); 
	}
	
	public List<WebElement> TeamAPlayerscoreAllRows()
	{
		return driver.findElements(TeamAPlayerscoreAllRows); 
	}
	public List<WebElement> TeamBPlayerscoreAllRows()
	{
		return driver.findElements(TeamBPlayerscoreAllRows); 
	}
	
	public WebElement TeamANameForAllPlayerDetails()
	{
		return driver.findElement(TeamANameForAllPlayerDetails); 
	}
	public WebElement TeamBNameForAllPlayerDetails()
	{
		return driver.findElement(TeamBNameForAllPlayerDetails); 
	}
	
	public WebElement SaveAllPlayerDataButton()
	{
		return driver.findElement(SaveAllPlayerDataButton); 
	}

}
