package expenses.controller;

import expenses.service.ExpensesService;

import expenses.valueobjects.ExpensesVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    private final Logger LOGGER = Logger.getLogger(ExpensesController.class);

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    public ExpensesVO createExpense (@RequestBody ExpensesVO expensesVO){
        LOGGER.info("New expense created.");
        boolean instertState = this.expensesService.insertExpense(expensesVO);
        return instertState ? expensesVO : null;
    }

    @RequestMapping(value = "/expensesByType/{type}", method = RequestMethod.GET)
    public List<ExpensesVO> getExpensesByType (@PathVariable("type") String type){ ///FIX
        LOGGER.info("Get expenses by Type.");
        List<ExpensesVO> expensesVOList = this.expensesService.getExpensesByType(type);
        return expensesVOList;
    }

    @RequestMapping(value = "/expensesByDate/{date}", method = RequestMethod.GET)
    public List<ExpensesVO> getExpensesByDate (@PathVariable("date")LocalDate date){
        LOGGER.info("Get expenses by Date.");
        List<ExpensesVO> expensesVOList = this.expensesService.getExpensesByDate(date);
        return expensesVOList;
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.PUT)
    public @ResponseBody  ExpensesVO modifyExpense (@PathVariable("id") long id,
                                     @RequestBody ExpensesVO expensesVO){
        LOGGER.info("Expense with id: " + id + "is been modified.");
        boolean modifyStatus = this.expensesService.modifyExpense(id, expensesVO);
        return modifyStatus ? expensesVO : null;
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE)
    public boolean deleteExpense(@PathVariable("id") long id){
        LOGGER.info("Expense with id: " + id + "has been deleted.");
        return this.expensesService.deleteExpense(id);
    }
}