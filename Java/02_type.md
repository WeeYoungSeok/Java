# TYPE

```java
int j = 100;
```



- Java의 변수 선언 방법

  > type 변수 = 값;
  >
  > 메모리에 값이 할당되는 것이다.
  >
  > 값 자체를 literal이라고 부른다.

  ```java
  int i1 = 100;
  float f1 = 0.1;
  char c1 = 'a';
  boolean b101 = true;
  
  String s = "Hi";
  ```

  

- Java의 Type

  > 기본타입

  ​     - 정수형 : byte(1), short(2), int(4), long(8)		기본형 : int

  ​	 - 실수형 : float(4), double(8)							  기본형 : float

  ​     - 문자형 : char(2) 												기본형 : char

  ​     - 논리형 : boolean(1)										  기본형 : boolean

  > 참조타입  

  ​     - 문자열 : String

  ​		문자열 스트링은 char가 합쳐진 존재라고 생각해도된다.

  ​		character(char)과 달리  " " 을 사용한다.

  ```java
  char c = 'c'
  	System.out.println(c + 1);
  
  String s = "c"
      System.out.println(s + 1);
  ```

  

  자바에서는 아스키코드라는 것이 존재한다.

  Google에 검색해보면 문자형을 아스키코드로 표현해준 표를 볼 수 있을것이다.

  

  위의 코드를 보면

  첫줄 char c = 'c'; 여기서 c의 문자형 아스키코드의 값은 99이다.

  근데 자바에서는 character의 형태와 int의 형태를 출력문에서 덧셈 또는 뺄셈을 해줄 경우,

  아스키코드값을 불러와서 덧셈을 해준다.

  고로 출력문의 값은 100이 나오게 된다.

  

  하지만

  문자열의 스트링의 경우에는 String형태와 int형태를 더해주면

  덧셈이 안되고 문자열 뒤에 붙게 된다.

  고로 출력문의 값은 c1이 나오게 된다.

  ​		

  ### 참조타입

  참조타입은 object형이라고도 한다.

  메모리에 할당된 주소를 참조한 값을 사용한다.(뒤에가서 자세히!)

  

  모든 클래스는 object를 상속받는다.

  

  저번 시간에 배운 출력문에 응용을 해보자!

  ```java
  int i = 100;
  String s = "잔돈";
  
  System.out.printf("%s은 %d원 입니다.", s,i);
  ```

  우리가 타입을 배우면 이런식으로도 활용이 가능하다.

  printf는 유용하니 잘 기억해두자!!

  

  ​			

  

  ​       

