package com.solt.demo.framework.ds;

import com.solt.demo.framework.model.Model;
import com.solt.demo.framework.view.View;

public class ModelAndView {

    private Model model;
    private View view;


    public ModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
