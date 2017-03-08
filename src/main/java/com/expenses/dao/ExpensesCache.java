package com.expenses.dao;

import com.expenses.valueobjects.ExpensesVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpensesCache {

    private List<ExpensesVO> expensesVOList = new ArrayList<>();

    public List<ExpensesVO> getExpensesVOList() {
        return expensesVOList;
    }

    public void setExpensesVOList(List<ExpensesVO> expensesVOList) {
        this.expensesVOList = expensesVOList;
    }

}
