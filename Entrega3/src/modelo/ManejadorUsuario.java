package modelo;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejadorUsuario {
	private static final File XML_Usuarios = new File("data/usuarios.xml");
	private static final String USUARIO = "USUARIO";
	private static final String USUARIOS = "USUARIOS";
	private Document document;
	
	public ManejadorUsuario() throws SAXException, IOException, ParserConfigurationException {
		this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Usuarios);
	}
	
	public void agregarUsuario(Usuario usuario) throws TransformerException {
		Element elementoUsuario = document.createElement(USUARIO);
		elementoUsuario.setAttribute("usuario", usuario.getNombreUsuario());
		elementoUsuario.setAttribute("contraseña", usuario.getContraseña());
		elementoUsuario.setAttribute("nombre", usuario.getNombre());
		elementoUsuario.setAttribute("documento", usuario.getDocumento());
		
		// Comprueba si es un objeto tipo administrador
		if (usuario instanceof Administrador) {
			elementoUsuario.setAttribute("type", "administrador");
		}
		
		// Comprueba si es un objeto tipo huesped
		else if (usuario instanceof Huesped) {
			Huesped usuarioHuesped = (Huesped) usuario;
			elementoUsuario.setAttribute("type", "huesped");
			elementoUsuario.setAttribute("edad", Integer.toString(usuarioHuesped.getEdad()));
			elementoUsuario.setAttribute("correo", usuarioHuesped.getCorreoElectronico());
			elementoUsuario.setAttribute("correo", usuarioHuesped.getCorreoElectronico());
			elementoUsuario.setAttribute("telefono", usuarioHuesped.getTelefono());
		}
		
		// Comprueba si es un objeto tipo empleado
		else if (usuario instanceof Empleado) {
			Empleado usuarioEmpleado = (Empleado) usuario;
			elementoUsuario.setAttribute("type", "empleado");
			elementoUsuario.setAttribute("servicio", usuarioEmpleado.getServicioEncargado());
		}
		
		// Agregar el nodo de usuario al final del archivo
        Node usuariosNode = document.getElementsByTagName(USUARIOS).item(0);
        usuariosNode.appendChild(elementoUsuario);
		
     // Guardar los cambios en el archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(XML_Usuarios);
        transformer.transform(source, result);
	}
	
	public Usuario obtenerUsuario(String nombreUsuario, String contraseña) {
		NodeList nodosUsuarios = document.getElementsByTagName(USUARIO);
		
		// Recorre los elementos Usuarios
		for (int i = 0; i < nodosUsuarios.getLength(); i++) {
	        Element elementoUsuario = (Element) nodosUsuarios.item(i);
	        String usuario = elementoUsuario.getAttribute("usuario");
	        String pass = elementoUsuario.getAttribute("contraseña");
	        
	        // Comprueba si el nombre y contraseña son correctos
	        if (usuario.equals(nombreUsuario) && pass.equals(contraseña)) {
	            String type = elementoUsuario.getAttribute("type");
	            String nombre = elementoUsuario.getAttribute("nombre");
	            String documento = elementoUsuario.getAttribute("documento");
	            
	            // Si es un administrador crea el objeto y lo retorna
	            if ("administrador".equals(type)) {
	                return new Administrador(nombreUsuario, contraseña, nombre, documento);
	            // Si es un huesped crea el objeto y lo retorna
	            } else if ("huesped".equals(type)) {
	                int edad = Integer.parseInt(elementoUsuario.getAttribute("edad"));
	                String correo = elementoUsuario.getAttribute("correo");
	                String telefono = elementoUsuario.getAttribute("telefono");
	                
	                return new Huesped(nombreUsuario, contraseña, nombre, documento, edad, correo, telefono);
	            // Si es un empleado crea el objeto y lo retorna
	            } else if ("empleado".equals(type)) {
	                String servicio = elementoUsuario.getAttribute("servicio");
	                
	                return new Empleado(nombreUsuario, contraseña, nombre, documento, servicio);
	            }
	        }
	    }
		// En caso de que no exista retorna null
	    return null;
	}
	

}
