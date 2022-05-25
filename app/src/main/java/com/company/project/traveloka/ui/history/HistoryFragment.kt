package com.company.project.traveloka.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.project.traveloka.data.local.model.entitiy.history.History
import com.company.project.traveloka.databinding.FragmentHistoryBinding
import com.company.project.traveloka.ui.history.adapter.ListHistoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(HistoryViewModel::class.java)

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        binding.recyclerViewHome.layoutManager = LinearLayoutManager(context)
        val adapter = ListHistoryAdapter()
        adapter.setStoryList(generateDummyHistory())
        binding.recyclerViewHome.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun generateDummyHistory(): List<History> {
        val historyList = ArrayList<History>()
        for (i in 1..10) {
            val history = History(
                i,
                123456,
                "Kamis, 19 May 2022",
                "The Sultan Hotel & Residence Jakarta (The Sultan Hotel & Residence)\n",
                "Purchase Success",
                123456.123
            )
            historyList.add(history)
        }
        return historyList
    }
}
