plugins {
    id("groovy") 
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.4"
    id("io.micronaut.aot") version "4.4.4"
    id("io.micronaut.openapi") version "4.4.4"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.jsonschema:micronaut-json-schema-processor")
    annotationProcessor("io.micronaut.openapi:micronaut-openapi")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.jsonschema:micronaut-json-schema-annotations")
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("io.micronaut.openapi:micronaut-openapi-annotations")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("ch.qos.logback:logback-classic")
    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass = "com.example.Application"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
    targetCompatibility = JavaVersion.toVersion("21")
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    openapi {
        server(file("src/main/resources/openapi/openapi-v1.yml")) {
            apiPackageName = "com.example.controller"
            modelPackageName = "com.example.dto"
        }
        client("ClientV1", file("src/main/resources/openapi/client/client-v1.yml")) {
            clientId.set("client-v1")
            apiPackageName = "com.example.clientone.controller"
            modelPackageName = "com.example.clientone.dto"
        }
        client("ClientV2", file("src/main/resources/openapi/client/client-v2.yml")) {
            clientId.set("client-v2")
            apiPackageName = "com.example.clienttwo.controller"
            modelPackageName = "com.example.clienttwo.dto"
        }
        client("ClientV3", file("src/main/resources/openapi/client/client-v3.yml")) {
            clientId.set("client-v3")
            apiPackageName = "com.example.clientthree.controller"
            modelPackageName = "com.example.clientthree.dto"
        }
        client("ClientV4", file("src/main/resources/openapi/client/client-v4.yml")) {
            clientId.set("client-v4")
            apiPackageName = "com.example.clientfour.controller"
            modelPackageName = "com.example.clientfour.dto"
        }
        client("ClientV5", file("src/main/resources/openapi/client/client-v5.yml")) {
            clientId.set("client-v5")
            apiPackageName = "com.example.clientfive.controller"
            modelPackageName = "com.example.clientfive.dto"
        }
        client("ClientV6", file("src/main/resources/openapi/client/client-v6.yml")) {
            clientId.set("client-v6")
            apiPackageName = "com.example.clientsix.controller"
            modelPackageName = "com.example.clientsix.dto"
        }
        client("ClientV7", file("src/main/resources/openapi/client/client-v7.yml")) {
            clientId.set("client-v7")
            apiPackageName = "com.example.clientseven.controller"
            modelPackageName = "com.example.clientseven.dto"
        }
    }

}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


