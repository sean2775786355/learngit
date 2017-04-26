package com.java1;

public class Demo1_1 {
    //属性
	private float screen;
	public float getScreen() {
		return screen;
	}
	public void setScreen(float screen) {
		this.screen = screen;
	}
	public float getCpu() {
		return cpu;
	}
	public void setCpu(float cpu) {
		this.cpu = cpu;
	}
	public float getMem() {
		return mem;
	}
	public void setMem(float mem) {
		this.mem = mem;
	}
	private float cpu;
    private	float mem;
	//方法
	void call()
	{
		System.out.println("打电话");
	}
	void sendMassage(){
		System.out.println("screen="+screen+"cpu"+cpu+"mem="+mem+"发信息");
	}
}
