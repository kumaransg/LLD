/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 *//*

package com.pc.multilevelparkinglot.processor;

import ProgramType;
import com.pc.multilevelparkinglot.processor.impl.FileProcessor;
import com.pc.multilevelparkinglot.processor.impl.InteractiveProcessor;

*/
/**
 * @author paras.chawla
 * @version $Id: ProcessorFactory.java, v 0.1 2020-11-13 09:30 paras.chawla Exp $$
 *//*


// Factory class to create Processor based on ProgramType
public class ProcessorFactory {

    private ProcessorFactory() {
        throw new IllegalArgumentException("This is not allowed");
    }

    public static final AbstractProcessor createProcessor(ProgramType programType) {

        AbstractProcessor processor = null;
        switch (programType) {
            case INTERACTIVE:
                processor = getInteractiveProcessor();
                break;
            case FILE:
                processor = getFileProcessor();
                break;
        }
        return processor;
    }

    private static AbstractProcessor getInteractiveProcessor() {
        return new InteractiveProcessor();
    }

    private static AbstractProcessor getFileProcessor() {
        return new FileProcessor();
    }

}*/
