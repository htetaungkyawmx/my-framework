package com.solt.demo.application.controller;

import com.solt.demo.application.view.IndexView;
import com.solt.demo.framework.controller.ControllerMapping;
import com.solt.demo.framework.controller.IController;
import com.solt.demo.framework.ds.ModelAndView;
import com.solt.demo.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/")
public class IndexController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        return new ModelAndView(new SimpleModel(),new IndexView());
    }
}
