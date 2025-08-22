package steps;

import io.cucumber.java.en.Given;

public class Search  {


    @Given("^I visit the website$")
    public void i_visit_the_website() {
        System.out.println("this is test");
    }

    @Given("^I will use (.+) and (.+) to login$")
    public void I_will_use_username_and_password_to_login(String userName, String pwd){
        System.out.println("username is " + userName  + pwd);

    }

}
