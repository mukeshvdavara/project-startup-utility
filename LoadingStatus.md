# LoadingStatus for easy state management
```kotlin
sealed class LoadingStatus<out T> {
    object Loading : LoadingStatus<Nothing>()
    data class Success<T>(val data: T) : LoadingStatus<T>()
    data class Error(val throwable: Throwable) : LoadingStatus<Nothing>()
}
```
