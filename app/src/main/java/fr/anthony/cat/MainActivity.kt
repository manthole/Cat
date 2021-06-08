package fr.anthony.cat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.anthony.cat.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger catrepos
        val repo = CatRepository()

        //MAJ de la liste de chat
        repo.updateData{
            //injecter le fragment dans notre container
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_main_page,HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}