package com.hanjie.controller.base;

import com.hanjie.common.http.AxiosResult;

public class BaseController {

    protected AxiosResult<Void> toAxios(int row){
        return row>0?AxiosResult.success():AxiosResult.error();

    }
}
