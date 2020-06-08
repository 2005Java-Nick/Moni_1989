package com.trms.model;

public class ReimburseForm {
	private int requestId;
	private String category;
	private String courseDate;
	private String currentDate;
	private String grade;
	private double amount;
	private String courseDes;
	private String BenCoApproval;
	private String DirSupApproval;
	private String HODApproval;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCourseDes() {
		return courseDes;
	}
	public void setCourseDes(String courseDes) {
		this.courseDes = courseDes;
	}
	public String getBenCoApproval() {
		return BenCoApproval;
	}
	public void setBenCoApproval(String benCoApproval) {
		BenCoApproval = benCoApproval;
	}
	public String getDirSupApproval() {
		return DirSupApproval;
	}
	public void setDirSupApproval(String dirSupApproval) {
		DirSupApproval = dirSupApproval;
	}
	public String getHODApproval() {
		return HODApproval;
	}
	public void setHODApproval(String hODApproval) {
		HODApproval = hODApproval;
	}
	
}
