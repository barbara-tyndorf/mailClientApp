package pl.sda.model;

import java.time.LocalDateTime;

public class EmailHistory {

    private LocalDateTime sentTime;
    private String receiver;
    private String subject;
    private String content;

    public EmailHistory() {
        sentTime = LocalDateTime.now();
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailHistory{" +
                "sentTime=" + sentTime +
                ", receiver='" + receiver + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
