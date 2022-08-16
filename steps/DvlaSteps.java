package api.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DvlaSteps {
    private WebDriver driver;
    @Given("open the website dvla")
    public void openTheWebsiteDvla() throws Throwable{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://vehicleenquiry.service.gov.uk//");

    }

    @When("enter the correct car registration number")
    public void clickOnStartButton()throws Throwable {
        driver.findElement(By.className("govuk-input--width-10")).sendKeys("LAU21A");
        driver.findElement(By.id("submit_vrn_button")).click();
        Thread.sleep(2000);
    }
    @And("confirm the input")
    public void confirmTheInput() {
        driver.findElement(By.id("yes-vehicle-confirm")).click();
        driver.findElement(By.id("capture_confirm_button")).click();
    }

    @Then("your car history is displayed")
    public void weAreOnNextPage() throws Throwable {
        System.out.println("check for car history");

    }


    @Then("The entered registration number is wrong")
    public void theEnteredRegistrationNumberIsWrong() {
        WebElement linkText = driver.findElement(By.partialLinkText("There is a problem"));

        if(linkText.isDisplayed())
        {
            System.out.println("the registration number in incorrect");
        }

    }

    @When("enter the incorrect car registration number")
    public void enterTheIncorrectCarRegistrationNumber() throws Throwable {
        driver.findElement(By.className("govuk-input--width-10")).sendKeys("LAUA");
        driver.findElement(By.id("submit_vrn_button")).click();
        Thread.sleep(2000);
    }

    @When("Check does the link open")
    public void checkDoesTheLinkOpen() {
        WebElement linkText = driver.findElement(By.linkText("Enter the registration number of the vehicle"));
    }

    @Then("link is active")
    public void linkIsActive() {
        System.out.println("The link is up and running");
    }
}