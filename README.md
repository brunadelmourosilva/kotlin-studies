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
and the Counter function recomposes to update the UI with the new count value

---

## References

- Section 5

https://tutorials.eu/the-power-of-jetpack-compose-and-ui-customization-day-5-android-14-masterclass/

- Section 6

https://tutorials.eu/mastering-state-management-and-essential-kotlin-syntax-day-6-android-14-masterclass/

