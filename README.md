#  Преобразование числа в письменную форму.

Библиотека реализующая преобразование числа в письменную форму.

#### Подключение

**Gradle**:
```
repositories {
    maven {
        url  "https://dl.bintray.com/a-k-pohresniy/onotoliy"
    }
}


dependencies {
    compile 'com.github.onotoliy:money2words:1.0.0'
}
```

**Maven**:
```
<repositories>
    <repository>
        <snapshots>
            <enabled>
                false
            </enabled>
        </snapshots>
        <id>
            bintray-a-k-pohresniy-onotoliy
        </id>
        <name>
            bintray
        </name>
        <url>
            https://dl.bintray.com/a-k-pohresniy/onotoliy
        </url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.onotoliy</groupId>
    <artifactId>money2words</artifactId>
    <version>1.0.0</version>
    <type>pom</type>
</dependency>
```
