package com.al_tair.storage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * @author Al_tair
 * @date 2022/7/21-14:22
 * 每次删除文件操作都会记录到该表，用于后续文件恢复使用
 */
@Data
@Table(name = "recoveryfile")
@Entity
@TableName("recoveryfile")
public class RecoveryFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    @Column(columnDefinition="bigint(20)")
    private Long recoveryFileId;
    @Column(columnDefinition = "bigint(20)")
    private Long userFileId;
    @Column(columnDefinition="varchar(25)")
    private String deleteTime;
    @Column(columnDefinition = "varchar(50)")
    private String deleteBatchNum;
}
