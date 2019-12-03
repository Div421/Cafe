package com.dxc.cafe2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="counters")
public class Counter {
	@Id
	private String id;
	private String counterName;
	private String counterOwner;
	private String counterEmail;
	private String counterPassword;
	
	public Counter(String counterId, String counterName, String counterOwner, String counterEmail,
			String counterPassword) {
		super();
		this.id = counterId;
		this.counterName = counterName;
		this.counterOwner = counterOwner;
		this.counterEmail = counterEmail;
		this.counterPassword = counterPassword;
	}
	public String getId() {
		return id;
	}
	
	public String getCounterEmail() {
		return counterEmail;
	}
	public void setCounterEmail(String counterEmail) {
		this.counterEmail = counterEmail;
	}
	public String getCounterPassword() {
		return counterPassword;
	}
	public void setCounterPassword(String counterPassword) {
		this.counterPassword = counterPassword;
	}
	public void setCounterId(String counterId) {
		this.id = counterId;
	}
	public String getCounterName() {
		return counterName;
	}
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	public String getCounterOwner() {
		return counterOwner;
	}
	public void setCounterOwner(String counterOwner) {
		this.counterOwner = counterOwner;
	}
	public Counter() {
		super();
	}
	@Override
	public String toString() {
		return "Counter [id=" + id + ", counterName=" + counterName + ", counterOwner=" + counterOwner
				+ ", counterEmail=" + counterEmail + ", counterPassword=" + counterPassword + "]";
	}
	
	

}
