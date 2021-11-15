import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Bot {
	ChromeDriver driver;
	int renderPointer=1;		//fixa
	int downloadPointer=1;
	int deletePointer=1;
	int startingDownloadPos=1;
	JavascriptExecutor js;
	int folderNumber=0;
	public Bot(int folderNumber) {
		this.folderNumber=folderNumber;
		String downloadFilepath = ""; //insert download location
	    Map<String, Object> preferences = new Hashtable<String, Object>();
	    preferences.put("profile.default_content_settings.popups", 0);
	    preferences.put("download.default_directory", downloadFilepath);
	    ChromeOptions options = new ChromeOptions();
	    options.setExperimentalOption("prefs", preferences);
		System.setProperty("webdriver.chrome.driver", "");	//insert chromedriver location
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}

	public void setup() {				
		driver.manage().window().maximize();		//debug
		driver.navigate().to("https://creators.aiva.ai/");	
		driver.findElementByXPath("//*[@id=\"login-window\"]/div[2]/input").click();
		driver.switchTo().activeElement().sendKeys("");	//insert mail
		driver.findElementByXPath("//*[@id=\"button-container\"]/div").click();
		driver.switchTo().activeElement().sendKeys("");	//insert psw
		driver.findElementByXPath("//*[@id=\"button-container\"]/div").click();	//end login
		try {
			driver.findElementByXPath("/html/body/div/div[2]/div/a/span[1]/span/span/span/span[1]/span/span[1]").click();
		}
		catch(Exception e) {
			System.out.println("finestra di merda non presente, godo");
		}
		driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div[1]/div/div[6]").click();		//start going in the right directory
		driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[3]/div[1]").click();
		driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div["+Integer.toString(folderNumber)+"]/div/div[6]").click();
		driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[3]/div[1]").click();		//arrived nel regno
	}
	
	public void createTracks(int number, int macroGen, int keySign, int pacing, int instrumentation, int duration) {
		String numberAdd=null, macroGenAdd=null, keySignAdd=null, pacingAdd=null, instrumentationAdd=null, durationAdd=null;
		String numberAddC=null, keySignAddC=null, pacingAddC=null, instrumentationAddC=null, durationAddC=null;
		macroGenAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div[2]/div/div[1]/div["+Integer.toString(macroGen+1)+"]/div[1]";
		switch (macroGen){
		case 0:	
			keySignAdd="";
			keySignAddC="2]/div["+Integer.toString(keySign+1)+"]"; 
			pacingAdd="";
			pacingAddC="2]/div["+Integer.toString(pacing+1)+"]";
			instrumentationAdd="";
			instrumentationAddC="2]/div["+Integer.toString(instrumentation+1)+"]";
			durationAdd="";
			durationAddC="2]/div["+Integer.toString(duration+1)+"]";
			numberAdd="";
			numberAddC="2]/div["+Integer.toString(number+1)+"]";
			break;
		case 1:
			break;
		case 2:	
			break;
		case 3: 
			break;
		case 4:	//fantasy
			keySignAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[1]";
			keySignAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[2]/div["+Integer.toString(keySign+1)+"]";
			pacingAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[1]";
			pacingAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[2]/div["+Integer.toString(pacing+1)+"]"; 
			instrumentationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[1]";
			instrumentationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[2]/div["+Integer.toString(instrumentation+1)+"]";
			durationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[1]";
			durationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[2]/div["+Integer.toString(duration+1)+"]";
			numberAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[5]/div/div[1]";
			numberAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[5]/div/div[2]/div["+Integer.toString(number+1)+"]";
			break;
		case 5:	//pop
			keySignAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[1]";
			keySignAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[2]/div["+Integer.toString(keySign+1)+"]";
			pacingAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[1]";
			pacingAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[2]/div["+Integer.toString(pacing+1)+"]"; 
			instrumentationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[1]";
			instrumentationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[2]/div["+Integer.toString(instrumentation+1)+"]";
			durationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[1]";
			durationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[2]/div["+Integer.toString(duration+1)+"]";
			numberAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[5]/div/div[1]";
			numberAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[5]/div/div[2]/div["+Integer.toString(number+1)+"]";
			break;
		case 6: //rock
			keySignAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[1]/div[1]/div[1]";
			keySignAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[1]/div[1]/div[2]/div["+Integer.toString(keySign+1)+"]";
			pacingAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[2]/div/div[1]";
			pacingAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[2]/div/div[2]/div["+Integer.toString(pacing+1)+"]";
			instrumentationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[3]/div/div[1]";
			instrumentationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[3]/div/div[2]/div["+Integer.toString(instrumentation+1)+"]";
			durationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[4]/div/div[1]";
			durationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[4]/div/div[2]/div["+Integer.toString(duration+1)+"]";
			numberAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[5]/div/div[1]";
			numberAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[3]/div[5]/div/div[2]/div["+Integer.toString(number+1)+"]";
			break;
		case 9: //electronic
			keySignAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[1]";
			keySignAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[2]/div["+Integer.toString(keySign+1)+"]"; 
			pacingAdd=null;
			pacingAddC=null;
			instrumentationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[1]";
			instrumentationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[2]/div["+Integer.toString(instrumentation+1)+"]";
			durationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[1]";
			durationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[2]/div["+Integer.toString(duration+1)+"]";
			numberAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[1]";
			numberAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[2]/div["+Integer.toString(number+1)+"]";
			break;
		case 10: //ambient
			keySignAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[1]/div[1]";
			keySignAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[1]/div[2]/div["+Integer.toString(keySign+1)+"]"; 
			pacingAdd=null;
			pacingAddC=null;
			instrumentationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[1]";
			instrumentationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[2]/div/div[2]/div["+Integer.toString(instrumentation+1)+"]";
			durationAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[1]";
			durationAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[3]/div/div[2]/div["+Integer.toString(duration+1)+"]";
			numberAdd="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[1]";
			numberAddC="/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[2]/div[4]/div/div[2]/div["+Integer.toString(number+1)+"]";
			break;
		}
		driver.findElementByXPath("//*[@id=\"track-view\"]/div[2]/div[2]").click();		//create new track
		driver.findElementByXPath(macroGenAdd).click();
		Actions action= new Actions(driver);
		WebElement category,selected;
		category=driver.findElementByXPath(keySignAdd);
		action.moveToElement(category).perform();
		selected=driver.findElementByXPath(keySignAddC);
		action.moveToElement(selected).click().perform();
		if(pacingAdd!=null) {
			category=driver.findElementByXPath(pacingAdd);
			action.moveToElement(category).perform();
			selected=driver.findElementByXPath(pacingAddC);
			action.moveToElement(selected).click().perform();
		}
		category=driver.findElementByXPath(instrumentationAdd);
		action.moveToElement(category).perform();
		selected=driver.findElementByXPath(instrumentationAddC);
		action.moveToElement(selected).click().perform();
		category=driver.findElementByXPath(durationAdd);
		action.moveToElement(category).perform();
		selected=driver.findElementByXPath(durationAddC);
		action.moveToElement(selected).click().perform();
		category=driver.findElementByXPath(numberAdd);
		action.moveToElement(category).perform();
		selected=driver.findElementByXPath(numberAddC);
		action.moveToElement(selected).click().perform();
		WebElement submit= driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/preset-component/div/div[5]");
		action.moveToElement(submit).click().perform();	
	}
	public void renderTracks() {
		String downloadF="/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div[2]/div[";
		String downloadS="]/div/div[8]";
		String downloadUpdated=null;
		Actions action= new Actions(driver);	//testing
		boolean flagStop=true;
		while(flagStop) {
			try {		//render
				downloadUpdated=downloadF+Integer.toString(renderPointer)+downloadS;
				action.moveToElement(driver.findElementByXPath(downloadUpdated)).perform();
				driver.findElementByXPath(downloadUpdated).click();
				driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/div[3]/div[1]/div[10]").click();
				renderPointer++;
			}
			catch(Exception e) {
				flagStop=false;
				System.out.println("render completato o era già stato effettuato, fatto fino a: "+renderPointer);
			}
		}
	}
	public int downloadAllWav(boolean pnc,boolean afterCleaning) {		//pnc clicca sulla modifica del nome nella fase di download
		startingDownloadPos=downloadPointer;
		String downloadF="/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div[2]/div[";
		String downloadS="]/div/div[8]";
		String downloadUpdated=null;
		int downloaded=0;
		boolean flagStop=true;
		Actions action= new Actions(driver);	//testing
		while(flagStop) {
			try {		//download
				downloadUpdated=downloadF+Integer.toString(downloadPointer)+downloadS;
				action.moveToElement(driver.findElementByXPath(downloadUpdated)).perform();
				driver.findElementByXPath(downloadUpdated).click();
				if(pnc) {
					driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/div[3]/div[3]/input").click();
					pnc=false;
				}
				driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/div[3]/div[1]/div[5]").click();
				downloadPointer++;
				downloaded++;
			}
			catch(Exception e) {
				flagStop=false;
				System.out.println("download effettuato o render in corso, effettuato fino a: "+downloadPointer);
				e.printStackTrace();
			}
		}
		if(afterCleaning) {
			afterDownloadCleaning(startingDownloadPos,downloadPointer);
		}	
		return downloaded;
	}
	
	public void afterDownloadCleaning(int posStart, int posEnd) {
		Actions action= new Actions(driver);	//testing
		String option="/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div[2]/div[1]/div/div[7]";
		for(int i=posStart;i<posEnd;i++) {
			action.moveToElement(driver.findElementByXPath(option)).perform();
			driver.findElementByXPath(option).click();
			driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[3]/div/div[9]").click();
			driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/div[5]").click();
			renderPointer--;
			downloadPointer--;
			System.out.println("eliminata una canzone");
		}
	}
	public boolean possibleNewRender() {
		if(renderPointer>downloadPointer)	return true;
		else return false;
	}
	public void deleteAllSong(){
		int eliminated=0;
		Actions action= new Actions(driver);	//testing
		String option="/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div[2]/div[1]/div/div[7]";
		boolean flagStop=true;
		try {
			while(flagStop) {
				action.moveToElement(driver.findElementByXPath(option)).perform();
				driver.findElementByXPath(option).click();
				driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[3]/div/div[9]").click();
				driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/div[5]").click();
				eliminated++;
			}
		}
		catch(Exception e) {
			System.out.println("canzoni eliminate: "+eliminated);
			e.printStackTrace();
		}
	}
	
	public int eliminateXSongs(int number) {
		int eliminated=0;
		Actions action= new Actions(driver);	//testing
		boolean flagStop=true;
		String option="/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[1]/div[2]/div[1]/div/div[7]";
		action.moveToElement(driver.findElementByXPath(option)).perform();
		try {
			while(flagStop) {
				driver.findElementByXPath(option).click();
				driver.findElementByXPath("/html/body/app-root/div/div/app-mytracks/div/div/div[2]/div/tracks-list/div[3]/div/div[9]").click();
				driver.findElementByXPath("/html/body/app-root/div/app-modals/div/div[2]/div[5]").click();
				eliminated++;
				if (eliminated==number) {
					throw new Exception();
				}
				Thread.sleep(100);
			}
		}
		catch(Exception e) {
			System.out.println("canzoni eliminate: "+eliminated);
			e.printStackTrace();
		}
		return eliminated;
	}
}

