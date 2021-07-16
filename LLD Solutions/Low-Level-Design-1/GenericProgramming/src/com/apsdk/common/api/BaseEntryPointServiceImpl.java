/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.apsdk.common.api;

/**
 * @author paras.chawla
 * @version $Id: BaseEntryPointServiceImpl.java, v 0.1 2019-06-10 23:44 paras.chawla Exp $$
 */
import com.apsdk.common.model.BaseRequest;
import com.apsdk.common.model.BaseResponse;


/**
 * @author paras.chawla
 * @version $Id: BaseEntryPointServiceImpl.java, v 0.1 2019-06-10 22:51 paras.chawla Exp $$
 */
public abstract class BaseEntryPointServiceImpl<AI extends BaseRequest, AO extends BaseResponse> implements EntryPointService<AI,AO> {

    @Override
    public AO execute(AI request) {
        return null;
    }
}
