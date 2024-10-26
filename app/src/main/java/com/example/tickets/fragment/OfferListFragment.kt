package com.example.tickets.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tickets.R
import com.example.tickets.adapter.OfferListAdapter
import com.example.tickets.databinding.FragmentOfferListBinding
import com.example.tickets.model.entity.Offer
import com.example.tickets.model.network.ApiClient
import com.example.tickets.model.service.FakeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OfferListFragment : Fragment() {

    companion object {
        fun newInstance() = OfferListFragment()
    }

    private var _binding: FragmentOfferListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: OfferListAdapter by lazy {
        OfferListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfferListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        adapter.setItems(FakeService.offerList)
//        ApiClient.client.fetchOfferList().enqueue(object : Callback<List<Offer>> {
//            override fun onResponse(p0: Call<List<Offer>>, p1: Response<List<Offer>>) {
//                val offerList = p1.body()
//                if (offerList != null ){
//                    adapter.setItems(offerList)
//                }
//
//            }
//
//            override fun onFailure(p0: Call<List<Offer>>, p1: Throwable) {
//                println("RetrofitRequest__: ${p1}")
//                adapter.setItems(FakeService.offerList)
//            }
//        })

    }



    private fun setupUI() {
        with(binding) {
            offerList.adapter = adapter

            sortRadioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.sort_by_price -> {
                        /**
                         * implement sorting by price
                         * hint: you can take the current list using getCurrentList method of ListAdapter instance
                         */
                        adapter.setItems(adapter.getCurrentList().sortedBy { it.price })
                    }

                    R.id.sort_by_duration -> {
                        /**
                         * implement sorting by duration
                         * hint: you can take the current list using getCurrentList method of ListAdapter instance
                         */
                        adapter.setItems(adapter.getCurrentList().sortedBy { it.flight.duration})
                    }
                }
            }
        }
    }
}