[![jeorge](https://socialify.git.ci/dynmie/jeorge/image?description=1&descriptionEditable=A%20lightweight%20dependency%20injection%20framework%20for%20Java.&forks=1&issues=1&language=1&name=1&owner=1&pulls=1&stargazers=1&theme=Light)](https://github.com/dynmie/jeorge)
<div align="center"><img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/dynmie/jeorge?style=for-the-badge"> <img alt="GitHub Workflow Status" src="https://img.shields.io/github/actions/workflow/status/dynmie/jeorge/gradle.yml?branch=master&logo=github&style=for-the-badge"></div>

# Getting started
Add the Maven dependency to your `pom.xml` file.
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.dynmie</groupId>
    <artifactId>jeorge</artifactId>
    <version>1.2.0</version>
</dependency>
```

## Registering a dependency
Create a Module and add binds to it.
```java
public class MyBinder extends Binder {
    @Override
    public void configure() {
        bind(Animal.class, Cat.class);
    }
}
```
Create a class and annotate the fields you want to inject into.
```java
public class MyClass {
    @Inject
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }
}

```
Create an Injector and inject into your instance.
```java
Injector injector = Jeorge.createInjector(new MyBinder());
MyClass instance = injector.createInstance(MyClass.class);
Animal animal = instance.getAnimal();
animal.speak(); // prints Meow!
```
