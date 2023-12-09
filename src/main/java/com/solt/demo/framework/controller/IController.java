package com.solt.demo.framework.controller;

import com.solt.demo.framework.ds.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IController {
    ModelAndView handleRequest(HttpServletRequest request);
}
