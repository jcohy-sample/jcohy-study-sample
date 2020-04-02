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

public class StudentDto implements Serializable {

    private Long 	sid;

    private String 	sname;

    private String 	sage;

    private String 	ssex;

    public StudentDto() {
    }

    public StudentDto(Long sid, String sname, String sage, String ssex) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
}
