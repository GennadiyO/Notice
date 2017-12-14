package sample;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoticeDetails {
    private StringProperty notice;
    private StringProperty date;

    public NoticeDetails(String notice, String date) {
        this.notice = new SimpleStringProperty(notice);
        this.date = new SimpleStringProperty(date);
    }

    public String getNotice() {
        return notice.get();
    }

    public StringProperty noticeProperty() {
        return notice;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setNotice(String notice) {
        this.notice.set(notice);
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
