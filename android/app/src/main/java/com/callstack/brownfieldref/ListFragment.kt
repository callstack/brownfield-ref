package com.callstack.brownfieldref

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val items = listOf("Native Fragment")

class ListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ListItemAdapter(items) {
            findNavController().navigate(R.id.action_ListFragment_to_DetailsFragment)
        }
        recyclerView.adapter = adapter
    }
}
