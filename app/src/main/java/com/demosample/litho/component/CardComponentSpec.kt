package com.demosample.litho.component

import android.graphics.Color
import com.demosample.litho.R
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Card
import com.facebook.yoga.YogaEdge


@LayoutSpec
object CardComponentSpec {


    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext?, @Prop content: Component): Component {
        return Row.create(c).paddingDip(YogaEdge.ALL, 5f).child(
                Card.create(c)
                        .content(content).
                        cornerRadiusDip(20f).
                        transparencyEnabled(true)
                        .build()
        )
                .build()

    }


}