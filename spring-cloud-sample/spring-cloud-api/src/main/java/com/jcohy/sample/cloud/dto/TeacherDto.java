package com.jcohy.sample.cloud.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019 www.xuanwuai.cn
 *
 * @author jiac
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/9 17:04
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/9      jiac           v1.0.0               修改原因
 */

public class TeacherDto implements Serializable {

    private Long tid;

    private String 	tname;

    public TeacherDto() {
    }

    public TeacherDto(Long tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
