/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package vacuumcleaner.template;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: BizTemplate.java, v 0.1 2020-08-13 09:30 paras.chawla Exp $$
 */
public class BizTemplate {


    public <T,R > R execute(final T request,final BizBaseCallback<T, R> action) {

        long startTime = System.currentTimeMillis();

        final Map<Object, Object> container = new HashMap<Object, Object>();

        final R result = action.createDefaultResult();

        try {

            action.preProcess(request, result, container);

            action.process(request, result, container);

            action.bizPostProcess(request, result, container);

        } catch (Exception ex) {


        } finally {
        }

        return result;
    }

}