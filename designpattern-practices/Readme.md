## Design patterns


#### Creational
1. **Singleton** *
> 클래스의 인스턴스, 즉 객체를 하나만 만들어 사용하는 패턴
<img width="250" height="130" src="https://github.com/Jiyoongrace/java-study/assets/88182667/4bc40277-ea88-4270-a6c4-744f68b08157" />

    - 인스턴스를 하나만 만들어 사용하기위한 패턴 (커넥션 풀, 스레드 풀, 디바이스 설정 등)
    - 주로 서버와 Socket Connection, DB JDBC Connetion, 스프링의 Bean 등에 많이 활용

> `싱글턴 패턴 만들기 과정`
    - new를 실행할 수 없도록 생성자에 private 접근 제어자를 지정한다.
    - 유일한 단일 객체를 반환할 수 있는 정적 메서드가 필요하다.
    - 유일한 단일 객체를 참조할 정적 참조 변수가 필요하다.

2. Factory Method *
3. Abstarct Factory
4. Builder *
5. Prototype

#### Behavioral
1. Chain of Responsibility
2. Command
3. Interpreter
4. Interator *
5. Mediator
6. Mementor
7. Observer *
8. State
9. Strategy *
10. Template Method *
11. Visitor


#### Structural
1. Adapter *
2. Bridge
3. Composite
4. Decorator *
5. Facade *
6. Flyweight
7. Proxy *
