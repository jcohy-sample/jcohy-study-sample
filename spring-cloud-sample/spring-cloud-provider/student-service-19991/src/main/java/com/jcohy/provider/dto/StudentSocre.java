package com.jcohy.provider.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 * Copyright: Copyright (c) 2019 http://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/9 16:14
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/9      jcohy           v1.0.0               修改原因
 */


public class StudentSocre implements Serializable {

    private String sname;

    private List<Map<String,Object>> mapList;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }
}
