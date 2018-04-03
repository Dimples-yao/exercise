package com.lisy.common;

import com.lisy.output.IOutputGenerator;
import com.lisy.output.OutputHelper;
import com.lisy.output.impl.CsvOutputGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
    public static void main(String[] args){
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
        OutputHelper outputHelper = (OutputHelper) context.getBean("OutputHelper");
        outputHelper.getOutpurGenerator();
    }
}
