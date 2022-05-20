package ir.mydvp.controller;

import ir.mydvp.model.entity.Employee;
import ir.mydvp.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/admin.do")
public class Admin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Employee> employees = EmployeeService.getInstance().findAll();
            req.setAttribute("list", employees);
            req.getRequestDispatcher("/admin/admin.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}