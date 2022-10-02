# Navigation Template with View Model

This app has the base navigation template to ease your initial development. By using `BottomNavigationView` and `Navigation Graph`, the app is able to navigate to different menu or to sub-screen through `Fragment`.

Other available examples:
+ Within `Fragment`, accessing the binding view (`Button` `TextView`) from the `xml` layout.
+ Accessible `Shared View Model` between `Activity` and `Fragment`
+ Individual `View Model` within each `Fragment`

### Example of menu structure

+ `Menu` `Nested navigation graph` Bold
	+ `Sub Screen` Bold 1
	+ `Sub Screen` Bold 2
	+ `Navigate` Italic menu
	+ `Button: Click binding field` To change binding field text name
	+ `Button: Show shared value` To show shared View Model value
	+ `Button: Show fragment value` To show own Fragment View Model value
	+ `Button: Amend shared value` To show amended shared View Model value
+ `Menu` Italic
+ `Menu` Parking
+ `Menu` Title

## Navigation Graph
![](https://github.com/ff55lab/android-kotlin-template-navigation/raw/main/nav_graph_1.png)

## Nested Navigation Graph
![](https://github.com/ff55lab/android-kotlin-template-navigation/raw/main/nav_graph_2_nested.png)

## Navigation UI

![](https://github.com/ff55lab/android-kotlin-template-navigation/raw/main/navigation_ui.png)

## Tools

- Android Studio Chipmunk | 2021.2.1 Patch 2
- Android SDK API Level 31 (Android 12.0)
- JDK 11.0.15 (64-bit)
