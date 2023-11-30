import com.greenrevive.serawaziapplication.data.OpenAiApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://greenrevive-backend-91401db68ead.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }


//    private const val BASE_URL = "https://api.openai.com/"
//    private val httpClient = OkHttpClient.Builder()
//        .build()
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(httpClient)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()


//    val apiService : OpenAiApi = retrofit.create(OpenAiApi::class.java)


}
