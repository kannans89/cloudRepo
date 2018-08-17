package com.techlabs.paresh.expensemanager;

public class Expense {

    String date, description,category;
    int amount,id;

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setId(int id) {
        this.id = id;
    }


    public Expense(String date, int amount, String description, String category,int id){
        this.date=date;
        this.amount=amount;
        this.description=description;
        this.category=category;
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getAmount() {
        return ("Rs."+String.valueOf(amount));
    }
    public String getId() {
        return (String.valueOf(id));
    }
}
