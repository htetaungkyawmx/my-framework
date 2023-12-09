package com.solt.demo.framework.servlet;

import com.solt.demo.framework.controller.IController;
import com.solt.demo.framework.ds.ModelAndView;
import com.solt.demo.framework.model.Model;
import com.solt.demo.framework.utils.ApplicationControllersFinder;
import com.solt.demo.framework.view.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Map;


@WebServlet(name = "framework-servlet", urlPatterns = "/*")
public class FrameworkHttpServlet extends HttpServlet {
    private Map<String, IController> uriToControllerMap;

    @Override
    public void init() {
      //  uriToControllerMap=new ApplicationControllersFinder()
         //       .findControllers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException, ServletException {
        String requestURI = req.getRequestURI();
        IController controller=uriToControllerMap.get(requestURI);
        if(controller !=null){
            ModelAndView modelAndView=controller.handleRequest(req);
            Model model=modelAndView.getModel();
            View view=modelAndView.getView();
            String renderedView=view.render(model);
            resp.setContentType("text/html");
            resp.getWriter().println(renderedView);
        }
        else
            throw new ServletException(String.format("Unable to find controller for request uri [%s]",requestURI));
    }
}
