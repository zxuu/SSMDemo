package Entity;

import java.util.Date;

public class Sensor {
 private int id;
 private float temp;
 private float humi;
 private Date time;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getTemp() {
	return temp;
}
public void setTemp(float temp) {
	this.temp = temp;
}
public float getHumi() {
	return humi;
}
public void setHumi(float humi) {
	this.humi = humi;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
 
}
