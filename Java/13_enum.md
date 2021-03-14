### enum

- enum : 열거형 (enumerated type)은 서로 연관된 상수들의 집합이다. (배열은 서로 연관된 값들의 집합) 즉 바뀌지 않는 값들의 집합이다.

- enum의 효과

  > 코드가 단순해진다.
  >
  > 인스턴스 생성과 상속을 방지한다. (enum을 만든 사람의 의도이다.)
  >
  > 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.

```java
package com.wee.weestagram;

public class ConstantDemo {

	/*
	 * class Fruit { public static final Fruit APPLE = new Fruit(); public static
	 * final Fruit PEACH = new Fruit(); public static final Fruit BANANA = new
	 * Fruit(); }
	 */

	// 위의 class Fruit와 같은 의미를 갖는다.
	// 복잡한 코드를 간략하게 만든게 enum이다.
	// enum은 class를 의미한다. (정확히 enum class이다.)
	// 문법적인 지원을 해준다.
	// enum안에 있는 APPLE는
	// public static final Fruit APPLE = new Fruit(); 이거와 같은 의미이다.
	enum Fruit {
		APPLE, PEACH, BANANA;
	}

	/*
	 * class Company { public static final Company GOOGLE = new Company(); public
	 * static final Company APPLE = new Company(); public static final Company
	 * GOOGLE = new Company(); }
	 */

	enum Company {
		GOOGLE, APPLE, ORACLE;
	}

	public static void main(String[] args) {

		Fruit type = Fruit.APPLE;
		switch (type) {
		// 스위치문으로 전달한 데이터 타입이 Fruit라는 것을 switch문은 알고있기때문에
		// case에는 Fruit를 붙일 필요없이 상수만 적어주면 된다.
		// 약속이다.
		case APPLE:
			System.out.println(57 + "kcal");
			break;
		default:
			break;
		}
	}
}

```

<br/>

- enum으로 생성자 호출과 매개변수를 가지는 생성자, 메소드 만들기

  > enum은 명백히 class를 의미한다.

```java
package com.wee.weestagram;

public class ConstantDemo {

	/*
	 * class Fruit {
	 * public static final Fruit APPLE = new Fruit(); 
	 * public static final Fruit PEACH = new Fruit(); 
	 * public static final Fruit BANANA = new Fruit();
	 *  }
	 */
	
	// enum은 사실 클래스다. 고로 생성자를 가질 수 있다.
	enum Fruit {
		// APPLE, PEACH, BANANA; 이거는 생성자 호출
		
		APPLE("red"), PEACH("pink"), BANANA("yellow");
		// 이것은 생성자 호출할때 매개변수를 갖는 생성자에게 부여된다
		// red,pink,yellow 등
		// 이 color는 스위치문에서 가져올 수 있다.
		
		// enum도 클래스이기 때문에 필드값을 가질수 있다.
		public String color;
		
		// 메소드 생성도 가능하다.
		public String getColor() {
			return this.color;
		}

		// 클래스 네임과 같은 메소드는 생성자이다.
		// enum도 마찬가지다.
		Fruit(String color) {
			System.out.println("생성자 호출" + this);
			this.color = color;
			// this.color의 color는 전역변수고
			// color는 지역변수를 의미
			// 전역변수보다 지역변수가 우선순위가 높기때문에
			// 전역변수는 this라고 명시해주어야한다.
		}

		/*
		 Fruit() {
		 	System.out.pringln("생성자 호출" + this);
		 }
		 */
		// 실행해보면
		/*
		 * 생성자 호출APPLE 
		 * 생성자 호출PEACH 
		 * 생성자 호출BANANA 
		 * 57kcal
		 * 결과값이다. 
		 */
		// 이유는 위의 class Fruit와 같은 의미를 필드가 가지고 있기 때문에
		// new Fruit가 3번 호출이 되었기 때문에 생성자가 3번 호출된다.
	}

	enum Company {
		GOOGLE, APPLE, ORACLE;
	}

	public static void main(String[] args) {
		/*
		Fruit type = Fruit.APPLE;
		switch (type) {
		case APPLE:
			// 결과는 같다.
			// 하지만 구현 방법은 다르다.
			System.out.println(57 + "kcal, color " + Fruit.APPLE.getColor());
			//System.out.println(57 + "kcal, color " + Fruit.APPLE.color);
			// 여기서 이런식으로 가져오면 된다.
			break;
		default:
			break;
		}
		*/
		
		for (Fruit f : Fruit.values()) {
			// values는 enum Fruit안에 있는 필드를 하나씩 꺼내서 f에 담아준다.
			System.out.println(f + " " + f.getColor());
			// 마치 배열처럼 상수들을 하나씩 꺼내서 처리할 수 있는 기능도 제공한다.
		}
	}
}

```

