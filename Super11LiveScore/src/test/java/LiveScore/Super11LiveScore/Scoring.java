package LiveScore.Super11LiveScore;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageObjects.CrickbuzzScoreboard;
import PageObjects.Super11ScoreBoard;
import PageObjects.super11LoginPage;
import resources.Base;

public class Scoring extends Base {
	public WebDriver driver;

	@SuppressWarnings("null")
	@BeforeTest
	public void initialize() throws IOException, InterruptedException {

		driver = InitialiseDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(prop.getProperty("CrickBuzzURL"));
		CrickbuzzScoreboard crickbuzz = new CrickbuzzScoreboard(driver);

		driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
		driver.get(prop.getProperty("Super11StagingURLLogin"));
		super11LoginPage superLogin = new super11LoginPage(driver);
		superLogin.Username().sendKeys(prop.getProperty("Super11AdminUsername"));
		superLogin.Password().sendKeys(prop.getProperty("Super11AdminPass"));
		superLogin.Sign_In().click();
		driver.get(prop.getProperty("Super11DynamicScore"));
		Set<String> windows = driver.getWindowHandles(); // [parentid,childid,subchildId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(parentId);

		wait.until(ExpectedConditions.visibilityOf(crickbuzz.MatchResultText()));
		// System.out.println(crickbuzz.MatchResultText().getText());
		List<String> Player1stInning = new ArrayList<String>();
		do {
			driver.switchTo().window(parentId);
			String teamAName = crickbuzz.FirstTeamName().getText();
			String teamBName = crickbuzz.SecondTeamName().getText();
			String Inning1Score = crickbuzz.FirstTeamScore().getText().split("-")[0];
			String Inning1Outs = crickbuzz.FirstTeamScore().getText().split("-")[1].split(" ")[0];
			String Inning1Overs = crickbuzz.FirstTeamScore().getText().split(" ")[1].substring(1);
			String Inning2Score = crickbuzz.SecondTeamScore().getText().split("-")[0];
			String Inning2Outs = crickbuzz.SecondTeamScore().getText().split("-")[1].split(" ")[0];
			String Inning2Overs = crickbuzz.SecondTeamScore().getText().split(" ")[1].substring(1);

			String Inning1ExtraAllText = null;
			int totalinning1battertablerow = crickbuzz.BatterTableInning1().size();
			int inning1battertablerow = totalinning1battertablerow - 3;
			for (int i = 0; i < totalinning1battertablerow; i++) {
				Player1stInning.add(crickbuzz.BatterTableInning1().get(i).getText());
				if (crickbuzz.BatterTableInning1().get(i).getText().contains("Extras")) {
					Inning1ExtraAllText = crickbuzz.BatterTableInning1().get(i).getText();
				}
			}
			String Inning1bye = Inning1ExtraAllText.split("\\r?\\n|\\r")[2].split("b")[1].split(",")[0].trim();
			;
			String Inning1LegBye = Inning1ExtraAllText.split("\\r?\\n|\\r")[2].split("lb")[1].split(",")[0].trim();
			;
			String Inning1Wide = Inning1ExtraAllText.split("\\r?\\n|\\r")[2].split("w")[1].split(",")[0].trim();
			String Inning1NoBall = Inning1ExtraAllText.split("\\r?\\n|\\r")[2].split("nb")[1].split(",")[0].trim();
			String Inning1Penaltystring = Inning1ExtraAllText.split("\\r?\\n|\\r")[2].split("p")[1].trim();
			String Inning1Penalty = Inning1Penaltystring.substring(0, Inning1Penaltystring.length() - 1);

			// System.out.println(Inning1Penalty);
			// To get all the values in a list.

			//
			List<String> Bowler1stInning = new ArrayList<String>();
			int totalinning1bowlertablerow = crickbuzz.BowlerTableInning1().size();

			for (int i = 0; i < totalinning1bowlertablerow; i++) {
				Bowler1stInning.add(crickbuzz.BowlerTableInning1().get(i).getText());
			}
			// System.out.println("Player name outside the for loop: "
			// +Bowler1stInning.get(3)/*.split("\\r?\\n|\\r")[2]*/);

			String Inning2ExtraAllText = null;
			List<String> Player2ndInning = new ArrayList<String>();
			int totalinning2battertablerow = crickbuzz.BatterTableInning2().size();
			int inning2battertablerow = totalinning2battertablerow - 3;
			for (int i = 0; i < totalinning2battertablerow; i++) {
				Player2ndInning.add(crickbuzz.BatterTableInning2().get(i).getText());
				if (crickbuzz.BatterTableInning2().get(i).getText().contains("Extras")) {
					Inning2ExtraAllText = crickbuzz.BatterTableInning2().get(i).getText();
				}
			}

			String Inning2bye = Inning2ExtraAllText.split("\\r?\\n|\\r")[2].split("b")[1].split(",")[0].trim();
			;
			String Inning2LegBye = Inning2ExtraAllText.split("\\r?\\n|\\r")[2].split("lb")[1].split(",")[0].trim();
			;
			String Inning2Wide = Inning2ExtraAllText.split("\\r?\\n|\\r")[2].split("w")[1].split(",")[0].trim();
			String Inning2NoBall = Inning2ExtraAllText.split("\\r?\\n|\\r")[2].split("nb")[1].split(",")[0].trim();
			String Inning2Penaltystring = Inning2ExtraAllText.split("\\r?\\n|\\r")[2].split("p")[1].trim();
			String Inning2Penalty = Inning2Penaltystring.substring(0, Inning2Penaltystring.length() - 1);

			// System.out.println("Player name outside the for loop: "
			// +Player2ndInning.get(3).split("\\r?\\n|\\r")[2]);

			List<String> Bowler2ndInning = new ArrayList<String>();
			int totalinning2bowlertablerow = crickbuzz.BowlerTableInning2().size();
			// int inning1bowlertablerow =totalinning1bowlertablerow-3;
			for (int i = 0; i < totalinning2bowlertablerow; i++) {
				Bowler2ndInning.add(crickbuzz.BowlerTableInning2().get(i).getText());
			}
			// System.out.println("Player name outside the for loop: "
			// +Bowler2ndInning.get(3).split("\\r?\\n|\\r")[3]);

			driver.switchTo().window(childId);
			Super11ScoreBoard scorboard = new Super11ScoreBoard(driver);
			teamAName = teamAName.replaceAll("Innings", "").trim();
			teamBName = teamBName.replaceAll("Innings", "").trim();
			// System.out.println(teamAName);
			// System.out.println(teamBName);
			String TeamName = null;
			if (teamAName.equalsIgnoreCase("Chennai Super Kings")
					|| teamBName.equalsIgnoreCase("Chennai Super Kings")) {
				TeamName = "CSK";
			}
			if (teamAName.equalsIgnoreCase("Delhi Capitals") || teamBName.equalsIgnoreCase("Delhi Capitals")) {
				TeamName = "DC";
			}
			if (teamAName.equalsIgnoreCase("Gujarat Titans") || teamBName.equalsIgnoreCase("Gujarat Titans")) {
				TeamName = "GT";
			}
			if (teamAName.equalsIgnoreCase("Kolkata Knight Riders")
					|| teamBName.equalsIgnoreCase("Kolkata Knight Riders")) {
				TeamName = "KKR";
			}
			if (teamAName.equalsIgnoreCase("Lucknow Super Giants")
					|| teamBName.equalsIgnoreCase("Lucknow Super Giants")) {
				TeamName = "LSG";
			}
			if (teamAName.equalsIgnoreCase("Mumbai Indians") || teamBName.equalsIgnoreCase("Mumbai Indians")) {
				TeamName = "MI";
			}
			if (teamAName.equalsIgnoreCase("Royal Challengers Bangalore")
					|| teamBName.equalsIgnoreCase("Royal Challengers Bangalore")) {
				TeamName = "RCB";
			} else if (teamAName.equalsIgnoreCase("Punjab Kings") || teamBName.equalsIgnoreCase("Punjab Kings")) {
				TeamName = "PBKS";
			}

			if (scorboard.TeamAName().getText().equalsIgnoreCase(TeamName)) {
				scorboard.TeamAPressEdit().click();
				scorboard.teamABattingRedioButton().click();
				scorboard.teamAInning1Bye().clear();
				scorboard.teamAInning1Bye().sendKeys(Inning1bye);
				scorboard.teamAInning1LegBye().clear();
				scorboard.teamAInning1LegBye().sendKeys(Inning1LegBye);
				scorboard.teamAInning1NoBall().clear();
				scorboard.teamAInning1NoBall().sendKeys(Inning1NoBall);
				scorboard.teamAInning1Wide().clear();
				scorboard.teamAInning1Wide().sendKeys(Inning1Wide);
				scorboard.teamAInning1Penalty().clear();
				scorboard.teamAInning1Penalty().sendKeys(Inning1Penalty);
				scorboard.teamAInning1TotalScore().clear();
				scorboard.teamAInning1TotalScore().sendKeys(Inning1Score);
				scorboard.teamAInning1TotalWickets().clear();
				scorboard.teamAInning1TotalWickets().sendKeys(Inning1Outs);
				scorboard.teamAInning1TotalOvers().clear();
				scorboard.teamAInning1TotalOvers().sendKeys(Inning1Overs);
				scorboard.teamAInning1IsCompletedRedioButton().click();
				scorboard.teamAInning1Approve().click();
				scorboard.are_you_sure_Match_is_startedPressed_Yes().click();

				scorboard.TeamBPressEdit().click();
				scorboard.teamBBattingRedioButton().click();
				scorboard.teamBInning1Bye().clear();
				scorboard.teamBInning1Bye().sendKeys(Inning2bye);
				scorboard.teamBInning1LegBye().clear();
				scorboard.teamBInning1LegBye().sendKeys(Inning2LegBye);
				scorboard.teamBInning1NoBall().clear();
				scorboard.teamBInning1NoBall().sendKeys(Inning2NoBall);
				scorboard.teamBInning1Wide().clear();
				scorboard.teamBInning1Wide().sendKeys(Inning2Wide);
				scorboard.teamBInning1Penalty().clear();
				scorboard.teamBInning1Penalty().sendKeys(Inning2Penalty);
				scorboard.teamBInning1TotalScore().clear();
				scorboard.teamBInning1TotalScore().sendKeys(Inning2Score);
				scorboard.teamBInning1TotalWickets().clear();
				scorboard.teamBInning1TotalWickets().sendKeys(Inning2Outs);
				scorboard.teamBInning1TotalOvers().clear();
				scorboard.teamBInning1TotalOvers().sendKeys(Inning2Overs);
			} else if (scorboard.TeamBName().getText().equals(TeamName)) {

				scorboard.TeamBPressEdit().click();
				scorboard.teamBBattingRedioButton().click();
				scorboard.teamBInning1Bye().clear();
				scorboard.teamBInning1Bye().sendKeys(Inning1bye);
				scorboard.teamBInning1LegBye().clear();
				scorboard.teamBInning1LegBye().sendKeys(Inning1LegBye);
				scorboard.teamBInning1NoBall().clear();
				scorboard.teamBInning1NoBall().sendKeys(Inning1NoBall);
				scorboard.teamBInning1Wide().clear();
				scorboard.teamBInning1Wide().sendKeys(Inning1Wide);
				scorboard.teamBInning1Penalty().clear();
				scorboard.teamBInning1Penalty().sendKeys(Inning1Penalty);
				scorboard.teamBInning1TotalScore().clear();
				scorboard.teamBInning1TotalScore().sendKeys(Inning1Score);
				scorboard.teamBInning1TotalWickets().clear();
				scorboard.teamBInning1TotalWickets().sendKeys(Inning1Outs);
				scorboard.teamBInning1TotalOvers().clear();
				scorboard.teamBInning1TotalOvers().sendKeys(Inning1Overs);
				scorboard.teamBInning1IsCompletedRedioButton().click();
				scorboard.teamBInning1Approve().click();
				scorboard.are_you_sure_Match_is_startedPressed_Yes().click();

				scorboard.TeamAPressEdit().click();
				scorboard.teamABattingRedioButton().click();
				scorboard.teamAInning1Bye().clear();
				scorboard.teamAInning1Bye().sendKeys(Inning2bye);
				scorboard.teamAInning1LegBye().clear();
				scorboard.teamAInning1LegBye().sendKeys(Inning2LegBye);
				scorboard.teamAInning1NoBall().clear();
				scorboard.teamAInning1NoBall().sendKeys(Inning2NoBall);
				scorboard.teamAInning1Wide().clear();
				scorboard.teamAInning1Wide().sendKeys(Inning2Wide);
				scorboard.teamAInning1Penalty().clear();
				scorboard.teamAInning1Penalty().sendKeys(Inning2Penalty);
				scorboard.teamAInning1TotalScore().clear();
				scorboard.teamAInning1TotalScore().sendKeys(Inning2Score);
				scorboard.teamAInning1TotalWickets().clear();
				scorboard.teamAInning1TotalWickets().sendKeys(Inning2Outs);
				scorboard.teamAInning1TotalOvers().clear();
				scorboard.teamAInning1TotalOvers().sendKeys(Inning2Overs);

			}
			scorboard.allInningScoreSave().click();
			scorboard.confirmSaveButtonAllInning().click();

			scorboard.team1playertable().click();
			Thread.sleep(3000l);
			scorboard.team2playertable().click();

			Thread.sleep(3000l);
			// Team A Players all table
			List<String> TeamAPlayerRecords = new ArrayList<String>();
			int TeamAPlayerNamesCounts = scorboard.TeamAPlayerscoreAllRows().size();
			// System.out.println(TeamAPlayerNamesCounts);
			for (int i = 0; i < TeamAPlayerNamesCounts; i++) {
				TeamAPlayerRecords.add(scorboard.TeamAPlayerscoreAllRows().get(i).getText());
			}
			List<String> TeamBPlayerRecords = new ArrayList<String>();
			int TeamBPlayerNamesCounts = scorboard.TeamBPlayerscoreAllRows().size();
			// System.out.println(TeamAPlayerNamesCounts);
			for (int i = 0; i < TeamBPlayerNamesCounts; i++) {
				TeamBPlayerRecords.add(scorboard.TeamBPlayerscoreAllRows().get(i).getText());
			}
			
			for (int i = 0; i < Player1stInning.size(); i++) {
				String PlayernameAtCricbuzz = Player1stInning.get(i).split("\\r?\\n|\\r")[0];
				for (int l = 0; l < TeamBPlayerRecords.size(); l++) {
					String PlayerNameAtScoreboard = TeamBPlayerRecords.get(l).split("\\r?\\n|\\r")[0];
					//System.out.println(PlayernameAtCricbuzz.regionMatches(0, PlayerNameAtScoreboard, 0, 12));
					// Player1stInning.get(0).split("\\r?\\n|\\r")[0].matches(TeamAPlayerRecords.get(0).split("\\r?\\n|\\r")[0]);
					String[] cricPlayerNameArray = PlayernameAtCricbuzz.split(" ");
					String[] superPlayerNameArray = PlayerNameAtScoreboard.split(" ");
					int foundName = 0;
					for (int j = 0; j < cricPlayerNameArray.length; j++) {
						for (int k = 0; k < superPlayerNameArray.length; k++) {
							if (cricPlayerNameArray[j].equalsIgnoreCase(superPlayerNameArray[k])) {
								foundName++;
								break;
							}
						}
					}
					System.out.println(PlayernameAtCricbuzz + " == " + PlayerNameAtScoreboard + " Found match " + foundName);
					if ((cricPlayerNameArray.length > 2 && foundName >= 2)
							|| PlayernameAtCricbuzz.equalsIgnoreCase(PlayerNameAtScoreboard)) {
						//System.out.println("I am in if");
						scorboard.TeamBPlayerEditButton().get(i).click();
						scorboard.TeamBPlayerBatsmanRun().get(i).sendKeys(Player1stInning.get(i).split("\\r?\\n|\\r")[2]);
					}
				}
			}
			// if(Player1stInning.get(i).split("\\r?\\n|\\r")[0].contains(Inning2Penaltystring))
//			if(Inning1Extra.split("\\r?\\n|\\r")[i])
//			{
			// TeamAPlayerscoreAllRows

			// System.out.println(TeamAPlayerNames.get(i));

			
//			
//			
//			scorboard.updateScoreInApp().click();
//			scorboard.confirmSaveButtonAllInning().click();

			Thread.sleep(99999l);

		} while (!crickbuzz.MatchResultText().getText().contains("won"));

		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

	}
	@AfterTest
	public void wedriverquit() throws InterruptedException {
		Thread.sleep(9000l);
		driver.quit();
	}
}
