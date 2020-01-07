package by.it.academy.design_bureau.web.tags.custom;

import by.it.academy.design_bureau.model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

public class AuthTag extends ConditionalTagSupport {

    private String path = "";

    @Override
    protected boolean condition() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpSession session = request.getSession();
        Employee user = (Employee) session.getAttribute("user");

        return user != null && user.getRole().equals("ADMIN");
    }

    public void setPath(String path) {
        this.path = path;
    }
}
