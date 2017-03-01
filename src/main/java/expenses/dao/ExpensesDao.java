package expenses.dao;

import expenses.repositories.ExpenseRepository;
import expenses.valueobjects.ExpensesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpensesDao {

    @Autowired
    private ExpensesCache expensesCache;

    @Autowired
    private ExpenseRepository expenseRepository;

    private static long actualExpenseID = 0;

    public boolean insertExpense(ExpensesVO expensesVO){
        try {
//            this.actualExpenseID++;
//            expensesVO.setExpenseID(this.actualExpenseID);
            expensesVO.setExpenseDate(LocalDate.now());
            expensesVO.setExpenseTime(LocalTime.now());
//            this.expensesCache.getExpensesVOList().add(expensesVO);
            this.expenseRepository.save(expensesVO);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<ExpensesVO> getExpensesByType(String type) {
        List<ExpensesVO> expensesVOList = expenseRepository.findByExpenseType(type);
        return expensesVOList;
    }
//    public List<ExpensesVO> getExpensesByTypeInCache(String type) {
//        List<ExpensesVO> expensesVOList = this.expensesCache.getExpensesVOList().stream().
//                filter(expensesVO -> expensesVO.getExpenseType().equals(type)).collect(Collectors.toList());
//        return expensesVOList;
//    }

    public List<ExpensesVO> getExpenses() {
        Iterable<ExpensesVO> expensesVOIterable = expenseRepository.findAll();
        List<ExpensesVO> expensesVOList = new ArrayList<>();
        expensesVOIterable.iterator().forEachRemaining(expensesVOList::add);

        return expensesVOList;
    }

    public List<ExpensesVO> getExpensesByDate(LocalDate date) {
//        List<ExpensesVO> expensesVOList = this.expensesCache.getExpensesVOList().stream().
//                filter(expenseVO -> expensesVO.getTimeStamp().toLocalDate() == date).collect(Collectors.toList());
        List<ExpensesVO> expensesVOList = this.expenseRepository.findByExpenseDate(date);
        return expensesVOList;
    }

    public boolean modifyExpense(long id, ExpensesVO eVO) {
        try {
            ExpensesVO expense = this.expenseRepository.findOne(id);
            expense.setExpenseType(eVO.getExpenseType());
            expense.setExpenseDescription(eVO.getExpenseDescription());
            expense.setQuantity(eVO.getQuantity());
            expense.setExpenseDate(LocalDate.now());
            expense.setExpenseTime(LocalTime.now());
            expense.setUnitPrice(eVO.getUnitPrice());
            this.expenseRepository.save(expense);
        } catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteExpense(long id) {
        try {
//            List<ExpensesVO> expensesVOList = this.expensesCache.getExpensesVOList();
//            expensesVOList.removeIf(expensesVO -> expensesVO.getExpenseID() == id);
            this.expenseRepository.delete(id);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
