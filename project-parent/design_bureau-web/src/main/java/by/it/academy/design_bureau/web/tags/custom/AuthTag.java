package by.it.academy.design_bureau.web.tags.custom;

import by.it.academy.design_bureau.web.dto.UserAccount;
import by.it.academy.design_bureau.web.util.CookieUtils;
import by.it.academy.design_bureau.web.util.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;
import java.util.Optional;

public class AuthTag extends ConditionalTagSupport {

    private String path = "";

    @Override
    protected boolean condition() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Optional<UserAccount> user = SessionUtils.getUserAccount(request);


        return (user.isPresent() && user.get().getRole().equals("ADMIN"));
    }

    public void setPath(String path) {
        this.path = path;
    }
}
