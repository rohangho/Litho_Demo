package com.demosample.litho.component

import android.graphics.Color
import androidx.recyclerview.widget.OrientationHelper
import com.demosample.litho.R
import com.demosample.litho.model.NewsModel
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.*
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge


@LayoutSpec
  object TitleComponentSpec {
        @OnCreateLayout
        fun onCreateLayout(c: ComponentContext?,@Prop modelr: NewsModel): Component {
            return Row.create(c).paddingDip(YogaEdge.ALL, 16F)
                .backgroundColor(Color.GRAY).child(
                    Column.create(c).widthPercent(100f)
                            .alignContent(YogaAlign.FLEX_END)
                        .backgroundColor(Color.WHITE)
                        .child(
                            Text.create(c)
                                .text(modelr.soursce)
                                .textSizeSp(15F)
                        )
                        .child(
                            Text.create(c)
                                .text(modelr.headline)
                                .textSizeSp(30F)
                        )

                        .child(
                            Text.create(c)
                                .text(modelr.timeAge)
                                .textSizeSp(10F)
                        )
                ).child(
                    Image.create(c).drawableRes(modelr.imgRes).widthDip(100F)
                            .backgroundColor(Color.WHITE)
                        .heightDip(100F)
                ).build()

        }





}