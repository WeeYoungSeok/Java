# Control Statement

제어문

- if문
- if(조건식){명령}; , else if 추가 조건식, else는 if의 조건식 이외

```java
public class A{
    public static void main(String[] args){
        int i = 10;
        if(i>10){
            System.out.println("i가 10보다 큽니다");
        } else if(i<10) {
            System.out.println("i가 10보다 작습니다.");
        } else {
            System.out.println("i는 10입니다.")
        }
    }
}
```



- switch문
- 조건에는 식/값, break를 안써주면 자신과 맞는 case 밑의 case를 전부 실행하게 된다.

``` java
public class A {
    public static void main(String[] args){
        int i = 10;
        
        switch(i){
            case 10 :
                System.out.println("i는 10입니다");
                break;
            case 11:
                System.out.println("1는 11입니다.");
            default: 
                System.out.println("케이가 전부 없을때 실행");
        }
    }
}
```

