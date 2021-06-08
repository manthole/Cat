package fr.anthony.cat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.anthony.cat.CatModel
import fr.anthony.cat.CatRepository.Singleton.catList
import fr.anthony.cat.MainActivity
import fr.anthony.cat.R
import fr.anthony.cat.adapter.CatAdapter
import fr.anthony.cat.adapter.CatItemDecoration

class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        //récupère le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = CatAdapter(context, catList,R.layout.item_horizontal_cat)

        //récupère le second recycleview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = CatAdapter(context, catList,R.layout.item_vertical_cat)
        verticalRecyclerView.addItemDecoration(CatItemDecoration())

        return view
    }
}