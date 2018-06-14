package ostbahn.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Notification {

    private String type;

    private String text;

    private Long time;

    public Notification(){
        time = System.currentTimeMillis();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
