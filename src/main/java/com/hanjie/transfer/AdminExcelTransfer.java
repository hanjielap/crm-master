package com.hanjie.transfer;

import com.hanjie.domin.entity.Admin;
import com.hanjie.domin.excel.AdminExcel;
import com.hanjie.transfer.base.BaseTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminExcelTransfer extends BaseTransfer<Admin, AdminExcel> {

}
