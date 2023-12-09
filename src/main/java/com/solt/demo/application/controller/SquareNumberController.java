package com.solt.demo.application.controller;

import com.solt.demo.application.view.SquareNumberView;
import com.solt.demo.framework.controller.ControllerMapping;
import com.solt.demo.framework.controller.IController;
import com.solt.demo.framework.ds.ModelAndView;
import com.solt.demo.framework.model.Model;
import com.solt.demo.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/square-number")
public class SquareNumberController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        Model model=new SimpleModel();
        int number=Integer.parseInt(request.getParameter("number"));
        int numberSquare= (int)Math.pow(number,2);
        model.set("number",String.valueOf(number));
        model.set("numberSquare",String.valueOf(numberSquare));
        return new ModelAndView(model,new SquareNumberView());
    }
}
