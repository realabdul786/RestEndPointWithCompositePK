package com.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnrollmentKey implements Serializable{
private int sid;
private int cid;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
@Override
public String toString() {
	return "EnrollmentKey [sid=" + sid + ", cid=" + cid + "]";
}

}