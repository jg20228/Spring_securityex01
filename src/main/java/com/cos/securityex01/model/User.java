package com.cos.securityex01.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

//ORM - Object Relation Mapping

@Data
@Entity
public class User {
	@Id //pk걸어주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	@CreationTimestamp //localdate가 나중에편함
	private Timestamp timestamp;
}
