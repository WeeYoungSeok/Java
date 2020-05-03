# 총정리

java란?

컴퓨터가 알아들을 수 있는 언어로 한 번에 변환하여 실행

객체 지향 언어



jvm -> jre -> jdk

jvm : java 실행 프로그램

jre : java 실행 환경

jdk : jre + 개발도구



Eclipse IDE

- 통합 개발 환경



자바에서의 주 진입점은 main 메소드이다.

```java
public static void main(String[] args){
    
}
// 주석
/*
 * 여러줄 주석
 */
```



자바에서의 출력문

```java
System.out.print("Hello World!");
```



java 변수 선언 방법

- Type 변수 = 값;

값 : literal

java에서의 타입은 기본타입과 참조타입으로 나뉨

기본타입 : 정수형 , 문자형, 실수형, 논리형이 있다.



정수형 : byte(1), short(2), int(4), long(8)

문자형 : char(2)

실수형  : float(4), double(8)

논리형 : boolean(1)



참조타입 : 문자열



문자열 :String은 참조타입이지만 기본타입처럼 사용 가능(new사용도 가능)

​				문자형이 여러개 합쳐진 존재



참초타입은 object형이라고도 함.

메모리에 할당된 주소를 참조한 값을 사용



모든 클래스는 object클래스를 상속받음(최상위 클래스)



filed : 속성

constructor : 생성자

method : 기능



기본타입을 참조타입으로

byte -> Byte

short -> Short

int -> Integer

long -> Long

float -> Long

double -> Double

char -> Character

boolean -> Boolean

기본타입을 참조타입으로 변경 시키는 이유는 그 타입의 기능을 쓰기 위해서다(object 상속)

wrapper클래스에 담아서 사용

```java
System.out.println("byte의 범위 : " + Byte.MIN_VALUE +" ~ " + Byte.MAX_VALUE);
		System.out.println("short의 범위 : " + Short.MIN_VALUE +" ~ " + Short.MAX_VALUE);
		System.out.println("int의 범위 : " + Integer.MIN_VALUE +" ~ " + Integer.MAX_VALUE);
		System.out.println("long의 범위 : " + Long.MIN_VALUE +" ~ " + Long.MAX_VALUE);
		System.out.println("float의 범위 : " + Float.MIN_VALUE +" ~ " + Float.MAX_VALUE);
		System.out.println("double의 범위 : " + Double.MIN_VALUE +" ~ " + Double.MAX_VALUE);
		
		System.out.println("Characer의 범위 : " + Character.SIZE);
```



java에서는 형 변환이 가능하다.

크기가 작은 형태를 큰 형태로 변형 할때는 묵시적 형 변환이 가능하다.

크기가 큰 형태를 작은 형태로 변형 할떄는 명시적 형 변환을 해주어야한다.

```java
byte b01 = 100;
int i01 = b01; // 묵시적 가능 int가 byte보다 크기때문

int i02 = 100;
byte b02 = (byte)i02; // 명시적 필요 byte가 int보다 작기때문
```



숫자에서 숫자로 형 변환 말고

문자에서 숫자로 숫자에서 문자로도 가능.

```java
char c01 = 'A';
int i01 = c01; // int가 크기다 더 크므로 묵시작이 가능 결과값 65

int i02 = 66;
char c02 = (char)i02; // char가 더 작으므로 명시적 형변환 결과값 B

char c03 = '9';
char c04 = '1';
System.out.println(c03+c04); // 결과값 아스키코드로 인해 106

String str = "65";
int i03 = Integer.parseInt(str); // 문자열을 정수형으로 변환 참조타입을 이용해 기능 사용

int i04 = 65;
String str1 = String.valueOf(i04);
String str2 = Integer.toString(i04);
// 두 방법 전부 정수형을 문자열로 바꾸어줌
System.out.println(str1 + 1); // 결과값 651
System.out.println(str2 + 1); // 결과값 652
```



boxing wrapper클래스로 감싸기

```java
Integer i = new Integer(100);

// unboxing
int j = i.intValue(); // 명시적으로 감싸기 
int k = i; // 묵시적으로 감싸기
```



print문의 종류

```java
System.out.print(); // 줄 바꿈 없음
System.out.println(); // 줄 바꿈 있음
System.out.printf(); // 'f' = fomatter (자리, 형식 지정)
```

System.out.printf();를 이용할때

%d : 정수형을 받아옴(digit)

%s : 문자열을 받아옴(String)

%c : 문자형을 받아옴(char)

%f : 실수형을 받아옴(float)



%와 형태의 사이에 숫자를 넣으면 칸수가 그 숫자만큼 생김

실수형은 %.몇f를 해주면 몇만큼 소수점을 표현해줌

