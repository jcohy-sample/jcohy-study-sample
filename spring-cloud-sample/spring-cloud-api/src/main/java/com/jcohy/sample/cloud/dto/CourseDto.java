package com.jcohy.sample.cloud.dto;

import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019 http://www.jcohy.com
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

public class CourseDto  implements Serializable {
    private Long cid;

    private String 	cname;

    private Long tid;

    public CourseDto() {
    }

    public CourseDto(Long cid, String cname, Long tid) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
}
