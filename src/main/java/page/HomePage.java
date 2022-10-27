package page;

import core.BasePage;
import core.KeywordWeb;
import core.LogHelper;
import core.PropertiesFile;
import org.slf4j.Logger;

public class HomePage extends BasePage {
    private static Logger logger = LogHelper.getLogger();
    public HomePage(){ super(); }
    public HomePage(KeywordWeb key){
        super(key);
    }
    public void gotoElementMenu(){
        keyword.click(PropertiesFile.getPropValue("BTN_HOME_ELEMENTS"));
    }
}
