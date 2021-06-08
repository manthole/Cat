package fr.anthony.cat

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.anthony.cat.CatRepository.Singleton.catList
import fr.anthony.cat.CatRepository.Singleton.databaseRef

class CatRepository {

    object Singleton {
        // se connecter à la réf Chat
        val databaseRef = FirebaseDatabase.getInstance().getReference("chats")

        //créer une liste de chat
        val catList = arrayListOf<CatModel>()

    }

    fun updateData(callback: () -> Unit) {
        //récuperer les donnée -> list de chats
        databaseRef.addValueEventListener(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //retirer les anciens chat
                catList.clear()

                //recolter la liste
                for (ds in snapshot.children){
                    //construire un objet chat
                    val chat = ds.getValue(CatModel::class.java)

                    //verifier que le chat n'est pas null
                    if(chat != null) {
                        //ajoute le chat à notre liste
                        catList.add(chat)
                    }
                }
                //actionner le callback
                callback()
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}