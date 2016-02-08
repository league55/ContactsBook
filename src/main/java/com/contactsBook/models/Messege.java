package com.contactsBook.models;

import java.util.Date;

/**
 * Created by mixmax on 06.02.16.
 */
public class Messege {

    private Date time = new Date();
    private Contact sender;
    private Contact acceptor;
    private String content;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Contact getSender() {
        return sender;
    }

    public void setSender(Contact sender) {
        this.sender = sender;
    }

    public Contact getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(Contact acceptor) {
        this.acceptor = acceptor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messege messege1 = (Messege) o;

        if (!time.equals(messege1.time)) return false;
        if (sender != null ? !sender.equals(messege1.sender) : messege1.sender != null) return false;
        if (acceptor != null ? !acceptor.equals(messege1.acceptor) : messege1.acceptor != null) return false;
        return content.equals(messege1.content);

    }

    @Override
    public int hashCode() {
        int result = time.hashCode();
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (acceptor != null ? acceptor.hashCode() : 0);
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Messege{" +
                "time=" + time +
                ", sender=" + sender +
                ", acceptor=" + acceptor +
                ", content='" + content + '\'' +
                '}';
    }
}