<br/>

- final : 변수가 한번 지정되면 값이 바뀌지 않음 변수마저도 상수가 됨
- static : 클래스의 변수라는 뜻

```java
private final static int APPLE = 1;
```



```java
private final static int APPLE = 1;

private final static int APPLE = 2;
```

> 이렇게되면 에러가 난다. 이유는 파이널로 상수로 고정시켜놨는데
>
> 한번더 선언이 되었기 때문이다.



```java
interface FRUIT {
    int APPLE = 1, PEACH = 2, ORACLE = 3;
}
```

> 이것과 public final static int APPLE = 1;과 같은 의미가 된다.
>
> 이유는 인터페이스에서 필드를 작성하면 public final static이 암시되어있다는 의미이다.



```java
// 인터페이스의 상수를 사용하기
int type = FRUIT.APPLE; // 이렇게 사용 가능하다.
```



- 비교할 수 없는 상수의 그룹들 ex) 과일이냐 기업이냐 차이 과일 APPLE과 기업 APPLE

```java
interface FRUIT {
    int APPLE = 1, PEACH = 2, ORACLE = 3;
}

interface COMPANY {
    int GOOGLE = 1, APPLE = 2, ORACLE = 3;
}

public class ConstantDemo {
    public static void main(String[] args) {
        if (FRUIT.APPLE == COMPANY.APPLE) {
            System.out.println("과일 애플과 회사 애플이 같다.");
            // 이런경우 비교조차 되면 안되기때문에 밑에처럼 변경해준다
            // 이런경우에는 런타임일 경우에 에러가 난다.
        }
    }
}
```

<br/>

```java
class Fruit {
    public static final Fruit APPLE = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit BANANA = new Fruit();
    // 상수를 클래스타입으로 만들었다 같이 데이터 타입이지만
    // 서로 다른 인스턴스를 가지고 있다.
}

class Company {
    public static final Company GOOGLE = new Company();
    public static final Company APPLE = new Company();
    public static final Company ORACLE = new Company();
}

public class ConstantDemo {
    public static void main(String[] args) {
        if (FRUIT.APPLE == COMPANY.APPLE) {
            System.out.println("과일 애플과 회사 애플이 같다.");
            // 이런 경우에는 if문의 조건이 에러가 난다.
            // 이런 경우에는 컴파일러때 에러를 알기때문에 더 효율성이 생긴다.
            // 심각한 에러이기때문
            // 에러는 타입이 다르기때문에 비교가 안된다.
        }
        
        Fruit type = Fruit.APPLE;
        switch (type) {
            case Fruit.APPLE:
            	System.out.println(57 + "kacl");
                break;
        }
        // 이런 경우 에러가 안나지만 switch안의 type에 에러가난다.
        // 이유는 switch문의 조건에는 제한된 데이터만 들어간다
        // byte, short, char, int, enum, String, Character, Byte, Short, Integer만 들어갈 수 있기 때문이다.
        // 우리가 사용할 데이터 타입은 클래스타입 Fruit와 Company 타입이기 때문이다.
        
        // 이렇게되면 우리가 switch문에는 사용할 수 없다
        // 하지만 if문에서는 사용가능하다.
        // switch문이 보기좋고 가독성이 좋기때문에 enum을 배우는 것이다.
    }
}
```





