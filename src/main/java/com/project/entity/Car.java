package com.project.entity;

public class Car {
    private String carId;

    private String carType;

    private String carCargoType;

    private String carName;

    private String carCheckpoint;

    private String carCheckthings;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String getCarCargoType() {
        return carCargoType;
    }

    public void setCarCargoType(String carCargoType) {
        this.carCargoType = carCargoType == null ? null : carCargoType.trim();
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public String getCarCheckpoint() {
        return carCheckpoint;
    }

    public void setCarCheckpoint(String carCheckpoint) {
        this.carCheckpoint = carCheckpoint == null ? null : carCheckpoint.trim();
    }

    public String getCarCheckthings() {
        return carCheckthings;
    }

    public void setCarCheckthings(String carCheckthings) {
        this.carCheckthings = carCheckthings == null ? null : carCheckthings.trim();
    }
}