package com.company.project.traveloka.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.company.project.traveloka.data.model.history.History
import com.company.project.traveloka.databinding.ItemRowHistoryBinding

class ListHistoryAdapter :
    RecyclerView.Adapter<ListHistoryAdapter.HistoryViewHolder>() {

    private var histories: List<History>? = null

    fun setStoryList(histories: List<History>?) {
        this.histories = histories
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ListHistoryAdapter.HistoryViewHolder {
        val view =
            ItemRowHistoryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListHistoryAdapter.HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListHistoryAdapter.HistoryViewHolder, position: Int) {
        val data = histories!![position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = histories?.size!!

    class HistoryViewHolder(private val binding: ItemRowHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(history: History) {

//            val zonedDateTime = ZonedDateTime.parse(story.createdAt)
//            val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale("id", "ID"))

//            itemView.setOnClickListener {
//                val intent = Intent(itemView.context, DetailActivity::class.java)
//                intent.putExtra(DetailActivity.extraStory, story)
//
//                val optionsCompat: ActivityOptionsCompat =
//                    ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        itemView.context as Activity,
//                        Pair(binding.imgItemPhoto, "storyImage"),
//                        Pair(binding.tvName, "name"),
//                        Pair(binding.tvDate, "date"),
//                        Pair(binding.tvDescription, "description"),
//                    )
//                itemView.context.startActivity(intent, optionsCompat.toBundle())
//            }
            binding.apply {
                tvBookingId.text = history.bookingId.toString()
                tvDate.text = history.date
                tvProductName.text = history.productName
                tvStatus.text = history.status
                tvPrice.text = history.price.toString()
            }
        }
    }
}
