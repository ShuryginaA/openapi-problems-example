import org.openapitools.generator.gradle.plugin.tasks.GenerateTask


plugins {
    id("groovy")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.4.4"
    id("io.micronaut.aot") version "4.4.4"
    id("org.openapi.generator") version "7.10.0"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

buildscript {
    dependencies {
        classpath("io.kokuwa.micronaut:micronaut-openapi-codegen:4.4.2")
    }
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
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.validation:micronaut-validation")
    implementation("io.micronaut.reactor:micronaut-reactor")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")
    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("io.micronaut.openapi:micronaut-openapi-annotations")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("ch.qos.logback:logback-classic")
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
}

open class CommonGenerateTask @Inject constructor(
        objectFactory: ObjectFactory
) : GenerateTask(objectFactory) {
    init {
        generatorName.set("micronaut")

        outputDir.set("${project.layout.buildDirectory.get()}/generated")

        generateApiTests.set(false)
        generateModelTests.set(false)

        generateApiDocumentation.set(false)
        generateModelDocumentation.set(false)

        configOptions.set(
                mapOf(
                        "useGenericResponse" to "false",
                        "useOptional" to "false",
                        "supportAsync" to "true",
                        "useBeanValidation" to "true"
                )
        )
    }
}

tasks.register("generateApiServer", CommonGenerateTask::class) {
    inputSpec.set("$rootDir/src/main/resources/openapi/openapi-v1.yml")

    apiPackage.set("com.example.controller")
    modelPackage.set("com.example.dto")
}

tasks.register("generateOpenApi") {
    dependsOn(
            tasks.getByPath("generateApiServer"))
}

java.sourceSets["main"].java {
    srcDir("${project.layout.buildDirectory.get()}/generated/generated-sources/openapi")
}
tasks.compileJava {
    dependsOn(tasks.getByPath("generateOpenApi"))
    options.encoding = "UTF-8"
}

tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


