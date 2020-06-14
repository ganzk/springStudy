package com.track.domain;

public class UserDo {

    String uderName;

    Integer sex;

    public UserDo(String uderName,Integer sex) {
        this.uderName = uderName;
        this.sex = sex;
    }
    public UserDo(){
        System.out.println("我被创建了");
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "uderName='" + uderName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
