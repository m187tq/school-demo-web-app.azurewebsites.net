package pageObjects;

import helper.assertion.VerificationHelper;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UsersPage extends BasePage {
    public static Logger log = LoggerHelper.getLogger(UsersPage.class);
    @FindBy(id = "[class='display-4']")
    public WebElement userListTxt;
    @FindBy(xpath = "//tbody/tr/td/a")
    public List<WebElement> editUserButtons;
    EditUsersPage editUsersPage = new EditUsersPage();
    @FindBy(css = "#FirstName")
    private WebElement firstNameBox;

    @FindBy(css = "#LastName")
    private WebElement lastNameBox;

    @FindBy(css = "#SelectedSchoolId")
    private WebElement schoolOptionDropDown;

    @FindBy(css = "#SelectedUserTypeId")
    private WebElement userTypeOptionDropDown;

    @FindBy(css = "#SelectedYearGroupId")
    private WebElement yearGroupOptionDropDown;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement searchUserBtn;

    @FindBy(css = "//tbody/tr/td[1]")
    private List<WebElement> firstColumnTableSearchResult;

    @FindBy(linkText = "Create User")
    private WebElement createUserBtn;
    @FindBy(css = "#userResults")
    private WebElement userResultSearch;
    @FindBy(xpath = "//div[@id='userResults'] //tbody/tr[1]/td[5]/a[1]")
    private WebElement userEditBtn;
    @FindBy(xpath = "//tbody/tr")
    private WebElement rowResultSearchTable;
    @FindBy(xpath = ".page-item")
    private List<WebElement> viewListButtons;
    @FindBy(xpath = "//*[@id=\"userResults\"]/thead/tr/th")
    private List<WebElement> userResultTableHeadings;
    @FindBy(xpath = "//*[@id=\"userResults\"]/thead/tr/th/a")
    private List<WebElement> resultTableHeadingsTextList;
    @FindBy(xpath = "//*[@id=\"userResults\"]/tbody/tr/td[1]")
    private List<WebElement> firstNameList;
    @FindBy(xpath = "//*[@id=\"userResults\"]/tbody/tr/td[2]")
    private List<WebElement> lastNameList;
    @FindBy(xpath = "//*[@id=\"userResults\"]/tbody/tr/td[3]")
    private List<WebElement> schoolNameList;
    @FindBy(xpath = "//*[@id=\"userResults\"]/tbody/tr/td[4]")
    private List<WebElement> yearGroupList;
    @FindBy(css = "th:nth-child(1)")
    private WebElement firstName_sr;
    @FindBy(css = "th:nth-child(2)")
    private WebElement lastName_sr;
    @FindBy(css = "th:nth-child(3)")
    private WebElement schoolName_sr;
    @FindBy(css = "th:nth-child(4)")
    private WebElement yearGroup_sr;
    @FindBy(xpath = "//*[@id=\"userResults\"]/tbody/tr/td")
    private List<WebElement> userResultTableList;
    @FindBy(css = "li.pagination")
    private WebElement paginationList;
    @FindBy(css = ".page-link")
    private List<WebElement> page_Links;

    public UsersPage() throws IOException {
        super();
    }

    public void resultTableHeadingsList() {
        List<WebElement> resultHeaderList = this.resultTableHeadingsTextList;

        for (int i = 0; i <= resultHeaderList.size() - 1; i++) {
            String firstNameText = resultHeaderList.get(i).getText();
            boolean displayedHeaders = resultHeaderList.get(i).isDisplayed();

            if (resultHeaderList.get(i).isDisplayed()) {
                System.out.println(firstNameText);
                System.out.println(displayedHeaders);
                System.out.println("=====================");
            }
        }

    }

    public void resultTableHeadingsCountAndIsDisplayed() {
        int sizeEle = this.getUserResultTableHeadings().size();
        for (int i = 0; i <= sizeEle - 1; i++) {
            String text = this.getUserResultTableHeadings().get(i).getText();
            boolean displayedText = this.getUserResultTableHeadings().get(i).isDisplayed();
            if (getUserResultTableHeadings().get(i).isDisplayed()) {
                System.out.println("Count of Searched result " + sizeEle);
                System.out.println("List Of Search items displayed: " + text);
                System.out.println("displayed texts: " + displayedText);

            }

        }

    }

    public List<WebElement> getUserResultTableList() {
        return userResultTableList;
    }

    public boolean validateUserListTxtIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(userListTxt);
    }

    public void inputFirstNameBox(String firstName) throws Exception {
        log.info("Entered text :" + firstName);
        sendKeysToWebElement(firstNameBox, firstName);
    }

    public void inputLastNameBox(String lastName) throws Exception {
        log.info("Entered text :" + lastNameBox);
        sendKeysToWebElement(lastNameBox, lastName);
    }

    public void selectSchoolOptionDropDown(String arg0) {
        log.info("selecting school options....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
    }

    public void selectUserTypeOptionDropDown(String arg0) {
        log.info("selecting users type options....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
    }

    public void selectYearGroupOptionDropDown(String arg0) {
        log.info("selecting users type options....");
        WebElement ele = getDriver().findElement(By.xpath("//option[contains(text(),'" + arg0 + "')]"));
        ele.click();
    }

    public void clickOnSearchUserBtn() {
        waitAndClickElement(searchUserBtn);
    }

    public boolean validateSearchUserBtnIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(searchUserBtn);
    }

    public WebElement getCreateUserBtn() {
        return createUserBtn;
    }

    public boolean validateCreateUserBtnIsDisplayed() {
        return new VerificationHelper(getDriver()).isDisplayed(createUserBtn);
    }

    public void clickOnCreateUserBtn() {
        waitAndClickElement(createUserBtn);
    }

    public WebElement getUserResultSearch() {
        return userResultSearch;
    }

    public WebElement getRowResultSearchTable() {
        return rowResultSearchTable;
    }

    public List<WebElement> getViewListButtons() {
        return viewListButtons;
    }

    public List<WebElement> getUserResultTableHeadings() {
        return userResultTableHeadings;
    }

    public void clickOnEditButton() throws InterruptedException {
        userEditBtn.click();
    }

    public List<WebElement> getPage_Links() {
        return page_Links;
    }

    public WebElement getPaginationList() {
        return paginationList;
    }


    public List<WebElement> getFirstColumnTableSearchResult() {
        return firstColumnTableSearchResult;
    }

    public void clickAndValidateOnFirstNameSearchReport() {
        // click on column
        waitForWebElementAndClick(firstName_sr);
        // capture all webElements into list
        List<WebElement> elementsList = this.firstNameList;
        // capture text of all webElements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);

    }

    public void clickAndValidateOnLastNameSearchReport() {
        // click on column
        waitForWebElementAndClick(lastName_sr);
        // capture all webElements into list
        List<WebElement> elementsList = this.lastNameList;
        // capture text of all webElements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);

    }

    public void clickAndValidateOnSchoolNameSearchReport() {
        // click on column
        waitForWebElementAndClick(schoolName_sr);
        // capture all webElements into list
        List<WebElement> elementsList = this.schoolNameList;
        // capture text of all webElements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);

    }

    public void clickAndValidateOnYearGroupSearchReport() {
        // click on column
        waitForWebElementAndClick(yearGroup_sr);
        // capture all webElements into list
        List<WebElement> elementsList = this.yearGroupList;
        // capture text of all webElements into new(original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        // sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);

    }


    public void readSearchTableResult() throws InterruptedException {
        List<WebElement> sub_links = getDriver().findElements(By.cssSelector(".page-item"));
        ;
        System.out.println("Total numbers of Paging links: " + sub_links.size());
        if (sub_links.size() > 0) {
            System.out.println("some links are present......");
            for (int i = 1; i < sub_links.size(); i++) {

                int rows = getDriver().findElements(By.xpath("//tbody/tr")).size();
                System.out.println("number of row displayed......" + rows);
                for (int r = 1; r < sub_links.size(); r++) {
                    Thread.sleep(2000);
                    String col1 = getDriver().findElement(By.xpath("//tbody/tr[" + r + "]/td[1]")).getText();
                    String col2 = getDriver().findElement(By.xpath("//tbody/tr[" + r + "]/td[2]")).getText();
                    String col3 = getDriver().findElement(By.xpath("//tbody/tr[" + r + "]/td[3]")).getText();
                    String col4 = getDriver().findElement(By.xpath("//tbody/tr[" + r + "]/td[4]")).getText();
                    String col5 = getDriver().findElement(By.xpath("//tbody/tr[" + r + "]/td[5]")).getText();
                    System.out.println(col1 + " " + col2 + " " + col3 + " " + col4 + " " + col5);
                }
            }
        } else {
            System.out.println("links are not present......");
        }
    }

}
