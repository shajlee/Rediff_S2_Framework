package com.rediff.S2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_LinksPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[@class='mailicon']")
	private WebElement rediffMailLink;
	
	@FindBy(xpath = "//div[@class='logtext']")
	private WebElement rediffMailLogo;
	
	@FindBy(xpath = "//div[@class='cell topicons']/child::a[1]/following-sibling::a[1]")
	private WebElement rediffMoneyLink;
	
	@FindBy(xpath = "//span[text()='Rediff Moneywiz']")
	private WebElement rediffMoneyLogo;
	
	@FindBy(css = "a.bmailicon.relative")
	private WebElement rediffBusinessMailLink;
	
	@FindBy(xpath = "//a[@class='logo']/child::img")
	private WebElement rediffBusinessMailLogo;
	
	@FindBy(className = "vdicon")
	private WebElement rediffVideoLink;
	
	@FindBy(css = "img.othersprite.isharelogo")
	private WebElement rediffVideoLogo;
	
	@FindBy(css = "a.guruicon.relative")
	private WebElement rediffGuruLink;
	
	@FindBy(css = "img.vbottom")
	private WebElement rediffGuruLogo;
	
	public S2_LinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnRediffMailLink() {
		rediffMailLink.click();
	}
	public WebElement rediffMailLogo() {
		return rediffMailLogo;
	}
	public boolean rediffMailLogoIsDisplayed() {
		boolean displayStatus = rediffMailLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffMoneyLink() {
		rediffMoneyLink.click();
	}
	public WebElement rediffMoneyLogo() {
		return rediffMoneyLogo;
	}
	public boolean rediffMoneyLogoIsDisplayed() {
		boolean displayStatus = rediffMoneyLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffBusinessMailLink() {
		rediffBusinessMailLink.click();
	}
	public WebElement rediffBusinessMailLogo() {
		return rediffBusinessMailLogo;
	}
	public boolean rediffBusinessMailLogoIsDisplayed() {
		boolean displayStatus = rediffBusinessMailLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffVideoLink() {
		rediffVideoLink.click();
	}
	public WebElement rediffVideoLogo() {
		return rediffVideoLogo;
	}
	public boolean rediffVideoLogoIsDisplayed() {
		boolean displayStatus = rediffVideoLogo.isDisplayed();
		return displayStatus;
	}
	public void clickOnRediffGuruLink() {
		rediffGuruLink.click();
	}
	public WebElement rediffGuruLogo() {
		return rediffGuruLogo;
	}
	public boolean rediffGuruLogoIsDisplayed() {
		boolean displayStatus = rediffGuruLogo.isDisplayed();
		return displayStatus;
		
	}
	
	
	

}
