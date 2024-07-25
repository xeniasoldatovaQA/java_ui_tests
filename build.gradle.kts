plugins {
    id("java")
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    //testImplementation("io.github.bonigarcia:webdrivermanager:5.7.0")
    testImplementation("com.codeborne:selenide:6.17.1")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("selenide.headless", System.getProperty("selenide.headless"))
    // свойство chromeoptions.prefs используется для задания настроек браузера в проектах на основе Selenide, выключаем менеджер паролей
    systemProperty("chromeoptions.prefs", System.getProperty("chromeoptions.prefs", "profile.password_manager_leak_detection=false"))
}