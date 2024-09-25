### Blog Management Android App
Android application for managing blogs. Users can create, view, and manage blog posts on various health topics.
This application integrates with a backend API to fetch and submit blog data, follows MVVM (Model-View-ViewModel) architecture, leveraging clean architecture principles. It also uses Room Database for caching and offline access.
Find the web version of this app here. https://github.com/GwakoSyprose/healthtech-hub

<p align="center">
  <img src="https://github.com/user-attachments/assets/1d24659f-eecd-4e11-be30-7c3a53148901" alt="Image 1" width="200"/>
  <img src="https://github.com/user-attachments/assets/d789c8cc-24d1-4a6a-a6b7-05ed8bd25b87" alt="Image 2" width="200"/>
  <img src="https://github.com/user-attachments/assets/3b9a6ee7-f9b4-4255-a995-256fe88d6ac0" alt="Image 3" width="200"/>
  <img src="https://github.com/user-attachments/assets/69ae583b-28d3-4514-8bf0-05789d891759" alt="Image 4" width="200"/>
</p>


## Features
- Add Blogs: Users can write and submit blog posts.
- View Blogs: Read published blogs on various health-related topics.
- View Topics: View various health-related topics.
- Topic Filtering: Filter blog posts by topic.
- Sort Functionality: Sort blogs by date in ascending and descending order.
- Form Validation: Ensure user input is valid before submission.
- Snackbar Notifications: Inform users of blog submission success or errors.
  
## Tech Stack
- Kotlin: Primary language used for Android development.
- Jetpack Compose: Modern toolkit for building native UI with declarative components.
- Hilt: Dependency injection framework.
- Coroutines: Manage background threads and asynchronous tasks.
- Retrofit: For API calls to interact with backend services.
- Room Database: To handle local data storage.
- Material3: For consistent and modern UI design.

## Architecture
The app follows MVVM (Model-View-ViewModel) architecture, leveraging clean architecture principles:

- **Domain Layer**: Contains core business logic and use cases.
- **Data Layer**: Manages data from remote APIs and local databases.
- **Presentation Layer**:  Handles UI/UX using Jetpack Compose and follows reactive UI patterns.
## Package Structure

The app is organized into multiple packages to keep the code modular, clean, and maintainable:

### 1. **Blog Feature (Main Feature)**

This feature is structured as a package with individual sub-packages for each screen:

- **Presentation Package**: Contains UI code and `ViewModel` for each screen:
  - `blog_add`: UI and `ViewModel` to add a new blog.
  - `blog_list`: UI and `ViewModel` to display a list of blogs.
  - `blog_detail`: UI and `ViewModel` to display blog details.
  - `home`: UI for home screen.
  
These screens communicate with the domain layer to retrieve and manipulate data.

### 2. **Domain**

The `domain` package contains the business logic, use cases, and repositories:

- **UseCases**: 
  - `BlogUseCases`: Handles operations like adding a blog, fetching blogs, and retrieving a blog by ID.
  - `TopicUseCases`: Handles operations related to blog topics.
  
- **Repositories**:
  - `BlogRepository` Interface and `BlogRepositoryImpl` class: Manages blog data, interacts with both the local database (Room) and remote API.
  - `TopicRepository` Interface and `TopicRepositoryImpl` Implementation: Manages blog topics.
  
  The repositories first attempt to fetch data from the local Room database, and then refresh the local cache with data from the remote API.

### 3. **Data Layer**

This package manages data sources and mapping between local and remote data.

- **Local**: Contains Data Transfer Objects (DTOs) and Data Access Objects (DAOs) for Room Database.
- **Remote**: Contains API services and DTOs for network operations.
- **Mapper**: Maps data between local DTOs, remote DTOs, and the domain models.

### 4. **Dependency Injection (DI)**
The app uses Dagger Hilt for Dependency Injection, providing easy management of dependencies across different layers of the application.
The `di` package contains:
- `NetworkModule`: Provides Retrofit and other network-related dependencies.
- `DatabaseModule`: Provides Room Database instances.
- `DispatcherModule`: Provides Coroutine dispatchers to ensure threading consistency.

### 5. **Core**
- `components`: This package contains reusable Compose UI components that can be shared across multiple screens.
- `utils`: Contains utility classes like Constants and helper functions that are used throughout the app.

## State Management
The app leverages:
- `MutableState` from Jetpack Compose to manage the state of each UI element, ensuring that the UI reacts automatically to state changes.
- `SharedFlow` is used to emit one-time UI events, such as showing a snackbar message or navigating between screens.

## Navigation
The app uses Compose Navigation with four main routes:
- `Home`: The app’s home screen.
- `BlogList`: A list of blogs fetched from the local cache or remote API.
- `BlogAdd`: A screen where users can add a new blog.
- `BlogDetail`: Displays detailed information about a specific blog post.
The bottom bar navigation allow navigation to `Home`, `Blogs` and `Menu`(inactive). The top bar shows the title of the screen and a back navigation.

## Installation
### Prerequisites
Ensure you have the following installed:
- Android Studio (latest stable version)
- JDK 11 or higher
- Android SDK
  
### BASE API URL
We use `BuildConfig` to securely store API URLs and other sensitive information. 



