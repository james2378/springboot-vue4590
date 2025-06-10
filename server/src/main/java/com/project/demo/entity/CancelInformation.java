package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 取消信息：(CancelInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CancelInformation")
public class CancelInformation implements Serializable {

    // CancelInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancel_information_id")
    private Integer cancel_information_id;

    // 运动员账号
    @Basic
    private Integer athlete_account;
    // 运动员
    @Basic
    private String athletes;
    // 性别
    @Basic
    private String gender;
    // 年龄
    @Basic
    private Integer age;
    // 项目编号
    @Basic
    private String project_number;
    // 项目名称
    @Basic
    private String entry_name;
    // 比赛分类
    @Basic
    private String competition_classification;
    // 比赛时间
    @Basic
    private Timestamp competition_time;
    // 裁判账号
    @Basic
    private Integer referee_account;
    // 裁判姓名
    @Basic
    private String referee_name;
    // 取消人数
    @Basic
    private Integer number_of_cancellations;
    // 取消原因
    @Basic
    private String reason_for_cancellation;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
