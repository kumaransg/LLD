/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.apsdk.common.api;

import com.apsdk.common.model.BaseRequest;
import com.apsdk.common.model.BaseResponse;

/**
 * @author paras.chawla
 * @version $Id: EntryPointService.java, v 0.1 2019-06-10 23:43 paras.chawla Exp $$
 */
public interface EntryPointService<AI extends BaseRequest, AO extends BaseResponse> {
    AO execute(AI request);
}