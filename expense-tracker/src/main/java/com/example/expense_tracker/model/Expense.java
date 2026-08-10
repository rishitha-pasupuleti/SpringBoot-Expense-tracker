package com.example.expense_tracker.model;

public class Expense {
    private Long id;
    private String title;
    private double amount;
    private String category;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Expense(double amount, Long id, String title, String category, String date, boolean completed) {
        this.amount = amount;
        this.id = id;
        this.title = title;
        this.category = category;
        this.date = date;
        this.completed = completed;
    }

    private boolean completed;
}