```java
int su = 100;	// 10칸
		int ch = 'A';	// 5칸
		double d =90.5;	// 5칸에 소수점 둘째자리수까지 표현
		
		System.out.printf("시험 점수 결과는 %10d점이고, 학점은 %5c가 나왔다.\n나의 오늘 감점지수는 %5.2f%%이다. ", su,ch,d);
```



method란?

어떤 작업을 수행하기 위한 명령문들의 집합 (기능)

무언가 입력한걸 처리해서 출력

하나의 이름으로 여러개의 명령을 일괄처리 하는 작은 모듈(funcion)



메소드 선언 방법

- 접근제한자 메모리영역 리턴타입 메소드명(파라미터) {명령문};



클래스 = 설계도



접근제한자의 종류

public : 어디에서나 접근 참조 가능

protected : 상속일 경우엔 상속된 곳에서 사용가능, 아닌경우 같은 패키지 내에서

(default) : 같은 패키지 내에서 접근 참조 가능

private : 현재 클래스 내에서만 접근 참조 가능



메모리영역의 종류

static : class.methid(); 호출 바로 가능 (객체 전체에 적용)

non-static : new 연산자로 객체 생성해서 호출 가능 (객체 하나하나 각 각 적용)

​						class 변수 = new class();

​						변수.method();



다이어그램에서 s가 붙으면 static 없으면 non-static



method1안에 method2가 있는 경우

-  method2 처리 후 method1 처리



리턴타입의 종류

메소드의 내부의 기능,명령문들 전부 처리한 후 return으로 값을 반환 - 리턴타입

리턴해줄 반환값이 없을떄 - void



메소드 외부에서 전달된 값을 받아서 메소드 내부에서 사용하는 변수 - parameter

메소드 외부에서 전덜되는 값 - argument

```java
public static void publicMethod(){
    System.out.println("어디에서나 접근 가능");
} // 이렇게 메소드를 만들수 있다.

public void nonStaticMethod(){
    System.out.println("non-staticMethod");
    System.out.println("객체 생성 필요");
}
// 클래스명을 AAA라고 예를 듬

AAA.publicMethod(); // 바로 호출 가능
publicMethod(); // 현재 클래스에서 호출시에는 클래스명 생략 가능

AAA nonstatic = new AAA();
nonstatic.nonStaticMethod(); //new 연산자를 통해 객체 생성 이후 호출 가능

// 만약 다른 패키지에서 접근 가능한 메소드를 사용할때는
// import.패키지명.클래스명;을 클래스위에 추가 해주면 됨.
```



전역변수란?

클래스 전체에서 전체적으로 사용할 수 있는 변수

클래스 바로 안에 들어가있으면 field : 속성



method 생성시 주의

클래스는 설계도이기 떄문에 클래스 밖에 method를 만들면 안됨

메소드안에 메소드를 호출할 수는 있는데 메소드안에 새로운 메소드를 만드는것은 불가능



Operator

사칙연산

- +,-,*,/,%
- / : 나눈 값의 몫, % : 나눈 값의 나머지

대입연산

- +=,-=,*=,/=,%=

```java
// 대입연산

int res = 0;
res += 10; //res = res + 10;
res -= 10; //res = res - 10;
res *= 10; //res = res * 10;
res /= 10; //res = res / 10;
res %= 10; //res = res % 10;
```



증감연산자

- ++,--
- 전위 연산자 : 연산자를 변수 앞에 붙여서 연산을 먼저 한 뒤 값을 리턴
- 후위 연산자 : 연산자를 변수 뒤에 붙여서 값을 먼저 리턴한 뒤 연산 수행

```java
int a = 10;

System.out.println(a++); // 10출력하고 a는 11이 됨
System.out.println(a); // 11출력
```



논리연산자

- &,|,&&,||
- 리턴값은 true, false

논리연산자 한개와 두개의 차이는 조건을 모두 검사하느냐와 앞에만 검사하느냐이다

&&는 둘다 true면 true리턴, 하나만 fasle면 false리턴

```java
System.out.println(true & false); // false 리턴
System.out.println(false && true); // false 리턴
// 여기서 차이점은 && true는 죽는 값?이 된다
// 이유는 먼저 검사한 값이 이미 false이므로 뒤의 조건은 검사를 해도 어차피
// false를 리턴해야하기떄문에 검사를 하지 않는다.
```

||와 |는 둘다 false여야 false리턴 하나만 true이면 무조건 true

이것도 &&연산자와 마찬가지로 ||연산자는 앞의 조건이 true이면 뒤의 조건은

죽는 조건이 되므로 검사를 안한다.



비교연산자

- <.>,>=,<=,==,!=

부등호는 초과,미만,이상,이하이고

나머지는 순서대로 == : 같다, != : 같지 않다.



상항연산자

- (조건)? 참:거짓;

조건이 참이면 참을 출력 거짓이면 거짓을 출력

```java
int a = 10;
int b = 20;

String str = (a<b)? "a가 b보다 작다." : "a가 b보다 크거나 같다."
```



