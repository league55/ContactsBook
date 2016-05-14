package com.contactsBook.models;

import java.util.Date;

/**
 * Created by mixmax on 06.02.16.
 */
public class Messege1 {

    private Date time = new Date();

    private String content;
    private Long senderId, recieverID;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverID;
    }

    public void setRecieverID(Long recieverID) {
        this.recieverID = recieverID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messege1 messege = (Messege1) o;

        if (time != null ? !time.equals(messege.time) : messege.time != null) return false;
        if (content != null ? !content.equals(messege.content) : messege.content != null) return false;
        if (senderId != null ? !senderId.equals(messege.senderId) : messege.senderId != null) return false;
        return recieverID != null ? recieverID.equals(messege.recieverID) : messege.recieverID == null;

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recieverID != null ? recieverID.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Messege{" +
                "time=" + time +
                ", content='" + content + '\'' +
                ", senderId=" + senderId +
                ", recieverID=" + recieverID +
                '}';
    }
}
