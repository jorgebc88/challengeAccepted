package com.expenses.service;

import com.expenses.dao.ExpensesDao;
import com.expenses.valueobjects.ExpensesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpensesService {

    @Autowired
    private ExpensesDao expensesDao;

    public boolean insertExpense(ExpensesVO expensesVO){
        return this.expensesDao.insertExpense(expensesVO);
    }

    public List<ExpensesVO> getExpensesByType(String type) {
        return this.expensesDao.getExpensesByType(type);
    }

    public List<ExpensesVO> getExpenses() {
        return this.expensesDao.getExpenses();
    }

    public List<ExpensesVO> getExpensesByDate(LocalDate date) {
        return this.expensesDao.getExpensesByDate(date);
    }

    public boolean modifyExpense(long id, ExpensesVO expensesVO) {
        return this.expensesDao.modifyExpense(id,expensesVO);
    }

    public boolean deleteExpense(long id) {
        return this.expensesDao.deleteExpense(id);
    }
}
