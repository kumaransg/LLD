/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package vacuumcleaner.validator;

/**
 * @author paras.chawla
 * @version $Id: BasicParameterValidator.java, v 0.1 2020-08-13 16:44 paras.chawla Exp $$
 */
public class BasicParameterValidator implements ParameterValidator {

    @Override
    public void validate(Object request) throws Exception {

        checkIfValidInstruction(request);

        checkIfValidCordinates(request);
    }

    private void checkIfValidCordinates(Object request) {
    }

    private void checkIfValidInstruction(Object request) {
    }
}