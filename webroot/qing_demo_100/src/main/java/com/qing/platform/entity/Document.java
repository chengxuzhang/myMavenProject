package com.qing.platform.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @description 维修费用
 *
 * @author srun(LuoXS)
 *
 * @createDate 2017-12-11 下午6:19:57
 */
@Entity
@Table(name = "document")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Document {

    private static final long serialVersionUID = 31451297804975L;

    private java.lang.Integer id;  // 0
    private java.lang.String title;  // 标题

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
