package com.expenses.valueobjects;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name= "expenses")
public class ExpensesVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long expenseID;

//    @Column(name="expense_date", columnDefinition="DATE") PREGUNTAR
    private LocalDate expenseDate;

//    @Column(name="expense_time", columnDefinition="TIME")
    private LocalTime expenseTime;

    private String expenseType = ExpensesTypes.OTHERS.getExpenseType();
    private String expenseDescription;
    private long quantity;
    private float unitPrice;

    public ExpensesVO() {
    }

    public long getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(long expenseID) {
        this.expenseID = expenseID;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public LocalTime getExpenseTime() {
        return expenseTime;
    }

    public void setExpenseTime(LocalTime expenseTime) {
        this.expenseTime = expenseTime;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}

