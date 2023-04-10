## 1. thrift version
0.10.0

## 2. dependences

```xml
        <dependency>
            <groupId>org.apache.thrift</groupId>
            <artifactId>libthrift</artifactId>
            <version>0.10.0</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.25</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.25</version>
        </dependency>
```
plugin

```xml
                <groupId>org.apache.thrift</groupId>
                <artifactId>thrift-maven-plugin</artifactId>
                <version>0.10.0</version>
```

source folder and target folder

```xml
                    <thriftSourceRoot>${basedir}/src/main/resources/thrift</thriftSourceRoot>
                    <outputDirectory>${basedir}/src/main/java/</outputDirectory>
```

## 3. thrift file

The thrift file is the contract between client and server.


## 4. Create Connection

```java
        TTransport transport = new TSocket("localhost", 9905);
```

## 5. Using Client

```java
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
```

## 6. Remote Procedure Call

```java
        APIResponse apiResponse = client.login(loginRequest);
```

This will call `login()` service on server remotely.
