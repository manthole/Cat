package fr.anthony.cat.adapter

import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.anthony.cat.CatModel
import fr.anthony.cat.R
import java.security.interfaces.RSAMultiPrimePrivateCrtKey
import com.bumptech.glide.Glide
import fr.anthony.cat.MainActivity

class CatAdapter(

    private val context: MainActivity,
    private val catList: List<CatModel>,
    private val layoutID :Int
    ) : RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    //boite pour ranger les images à placer
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val catImage = view.findViewById<ImageView>(R.id.image_item)
        val catName:TextView? =  view.findViewById(R.id.name_item)
        val catDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutID, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //récupère les informations du chat
        val currentCat = catList[position]

        //Glide
        Glide.with(context).load(Uri.parse(currentCat.imageUrl)).into(holder.catImage)

        //mettre à jour le nom du chat
        holder.catName?.text = currentCat.name

        //mettre à jour la description du chat
        holder.catDescription?.text = currentCat.description

        //verification du like du chat
        if(currentCat.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_iclike)
        }
        else {
            holder.starIcon.setImageResource(R.drawable.ic_unlike)
        }
    }

    override fun getItemCount(): Int = catList.size


}