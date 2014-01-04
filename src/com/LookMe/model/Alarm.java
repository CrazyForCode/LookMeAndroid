package com.LookMe.model;

public class Alarm {

	private int id; // 唯一的id号
	private boolean enable; // 是否开启
	private int hour; // 小时
	private int minute; // 分钟
	private String[] dayOfWeekends;
	private boolean slient; // 是否静音
	private boolean vibrate; // 是否振动
	private String label; // 是否有标签

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String[] getDayOfWeekends() {
		return dayOfWeekends;
	}

	public void setDayOfWeekends(String[] dayOfWeekends) {
		this.dayOfWeekends = dayOfWeekends;
	}

	public boolean isSlient() {
		return slient;
	}

	public void setSlient(boolean slient) {
		this.slient = slient;
	}

	public boolean isVibrate() {
		return vibrate;
	}

	public void setVibrate(boolean vibrate) {
		this.vibrate = vibrate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
