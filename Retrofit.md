
### Easy Access Retrofit Singleton 
```Kotlin
interface WebService {

    companion object {
        private val service by lazy {
            Retrofit.Builder()
                .baseUrl("http://google.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebService::class.java)
        }

        fun get(): WebService = service

    }

    @Streaming
    @GET
    suspend fun downloadFile(@Url fileUrl: String): ResponseBody
}
```
### Usage
``` Kotlin

val response = WebService.get().downloadFile(url)
