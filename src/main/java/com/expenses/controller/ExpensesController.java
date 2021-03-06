package com.expenses.controller;

import com.expenses.service.ExpensesService;

import com.expenses.valueobjects.ExpensesVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    private final Logger LOGGER = Logger.getLogger(ExpensesController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ExpensesVO createExpense (HttpServletResponse httpServletResponse, @RequestBody ExpensesVO expensesVO){
        addCorsHeader(httpServletResponse);
        LOGGER.info("New expense created.");
        boolean instertState = this.expensesService.insertExpense(expensesVO);
        return instertState ? expensesVO : null;
    }

    @RequestMapping(value = "/byType/{type}", method = RequestMethod.GET)
    public List<ExpensesVO> getExpensesByType (HttpServletResponse httpServletResponse, @PathVariable("type") String type){ ///FIX
        addCorsHeader(httpServletResponse);
        LOGGER.info("Get expenses by Type.");
        List<ExpensesVO> expensesVOList = this.expensesService.getExpensesByType(type);
        return expensesVOList;
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public List<ExpensesVO> getExpenses (HttpServletResponse httpServletResponse){
        addCorsHeader(httpServletResponse);
        LOGGER.info("Get expenses.");
        List<ExpensesVO> expensesVOList = this.expensesService.getExpenses();
        return expensesVOList;
    }

    @RequestMapping(value = "/byDate/{date}", method = RequestMethod.GET)
    public List<ExpensesVO> getExpensesByDate (HttpServletResponse httpServletResponse, @PathVariable("date") @DateTimeFormat(pattern="yyyyMMdd") LocalDate date){
        addCorsHeader(httpServletResponse);
        LOGGER.info("Get expenses by Date.");
        List<ExpensesVO> expensesVOList = this.expensesService.getExpensesByDate(date);
        return expensesVOList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody  ExpensesVO modifyExpense (HttpServletResponse httpServletResponse, @PathVariable("id") long id,
                                     @RequestBody ExpensesVO expensesVO){
        addCorsHeader(httpServletResponse);
        LOGGER.info("Expense with id: " + id + "is been modified.");
        boolean modifyStatus = this.expensesService.modifyExpense(id, expensesVO);
        return modifyStatus ? expensesVO : null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteExpense(HttpServletResponse httpServletResponse, @PathVariable("id") long id){
        addCorsHeader(httpServletResponse);
        LOGGER.info("Expense with id: " + id + "has been deleted.");
        return this.expensesService.deleteExpense(id);
    }


    public static void addCorsHeader(HttpServletResponse response) {
        // TODO: externalize the Allow-Origin
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
////        response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization, X-Request-With");
//        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
//        response.addHeader("Access-Control-Allow-Credentials", "true");
//        response.addHeader("Content-Type", "application/x-www-form-urlencoded");
//        response.addHeader("Access-Control-Max-Age", "1728000");
    }

}
