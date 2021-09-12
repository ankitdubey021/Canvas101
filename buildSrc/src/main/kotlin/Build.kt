/**
 * Created by Ankit Dubey on 14,July,2021
 */
object Build {
    private const val gradleBuildTools = "7.0.2"

    const val buildTools = "com.android.tools.build:gradle:${gradleBuildTools}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
}