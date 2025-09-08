package dataprovider;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class DataProviders {

    @DataProvider(name = "TrainData")
    public Object[][] getTrainData() {
        String filePath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1"); // Sheet1 with FromStation, ToStation
        return ExcelUtils.getTestData();
    }
}
