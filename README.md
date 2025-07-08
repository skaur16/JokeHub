
# JokeHub

A simple application to display tech related jokes over the home page, enabling users to add any to their favourites and also a page for Joke of the day. This is a basic dummy application built with an intent for proof of concept. 
It calls the API through Volley, uses Room DB for local storage and also to perform CRUD operations, executed in favourites feature.
Apart from this, a tab layout UI is also in picture, which provides a bottom bar to navigate through screens.



## Screenshots

<img src="app/src/main/java/com/example/jokeHub/images/ss1.png" width="200" alt="Launch Screen">
<img src="app/src/main/java/com/example/jokeHub/images/ss2.png" width="200" alt="Joke of the Day">
<img src="app/src/main/java/com/example/jokeHub/images/ss3.png" width="200" alt="Favourite Jokes">
<img src="app/src/main/java/com/example/jokeHub/images/ss4.png" width="200" alt="Delete Fav ">





## Features

- Display Tech Jokes on Home page, by calling API through Volley.
- Enable any/each joke to be added to Favourites.
- A random joke displayed for Joke of the Day title.
- Favourite jokes remain even when the application is closed(execution of Room DB)
- Remove from Favourite Jokes, i.e. tapping on the heart icon again removes the joke from Favourites list (Deletion from ROoom DB)


## Tech Stack

**Business Logic :** Kotlin

**UI Designing:** Jetpack Compose

**Design Pattern:** MVVM
## Lessons Learned

-Volley usage
-Room DB usage
-Room DB CRUD operations
-Bottom bar execution for navigation

