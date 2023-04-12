package core;

import org.slf4j.Logger;

import java.net.MalformedURLException;

public class BasePage {
    private static Logger logger = LogHelper.getLogger();
    protected KeywordWeb keyword;
    public BasePage() throws MalformedURLException {
        keyword = new KeywordWeb();

    }
    public BasePage(KeywordWeb keyword) {
        this.keyword = keyword;
    }
}
