package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class b2b_Page {
	
		public WebDriver driver;
		public b2b_Page(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}
		
		private By editStriker = By.id("editStriker");
		private By striker = By.id("striker");

        private By editNonStriker = By.id("editNonStriker");
		private By nonstriker = By.id("nonStriker");
		
		private By editBowler = By.id("editBowler");
		private By bowler = By.id("bowler");
		
		
		private By teamAInning1Runs= By.id("teamAInning1Runs");
		private By teamAInning1Overs= By.id("teamAInning1Overs");
		
		private By teamBInning1Runs= By.id("teamBInning1Runs");
		private By teamBInning1Overs= By.id("teamBInning1Overs");
		
		private By lastDetails= By.id("lastDetails");
		
		
		private By player1Name= By.id("player1Name");
		private By player1Runs = By.id("player1Runs");
		private By player1Balls = By.id("player1Balls");
		private By player1Fours = By.id("player1Fours");
		private By player1Sixes = By.id("player1Sixes");
		private By player1SR = By.id("player1SR");
		
		private By player2Name= By.id("player2Name");
		private By player2Runs= By.id("player2Runs");
		private By player2Balls= By.id("player2Balls");
		private By player2Fours= By.id("player2Fours");
		private By player2Sixes= By.id("player2Sixes");
		private By player2SR= By.id("player2SR");
				
		private By bowlerName = By.id("bowlerName");
		private By bowlerOver = By.id("bowlerOver");
		private By bowlerMaiden = By.id("bowlerMaiden");
		private By bowlerRun = By.id("bowlerRun");
		private By bowlerWicket = By.id("bowlerWicket");
		private By bowlerEco = By.id("bowlerEco");
		
		private By scoreZero = By.xpath("//label[@for='zero']");
		private By scoreOne = By.xpath("//label[@for='one']");
		private By scoreTwo = By.xpath("//label[@for='two']");
		private By scoreThree = By.xpath("//label[@for='three']");
		private By scoreFour = By.xpath("//label[@for='four']");
		private By scoreFive = By.xpath("//label[@for='five']");
		private By scoreSix = By.xpath("//label[@for='six']");
		private By scoreSeven = By.xpath("//label[@for='seven']");
		private By scoreEight = By.xpath("//label[@for='eight']");
		
		private By recentBalls  = By.xpath("//span[@class='ballIndicator']");
		
		private By extraWideNoBall = By.id("extraWideNoBall");
		private By extraByeLegBye = By.id("extraByeLegBye");
		private By wicketBtn = By.id("wicketBtn");
		private By undo = By.id("undo");
		private By isBoundary = By.id("isBoundary");
		private By retiredHurtBtn = By.id("retiredHurtBtn");
		private By penaltyBtn = By.id("penaltyBtn");
		private By isInningCompleted = By.id("isCompleted");
		private By isSuperOver = By.id("isSuperOver");
		private By isTied = By.id("isTied");
		
		private By maidenOver = By.id("maidenOver");
		
		private By century = By.id("century");
		private By halfCentury = By.id("halfCentury");
		private By approveLastBall = By.id("approveLastBall");
		private By editLastBall = By.id("editLastBall");
		private By submitScore = By.id("submitScore");
		
		private By dlsApplied = By.id("dlsApplied");
		
		private By breakBtn = By.id("breakBtn");
		private By matchCompletedBtn = By.id("matchCompletedBtn");
		private By confirmbutton = By.cssSelector("button.swal2-confirm.swal2-styled");
		
		
		
		
		public WebElement EditStriker()
		{
			return driver.findElement(editStriker); 
		}
		
		public WebElement Striker()
		{
			return driver.findElement(striker); 
		}
		public WebElement EditNonStriker()
		{
			return driver.findElement(editNonStriker); 
		}
		public WebElement NonStriker()
		{
			return driver.findElement(nonstriker); 
		}
		
		
		public WebElement EditBowler()
		{
			return driver.findElement(editBowler); 
		}
		
		public WebElement Bowler()
		{
			return driver.findElement(bowler); 
		}
		public WebElement getTeamAInning1Runs()
		{
			return driver.findElement(teamAInning1Runs); 
		}
		
		public WebElement getTeamBInning1Runs()
		{
			return driver.findElement(teamBInning1Runs); 
		}
		
		public WebElement getTeamAInning1Overs()
		{
			return driver.findElement(teamAInning1Overs); 
		}
		
		public WebElement getTeamBInning1Overs()
		{
			return driver.findElement(teamBInning1Overs); 
		}
		public WebElement getLastDetails()
		{
			return driver.findElement(lastDetails); 
		}
		
		public WebElement getPlayer1Name()
		{
			return driver.findElement(player1Name); 
		}
		public WebElement getPlayer1Runs()
		{
			return driver.findElement(player1Runs); 
		}
		public WebElement getPlayer1Balls()
		{
			return driver.findElement(player1Balls); 
		}
		public WebElement getPlayer1Fours()
		{
			return driver.findElement(player1Fours); 
		}
		public WebElement getPlayer1Sixes()
		{
			return driver.findElement(player1Sixes); 
		}
		public WebElement getPlayer1SR()
		{
			return driver.findElement(player1SR); 
		}
		
		public WebElement getPlayer2Name()
		{
			return driver.findElement(player2Name); 
		}
		public WebElement getPlayer2Runs()
		{
			return driver.findElement(player2Runs); 
		}
		public WebElement getPlayer2Balls()
		{
			return driver.findElement(player2Balls); 
		}
		public WebElement getPlayer2Fours()
		{
			return driver.findElement(player2Fours); 
		}
		public WebElement getPlayer2Sixes()
		{
			return driver.findElement(player2Sixes); 
		}
		public WebElement getPlayer2SR()
		{
			return driver.findElement(player2SR); 
		}
		
		public WebElement getBowlerName()
		{
			return driver.findElement(bowlerName); 
		}
		public WebElement getBowlerOver()
		{
			return driver.findElement(bowlerOver); 
		}
		public WebElement getBowlerMaiden()
		{
			return driver.findElement(bowlerMaiden); 
		}
		public WebElement getBowlerRun()
		{
			return driver.findElement(bowlerRun); 
		}
		public WebElement getBowlerWicket()
		{
			return driver.findElement(bowlerWicket); 
		}
		public WebElement getBowlerEco()
		{
			return driver.findElement(bowlerEco); 
		}
		
		
		public WebElement ScoreZero()
		{
			return driver.findElement(scoreZero); 
		}
		public WebElement ScoreOne()
		{
			return driver.findElement(scoreOne); 
		}
		public WebElement ScoreTwo()
		{
			return driver.findElement(scoreTwo); 
		}
		public WebElement ScoreThree()
		{
			return driver.findElement(scoreThree); 
		}
		public WebElement ScoreFour()
		{
			return driver.findElement(scoreFour); 
		}
		public WebElement ScoreFive()
		{
			return driver.findElement(scoreFive); 
		}
		public WebElement ScoreSix()
		{
			return driver.findElement(scoreSix); 
		}
		public WebElement ScoreSeven()
		{
			return driver.findElement(scoreSeven); 
		}
		public WebElement ScoreEight()
		{
			return driver.findElement(scoreEight); 
		}

		public WebElement getRecentBalls() {
			return driver.findElement(recentBalls);
		}

		public WebElement ExtraWideNoBall() {
			return driver.findElement(extraWideNoBall);
		}
		public WebElement ExtraByeLegBye() {
			return driver.findElement(extraByeLegBye);
		}

		public WebElement WicketButton() {
			return driver.findElement(wicketBtn);
		}
		
		public WebElement UndoButton() {
			return driver.findElement(undo);
		}
		public WebElement BoundaryCheckBox() {
			return driver.findElement(isBoundary);
		}
		public WebElement RetiredHurtButton() {
			return driver.findElement(retiredHurtBtn);
		}
		public WebElement PenaltyButton() {
			return driver.findElement(penaltyBtn);
		}
		public WebElement InningCompletedCheckBox() {
			return driver.findElement(isInningCompleted);
		}
		public WebElement SuperOverCheckBox() {
			return driver.findElement(isSuperOver);
		}
		
		public WebElement TiedCheckBox() {
			return driver.findElement(isTied);
		}
		
		public WebElement MaidenOverCheckBox() {
			return driver.findElement(maidenOver);
		}
		
		public WebElement CenturyCheckBox() {
			return driver.findElement(century);
		}
		
		public WebElement HalfCenturyCheckBox() {
			return driver.findElement(halfCentury);
		}
		public WebElement ApproveLastBallButton() {
			return driver.findElement(approveLastBall);
		}
		
		public WebElement editLastBallButton() {
			return driver.findElement(editLastBall);
		}
		
		public WebElement SubmitScoreButton() {
			return driver.findElement(submitScore);
		}
		
		public WebElement DlsAppliedButton() {
			return driver.findElement(dlsApplied);
		}
		
		public WebElement BreakButton() {
			return driver.findElement(breakBtn);
		}
		
		public WebElement MatchCompletedButton() {
			return driver.findElement(matchCompletedBtn);
		}
		
		public WebElement ConfirmButton()
		{
			return driver.findElement(confirmbutton); 
		}
		
}
