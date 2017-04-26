package com.java4;

public class Initial {

	public static void main(String[] args) {
		
     /*     // 父类的引用指向父类的对象
		  //创建一个动物对象
		  Animal an1=new Animal();
          //父类的引用指向子类对象
		  //创建一个dog对象
          Animal an2=new Dog();
          //创建一个猫对象
          Animal an3=new Cat();
          //调用父类的方法
          an1.eat();
          //调用子类方法
          an2.eat();
          //子类继承父类的方法
          an3.eat();
          */
		Dog dog =new Dog();
		Animal an=dog;//自动提升 向上类型转换
		Dog dog2=(Dog)an;//向下类型转换（强转）
		//intanceof 判断是否能强转
		if(an instanceof Cat)
		{
			Cat cat=(Cat)an;
		}else{
			System.out.println("无法进行类型转换");
		}
		
		
		
	}

}
