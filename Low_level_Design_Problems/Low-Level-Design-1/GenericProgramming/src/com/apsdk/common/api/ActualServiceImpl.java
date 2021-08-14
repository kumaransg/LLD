/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.apsdk.common.api;

/**
 * @author paras.chawla
 * @version $Id: ActualServiceImpl.java, v 0.1 2019-06-10 23:45 paras.chawla Exp $$
 */
import com.apsdk.common.model.ActualRequest;
import com.apsdk.common.model.ActualResponse;

/**
 * @author paras.chawla
 * @version $Id: DummyServiceImpl.java, v 0.1 2019-06-10 23:01 paras.chawla Exp $$
 */
public class ActualServiceImpl extends BaseEntryPointServiceImpl<ActualRequest, ActualResponse>{

    @Override
    public ActualResponse execute(ActualRequest request) {
        return super.execute(request);
    }
}
