package com.example.firebaserealtimedatabase;

public class EmployeeInfo {
    String employeeName, employeePhone, employeeAddress;

    public EmployeeInfo() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public EmployeeInfo(String employeeName, String employeePhone, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeAddress = employeeAddress;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "employeeName='" + employeeName + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                '}';
    }
}
