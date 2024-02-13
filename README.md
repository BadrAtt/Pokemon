
# Pokemon

Pokemon is a jetpack compose app built with modern android technologies, multi-module app with clean architecture, MVI, Coroutines, Flow, Retrofit, Turbine Gradle version Catalog
 
 # Tech Stack
 This app is built with modern android technologies, including: 

* 100% [Kotlin](https://www.google.com) Based
* [Jetpack compose](https://developer.android.com/jetpack/compose) for building user interface and app components
* [Corotines](https://kotlinlang.org/docs/coroutines-overview.html) and [Flows](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) for asynchronous tasks
* [Retrofit](https://square.github.io/retrofit/) & [OKHttp](https://square.github.io/okhttp/) for handling http requests
* [Moshi](https://github.com/square/moshi) library for parsing JSON data to Kotlin classes
* [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) for loading and displaying data from the api
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
* [Turbine](https://github.com/cashapp/turbine) a small testing library for kotlinx.coroutines [Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/)
* [MockK](https://mockk.io/) a mocking library for Kotlin
* [Gradle version Catalog](https://docs.gradle.org/current/userguide/platforms.html) for managing dependencies 

# Architecture and patterns
This App is built with Clean architeture, it's composed with 3 leayers: Data, Domain and Presentation, with the MVVM pattern.
it's highly decoupled and each leayer is independet. 

the communication between layers follows a uniderictional flow, 
The ui layer sends user action as intents to the viewModel, which communicates respectively with the domain layer, then the data layer. 
Each layer exposes data to other layer as data streams. 

![Architecture](https://raw.githubusercontent.com/BadrAtt/Pokemon/main/images/architecture.png)

# Modularization

The app is built with multi-module structure for:

**Improved Code Maintainability:** Modularization organizes code into smaller, focused modules, enhancing readability, and making it easier to maintain, update, and debug.

**Reusability:** Modularization encourages creating reusable modules for common functionalities, reducing redundant code and accelerating development across projects.

**Scalability:** Breaking the app into modules enables parallel development, facilitating the addition of new features and modifications without disrupting other parts of the app.

## Screenshots

| Home Page  | Details Page |
| ------------- | ------------- |
| ![Home Page](https://raw.githubusercontent.com/BadrAtt/Pokemon/main/images/home.png)  | ![Details Page](https://raw.githubusercontent.com/BadrAtt/Pokemon/main/images/details.png) |


