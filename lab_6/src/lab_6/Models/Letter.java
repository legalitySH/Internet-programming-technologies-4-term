package lab_6.Models;

import java.util.Date;

public class Letter {

    private int id;
    private int senderId;
    private int recipientId;
    private String subject;
    private String body;
    private Date sentDate;

    public Letter(int id, int senderId, int recipientId, String subject, String body, Date sentDate)
    {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.subject = subject;
        this.body = body;
        this.sentDate = sentDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }
}
