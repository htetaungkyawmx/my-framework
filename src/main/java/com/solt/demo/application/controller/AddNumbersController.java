package com.solt.demo.application.controller;

import com.solt.demo.application.view.AddNumbersView;
import com.solt.demo.framework.controller.ControllerMapping;
import com.solt.demo.framework.controller.IController;
import com.solt.demo.framework.ds.ModelAndView;
import com.solt.demo.framework.model.Model;
import com.solt.demo.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;
@ControllerMapping("/add-numbers")
public class AddNumbersController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        Model model=new SimpleModel();
        int numberA = Integer.parseInt(request.getParameter("numberA"));
        int numberB = Integer.parseInt(request.getParameter("numbeB"));

        model.set("numberA",String.valueOf(numberA));
        model.set("numberB",String.valueOf(numberB));
        model.set("result",String.valueOf(numberA + numberB));

        return new ModelAndView(model, new AddNumbersView());
    }
}
