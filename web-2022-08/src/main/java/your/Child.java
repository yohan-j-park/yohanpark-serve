package your;

import my.PackageClass;

public class Child extends PackageClass{  // 다른 패키지를 상속받는 것
    Child(){
//     a=1;   // 다른 패키지에 있는 정수형 변수 a의 접근제한자가 생략되어 있기 때문에
              // 상속을 받아도 패키지명이 다르면 사용할 수 없다
       
       b=2; // 상속받은 PackageClass의 정수형 변수 b의 접근제한자가 public이라 사용 가능 
       c=3; // 상속받은 PackageClass의 정수형 변수 c의 접근제한자가 
            // preotected이기 때문에 상속받았으면 사용 가능(상속안받으면 사용 불가)
    }
}
