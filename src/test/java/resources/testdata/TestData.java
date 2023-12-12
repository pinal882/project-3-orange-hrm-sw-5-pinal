package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "userTest")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Admin", "Admin", "Paul  Collings ", "Enable"},
                {"Cassidy.Hope", "ESS", "Cassidy Hope", "Enable"},
                {"Nina.Patel", "ESS", "Nina Patel", "Enable"},
                {"Odis.Adalwin", "Admin", "Odis Adalwin", "Enable"}

        };
        return data;
    }
    @DataProvider(name = "loginTest")
    public Object[][] loginTest() {
        Object[][] data = new Object[][]{
                {"username","","test123@gmail.com","","test123@gmail.com"},
                {"password","","","test123","test123"},
                {"errorMessage","Required","Required","Required","Invalid credentials"}
        };
        return data;
        }
}
