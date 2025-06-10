package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 成绩信息：(ScoreInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ScoreInformation")
public class ScoreInformation implements Serializable {

    // ScoreInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_information_id")
    private Integer score_information_id;

    // 裁判账号
    @Basic
    private Integer referee_account;
    // 裁判姓名
    @Basic
    private String referee_name;
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
    // 比赛成绩
    @Basic
    private String score;
    // 成绩说明
    @Basic
    private String score_description;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
