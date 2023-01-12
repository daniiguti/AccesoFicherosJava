package Controlador;

import Modelo.Alumno;
import RecursosCompartidos.Recursos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CtrlAlumnos {
    RandomAccessFile raf;
    
    //Funciones de abrir:
    //Fichero de objetos serializables
    public void abrirFicheroSerializable(File myFile) throws IOException, ClassNotFoundException{
        FileInputStream fis = null;
        ObjectInputStream ois = null; 
        try{    
            //Escribir en el fichero
            fis = new FileInputStream(myFile);
            ois = new ObjectInputStream(fis); 
            ArrayList<Alumno> aux = (ArrayList<Alumno>) ois.readObject();   
            for(Alumno auxAlumno: aux){
                if(comprobarNumMatricula(auxAlumno.getNumMatricula()) == false){
                    Recursos.alumnos.add(auxAlumno);
                }
            }      
        }catch(IOException ex){
            throw new IOException();
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException();
        }       
        finally{
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {
                throw new IOException();
            }             
        }
    }
    //Fichero de Texto
    public void abrirFicheroTexto(File myFile) throws IOException, ParseException{
        FileReader fr = null;
        BufferedReader br = null;
        String fraseLeida = "";
        try {              
            fr = new FileReader(myFile);
            br = new BufferedReader(fr);
            do{             
                fraseLeida = br.readLine();
                if(fraseLeida != null){
                      
                    int primerAsterisco = fraseLeida.indexOf("*");
                    int numMatricula = Integer.parseInt(fraseLeida.substring(0, primerAsterisco));                                           
                    fraseLeida = fraseLeida.substring(primerAsterisco+1, fraseLeida.length());
                       
                    int segundoAsterisco = fraseLeida.indexOf("*");                        
                    String nombre = fraseLeida.substring(0, segundoAsterisco);                         
                    fraseLeida = fraseLeida.substring(segundoAsterisco+1, fraseLeida.length());                      
                        
                    int tercerAsterisco = fraseLeida.indexOf("*");
                    String fechaNac = fraseLeida.substring(0, tercerAsterisco);                        
                    Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
                    fraseLeida = fraseLeida.substring(tercerAsterisco+1, fraseLeida.length());                       
                        
                    int cuartoAsterisco = fraseLeida.indexOf("*");
                    double notaMedia = Double.parseDouble(fraseLeida.substring(0, cuartoAsterisco));
                    fraseLeida = fraseLeida.substring(cuartoAsterisco+1, fraseLeida.length());                                              
                        
                    int edad = Integer.parseInt(fraseLeida.substring(0, fraseLeida.length()));                      
                        
                    Alumno aux = new Alumno(numMatricula, nombre, fecha, notaMedia, edad);                      
                    if(comprobarNumMatricula(numMatricula) == false){
                       Recursos.alumnos.add(aux);                      
                    }    
                }    
            }while(fraseLeida != null);

        } catch (IOException ex) {
            throw new IOException();
        } catch (ParseException ex) {
            throw new ParseException("",0);
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
               throw new IOException();
            }                
        }
    }
    //Fichero XML
    public void abrirFicheroXML(File myFile){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;
        
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(myFile);
        } catch (ParserConfigurationException ex) {
           
        } catch (SAXException ex) {
            
        } catch (IOException ex) {
            
        }
        
        //nodo raiz
        Element listaAlumnos = document.getDocumentElement();
        //nodos hijos
        NodeList alumnos = listaAlumnos.getChildNodes();
        
        //Atributos de cada alumno
        int numMatricula = 0;
        String nombre = "";
        Date fechaNac = null;
        double notaMedia = 0;
        int edad = 0;
        
        for(int i = 0; i < alumnos.getLength(); i++){
            Node alumno = alumnos.item(i);
            if(alumno instanceof Element){

                NodeList informacionAlumno = alumno.getChildNodes();
                for(int j = 0; j < informacionAlumno.getLength(); j++){
                    Node nodo2 = informacionAlumno.item(j);
                    if(nodo2.getNodeName() == "Matricula"){
                        NodeList hijos = nodo2.getChildNodes();
                        Node node3 = hijos.item(0);                        
                        numMatricula = Integer.parseInt(node3.getNodeValue());
                    }
                    if(nodo2.getNodeName() == "Nombre"){
                        NodeList hijos = nodo2.getChildNodes();
                        Node node3 = hijos.item(0);      
                        nombre = node3.getNodeValue();
                    }
                    if(nodo2.getNodeName() == "FechaNacimiento"){
                        NodeList hijos = nodo2.getChildNodes();
                        Node node3 = hijos.item(0);      
                        String auxFecha = node3.getNodeValue();
                        try {
                            fechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(auxFecha);
                        } catch (ParseException ex) {
 
                        }
                    }
                    if(nodo2.getNodeName() == "NotaMedia"){
                        NodeList hijos = nodo2.getChildNodes();
                        Node node3 = hijos.item(0);      
                        notaMedia = Double.parseDouble(node3.getNodeValue());
                    }
                    if(nodo2.getNodeName() == "Edad"){
                        NodeList hijos = nodo2.getChildNodes();
                        Node node3 = hijos.item(0);      
                        edad = Integer.parseInt(node3.getNodeValue());
                    }                    
                }
                if(comprobarNumMatricula(numMatricula) == false){
                    Alumno aux = new Alumno(numMatricula, nombre, fechaNac, notaMedia, edad);
                    Recursos.alumnos.add(aux);
                }            
            }    
        }
    }
    public void abrirFicheroDirecto(File myFile){
        int contador = 0;
        try {
            raf = new RandomAccessFile(myFile,"rw");
        } catch (FileNotFoundException ex) {
        }
        
        int tamanio = 62;
        long pos = 0;
        try{
            int numRegistros = (int)myFile.length()/tamanio;
            for(int i = 0; i < numRegistros; i++){
                pos = (i)*tamanio;
                raf.seek(pos);
                
                int auxMatri = raf.readInt();
                if(auxMatri != 0){
                    int numMatricula = auxMatri;
                    String nombre = leerCaracteres(15);
                    String fecha = leerCaracteres(10);
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
                    Double notaMedia = raf.readDouble();
                    int edad = raf.readInt();
                    Alumno aux = new Alumno(numMatricula, nombre, date1, notaMedia, edad);
                    if(comprobarNumMatricula(numMatricula) == false){                       
                        Recursos.alumnos.add(aux);
                    }
                }
            }
        }catch(IOException ex){
            
        } catch (ParseException ex) {
            
        }    
    }
    
    //Funciones de Guardar:
    //Fichero de objetos serializables
    public void guardarFicheroSerializable(File myFile) throws FileNotFoundException, IOException{
        FileOutputStream fos = null;
        ObjectOutputStream oos = null; 
        try{    
            //Escribir en el fichero
            fos = new FileOutputStream(myFile);
            oos = new ObjectOutputStream(fos); 
            oos.writeObject(Recursos.alumnos);           
               
        }catch(FileNotFoundException ex){
            throw new FileNotFoundException();
        }    
        catch(IOException ex){
            throw new IOException();
        }       
        finally{
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                throw new IOException();
            }             
        }
    }
    //Fichero de Texto
    public void guardarFicheroTexto(File myFile) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {              
            fw = new FileWriter(myFile);
            bw = new BufferedWriter(fw);
            for(Alumno aux: Recursos.alumnos){                    
                int numExp = aux.getNumMatricula();
                String nombre = aux.getNombreAlumno();
                Date date = aux.getFechaNac();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(date);
                double notaMedia = aux.getNotaMedia();
                int edad = aux.getEdad();                       
                   
                String lineaEscribir = numExp + "*" + nombre + "*" + fecha + "*" + notaMedia + "*" + edad + "\n";
                bw.write(lineaEscribir);
            }

        } catch (IOException ex) {
            throw new IOException();
        }finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
               throw new IOException();
            }                
        }
    }
    //Fichero XML
    public void guardarArchivoXML(File rutaArchivo){
        Document doc = null;
        Transformer xformer = null;
        Source source;
        Result result;    
        
        //Inicializamos el doc a un arbol dom vacio
        doc = inicializarDoc();
        Date fecha = null;
        
        //Nos creamos la etiqueta raiz <listaVideojuegos>
        Node nodoRaiz = doc.createElement("listaAlumnos");
        //Hay que añadirla a algo, al padre, como es la raiz, la añadimos al doc
        doc.appendChild(nodoRaiz);
        
        //Recorremos el array
        for(Alumno aux: Recursos.alumnos){
            //Nodo padre
            Element alumno = doc.createElement("Alumno");
            alumno.setAttribute("id", aux.getNumMatricula() + "");
            nodoRaiz.appendChild(alumno);
          
            //Matricula
            //Nos creamos una etiqueta 
            //<Matricula>
            Node matricula  = doc.createElement("Matricula");
            //<Matricula>123</Matricula>
            //Le damos el texto que hay dentro de la etiqueta
            matricula.setTextContent(aux.getNumMatricula() + "");
            //Añadimos la eitqueta a su padre, en este caso alumno
            alumno.appendChild(matricula);
            
            //Nombre
            Node nombre = doc.createElement("Nombre");
            nombre.setTextContent(aux.getNombreAlumno());
            alumno.appendChild(nombre);
            
            //Fecha
            Node fechaNac = doc.createElement("FechaNacimiento");
            //Date fecha = aux.getFechaNac();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaAux = sdf.format(fecha);
            fechaNac.setTextContent(fechaAux);
            alumno.appendChild(fechaNac);       
            
            //Nota media
            Node notaMedia = doc.createElement("NotaMedia");
            notaMedia.setTextContent(aux.getNotaMedia() + "");
            alumno.appendChild(notaMedia);
            
            //Edad
            Node edad = doc.createElement("Edad");
            edad.setTextContent(aux.getEdad() + "");
            alumno.appendChild(edad);
        }

        //Inicializamos el transformer
        try {
            xformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerFactoryConfigurationError e) {
                
        } catch (TransformerConfigurationException ex) {
              
        }
        
        //Propiedades del fichero XML de salida
        xformer.setOutputProperty(OutputKeys.METHOD, "xml");
        xformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        
        //Definimos la Entrada y la Salida de la Transformacion
        source = new DOMSource(doc); //el doc donde tenemos el arraylist transformado en dom
        result = new StreamResult(rutaArchivo); //donde vamos a guardar el dom
 
        //Realizamos la Transformación mediante el metodo transform()
        try {
            xformer.transform(source, result);
        } catch (TransformerException e) {
            
        }
    }    
    public void guardarFicheroDirecto(File myFile){
        try {
            raf = new RandomAccessFile(myFile,"rw");
        } catch (FileNotFoundException ex) {
        }
        
        int tamanio = 62;
        long pos = 0;
        for(int i = 0; i < Recursos.alumnos.size(); i++){
            Alumno auxAlumno = Recursos.alumnos.get(i);
            pos = ((auxAlumno.getNumMatricula() - 1) * tamanio);
               
            try {
                //Situamos el puntero en esa posicion
                raf.seek(pos);
                 
            } catch (IOException ex) {
            }
            
            try {
                raf.writeInt(auxAlumno.getNumMatricula());
                
                StringBuffer sb = new StringBuffer(auxAlumno.getNombreAlumno());
                sb.setLength(15);
                raf.writeChars(sb.toString());
                
                Date dateAlumno = auxAlumno.getFechaNac();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(dateAlumno);
                StringBuffer sb2 = new StringBuffer(fecha);
                sb2.setLength(10);
                raf.writeChars(sb2.toString());
                
                raf.writeDouble(auxAlumno.getNotaMedia());
                
                raf.writeInt(auxAlumno.getEdad());
            } catch (IOException ex) {
            }
        }
    }
    
    //Métodos auxiliares
    public boolean comprobarNumMatricula(int numMatricula){
        boolean yaExiste = false;
        for(Alumno aux: RecursosCompartidos.Recursos.alumnos){
            if(aux.getNumMatricula() == numMatricula){
                yaExiste = true;
            }
        }
        return yaExiste;
    }
    
    private Document inicializarDoc() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
        } catch (ParserConfigurationException ex) {
            
        }
        return doc;
    }
    
    private String leerCaracteres(int limite){
        String aux ="";
        for(int j=0; j < limite; j++){
            try{
                aux = aux + raf.readChar();
            }catch(IOException ex){
            }
        }
        return aux;
    }

}
