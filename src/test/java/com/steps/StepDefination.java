package com.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class StepDefination {

	WebDriver driver;

	@Given("User is in Gmail")
	public void user_is_in_Gmail() {

		System.setProperty("webdriver.chrome.driver",
				"F:\\Gurava Reddy\\Selenium\\EclipsePractice\\CucumberPractice\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String url = "https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession&TL=APDPHBBcJ6-xSPXOvdgAlOe68DlcIBK-EjLaqKA6ast2h2nu5Xi7-WF2Sklw8bws";

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	@When("User enters mail and click next")
	public void user_enters_mail_and_click_next() {

		driver.findElement(By.id("identifierId")).sendKeys("xxxxxx@gmail.com");

		driver.findElement(By.className("CwaK9")).click();

	}

	@When("User enters password and click next")

	public void user_enters_password_and_click_next() {

		driver.findElement(By.name("password")).sendKeys("xxxxxxxx");
		driver.findElement(By.xpath("(//span[@class=\"RveJvd snByac\"])[1]")).click();

	}

	@When("User eneters Recepient address")
	public void user_eneters_Recepient_address(io.cucumber.datatable.DataTable data) throws InterruptedException {

		List<String> l1 = data.asList();

		for (int i = 0; i < l1.size(); i++) {

			WebElement compose = driver.findElement(By.className("z0"));

			compose.click();

			driver.findElement(By.className("vO")).sendKeys(l1.get(i));

			driver.findElement(By.name("subjectbox")).sendKeys("hi");

			driver.findElement(By.xpath("//div[@aria-label=\"Message Body\"]")).sendKeys("Hello, Welcome");

			Thread.sleep(15000);

			driver.findElement(By.xpath("//div[@data-tooltip=\"Send ‪(Ctrl-Enter)‬\"]")).click();

			Thread.sleep(15000);

			System.out.println("Sent mail : " + i);

		}

		driver.findElement(By.xpath("(//span[@aria-hidden=\"true\"])[2]")).click();

		driver.findElement(By.id("gb_71")).click();
	}

}
