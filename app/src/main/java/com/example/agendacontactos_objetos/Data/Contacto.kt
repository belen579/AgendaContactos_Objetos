package com.example.agendacontactos_objetos.Data

import java.io.Serializable

data class Contacto(var nombre: String, var telefono:String, var email:String, val foto: Int, val id: Int):Serializable