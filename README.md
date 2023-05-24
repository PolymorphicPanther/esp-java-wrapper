# esp-java-wrapper

Java wrapper for the [Eskom Se Push API](https://eskomsepush.gumroad.com/l/api)

## 1) Installation

### 1.1) Gradle

Add the maven central repository and a compile dependency for the wrapper

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    // Include the wrapper as a dependency
    implementation("io.github.polymorphicpanther:esp-wrapper:0.0.1")
}
```

### 1.2) Maven

Add the dependency under the `dependencies` section in pom.xml

```xml
<dependencies>
        <dependency>
            <!--        Include the wrapper as a dependency -->
            <groupId>io.github.polymorphicpanther</groupId>
            <artifactId>esp-wrapper</artifactId>
            <version>0.0.1</version>
        </dependency>
```

## 2) Using the wrapper

### 2.1) Get an API key

Get an API key to allow you to use the API. Click [here](https://eskomsepush.gumroad.com/l/api) to register and obtain a key.

### 2.2) Create an implementation of an IAuthenticationProvider

This type is responsible for supplying the API key which is used when making requests. A simple implementation for testing purposes could be something like:

```java
IAuthenticationProvider authProvider = () -> CompletableFuture.completedFuture("Y1O2U3R-A4P5I-K6E7Y-H8E9R10E");
```

### 2.3) Create an EspClient object

An EspClient object handles building requests, sending them to the Eskom Se Push API and processing the response received. In order to create this class an instance of IAuthenticationProvider (created in 2.2) is needed:

```java
var client = new EspClient.Builder()
       .authenticationProvider(authProvider)
       .build();
```

## 3) Make requests

After creating a client, requests can be made against the API, some examples:

### 3.1) Checking allowances

```java
var allowance = client.allowance().check().build().get();
System.out.format("Allowance: count = %d limit = %d", allowance.count(), allowance.limit());
```

Output

```
Allowance: count = 12 limit = 50
```

### 3.2) Get the current load shedding status

```java
var status = client.status().build().get();
var ctStatus = status.status().get("capetown");
System.out.format("Status: name = %s stage = %s", ctStatus.name(), ctStatus.stage());
```

Output

```
Status: name = Cape Town stage = 5
```

### 3.3) Topics nearby 

```java
var topics = client.topics().nearBy(48.85, 2.2923)
        .build()
        .get();

System.out.format("First topic body: %s", topics.topics()[0].body().substring(0,20));
```

Output

```
First topic body: Why is soshanguve So
```

### 3.4) Area information

```java
 var areaInfo = client.areas().info("eskde-10-fourwaysext10cityofjohannesburggauteng")
                .build()
                .get();

 System.out.format("Area info: name = %s current event note = %s", areaInfo.info().name(), areaInfo.events()[0].note());
```

Output

```
Area info: name = Fourways Ext 10 (10) current event note = Stage 4
```

### 3.5) Areas nearby

