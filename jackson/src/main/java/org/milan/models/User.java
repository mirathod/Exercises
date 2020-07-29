package org.milan.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.milan.handlers.DateHandler;

import java.util.Date;

/**
 * Pojo of User
 *
 * @author Milan Rathod
 */
public class User {

    private String username;

    private String name;

    private long number;

    @JsonDeserialize(using = DateHandler.class)
    private Date birthDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", birthDate=" + birthDate +
                '}';
    }
}
