package com.solt.demo.framework.utils;

import com.solt.demo.framework.controller.ControllerMapping;
import com.solt.demo.framework.controller.IController;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationControllersFinder {

  //  public Map<String, IController> findControllers() {
        //  return new Reflections()
        // .getTypesAnnotatedWith(ControllerMapping.class) Set<Class<?>>
        //  .stream() Stream<Class<?>>
        //   .map(this::getAsControllerClass) Stream<Class<IController>>
        //   .map(this::getAsControllerInstance) Stream<IController>
       //  .collect(Collectors.toMap(this::getUri, Function.identity()));



    private Class<IController> getAsControllerClass(Class<?> controller){
        return (Class<IController>)controller;
    }

    private IController getControllerInstance(Class<IController> controller){
        try{
            return controller.getConstructor().newInstance();
        }catch (Exception e){
            throw new RuntimeException(
                    String.format("Error occured while creating instance of controler %s : %s"
                            ,controller.getSimpleName(), e.getMessage()),
                    e
            );
        }
    }

    private String getUri(IController controller){
        return controller.getClass().getAnnotation(ControllerMapping.class).value();
    }
}
