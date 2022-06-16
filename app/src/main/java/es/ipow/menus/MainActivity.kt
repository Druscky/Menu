package es.ipow.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import es.ipow.menus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    companion object {
        private val ID_GROUP_BR = Menu.FIRST
        private val ID_ELEMENTO_CHECKBOX = Menu.FIRST
        private val ID_BOTONRADIO_1 = Menu.FIRST + 1
        private val ID_BOTONRADIO_2 = Menu.FIRST + 2
        private val ID_BOTONRADIO_3 = Menu.FIRST + 3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu)
//        // Identificador de grupo
//        val groupId = Menu.NONE
//        // Identificador único del elemento del menú
//        val itemId = ID_MENU_SETTINGS
//        // Posición del elemento. Con NONE indicamos que nos es indiferente
//        val itemOrder = Menu.NONE
//        // Texto de la opción del menú
//        val itemText = "Settings"
//        // Creamos el elemento con todos esto datos
//        val item = menu?.add(groupId, itemId, itemOrder, itemText)
//        return true
//    }
//  onCreateOptionsMenu sólo se ejecuta una una vez, cuando se crea el menú.
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu)
//        // Creamos un elemento del tipo CheckBox
//        menu?.add(Menu.NONE, ID_ELEMENTO_CHECKBOX, Menu.NONE, "Checkbox")?.setCheckable(true)
//        // Creamos un grupo de botones Radio
//        menu?.add(ID_GROUP_BR, ID_BOTONRADIO_1, Menu.NONE, "Opción 1")
//        menu?.add(ID_GROUP_BR, ID_BOTONRADIO_2, Menu.NONE, "Opción 2")
//        menu?.add(ID_GROUP_BR, ID_BOTONRADIO_3, Menu.NONE, "Opción 3")?.setChecked(true)
//        menu?.setGroupCheckable(ID_GROUP_BR, true, true)
//        val sub = menu?.addSubMenu(0,0,Menu.NONE, "Llamada Submenú")
//        sub?.setHeaderIcon(R.drawable.icons8_spider_16)
//        sub?.add(0,0,Menu.NONE, "Elemento Submenú")
//        return true
//    }

//  onPrepareOptionsMenu se ejecuta siempre que se llama al menú.
//  Esto nos permite modificar el menú dinámicamente
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        super.onPrepareOptionsMenu(menu)
        var menuItem = menu?.findItem(ID_BOTONRADIO_2)
        menuItem?.setTitle("Papafrita")
        menuItem = menu?.findItem(ID_BOTONRADIO_3)
        menuItem?.setIcon(R.drawable.icons8_spider_32)
        menuItem?.setTitle(R.string.app_name)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId){
            ID_ELEMENTO_CHECKBOX -> {
                Snackbar.make(b.root, "Checkbox", Snackbar.LENGTH_SHORT).show()
                return true}
            ID_BOTONRADIO_1 -> {
                Snackbar.make(b.root, "RadioButton 1", Snackbar.LENGTH_SHORT).show()
                return true}
            ID_BOTONRADIO_2 -> {
                Snackbar.make(b.root, "RadioButton 2", Snackbar.LENGTH_SHORT).show()
                return true}
        }
        // Devolvemos false si no hemos hecho nada con el item
        return false
    }
    // Con la fución onCreateOptionsMenu lanzamos nuestro menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        // Asociamos el fichero de recurso /res/menu/custom_menu.xml
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

}