package com.demosample.litho

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demosample.litho.component.RecyclerComponent
import com.demosample.litho.model.NewsModel
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView

class MainActivity : AppCompatActivity() {


    private var demoList = ArrayList<NewsModel>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        for (i in 1..9) {
            demoList.add(NewsModel("google", "Demo news", "0 min", R.drawable.ic_android_black_24dp))
        }

        var c = ComponentContext(this)

        setContentView(
                LithoView.create(
                        this,
                        RecyclerComponent.create(c)
                                .dataModels(demoList)

                                .build()))
    }

}

