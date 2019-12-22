package com.gyf.bookstore.model;

import java.util.Date;


public class Outlist
{
    private String abookId;

    private Integer userId;

    private Date borrowDate;

    public String getAbookId()
    {
        return abookId;
    }

    public void setAbookId(String abookId)
    {
        this.abookId = abookId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Date getBorrowDate()
    {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate)
    {
        this.borrowDate = borrowDate;
    }
}
