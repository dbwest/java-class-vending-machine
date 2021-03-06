package com.awesomevendingco.vendingmachine.ui;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class HelpfulServlet extends HttpServlet {

	private static final long serialVersionUID = 5082625629247683759L;

	protected void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

    protected void setApplicationScope(ServletContext context, String attribute, Object value) {
        context.setAttribute(attribute, value);
    }

    protected void setSessionScope(HttpSession session, String attribute, Object value) {
        session.setAttribute(attribute, value);
    }

    protected void setRequestScope(ServletRequest request, String attribute, Object value) {
        request.setAttribute(attribute, value);
    }

    protected Object getApplicationScope(ServletContext context, String attribute) {
        return context.getAttribute(attribute);
    }

    protected Object getSessionScope(HttpSession session, String attribute) {
        return session.getAttribute(attribute);
    }

    protected Object getRequestScope(ServletRequest request, String attribute) {
        return request.getAttribute(attribute);
    }

}
