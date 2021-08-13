package com.example.MinhTu300322371;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id","name","deposit","yr","type","errMsg","errorMessage"})
@RequestMapping
@Controller
public class SavingsController {

    DatabaseService service1;

    @Autowired
    Connection123 connect;

    @RequestMapping(value = "/savingstable", method = RequestMethod.GET)
    public String showMainpage(ModelMap model,@RequestParam(defaultValue = "") String id) throws
            ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());
        List<Savings> filteredTodos = new ArrayList<>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getCustomerNumber());
        model.put("name",filteredTodos.get(0).getCustomerName());
        model.put("deposit",filteredTodos.get(0).getCustomerDeposit());
        model.put("yr",filteredTodos.get(0).getYear());
        model.put("type",filteredTodos.get(0).getSavingType());
        return "savingstable";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showMainpage2(ModelMap model) throws ClassNotFoundException, SQLException {
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());
        List<Savings> filteredTodos = new ArrayList<>();
        filteredTodos = (List) model.get("todos");
        model.put("id",filteredTodos.get(0).getCustomerNumber());
        model.put("name",filteredTodos.get(0).getCustomerName());
        model.put("deposit",filteredTodos.get(0).getCustomerDeposit());
        model.put("yr",filteredTodos.get(0).getYear());
        model.put("type",filteredTodos.get(0).getSavingType());
        return "savingstable";
    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showAddpage(){
        return "savingsadd";
    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String customerNumber, @RequestParam String customerName,
                          @RequestParam double customerDeposit, @RequestParam int year,@RequestParam String savingType)
            throws SQLException, ClassNotFoundException {
        if (!((service1.search(customerNumber)) ==null)){
            model.put("errorMessage","Record Existing");
            return "redirect:/savingstable";
        }
        Savings ss = new Savings(customerNumber,customerName,customerDeposit,year,savingType);
        service1.add(ss);
        model.clear();
        return "redirect:/savingstable";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam(defaultValue = "") String id)
            throws SQLException, ClassNotFoundException {
        model.put("id", id);
        Savings ss = service1.search(id);
        model.put("id",ss.getCustomerNumber());
        model.put("name", ss.getCustomerName());
        model.put("deposit",ss.getCustomerDeposit());
        model.put("yr",ss.getYear());
        model.put("type",ss.getSavingType());
        return "savingsedit";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String customerNumber, @RequestParam String customerName,
                             @RequestParam double customerDeposit, @RequestParam int year,@RequestParam String savingType) throws SQLException, ClassNotFoundException {
        String iid = (String) model.get("id");
        Savings ss = new Savings(customerNumber,customerName,customerDeposit,year,savingType);
        service1.edit(ss,iid);
        return "redirect:/";
    }

    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException,
            ClassNotFoundException {
        service1.delete(id);
        model.clear();
        return "redirect:/";
    }

    @RequestMapping(value ="/see-todo", method = RequestMethod.GET)
    public String seetodo(ModelMap model, @RequestParam(defaultValue = "") String id) throws
            SQLException, ClassNotFoundException {
        model.put("id", id);
        service1 = new DatabaseService(connect.connect());
        String iid = (String) model.get("id");
        List<Interest> Interestlist = new ArrayList<>();

        return "interest";
    }
    @RequestMapping(value ="/see-todo", method = RequestMethod.POST)
    public String seetodo2(ModelMap model) throws SQLException, ClassNotFoundException {
        return "redirect:/";
    }

}
