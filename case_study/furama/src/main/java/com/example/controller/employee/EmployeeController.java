package com.example.controller.employee;

import com.example.dto.customer.CustomerDto;
import com.example.dto.employee.EmployeeDto;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @GetMapping("/list")
    public String showListEmployee(Model model, @PageableDefault(value = 3) Pageable pageable,
                                   @RequestParam ("searchByName") Optional<String> nameSearch) {
        String keyWord = nameSearch.orElse("");
        Page<Employee> employees = iEmployeeService.findAll(keyWord, pageable);
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("employees", employees);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("divisions", iDivisionService.findAll());
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(Model model, RedirectAttributes redirectAttributes,
                               @Valid @ModelAttribute EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               Employee employee) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", iPositionService.findAll());
            model.addAttribute("divisions", iDivisionService.findAll());
            model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
            return "/employee/create";
        } else {
            employeeDto.setDeleteFlag(true);
            BeanUtils.copyProperties(employeeDto, employee);
            redirectAttributes.addFlashAttribute("message", "Create customer success");

            iEmployeeService.save(employee);
            return "redirect:/employees/list";
        }
    }

    @GetMapping("/edit/{employeeId}")
    public String editEmployee(@PathVariable Integer employeeId,
                               Model model) {
        Employee employee = iEmployeeService.findById(employeeId);
        if (employee != null) {
            EmployeeDto employeeDto = new EmployeeDto();

            BeanUtils.copyProperties(employee, employeeDto);
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("positions", iPositionService.findAll());
            model.addAttribute("divisions", iDivisionService.findAll());
            model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        }
        return "/employee/edit";
    }

    @PostMapping("/update")
    public String updateEmployee(Model model, RedirectAttributes redirectAttributes,
                                 @Valid @ModelAttribute EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 Employee employee) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", iPositionService.findAll());
            model.addAttribute("divisions", iDivisionService.findAll());
            model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
            return "/employee/edit";
        } else {
            BeanUtils.copyProperties(employeeDto, employee);
            redirectAttributes.addFlashAttribute("message", "Update employee success");

            iEmployeeService.save(employee);
            return "redirect:/employees/list";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer deleteByEmployeeId) {
//        iCustomerService.remove(deleteByCustomerId);
        Employee employee = iEmployeeService.findById(deleteByEmployeeId);
        employee.setDeleteFlag(false);
        iEmployeeService.save(employee);
        return "redirect:/employees/list";
    }
}
