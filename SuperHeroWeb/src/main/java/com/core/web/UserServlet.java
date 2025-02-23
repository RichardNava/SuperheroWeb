
package com.core.web;

import com.core.dao.UserController;
import com.core.entities.User;
import com.core.exceptions.PreexistingEntityException;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;

public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final UserController uc = new UserController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mode = request.getParameter("mode");
        switch (mode) {
            case "login" -> {
                login(request, response);
            }
            case "singup" -> {
                try{
                    singup(request, response);                
                }
                catch(Exception e){
                    throw new ServletException("nombre no disponible");
                }
            }
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        Optional<User> userOp = uc.findUserByEmail(email);
        if (userOp.isPresent()) {
            User user = userOp.get();
            if (user.getPassword().equals(pwd)) {
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("private/home.xhtml");
                rd.forward(request, response);
            }
            else {
                request.setAttribute("msg", "El password no es correcto");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
        else {
            request.setAttribute("msg", "No existe ningun usuario con ese email");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    private void singup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PreexistingEntityException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String role = request.getParameter("role");
        User user = new User(username,pwd,email,role);
        uc.createUser(user);
        response.sendRedirect("index.jsp");
    }

}
