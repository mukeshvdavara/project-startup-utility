```Kotlin
fun LifecycleOwner.doOnDestroy(onDestroy: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)
            onDestroy.invoke()
        }
    })
}

fun LifecycleOwner.doOnResume(onResume: () -> Unit) {
    lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onResume(owner: LifecycleOwner) {
            onResume.invoke()
        }
    })
}

fun View.showKeyboard() {
    val manager = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    manager?.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
    val manager = ContextCompat.getSystemService(context, InputMethodManager::class.java)
    manager?.hideSoftInputFromWindow(windowToken, 0)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showToastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Dialog.autoDismiss(owner: LifecycleOwner) = owner.doOnDestroy { dismiss() }


fun File.open(): InputStream = FileInputStream(this)

fun File.copyFromInputStream(inputStream: InputStream) =
    inputStream.use { input -> outputStream().use { output -> input.copyTo(output) } }


fun File.readToString() = open().readTextAndClose()

fun InputStream.readTextAndClose(charset: Charset = Charsets.UTF_8): String {
    return this.bufferedReader(charset).use { it.readText() }
}

inline fun Fragment.askForSinglePermission(
    crossinline onDenied: () -> Unit = {},
    crossinline onPermissionsGranted: () -> Unit = {}
): ActivityResultLauncher<String> =
    registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        if (it) {
            onPermissionsGranted()
        } else {
            onDenied()
        }
    }

inline fun FragmentActivity.askForSinglePermission(
    crossinline onDenied: () -> Unit = {},
    crossinline onPermissionsGranted: () -> Unit = {}
): ActivityResultLauncher<String> =
    registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        if (it) {
            onPermissionsGranted()
        } else {
            onDenied()
        }
    }

fun Context.openAppSystemSettings() {
    startActivity(Intent().apply {
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        data = Uri.fromParts("package", packageName, null)
    })
}
