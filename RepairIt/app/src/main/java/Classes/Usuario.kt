package Classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id:Int?,

    @ColumnInfo(name = "username" )
    val username:String?,
    @ColumnInfo(name = "password" )
    val password:String?,
    @ColumnInfo(name = "apellidos" )
    val apellidos:String?,
    @ColumnInfo(name = "nombres" )
    val nombres:String?,
    @ColumnInfo(name = "correo" )
    val correo:String?,
    @ColumnInfo(name = "userType")
    val userType: String?,
    )
