package your;

import my.PackageClass; 
// package명이 다르기 때문에 YourClass 라는 Class 안에 YourClass라는 
// 생성자 안에서 PackageClass에서 ctrl+space누르면 import됨

public class YourClass {
    YourClass(){
        PackageClass c = new PackageClass();
        c.b=100;
//      c.a=200; // 다른 패키지(c)에 있는 정수형 변수 a의 접근제한자가 생략되어 있기 때문에
                 // 패키지명이 다르면 사용할 수 없다
//      c.c = 1; // 접근제한자 protected로 선언된 변수는 다른 패키지에선 상속받지 않으면 사용할 수 없다. 
        
    }
}
