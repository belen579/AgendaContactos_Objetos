package com.example.agendacontactos_objetos.Data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.agendacontactos_objetos.R

class viewModelContacto: ViewModel() {


     val contacto = mutableStateOf(Contacto(nombre = "", telefono ="", email ="", foto = R.drawable.ic_launcher_background, id =0))


    var list = listOf<Contacto>()


    init {


        list = listOf(
            Contacto("Ana", "655889963", "ana@gmail.com", R.drawable.ana, 1),
            Contacto("Abuelo", "655889967", "abuelo@gmail.com", R.drawable.abuelo, 2),
            Contacto("Abuela", "655888963", "abuela@gmail.com", R.drawable.abuela, 3),
            Contacto("Tio", "655889973", "tio@gmail.com", R.drawable.tio, 4),
            Contacto("Juan", "655886663", "juan@gmail.com", R.drawable.chico1, 5),
                    Contacto("Camilo", "677889963", "camilo@gmail.com", R.drawable.camilo, 6),
        Contacto("Angel", "663389967", "angel@gmail.com", R.drawable.angel, 7),
        Contacto("Natalia", "677888963", "natalia@gmail.com", R.drawable.natalia, 8),
        Contacto("Ivan", "666559973", "ivan@gmail.com", R.drawable.ivan, 9),
        Contacto("Raquel", "612346663", "raquel@gmail.com", R.drawable.raquel, 10)
        )
    }


}