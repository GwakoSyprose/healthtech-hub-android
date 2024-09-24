### Blog Management Android App
Android application for managing blogs. Users can create, view, and manage blog posts on various health topics.
An Android application for managing blog posts, where users can create, view, and manage blog entries on various health topics.
This application integrates with a backend API to fetch and submit blog data, follows MVVM (Model-View-ViewModel) architecture, leveraging clean architecture principles. It also uses Room Database for caching and offline access.
Find the web version of this app here. https://github.com/GwakoSyprose/healthtech-hub

<p align="center">
  <img src="https://github.com/user-attachments/assets/c8560a14-f846-4f19-bf51-11e7bd4e718b" alt="Image 1" width="200"/>
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

- Domain Layer: Contains core business logic and use cases.
- Data Layer: Manages data from remote APIs and local databases.
- Presentation Layer:  Handles UI/UX using Jetpack Compose and follows reactive UI patterns.


