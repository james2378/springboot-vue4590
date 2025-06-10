package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 比赛信息：(CompetitionInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CompetitionInformation")
public class CompetitionInformation implements Serializable {

    // CompetitionInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competition_information_id")
    private Integer competition_information_id;

    // 项目编号
    @Basic
    private String project_number;
    // 项目名称
    @Basic
    private String entry_name;
    // 比赛海报
    @Basic
    private String competition_poster;
    // 比赛分类
    @Basic
    private String competition_classification;
    // 比赛时间
    @Basic
    private Timestamp competition_time;
    // 比赛人数
    @Basic
    private Integer number_of_participants_in_the_competition;
    // 可报人数
    @Basic
    private Integer reportable_number_of_people;
    // 裁判账号
    @Basic
    private Integer referee_account;
    // 裁判姓名
    @Basic
    private String referee_name;
    // 比赛要求
    @Basic
    private String competition_requirements;
    // 裁判简介
    @Basic
    private String introduction_to_judges;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
