package com.jcohy.provider.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/10 16:03
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/10      jcohy           v1.0.0               修改原因
 */

@Entity
@Table(name = "sc")
@IdClass(ScPk.class)
public class Sc implements Serializable {

    @Id
    private Long sid;

    @Id
    private Long cid;

    @Column(name = "score", nullable = false)
    private Integer score;

    public Sc() {
    }

    public Sc(Long sid, Long cid, Integer score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