비트연산자(2진법)

- &,|,^,~,<<,>>

& : a라는 2진법의 값과 b라는 2진법의 값을 1과 0들의 자리를 비교하여 둘다 1이면 1로 반환

​		한쪽만 1이면 0 반환 and 연산자와 연관됨

| : or연산자와 연관 한쪽만 1이여도 1반환

^ : 두 비트의 값이 서로 다른 경우에만 1반환

~ : 0은 1로 1은 0으로 반환

<< : 왼쪽으로 이동 ex) a << 2 왼쪽으로 2칸 이동 비어있는 칸은 0으로 채우고 넘치는 칸은 짜름

오른쪽으로는 >> 연산자 사용



제어문이란?

```java
if(조건) {
    명령 // 해당 조건이 참일떄
} else if (조건) {
    명령 // 해당 조건이 참일때
} else {
    명령 // 해당 조건이 전부 거짓일때
}
```



```java
switch(식/값) {
    case 값:
        명령
        break; // 밑의 케이스들이 더 이상 나오지 않게 하기 위해 걸어줌
    case 값:
        명령
    case 값:
        명령
            
            
    default: 
        명령 // 케이스가 전부 없을 경우
}
```



반복문이란?

```java
변수 선언
    while(조건){
        명령
        증감식
    }

변수 선언
    do{
        명령
        증감식
    }whlie(조건);
```



while문과 do while문의 차이점은 적어도 한번 실행 할거냐 말거냐이다.

do while은 먼저 실행 한 뒤에 조건을 검사하므로 적어도 한번은 무조건 실행하게 된다.

while문 안에 break를 쓸 수 있다.

break를 쓰면 while문 밖으로 나가버린다.

countinue도 쓸 수 있다.

거짓이면 밖으로 나가서 while문 안의 출력문같은것을 실행하고 다시 while문으로 가서 순서대로

명령 수행하고 참이면 while문 밖에있는 출력문같은것을 실행하지 않고 바로 다시 while문 조건으로 올라간다.

while문 안에 while문 가능



```java
for(초기값; 조건식; 증감식;){
    명령
}
```



for문은 while문에서 선언한 것을 ()안에 다 넣을 수 있다.

상황에 따라 while문을 쓸지 for문을 쓸지 do while문을 쓸지 잘 생각하고 써야한다!!

break는 if문, switch문, while문, do while문, for문 전부 사용 가능

for문안에 for문 가능 



Scanner란?

사용자의 입력값을 받아 쓰기 위한 기능

```java
Scanner sc = new Scanner(Sytem.in);
System.out.println("첫 숫자 입력 : ");
int a = sc.nextInt();
System.out.println("두번째 숫자 입력 : ");
int b = sc.nextInt(); // 정수형 입력 받음

int sum = a + b;
System.out.println("입력하신 두 수의 합 : " + sum);
```



배열(Array)이란?

- 같은 타입 여려개의 값을 효과적으로 관리하기 위한 객체



배열 -> 참조타입(mutable) : 주소값으로 변경

new를 사용하지 않아도 객체 생성 가능!

데이터타입 [] 변수 = {...};

참조타입은 호출하면 주소값을 전달. (a라는 배열 System.out.println(a)시 출력은 주소값)

```java
int[] a = new int[1];
a[0]=1;

System.out.println(a); // 주소값 출력
```



선언 방법

- 선언; 정의; 초기화;
- 선언 정의 초기화;
- 선언 초기화;

```java
int[] a;
a = new int[2];
a[0] = 1;
a[1] = 2; // 선언; 정의; 초기화;

int[] b = new int[2] {1,2}; // 선언 정의 초기화;

int[] c = {1,2}; // 선언 초기화;
```





배열의 크기가 5인곳에 1~5까지 들어가있으면

배열의 인덱스(번지)는 0~4이다. (배열의 첫 시작은 항상 0번지)



배열의 복사

shallow copy(얕은 카피) : 배열의 주소값까지 카피함

- 복사본을 변경하면 원본도 같이 변경됨!!
- ==시 true

```java
int[] original = {1,2,3,4};
int[] copy = original;
System.out.println(original==copy); // true
```



deep copy(깊은 카피) : 배열의 인덱스의 값만 카피 (주소값이 다름)

- 복사본을 변경해도 원본에 영향없음!!
- ==시 false

```java
int original = {1,2,3,4};
int[] copy = new int[original.length];
System.out.println(original==copy); // false
```

```java
Arrays.fill(original, 100); // 0으로 가득찬 배열을 100으로 전부 채움
System.arraycopy(original, 0, copy, 2, 3);
//System.arraycopy(원본 배열 객체, 원본 시작 위치, 복사될 배열 객체, 복사될 시작 위치, 복사 갯수)
```

원본 배열꺼를 복사해서 복사될 배열에 넣어줌



