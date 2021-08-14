/**
 * Alipay.com Inc. Copyright (c) 2004-2015 All Rights Reserved.
 */
package vacuumcleaner.template;

import java.util.Map;

/**
 */
public abstract class BizBaseCallback<T, R> {

    protected void preProcess(T request, R result, Map<Object, Object> container) {
        try {
            bizPreProcess(request, result, container);
        } finally {

        }
    }

    /*
    */
    protected void process(T request, R result, Map<Object, Object> container) {
        try {
            bizProcess(request, result, container);
        } finally {

        }
    }

    /**
     */
    protected final void postProcess(T request, R result, Map<Object, Object> container) {
        try {
            bizPostProcess(request, result, container);
        } finally {

        }
    }

    /**
     */
    protected void bizPreProcess(T request, R result, Map<Object, Object> container) {

    }

    /**
     */
    protected abstract void bizProcess(T request, R result, Map<Object, Object> container);

    /**
     */
    protected void bizPostProcess(T request, R result, Map<Object, Object> container) {

    }

    protected abstract R createDefaultResult();
}
