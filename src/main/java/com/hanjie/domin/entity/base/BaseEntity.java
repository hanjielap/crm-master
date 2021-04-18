package com.hanjie.domin.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class BaseEntity implements Serializable  {

    /**
     * 管理员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 创建者
     */

    private Long createBy;

    /**
     * 创建时间
     */

    private LocalDateTime createTime;

    /**
     * 修改者
     */

    private Long updateBy;

    /**
     * 修改时间
     */

    private LocalDateTime updateTime;


    /**
     * 创建时间和修改时间的调用
     */
    public void setData() {
        if (id == null) {
            //添加功能
            this.createBy = 1L;//创建人
            this.createTime = LocalDateTime.now();//当前创建时间
        } else {
            this.updateBy = 2L;//修改人
            this.updateTime = LocalDateTime.now();//当前修改时间
        }
    }
}
