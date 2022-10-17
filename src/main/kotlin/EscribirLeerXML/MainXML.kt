import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

fun main() {

    /*
    LEER ARCHIVOS XML
     */

    //Para leer archivos XML usamos una implementacion del DOM
    //Esta implementacion está en DocumentBuilderFactory

    //1º Abrimos el archivo xml (igual que en casos anteriores)
    val ficheroXML: File = File("resources/productos.xml")

    //2º Debemos construir nuestro arbol DOM.
    //Para ello debemos usar varios métodos
    val ficheroXMLDOM: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ficheroXML)

    //(Opcional) Podemos usar la funcion .normalize() para eliminar nodos vacios
    ficheroXMLDOM.documentElement.normalize()

    println(ficheroXMLDOM.documentElement) //Imprime el elemento del documento (El nodo padre)
    println(ficheroXMLDOM.nodeType) //Imprime el elemento del documento (El nodo padre)

    //Obtenemos todos los elementos con tagName = producto
    val productos: NodeList = ficheroXMLDOM.getElementsByTagName("producto")

    //Ahora empezamos a iterar sobre esa NodeList, sobre el arbol DOM
    //Aquí empiezan los jajas
    for (i in 0..productos.length - 1) {
        println("Tipo Nodo: ${productos.item(i).nodeType}")
        if (productos.item(i).nodeType == Node.ELEMENT_NODE) {
            var producto: Element = productos.item(i) as Element

            var itemsProducto: NodeList = producto.childNodes

            for (j in 0..itemsProducto.length - 1) {

                if (itemsProducto.item(j).nodeType == Node.ELEMENT_NODE) {
                    var item: Element = itemsProducto.item(j) as Element
                    println("${item.tagName}: ${item.textContent}")
                }
            }

        }


    }


}