package com.demosample.litho.component

import android.graphics.Color
import com.demosample.litho.model.NewsModel
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.*
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.OnCheckIsSameContentEvent
import com.facebook.litho.sections.common.OnCheckIsSameItemEvent
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo


@LayoutSpec
object RecyclerComponentSpec {


    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext, @Prop dataModels: List<NewsModel>): Component =
            RecyclerCollectionComponent.create(c)
                    .section(
                            DataDiffSection.create<NewsModel>(SectionContext(c))
                                    .data(dataModels)
                                    .renderEventHandler(RecyclerComponent.onRender(c))
                                    .onCheckIsSameItemEventHandler(RecyclerComponent.isSameItem(c))
                                    .onCheckIsSameContentEventHandler(RecyclerComponent.isSameContent(c))
                                    .build())
                    .backgroundColor(Color.GRAY)
                    .disablePTR(true)
                    .build()


    @OnEvent(RenderEvent::class)
    fun onRender(
            c: ComponentContext,
            @FromEvent model: NewsModel,
    ): RenderInfo =
            ComponentRenderInfo.create()
                    .component(
                            CardComponent.create(c).content(TitleComponent.create(c).modelr(model).build())
//                                    .currentIndices(getUpdatedIndices(parentIndices, index))
                                    .build())
                    .build()


//    private fun getUpdatedIndices(parentIndices: IntArray?, currentIndex: Int): IntArray =
//            if (parentIndices == null) {
//                intArrayOf(currentIndex)
//            } else {
//                val updatedIndices = Arrays.copyOf(parentIndices, parentIndices.size + 1)
//                updatedIndices[parentIndices.size] = currentIndex
//                updatedIndices
//            }


    // Diffutils for object same


    @OnEvent(OnCheckIsSameItemEvent::class)
    fun isSameItem(
            c: ComponentContext,
            @FromEvent previousItem: NewsModel,
            @FromEvent nextItem: NewsModel
    ): Boolean = previousItem === nextItem


    // Diffutils for content same


    @OnEvent(OnCheckIsSameContentEvent::class)
    fun isSameContent(
            c: ComponentContext,
            @FromEvent previousItem: NewsModel?,
            @FromEvent nextItem: NewsModel?
    ): Boolean =

            if (previousItem == null) {
                nextItem == null
            } else {
                nextItem?.headline == previousItem.headline
            }
}
