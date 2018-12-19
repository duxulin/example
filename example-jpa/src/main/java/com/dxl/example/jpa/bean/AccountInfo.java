package com.dxl.example.jpa.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Program AccountInfo
 * @Description
 * @Author duxl
 * @Create 2018/12/11 8:50
 */
@Entity
@Table(name = "t_accountinfo")
@Data
public class AccountInfo implements Serializable {
	@Id
	@GeneratedValue
	private Long accountId;
	@Column
	private Integer balance;
	@Column
	private String name;
	@Column
	private String pwd;

}
