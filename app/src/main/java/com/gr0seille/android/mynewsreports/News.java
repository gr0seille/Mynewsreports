package com.gr0seille.android.mynewsreports;


public class News {
    private String webUrl;
    private String sectionName;
    private String webTitle;
    private String webPublicationDate;

    public News(String webUrl, String sectionName, String webTitle, String webPublicationDate) {
        this.webUrl = webUrl;
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.webPublicationDate = webPublicationDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }
}