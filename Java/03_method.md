## Wrapper class

```java
byte b1 = 100;
		int i1 = b1;	//묵시적 형 변환 (upCasting, promotion) 작은 타입 -> 타입으로 갈때
		System.out.println(i1);
		
		int i2 =100;
		byte b2 = (byte) i2; //큰타입 -> 작은타입으로 가려면 형 변환이 필요 명시적 형 변환 (downCasting, casting)
		System.out.println(b2);

// boxing wrapper 클래스로 감싸는것
		
		Integer i = new Integer(100);
		
		
		// unboxing
		// 명시적
		int j = i.intValue();
		System.out.println(j);
		
		// 묵시적
		int k = i;
		System.out.println(k);
```



type에서 언급을 못한 내용을 여기서 추가 설명

call by value 

​	호출시 값 (기본타입)

call by reference

​	문자형 (스트링) - 기본타입처럼 사용



wrapper class로 감싸는 이유는

기본타입은 값만 저장이 가능하기때문에 기능을 사용하기 위해 

wrapper class로 감싸준다.



기본타입을 참조타입으로 바꾸어 줄수가 있다.



기본타입								참조타입 <Wrapper class>

byte										Byte

short									  Short

int										   Integer

long										Long

float									   Float

double								   Double

char									    Character

boolean								 Boolean 



그리고 형 변환을 해줄때 묵시적 형변환과 명시적 형변환이 있다.



묵시적은 작은것을 큰것에 담을때

명시적은 큰것을 작은것에 담을때이다. (타입의 크기를 말하는 것)





# Method

어떤 작업을 수행하기 위한 명령문들의 집함(기능)

하나의 이름으로 여러 개의 명령을 일괄처리 하는 작은 모듈(function)



메소드 선언 방법

- 접근제한자 메모리영역 리턴타입 메소드명(파람/아규){명령/기능};



접근 제한자

- (+)public : 어디에서나 접근 참조 가능
- (#)protected : 상속일 경우 상속된 곳에서,아닌 경우 같은 패키지내에서 접근 참조 가능
- (~)(default) : 같은 패키지내에서먼 접근 참조 가능
- (-)(private) : 현재 클래스 내에서만 접근 참조 가능
- +, -, #, ~ 는 class diagram에서 표기법



메모리 영역

- static : 클래스에서 바로 호출 가능 (class명.method명();)
- non-static : new 연산자를 통해 객체 생성 이후 호출 가능



리턴타입

- 리턴해줄 반환값이 없을 경우 - void
- 메소드 내부의 명령/기능을 전부 처리한 후 return으로 값을 반환



파람/아규

- 메소드 외부에서 전달되는 값 - argument
- 메소드 외보에서 전달되는 값을 메소드 내부에서 사용하기 위한 변수 - parameter



*메소드 선언시 주위*

- 클래스는 설계도이기 때문에 클래스 밖에서 메소드를 생성할 수 없다.
- 메소드 내부에서 다른 메소드를 호출 가능하지만, 새로운 메소드를 만들 수 없다.

```java
public class A{
    public static void prn(){
        System.out.println("static method");
    }
    public void prn1(){
        System.out.println("non-static method");
    }
}
```

```java
public class MTest{
    public static void main(String[] args){
        A.prn(); // static method
        
        A a = new A();
        a.prn1();
           
    }
}
```



