package Interfaces

import Classes.Usuario
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inser(usuario: Usuario)

    @Query("select * from users")
    fun listaUsers():List<Usuario>

    @Query("select * from users where username=(:username) and password = (:password)")
    fun getUser(username: String, password: String): Usuario
}