# Kotlin studies

## UI Components

- Column
- Row
- Box
- Button
- DropdownMenu
- DropdownMenuItem
- Icon
- Text
- OutlinedTextField
- Spacer
- Padding: Modifier.padding(16.dp)
- LazyColumn
- AlertDialog
- IconButton
- Icon (images)
- BasicTextField
- LazyVerticalGrid
- CircularProgressIndicator
- NavController / NavHost
- Scroll Text: Modifier.verticalScroll(rememberScrollState())

## Annotations

- @Composable

Composables are Kotlin functions annotated with @Composable. They can define anything from a single UI element, like a button or a text field, to a complete screen or a part of it.
We can create our own composable element to allow for reusable and modular code. It's like creating custom annotations in Spring Boot.

- @Preview

It lets you see what your app’s screen or a part of it will look like without running the whole app on a phone or emulator.

## Feature classes

- Context

It’s like a messenger that helps parts of your app talk to the operating system and access resources, services, and other stuff.

- Toast

It's a quick message that pops up on the screen. It’s a way to give users a short message or feedback, like “Message sent” or “Error occurred.”

## Important concepts

- State

When the state of a component changes, the UI is updated to reflect this new state.
For instance, if a user types something into a text box, the state of the text box changes, and the UI is updated to show the new text.

In Kotlin, when developing Android apps, you often work with mutable and immutable states. 
Mutable states are those that can be changed, while immutable states cannot be changed once they are set.

Here’s a basic syntax for creating a *mutable* state in Kotlin:

```
val countState = mutableStateOf(0)
 
// To update the state
countState.value = 5
```
 
And here’s how you might create an *immutable* state:

```
val countState = remember { mutableStateOf(0) }
 
// This will cause a compile error because countState is read-only
// countState = mutableStateOf(5)
 
// To update the state
countState.value = 5
```

Another way to declare a state, using the *by* keyword:

```
var state by remember { mutableStateOf("") }
```

- Recomposition

It refers to the process where the UI automatically updates in response to state changes.
When the state changes, the composable function automatically recomposes.

Ex.: When you type in a OutlinedTextField, the state of this input is changing. Also, if you wanna print the message that you're typing,
then there is a Text Composable for example, where it's recomposing as you write in order to show in the screen.

Another example:

```
@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
 
    Button(onClick = { count.value++ }) {
        Text("Clicked ${count.value} times")
    }
}
```

In this example, the Counter composable function has a mutable state count. Every time the button is clicked, the count value increases, 
and the Counter function recomposes to update the UI with the new count value.

- Remember: funciona como um "banco de dados" pois a cada recomposição da UI, o valor da variável envolvida com o "remember", não será perdido.
- Mutable State Of: torna a variável mutável para ser atualizada com outros valores no decorrer do fluxo. Ex.: uma variável receberá diferentes cores,
conforme o botão clicado com uma determinada cor.

---

## MVVM Architecture

MVVM helps organize code and break programs into modules to make development, updating and reuse of code simpler and faster.

![image](https://github.com/brunadelmourosilva/kotlin-studies/assets/61791877/bd434b85-5911-46c2-a007-df85f49baac1)

---

## API Calls in Kotlin

### Important dependencies

```
//Compose ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

//Network calls
implementation("com.squareup.retrofit2:retrofit:2.9.0")

//Json to Kotlin object mapping
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

//Image loading
implementation("io.coil-kt:coil-compose:2.4.0")
```

---

## Navigation between screens in Android



---

## References

- Section 5

https://tutorials.eu/the-power-of-jetpack-compose-and-ui-customization-day-5-android-14-masterclass/

- Section 6

https://tutorials.eu/mastering-state-management-and-essential-kotlin-syntax-day-6-android-14-masterclass/

- Section 7

https://tutorials.eu/exploring-more-advanced-ui-components-day-7-android-14-masterclass/

- Section 8 (MVVM, Inheritance, Interface)

https://tutorials.eu/the-foundations-of-mvvm-inheritance-and-interfaces-day-8-android-14-masterclass/

- Section 9 (API communication, async coroutines)

https://tutorials.eu/navigating-libraries-apis-and-remote-content-day-9-android-14-masterclass/

- Section 10 (Navigation in Android)

https://developer.android.com/develop/ui/compose/navigation#kts

---

### Review by week

####  Every 2 weeks

- [x] 15/06/2024

Revised content and projects:

- Revised README and MyRecipeApp project

- [x] 29/06/2024

Revised content and projects:

- Revised README and CapitanGame project (uses state concept in order to change the UI when the component changes)
- https://chatgpt.com/share/61068f7e-f97b-4b86-ab89-b3f987efaa1a

- [x] 29/07/2024

Revised content and projects:

- Revised README and MvvmArchitecture project

- [x] 24/08/2024

Revised content and projects:

- Revised README and naviagationsample project

- [x] 02/11/2024

Revised content and projects:

- Revised README and shoppinglist project

review unitconverter and navigationsample

---

### To be done after the studies for AWS certification ⚠️

- Review all the content learned
  - Readme
  - Projects (mark as check the projects reviewed by week) 
- Build a petshop app with API calls based on this project: https://github.com/brunadelmourosilva/UNIFEI-COM222-projeto-final-backend
- Continue to watch the course and implement new features in the app built above
