## About
This application was originally developed to practice list handling in Android using RecyclerView, but has since been rewritten using **Jetpack Compose**, Google's modern toolkit for building native UIs in a declarative way.  
The app displays a contact list that can be switched between **list view** and **grid view**, and also allows users to view contact details, share contact information, and simulate actions like calling or deleting a contact.

## Screenshots
<p float="left">
<img src = "https://github.com/alanliongar/Recyclerview/blob/master/Screenshot_01.png" width="250"/>
<img src = "https://github.com/alanliongar/Recyclerview/blob/master/Screenshot_02.png" width="250"/>
<img src = "https://github.com/alanliongar/Recyclerview/blob/master/Screenshot_20241212_174854.png" width="250"/>
</p>

## Features
- Display a list of contacts with name, phone and photo
- Toggle between **List** and **Grid** layouts
- Tap a contact to view details
- Share contact information via Android's native share intent
- Simulate contact deletion or phone call (UI only)
- BackHandler support for returning from detail view

## Tech Stack
- Kotlin
- Jetpack Compose
  - `LazyColumn`, `LazyVerticalGrid`
  - `remember`, `mutableStateOf`
  - `BackHandler`
  - `Modifier`, `Surface`, `Theme`
- Material 3 Components (`material3`)
- Intent handling via `Intent.ACTION_SEND`
- Android Studio Preview support via `@Preview`
- Adaptive UI for both portrait and grid modes

## How to Run
1. Clone this repository
2. Open in Android Studio (Electric Eel or newer recommended)
3. Sync project and run on an emulator or physical device (API 21+)

## Notes
- All contact images are local drawable resources.
- The app was rewritten using **Compose** to move away from `RecyclerView`, `ConstraintLayout`, `ListAdapter`, and `DiffUtil`, embracing a fully declarative UI approach.
