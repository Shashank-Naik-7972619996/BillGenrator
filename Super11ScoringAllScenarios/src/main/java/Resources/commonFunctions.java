package Resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import PageObjects.b2b_Page;

public class commonFunctions extends Base {

	public WebDriver driver;

	public commonFunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public int TeamAInning1Runs, TeamAInning1Outs, TeamBInning1Runs, TeamBInning1Outs, Batsman1Runs, Batsman1Balls,
			Batsman1Fours, Batsman1Sixes, Batsman2Runs, Batsman2Balls, Batsman2Fours, Batsman2Sixes, BowlerMaiden,
			BowlerRuns, BowlerWickets;
	public float TeamAInning1Overs, TeamBInning1Overs, Batsman1SR, Batsman2SR, BowlerOvers, BowlerECO,
			OverCountInLastBall;
	public String PlayerOnStrike, PlayerOnNonStrike, BowlerName, TeamAInning1RunsString, TeamAInning1OversString,
			TeamBInning1RunsString, TeamBInning1OversString, Batsman1RunInText, Batsman1BallsInText,
			Batsman1FoursInText, Batsman1SixesInText, Batsman1SRInText, Batsman2RunInText, Batsman2BallsInText,
			Batsman2FoursInText, Batsman2SixesInText, Batsman2SRInText, BowlerOversInText, BowlerMaidenInText,
			BowlerRunsInText, BowlerWicketInText, BowlerECOInText, OverCountlbInText, BolwlerNameInLastBall,
			StrikerNameInLastBall, ScoreInLastBallInText;
	/*
	 * public WebElement FindRequiredMatchToTest(String MatchName) { MatchList
	 * matchlist = new MatchList(driver); boolean found = false; do { int rowcount =
	 * matchlist.ListOfMatch().size();
	 * 
	 * for (int i = 1; i <= rowcount; i++) { String matchName =
	 * matchlist.ListOfMatch().get(i).getText(); if
	 * (matchName.equalsIgnoreCase(MatchName)) { found = true; return
	 * matchlist.ScoreManagmentButton(); } else if (found == false) {
	 * matchlist.NextButton().click(); }
	 * 
	 * } } while (matchlist.NextButton().getAttribute("class").
	 * equals("paginate_button page-item next") && found == false); return null;
	 * 
	 * }
	 */

	public void getAllScoreData() throws InterruptedException {

		// Thread.sleep(3000l);
		// int time = Integer.parseInt(prop.getProperty("timeout"));
		// driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		b2b_Page scorePage = new b2b_Page(driver);
		TeamAInning1RunsString = scorePage.getTeamAInning1Runs().getText();
		TeamAInning1Runs = Integer.parseInt(TeamAInning1RunsString.split("/")[0].trim());
		TeamAInning1Outs = Integer.parseInt(TeamAInning1RunsString.split("/")[1].trim());
		TeamAInning1OversString = scorePage.getTeamAInning1Overs().getText();
		TeamAInning1Overs = Float.parseFloat(TeamAInning1OversString.split("overs")[0].substring(1).trim());

		TeamBInning1RunsString = scorePage.getTeamBInning1Runs().getText();
		TeamBInning1Runs = Integer.parseInt(TeamBInning1RunsString.split("/")[0].trim());
		TeamBInning1Outs = Integer.parseInt(TeamBInning1RunsString.split("/")[1].trim());
		TeamBInning1OversString = scorePage.getTeamBInning1Overs().getText();
		TeamBInning1Overs = Float.parseFloat(TeamBInning1OversString.split("overs")[0].substring(1).trim());

		PlayerOnStrike = scorePage.getPlayer1Name().getText();
		Batsman1RunInText = scorePage.getPlayer1Runs().getText();
		Batsman1Runs = Integer.parseInt(Batsman1RunInText);
		Batsman1BallsInText = scorePage.getPlayer1Balls().getText();
		Batsman1Balls = Integer.parseInt(Batsman1BallsInText);
		Batsman1FoursInText = scorePage.getPlayer1Fours().getText();
		Batsman1Fours = Integer.parseInt(Batsman1FoursInText);
		Batsman1SixesInText = scorePage.getPlayer1Sixes().getText();
		Batsman1Sixes = Integer.parseInt(Batsman1SixesInText);
		Batsman1SRInText = scorePage.getPlayer1SR().getText();
		Batsman1SR = Float.parseFloat(Batsman1SRInText);

		PlayerOnNonStrike = scorePage.getPlayer2Name().getText();
		Batsman2RunInText = scorePage.getPlayer2Runs().getText();
		Batsman2Runs = Integer.parseInt(Batsman2RunInText);
		Batsman2BallsInText = scorePage.getPlayer2Balls().getText();
		Batsman2Balls = Integer.parseInt(Batsman2BallsInText);
		Batsman2FoursInText = scorePage.getPlayer2Fours().getText();
		Batsman2Fours = Integer.parseInt(Batsman2FoursInText);
		Batsman2SixesInText = scorePage.getPlayer2Sixes().getText();
		Batsman2Sixes = Integer.parseInt(Batsman2SixesInText);
		Batsman2SRInText = scorePage.getPlayer2SR().getText();
		Batsman2SR = Float.parseFloat(Batsman2SRInText);

		BowlerName = scorePage.getBowlerName().getText();
		BowlerOversInText = scorePage.getBowlerOver().getText();
		BowlerOvers = Float.parseFloat(BowlerOversInText);
		BowlerMaidenInText = scorePage.getBowlerMaiden().getText();
		BowlerMaiden = Integer.parseInt(BowlerMaidenInText);
		BowlerRunsInText = scorePage.getBowlerRun().getText();
		BowlerRuns = Integer.parseInt(BowlerRunsInText);
		BowlerWicketInText = scorePage.getBowlerWicket().getText();
		BowlerWickets = Integer.parseInt(BowlerWicketInText);
		BowlerECOInText = scorePage.getBowlerEco().getText();
		BowlerECO = Float.parseFloat(BowlerECOInText);
		// Thread.sleep(3000l);
		/*
		 * System.out.println( "Team A Runs: " + TeamAInning1Runs + " Outs: " +
		 * TeamAInning1Outs + " Overs: " + TeamAInning1Overs); System.out.println(
		 * "\nTeam B Runs: " + TeamBInning1Runs + " Outs: " + TeamBInning1Outs +
		 * " Overs: " + TeamBInning1Overs); System.out.println( "BatsmanOnStrike Name: "
		 * + PlayerOnStrike + " Runs: " + Batsman1Runs + " Balls: " + Batsman1Balls +
		 * " Fours: " + Batsman1Fours + " Sixes: " + Batsman1Sixes + " Strike Rate: " +
		 * Batsman1SR); System.out.println("\nBatsmanOnNonStrike Name: " +
		 * PlayerOnNonStrike + " Runs: " + Batsman2Runs + " Balls: " + Batsman2Balls +
		 * " Fours: " + Batsman2Fours + " Sixes: " + Batsman2Sixes + " Strike Rate: " +
		 * Batsman2SR); System.out.println("\nBowler Name: " + BowlerName + " Overs: " +
		 * BowlerOvers + " Maidens: " + BowlerMaiden + " Runs: " + BowlerRuns +
		 * " Wickets: " + BowlerWickets + " Economy: " + BowlerECO);
		 */

	}
	/*
	 * public void getLastBallDetails() throws InterruptedException { b2b_Page
	 * scorePage = new b2b_Page(driver); OverCountlbInText=
	 * scorePage.getLastDetails().getText();
	 * OverCountInLastBall=Float.parseFloat(OverCountlbInText.split("-")[0].trim());
	 * 
	 * }
	 */

