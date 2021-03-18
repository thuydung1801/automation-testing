package autoTest.model;


public class Statistic {
    private int smileCount;
    private int viewCount;
    private int onlineFavouriteCount;

    public Statistic (int smileCount, int viewCount, int onlineFavouriteCount) {
        this.smileCount = smileCount;
        this.viewCount = viewCount;
        this.onlineFavouriteCount = onlineFavouriteCount;
    }

    public int getSmileCount() {
        return smileCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getOnlineFavouriteCount() {
        return onlineFavouriteCount;
    }
}
