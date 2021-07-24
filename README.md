# Appium Mobile Test (Android and iOS)

### Language and Frameworks:
* Java
* TestNG
* Appium
* Gradle
* Hamcrest

### Project execution with IDE (IntelliJ):
* Direct button in the desired suite > Run (src/test/resources/suites)

### Project execution with Gradle:
* gradle test -Psuite=ios_test
* gradle test -Psuite=android_test
* gradle test -Psuite=parallel_tests

### Pre-conditions:
* Setup: Node.js, Appium Server, Java JDK and archive "bash_profile" configured (macOS)
* Android Emulator (Android Studio)
* iOS Simulator (Xcode)