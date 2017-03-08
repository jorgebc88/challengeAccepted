package com.expenses.repositories;

import com.expenses.valueobjects.ExpensesVO;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<ExpensesVO, Long> {

    List<ExpensesVO> findByExpenseType (String expenseType);

    List<ExpensesVO> findByExpenseDate (LocalDate expenseDate);

}
