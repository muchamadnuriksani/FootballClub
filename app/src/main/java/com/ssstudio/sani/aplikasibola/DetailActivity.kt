package com.ssstudio.sani.aplikasibola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = intent.getParcelableExtra<Item>(MainActivity.parcelableData)
        DetailActivityUI(items).setContentView(this)
    }

    class DetailActivityUI(val items: Item) : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                imageView {
                    Picasso.get().load(items.image).into(this)
                }.lparams(dip(100), dip(100)) {
                    gravity = Gravity.CENTER_HORIZONTAL
                    padding = dip(10)
                }

                textView {
                    text = items.name
                    textSize = sp(7).toFloat()
                }.lparams {
                    gravity = Gravity.CENTER_HORIZONTAL
                    bottomMargin = dip(8)
                }
                textView {
                    text = items.desc
                    textSize = sp(5).toFloat()
                }.lparams {
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
        }
    }
}