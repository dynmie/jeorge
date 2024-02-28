plugins {
    id("java")
    id("maven-publish")
}

group = "me.dynmie.jeorge"
version = "1.2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "me.dynmie.jeorge"
            artifactId = "jeorge"
            version = version
            from(components["java"])
        }
    }
}
