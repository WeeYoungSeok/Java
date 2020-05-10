# Repetitive Statement

반복문

- for문
- for(초기값; 조건식; 증감식;){명령};

```java
public class A {
    public static void main(String[] args) {
        // 구구단
        for(int i = 2; i < 10; i++){
            for(int j = 1; j < 10; j++){
                System.out.println(i + "X" + j + " = " + i*j);
            }
            System.out.println();
        } 
    }
}
```



- while문
- while문은 for문과 달리 초기값을 정해주어야한다
- while(조건) 조건에는 식 또는 참,거짓이 들어간다.

```java
public class A {
    public static void main(String[] args) {
        int i = 2;
		int j = 1;
		
		while(i < 10) {
			System.out.println(i + "X" + j + " = " + i*j);
			j++;
			if(j==10) {
				j=1;
				i++;
				System.out.println();
			}
		}
    }
}
```



- do while문
- 적어도 한번 실행하고 싶을 경우 사용한다. 
- 첫 조건이 거짓이어도 무조건 한번을 실행하고 조건을 검사한다.

```java
public class A {
    public static void main(String[] args) {
        int i = 10;
        
        do {
            System.ouy.println(i);
            i++
        } while(i==10);
        System.out.println("do while문이 종료된 후 i = " + i);
        // 출력은 1하고
        // do while문이 종료된 후 i = 2가 출력됨
    }
```