	public int getTeamAInning1Runs() {
		return TeamAInning1Runs;
	}

	public int getTeamAInning1Outs() {
		return TeamAInning1Outs;
	}

	public float getTeamAInning1Overs() {
		return TeamAInning1Overs;
	}

	public int getTeamBInning1Runs() {
		return TeamBInning1Runs;
	}

	public int getTeamBInning1Outs() {
		return TeamBInning1Outs;
	}

	public float getTeamBInning1Overs() {
		return TeamBInning1Overs;
	}

	public String getPlayerOnStrike() {
		return PlayerOnStrike;
	}

	public int getBatsman1Runs() {
		return Batsman1Runs;
	}

	public int getBatsman1Balls() {
		return Batsman1Balls;
	}

	public int getBatsman1Fours() {
		return Batsman1Fours;
	}

	public int getBatsman1Sixes() {
		return Batsman1Sixes;
	}

	public float getBatsman1SR() {
		return Batsman1SR;
	}

	public String getPlayerOnNonStrike() {
		return PlayerOnNonStrike;
	}

	public int getBatsman2Runs() {
		return Batsman2Runs;
	}

	public int getBatsman2Balls() {
		return Batsman2Balls;
	}

	public int getBatsman2Fours() {
		return Batsman2Fours;
	}

	public int getBatsman2Sixes() {
		return Batsman2Sixes;
	}

	public float getBatsman2SR() {
		return Batsman2SR;
	}

	public String getBowlerName() {
		return BowlerName;
	}

	public float getBowlerOvers() {
		return BowlerOvers;
	}

	public int getBowlerMaiden() {
		return BowlerMaiden;
	}

	public int getBowlerRuns() {
		return BowlerRuns;
	}

	public int getBowlerWickets() {
		return BowlerWickets;
	}

	public float getBowlerECO() {
		return BowlerECO;
	}

	public void printAllScoreInConsole() {

		System.out.println(
				"Team A Runs: " + TeamAInning1Runs + " Outs: " + TeamAInning1Outs + " Overs: " + TeamAInning1Overs);
		System.out.println(
				"\nTeam B Runs: " + TeamBInning1Runs + " Outs: " + TeamBInning1Outs + " Overs: " + TeamBInning1Overs);
		System.out.println(
				"BatsmanOnStrike Name: " + PlayerOnStrike + " Runs: " + Batsman1Runs + " Balls: " + Batsman1Balls
						+ " Fours: " + Batsman1Fours + " Sixes: " + Batsman1Sixes + " Strike Rate: " + Batsman1SR);
		System.out.println("\nBatsmanOnNonStrike Name: " + PlayerOnNonStrike + " Runs: " + Batsman2Runs + " Balls: "
				+ Batsman2Balls + " Fours: " + Batsman2Fours + " Sixes: " + Batsman2Sixes + " Strike Rate: "
				+ Batsman2SR);
		System.out.println("\nBowler Name: " + BowlerName + " Overs: " + BowlerOvers + " Maidens: " + BowlerMaiden
				+ " Runs: " + BowlerRuns + " Wickets: " + BowlerWickets + " Economy: " + BowlerECO);
	}
	
	

	public void whenOverFinished() {
		b2b_Page scorePage = new b2b_Page(driver);
		Select bowler = new Select(scorePage.Bowler());
		
		if (bowler.getFirstSelectedOption().getAttribute("value") == "none") {
			scorePage.EditBowler().click();
			bowler.selectByIndex(1);	
			
		}
			bowler.selectByIndex(2);
	}


}
