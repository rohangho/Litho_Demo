package com.demosample.litho.component

import android.graphics.Color
import com.demosample.litho.model.NewsModel
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Image
import com.facebook.litho.widget.Text
import com.facebook.litho.widget.TextAlignment
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge


@LayoutSpec
object TitleComponentSpec {
    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext?, @Prop modelr: NewsModel): Component {
        return Row.create(c).paddingDip(YogaEdge.ALL, 5f)
                .child(
                        Row.create(c).paddingDip(YogaEdge.ALL, 10f)
                                .child(
                                        Column.create(c).widthPercent(100f).alignSelf(YogaAlign.CENTER)
                                                .widthDip(1f)
                                                .child(
                                                        Text.create(c)
                                                                .paddingDip(YogaEdge.LEFT, 10f)
                                                                .text(modelr.soursce)
                                                                .textSizeSp(15F)
                                                )
                                                .child(
                                                        Text.create(c)
                                                                .paddingDip(YogaEdge.LEFT, 10f)
                                                                .text(modelr.headline)
                                                                .textSizeSp(20F)
                                                )

                                                .child(
                                                        Text.create(c).alignment(TextAlignment.LEFT)
                                                                .paddingDip(YogaEdge.LEFT, 10f)
                                                                .text(modelr.timeAge)
                                                                .textSizeSp(10F)
                                                )
                                ).child(
                                        Image.create(c).drawableRes(modelr.imgRes).widthDip(100F).alignSelf(YogaAlign.FLEX_END)
                                                .heightDip(100F)

                                )
                ).build()

    }


}