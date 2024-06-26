/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("in.halter.roebi.roebiapplicationcli.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
    // https://mvnrepository.com/artifact/info.picocli/picocli
    implementation("info.picocli:picocli:4.7.6")
}

application {
    // Define the main class for the application.
    mainClass.set("in.halter.roebi.roebiapplicationcli.app.App")
}

distributions {
    main {
        contents {
            from("../NOTICE.txt")
            from("../legal")
        }
    }
}
