import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.iriscubeapp.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.*
import kotlin.collections.ArrayList


/* Returns initial list of flowers. */
fun MovementDatas(resources: Resources,context: Context): List<sampleData> {
    val url = "https://mocki.io/v1/08bdd00f-c17f-4f9a-a27f-f2ec437781b9"
    var list = ArrayList<sampleData>()
    val que = Volley.newRequestQueue(context)
    val jsonObjectRequest = JsonArrayRequest(
        Request.Method.GET, url, null,
        { response ->
            println(response)
            val gson = GsonBuilder().create()
            //val Model= gson.fromJson(response.getString(0),Array<sampleData>::class.java).toList()
            var i: Int = 0
            while (i < response.length()) {
                val bankAccount = gson.fromJson(response.getString(i),sampleData(description = "",title = "",value = 0.0,id = 0).javaClass)
                println(bankAccount.toString())
                list.add(bankAccount)
                ++i
            }


        },
        { error ->
            println(error)
        }
    )
    que.add(jsonObjectRequest)
    return list
}