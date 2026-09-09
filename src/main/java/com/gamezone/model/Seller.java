/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamezone.model;

/**
 * Represents a seller who attends clients and registers sales at the GameZone store.
 */
public class Seller extends Person{
    private String employeeCode;
    private String shift;
    /**
 * Creates a new Seller with the given personal data and work information.
 *
 * @param name the seller's full name
 * @param identification the seller's identification document number
 * @param phone the seller's contact phone number
 * @param employeeCode the seller's employee code
 * @param shift the seller's assigned work shift
 */
    public Seller(String name, String identification, String phone, String employeeCode, String shift) {
    super(name, identification, phone);
    this.employeeCode = employeeCode;
    this.shift = shift;
}
    /**
 * Returns the seller's employee code.
 *
 * @return the employee code
 */
    public String getEmployeeCode() {
    return employeeCode;
}
/**
 * Updates the seller's employee code.
 *
 * @param employeeCode the new employee code
 */
public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
}
/**
 * Returns the seller's assigned work shift.
 *
 * @return the work shift
 */
public String getShift() {
    return shift;
}
/**
 * Updates the seller's assigned work shift.
 *
 * @param shift the new work shift
 */
public void setShift(String shift) {
    this.shift = shift;
}
}
