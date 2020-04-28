# Class



Object Oriented Programming : 기능별로 객체를 나눈다.



추상화 : 여러 객체들을 하나의 추상적인 큰 개념으로 묶는다

- ex) 버스 승용차 트럭 -> 모두 차라는 큰개념



캡슐화 : 객체의 기능을 사용만 한다. (코드는 온닉)

- ex) String tocharArray() 내부적인 코드는 모르지만 문자열을 캐릭터 배열로 바꾸어주는 기능



상속 : 상위 객체를 하위 객체가 물려받는다.

- ex) 동물이라는 상위 객체를 곰에게 부여, 다리가 4개라는 기능을 곰에게 부여



다형성 : 같은 형태로 다른 행위를 한다.

- ex) 고양이,강아지 둘다 동물이지만 다른 울음소리와 다른 몸짓을 가지고있음
- 같은 타입으로 가진 형태인데 각각 다른 일을 할 수 있음.



#### java

> 자바는 객체 지향 프로그램이다 (객체들을 가지고 만든다.)





##### field

```java
private int abc; //instance variable (non static은 해당 클래스를 통해서 실제 객체에 
					//적용되는 변수

private static String def = test; // class variable (static은 해당 클래스 전체에 적용)

//field값을 설정해줄때 굳이 왜? private으로 하는지 꼭 찾아보자!!
```



- instance variable의 예

  ex) 사람타입 하나하나가 각자 다른 이름을 가지고 있음

- class variable 예

  ex) 사람타입 모든 객체에 하나의 이름을 가지고 있음



##### constructor

```java
public class AAA{
    //모든 클래스는 object클래스를 상속받는다 
    //가장 상위 클래스(가장 위의 부모 클래스)는 object 클래스이다.
    
    //기본 생성자
    public AAA{
        //super(); object 클래스 상속됨 부모클래스의 기본 생성자를 가져올떼
        			//셍략 가능
    }
    //파라미터가 한개 있는 기본 생성자
    public AAA(int abc){
        
        this.abc=abc;
    }
}
```

##### <생성자>

- 클래스 이름과 동일하되, 리턴타입은 없고, 객체 생성의 접근제한자는 public이다.

- 클래스를 만들고 항상 가장 먼저해야할 것은 기본 생성자를 만들어 주는 것이다.

- 생성자는 객체 생성을 하는 new 연산자와 함께 사용되며 생성시 단 한번만 자동 호출됨

  > Test t1 = new Test();		(o) : 기본 생성자 호출

- 생성자는 메소드 처럼 객체 및 클래스명으로 호출 할 수 없다.

  > t1.Test();							(x)
  >
  > Test.Test();						(x)

- overload(ing)이 가능함

  > overload란? 같은 이름의 메소드를 다른 파라미터를 사용하여 정의 할 수 있음
  >
  > ex)

```java
class Test{
    public Test(){
        
    }
    public Test(int a){
        
    }
    public Test(int a, int b){
        
    }
}
```

- 생성자를 명시하지 않으면 기본 생성자가 제공되며 필드를 초기화 하고, 생성자를 명시하면 명시한 생성자만 호출되고 기본 생성자는 제공되지 않는다.

```java
class AA{
    
}						// AA a = new AA();			가능(o) : 생성자 명시 안해도 기본 생성자 제공 

class BB{
	public BB(){		// BB b = new BB();			가능(o)
        			
		}
}
class CC{
    public CC(int a){	// CC c = new CC();			가능(x)
        				// CC c = new CC(10);		가능(o)
    }
}
```

- CC c = new CC(); 가 안되는 이유는 파라미터를 가진 기본 생성자를 생성하고 파라미터를 가지지 않는 기본 생성자는 생성해주지 않았기 때문이다.

  평소에 파라미터가 없는 기본 생성자를 만드는 습관을 들이자!

  

- 생성자는 상속되지 않는다.

- 생성자는 내부 호출 할 수 있다.

  > this();

- 생성자의 목적 : 객체 생성, 필드 초기화



그리고나서 우리가 기존에 쓰던 메소드를 만들어서 main메소드에 불러오면 되는 것이다.

파라미터를 받는 기본 생성자 AAA(int abc)에서 this는 현재 클래스에 있는 field값을 의미하는 것이다.