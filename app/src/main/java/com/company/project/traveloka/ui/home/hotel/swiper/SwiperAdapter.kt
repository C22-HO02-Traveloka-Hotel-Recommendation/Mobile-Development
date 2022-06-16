package com.company.project.traveloka.ui.home.hotel.swiper

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.company.project.traveloka.R
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.ui.home.hotel.detail.DetailActivity
import com.company.project.traveloka.ui.home.hotel.detail.DetailActivity.Companion.extraHotel

class SwiperAdapter(private val hotels: List<Hotel>, private val context: Context) :
    PagerAdapter() {

    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return hotels.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        layoutInflater = LayoutInflater.from(context)
        val view: View? = layoutInflater?.inflate(R.layout.item_recommendation, container, false)

        val imageView: ImageView? = view?.findViewById(R.id.image)
        val title: TextView? = view?.findViewById(R.id.title)
        val desc: TextView? = view?.findViewById(R.id.desc)

        Glide.with(context)
            .load(hotels[position].image)
            .placeholder(R.drawable.ic_block)
            .into(imageView!!)
        title?.text = hotels[position].name
        val price = hotels[position].price?.div(1000)
        desc?.text = StringBuilder().append("Rp").append(price).append("k /Night")

        view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(extraHotel, hotels[position])
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
