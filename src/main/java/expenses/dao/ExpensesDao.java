package expenses.dao;

import expenses.valueobjects.ExpensesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpensesDao {

    @Autowired
    private ExpensesCache expensesCache;

    private static long actualExpenseID = 0;

    public boolean insertExpense(ExpensesVO expensesVO){
        try {
            this.actualExpenseID++;
            expensesVO.setExpenseID(this.actualExpenseID);
            expensesVO.setTimeStamp(LocalDateTime.now());
            this.expensesCache.getExpensesVOList().add(expensesVO);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<ExpensesVO> getExpensesByType(String type) {
        List<ExpensesVO> expensesVOList = this.expensesCache.getExpensesVOList().stream().
                filter(expensesVO -> expensesVO.getExpenseType().equals(type)).collect(Collectors.toList());
        return expensesVOList;
    }

    public List<ExpensesVO> getExpensesByDate(LocalDate date) {
        List<ExpensesVO> expensesVOList = this.expensesCache.getExpensesVOList().stream().
                filter(expensesVO -> expensesVO.getTimeStamp().toLocalDate() == date).collect(Collectors.toList());
        return expensesVOList;
    }

    public boolean modifyExpense(long id, ExpensesVO eVO) {
        try {
            ExpensesVO expense = this.expensesCache.getExpensesVOList().stream().
                    filter(expensesVO -> expensesVO.getExpenseID() == id).findAny().orElse(null);

            expense.setExpenseType(eVO.getExpenseType());
            expense.setExpenseDescription(eVO.getExpenseDescription());
            expense.setQuantity(eVO.getQuantity());
            expense.setTimeStamp(LocalDateTime.now());
        } catch(Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteExpense(long id) {
        try {
            List<ExpensesVO> expensesVOList = this.expensesCache.getExpensesVOList();
            expensesVOList.removeIf(expensesVO -> expensesVO.getExpenseID() == id);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
