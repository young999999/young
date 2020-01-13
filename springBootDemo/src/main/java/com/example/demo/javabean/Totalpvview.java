package com.example.demo.javabean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author young
 * @since 2020-01-03
 */
@TableName("totalpvview")
public class Totalpvview extends Model<Totalpvview> {

    private static final long serialVersionUID=1L;

    @TableField("totalPv")
    private BigDecimal totalPv;

    private Integer uid;


    public BigDecimal getTotalPv() {
        return totalPv;
    }

    public void setTotalPv(BigDecimal totalPv) {
        this.totalPv = totalPv;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Totalpvview{" +
        "totalPv=" + totalPv +
        ", uid=" + uid +
        "}";
    }
}
