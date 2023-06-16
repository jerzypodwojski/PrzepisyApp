package com.example.przepisyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.przepisyapp.ListFragment.Global.Companion.categoryNumber
import com.example.przepisyapp.ListFragment.Global.Companion.isCategory


class ListFragment : Fragment(R.layout.fragment_list) {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_list, container, false)
    }
    class Global {
        companion object {
            var isCategory: Boolean = true
            var categoryNumber: Int = 0
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var dishes: Array<String>
        if (isCategory){
            dishes = arrayOf(
                "1 Mięsne", "2 Wegańskie", "3 Kuchnia Polska", "4 Kuchnia Zagraniczna", "5 Zupy",
                "6 Drugie Dania", "7 Surówki i sałatki", "8 Ciastka i desery"
            )
        }else {
            when (categoryNumber) {
                1 -> dishes = arrayOf(
                    "1 Amerykańskie burgery z pieczarkami i sadzonym jajem",
                    "2 Grillowane piersi z kurczaka z rozmarynem"
                )

                2 -> dishes = arrayOf(
                    "1 Wegańskie spaghetti bolognese",
                    "2 Wegańska lasagne w stylu bolognese"
                )

                3 -> dishes = arrayOf(
                    "1 Barszcz polski",
                    "2 Polskie łazanki z kapustą"
                )

                4 -> dishes = arrayOf(
                    "1 Kartoffelsalat",
                    "2 Reibekuchen, czyli chrupiące niemieckie placki ziemniaczane"
                )

                5 -> dishes = arrayOf(
                    "1 Zupa grzybowa kremowa",
                    "2 Zupa cebulowa"
                )

                6 -> dishes = arrayOf(
                    "1 Pieczeone parówki ze śliwką",
                    "2 Indyk w marynacie jogurtowej (hinduskiej)"
                )

                7 -> dishes = arrayOf(
                    "1 Sałatka zielona",
                    "2 Sałatka Szwedzka"
                )

                else -> dishes = arrayOf(
                    "1 Włoskie ciastka z warzywami",
                    "2 Proste ciastka"
                )
            }
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerAdapter(dishes)
    }
}