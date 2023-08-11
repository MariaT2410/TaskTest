package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Главная страница */
public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement inputUserEmail;

    @FindBy(xpath = "//div/label[@for='gender-radio-1']")
    private WebElement inputGenderMale;

    @FindBy(xpath = "//div/label[@for='gender-radio-2']")
    private WebElement inputGenderFemale;

    @FindBy(xpath = "//div/label[@for='gender-radio-3']")
    private WebElement inputGenderOther;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement inputUserNumber;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//div[@id='dateOfBirth']//div[text()='10']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//div/label[@for='hobbies-checkbox-1']")
    private WebElement checkboxSports;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']")
    private WebElement checkboxReading;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-3']")
    private WebElement checkboxMusic;

    @FindBy(xpath = "//div[@id='state']")
    private WebElement stateDrop;

    @FindBy(xpath = "//div[@id='state']//div[@id='react-select-3-option-0']")
    private WebElement stateDropDown;

    @FindBy(xpath = "//div[@id='city']")
    private WebElement cityDrop;

    @FindBy(xpath = "//div[@id='city']//div[@id='react-select-4-option-0']")
    private WebElement cityDropDown;

    private WebElement button = driver.findElement(By.className("button"));

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement currentState;


    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Создать пользователя")
    public MainPage createUser(String firstname, String lastName, String mobile) throws InterruptedException {
        setInputFirstName(firstname);
        setInputLastName(lastName);
        setInputUserNumber(mobile);
        clickGenderFemale();
        dateOfBirthInput.click();
        dateOfBirth.click();
        clickHobbiesReading();
        selectStateFromList();
        selectCityFromList();
        clickOnSubmitButton();
        return this;
    }

    @Step("Ввести имя: {text}")
    private void setInputFirstName(String text) {
        try {
            inputFirstName.sendKeys(text);
        }catch (NullPointerException e){}
    }
    @Step("Ввести фамилию: {text}")
    private void setInputLastName(String text) {
        try {
            inputLastName.sendKeys(text);
        }catch (NullPointerException e){}
    }
    @Step("Ввести номер телефона: {text}")
    private void setInputUserNumber(String text) {
        try {
            inputUserNumber.sendKeys(text);
        }catch (NullPointerException e){}
    }
    @Step("Нажать на кнопку")
    private void clickOnSubmitButton() {
        try {
            button.submit();
        }catch (NullPointerException e){}
    }
    @Step("Выбрать Male")
    private void clickGenderMale() {
        try {
            inputGenderMale.isSelected();
        }catch (NullPointerException e){}
    }

    @Step("Выбрать Female")
    private void clickGenderFemale() {
        try {
            inputGenderFemale.isSelected();
            inputGenderFemale.click();
        }catch (NullPointerException e){}
    }

    @Step("Выбрать Other")
    private void clickGenderOther() {
        try {
            inputGenderOther.click();
        }catch (NullPointerException e){}
    }

    @Step("Выбрать хобби музыка")
    private void clickHobbiesMusic() {
        try {
            checkboxMusic.click();
        }catch (NullPointerException e){}
    }

    @Step("Выбрать хобби чтение")
    private void clickHobbiesReading() {
        try {
            checkboxReading.click();
        }catch (NullPointerException e){}
    }


    @Step("Выбрать хобби спорт")
    private void clickHobbiesSport() {
        try {
            checkboxSports.click();

        }catch (NullPointerException e){}
    }


    public void selectStateFromList() {

        Actions actions = new Actions(driver);
        actions.moveToElement(stateDrop).click().build().perform();
        stateDrop.click();
        stateDropDown.isDisplayed();
        stateDropDown.click();
    }

    public void selectCityFromList() {
        if (cityDrop.isDisplayed()){
            cityDrop.click();
            cityDropDown.isDisplayed();
        }
    }
}
