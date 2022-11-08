package com.example.qoran.ui

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qoran.R
import com.example.qoran.model.aya
import com.example.qoran.customAdapterSoura
import com.example.qoran.model.soura
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var con=this
    var arr:ArrayList<aya> =ArrayList()
    var quran:ArrayList<soura> = ArrayList()
    var newlistquran:ArrayList<soura> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)


        readjsonfile()

    }

    //-------------------------------------------------------------------------------------------------------------------

    //body of menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        var searchManger=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu!!.findItem(R.id.button).actionView as androidx.appcompat.widget.SearchView).apply {
            setSearchableInfo(searchManger.getSearchableInfo(componentName))
            setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    return true
                }

            })
        }
        return true
    }
//-------------------------------------------------------------------------------------------------------------------

    //this function take data from json file and display in recyclerView but it not yet complete
    fun readjsonfile()
    {
        var json:String
        try {
            var inputStream:InputStream=assets.open("quran.json")
            json=inputStream.bufferedReader().use { it.readText() }
            var jsonArray=JSONArray(json)
            for (i in 0..(jsonArray.length()-1))
            {
                var jsonObject=jsonArray.getJSONObject(i)
                arr.add(
                    aya(
                        jsonObject.getInt("sura_id"), jsonObject.getInt("aya_id"), jsonObject
                            .getString("sura_name"), jsonObject
                            .getString("standard_full")
                    )
                )

            }
            for (i in 1..114)
            {
                var soura= soura(1, "", ArrayList())
                for (j in arr)
                {
                    if (j.sura_id==i)
                    {
                        if (j.sura_id==i)
                        {
                            soura.name=j.sura_name
                            soura.id=j.sura_id
                        }
                        soura.soura.add(j)
                    }
                }
                quran.add(soura)
            }
            main_recyclerview.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)
            main_recyclerview.adapter=
                customAdapterSoura(quran, this)

        }
        catch (e:Exception){

        }
    }
    //end body of readjsonfile() function

//------------------------------------------------------------------------------------------------------------------
    //this function take ddta from api of json and display in recyclerView but not yet complete
//    fun fitshData()
//    {
//        val url="https://raw.githubusercontent.com/forabi/aQuran/gh-pages/resources/quran.json/"
//        val retrofit=Retrofit.Builder()
//            .baseUrl(url)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val api=retrofit.create(Api::class.java)
//        val call=api.getData()
//        var item=call.enqueue(object :Callback<ArrayList<soura>>
//        {
//            override fun onFailure(call: Call<ArrayList<soura>>, t: Throwable) {
//
//            }
//
//            override fun onResponse(call: Call<ArrayList<soura>>, response: Response<ArrayList<soura>>) {
//                val data:ArrayList<soura>?=response.body()!!
//                main_recyclerview.adapter=customAdapterSoura(data!!)
//                Toast.makeText(con,"sucsees",Toast.LENGTH_LONG).show()
//
//            }
//
//        })
//
//    }

//-------------------------------------------------------------------------------------------------------------------
}