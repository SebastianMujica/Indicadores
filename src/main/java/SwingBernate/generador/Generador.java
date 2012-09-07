package SwingBernate.generador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Productor.Productor;
import Reporte.Reporte;
import Reporte.modeloReporte;
import antlr.CharBuffer;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
//import com.sun.codemodel.*;

//import org.eclipse.core.resources.IFile;


import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.eclipse.jdt.core.dom.ArrayAccess;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InstanceofExpression;
import org.eclipse.jdt.core.dom.MemberRef;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.InfixExpression.Operator;
import org.eclipse.jdt.core.dom.PrimitiveType.Code;
import org.eclipse.jdt.internal.compiler.ast.Argument;

import com.sun.codemodel.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.xml.bind.v2.schemagen.xmlschema.SimpleType;
//import org.eclipse.core.runtime.Plugin;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.jface.text.Document;




import javax.persistence.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.text.StyledEditorKit.BoldAction;


public class Generador {
	String javabean;
	String paquete;
	String salida;
	ArrayList atributos;
	CompilationUnit JavaBean;
	CompilationUnit Modelo;
	CompilationUnit Vista;
	CompilationUnit Controlador;
	
	/**
	 * @param args
	 */
	public Generador(){
	};
	public Generador(String[] args){
		YamlReader reader;
		YamlReader instructor;
		try {
			reader     = new YamlReader(new FileReader(args[0]));
			//instructor = new YamlReader(new FileReader(args[1]));	

			//Object plantilla= instructor.read();
			Object object   = reader.read();
			
			Map objeto = (Map)object;
			//Map guia   = (Map)plantilla;

			this.javabean=objeto.get("nombredelaclase").toString();
			this.atributos=(ArrayList) objeto.get("atributos");
			
			this.paquete=this.javabean;
			/*if(objeto.get("paquete").toString().equals(null)){
				this.paquete=this.javabean;	
			}else{
				//TODO Manejo de Paquetes Espesificos
				String paquete=objeto.get("paquete").toString();
				this.paquete=objeto.get("paquete").toString();;
			}*/
			
			

			Runtime r=Runtime.getRuntime();
			r.exec("mkdir "+args[1]+javabean);
			this.salida=args[1]+"/";
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (YamlException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}
	public static JType getTypeDetailsForCodeModel(JCodeModel jCodeModel, String type) {
		if (type.equals("Unsigned32")) {
			return jCodeModel.LONG;
		} else if (type.equals("Unsigned64")) {
			return jCodeModel.LONG;
		} else if (type.equals("Integer32")) {
			return jCodeModel.INT;
		} else if (type.equals("Integer64")) {
			return jCodeModel.LONG;
		} else if (type.equals("Enumerated")) {
			return jCodeModel.INT;
		} else if (type.equals("Float32")) {
			return jCodeModel.FLOAT;
		} else if (type.equals("Float64")) {
			return jCodeModel.DOUBLE;
		}  else if (type.equals("void")) {
			return jCodeModel.VOID;
		} else {
			return null;
		}

	}
	public static boolean isPrimitive(String nombre){
		if (nombre.equals("void"))
			return true;
		else if (nombre.equals("boolean"))
			return true;
		else if (nombre.equals("byte"))
			return true;
		else if (nombre.equals("short"))
			return true;
		else if (nombre.equals("char"))
			return true;
		else if (nombre.equals("int"))
			return true;
		else if (nombre.equals("float"))
			return true;
		else if (nombre.equals("long"))
			return true;
		else if (nombre.equals("double"))
			return true;
		else
			return false;
	}
	public static Object parseNoPrimitive(String tipo){
		if(tipo.equals("String")){
			String a=new String();
			return a;
		}else if (tipo.equals("Date")){
			Date a=new Date();
			return a;
		}
		return null;	
	}
	public static int parseToJMod(String param){
		if (param.equals("public")){
			return new JMod().PUBLIC;
		}
		return 0;
	}


	public static String toCamel(String param[]){
		String camel=new String();
		camel=param[0].toLowerCase();
		for (int i = 1; i < param.length; i++) {
			System.out.println(param[i]);
			camel=camel.concat(param[i].substring(0,1).toUpperCase())+param[i].substring(1,param[i].length()).toLowerCase();

		}
		System.out.println(camel);
		return camel;
	}
	public void digerir(String arq){
//TODO
	}
	public static String parseTipo(String valor){

		String retorno= "nada";

		Pattern p = Pattern.compile("^[0-9]+");
		Matcher m = p.matcher(valor);
		
		if (m.find()){
			retorno="numeral";
			}
		else{
			p = Pattern.compile("\\.+");
			m = p.matcher(valor);
			if (m.find()){
				retorno="tipoFia";
			}else if (valor.equals("true")||valor.equals("false")){
				retorno="boolean";
			}else{
				retorno="stringLiteral";
			}
			
		}
		//System.out.println(retorno);
		return retorno;
	}
	public static String generarPrefijo(String Tipo){
		

		if ((Tipo=="double")||(Tipo=="float")||(Tipo=="integer")){
		return Tipo.substring(0,3);
		}if (Tipo=="long"){
			return "lng";
		}if (Tipo=="String"){
			return "str";
		}
		else{
		return "dto";	
		}
	}
	public void JavaBean(){

		String bean=this.javabean;
		String paquetes=this.paquete;
		String imports[][]={new String[] { "java", "util"},
							new String[] {"SwingBernate"},
							new String[] {"javax","validation","constraints"},
							new String[] {"javax","persistence"}};
		
		 
		
		 String params[]={"param","bean"};
 
		 
		

					 
		 AST ast = AST.newAST(AST.JLS3);
		CompilationUnit cu = ast.newCompilationUnit();

		PackageDeclaration p1 = ast.newPackageDeclaration();
		p1.setName(ast.newSimpleName(paquetes));
		cu.setPackage(p1);

		//Agregamos Imports
/*		ImportDeclaration importDeclaration = ast.newImportDeclaration();
		QualifiedName name = 
			ast.newQualifiedName(
				ast.newSimpleName("java"),
				ast.newSimpleName("util"));
		importDeclaration.setName(name);
		importDeclaration.setOnDemand(true);
		cu.imports().add(importDeclaration);
	*/	
		for (String[] strings : imports) {
			ImportDeclaration id = ast.newImportDeclaration();
			id.setName(ast.newName(strings));
			id.setOnDemand(true);
			cu.imports().add(id);

		}
		
		
		TypeDeclaration td = ast.newTypeDeclaration();
		
		td.setName(ast.newSimpleName(bean));	
		td.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		td.setSuperclassType(ast.newSimpleType(ast.newSimpleName("DtoBase")));
		
/*
		AnnotationTypeDeclaration entity=ast.newAnnotationTypeDeclaration();
		AnnotationTypeMemberDeclaration enti=ast.newAnnotationTypeMemberDeclaration();
		enti.setType(ast.newSimpleType(ast.newSimpleName("Entity")));
		
		entity.setName(ast.newSimpleName("Entity"));
		
		//entity.setModifiers(Modifier.NONE);
		cu.types().add(entity);
	*/
		cu.types().add(td);
		
		
				////////////////Agreguemos los Parametros!
		
		
		//System.out.println(atributos);
		for (Iterator iterator = atributos.iterator(); iterator.hasNext();) {
			Map atributo = (Map) iterator.next();
			ArrayList anotaciones=(ArrayList)atributo.get("anotaciones");
			//System.out.println(atributo.get("nombre"));
			//System.out.println(atributo.get("anotaciones"));

			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			
			//frac.setName(ast.newSimpleName(generarPrefijo(atributo.get("tipo").toString())+atributo.get("nombre").toString()));
			frac.setName(ast.newSimpleName(atributo.get("nombre").toString()));
			
		/*	if(atributo.get("nombre").toString().startsWith("str")){
				if (atributo.get("size").toString()!=null){
					ClassInstanceCreation newString=ast.newClassInstanceCreation();
					newString.setType(ast.newSimpleType(ast.newName("String")));
					newString.arguments().add(ast.newNumberLiteral(atributo.get("size").toString()));
					frac.setInitializer(newString);
				}
			}
			*/

			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			
			//ast.newPrimitiveType(PrimitiveType.)
			if (Generador.isPrimitive(atributo.get("tipo").toString()))
			{
				
			    fdecl.setType(ast.newPrimitiveType(PrimitiveType.toCode(atributo.get("tipo").toString())));
			}else{
				boolean flag=false;
				for (Object object : anotaciones) {
					Map an=(Map)object;
					if(an.get("tipo").toString().equals("OneToMany")){
						flag=true;
					}
					try {
						//TODO revisar
						//System.out.println("+++++++++++++"+atributo.get("nombre").toString().substring(0,3));
						if (atributo.get("nombre").toString().substring(0,3).equalsIgnoreCase("dto")){
						ImportDeclaration imd = ast.newImportDeclaration();
						imd.setName(ast.newName(new String[] {atributo.get("tipo").toString(),atributo.get("tipo").toString()}));
						imd.resolveBinding();
						cu.imports().add(imd);	
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				if (flag){
					
					ParameterizedType pt=ast.newParameterizedType(ast.newSimpleType(ast.newSimpleName("List")));
					pt.typeArguments().add(ast.newSimpleType(ast.newSimpleName(atributo.get("tipo").toString())));
					fdecl.setType(pt);
					

				
				}else{
				fdecl.setType(ast.newSimpleType(ast.newName(atributo.get("tipo").toString())));
				}
			}
			
			//Anotaciones
			for (Iterator iterator2 = anotaciones.iterator(); iterator2.hasNext();) {
				
				Map anotacion = (Map) iterator2.next();
				NormalAnnotation sma=ast.newNormalAnnotation();
				sma.setTypeName(ast.newName(anotacion.get("tipo").toString()));
				
				if (anotacion.get("parametros")==null)
				{
					
				}else{ArrayList params1=(ArrayList)anotacion.get("parametros");
			
				for (Object object : params1) {
					Map param=(Map)object;
					MemberValuePair	mvp=ast.newMemberValuePair();
					
					mvp.setName(ast.newSimpleName(param.get("nombre").toString()));
					String valor=param.get("valor").toString();
					//System.out.println(valor);
					String x=Generador.parseTipo(valor);
					if (x.equals("numeral")){
						mvp.setValue(ast.newNumberLiteral(valor));
					}else{
						if (x.equals("tipoFia")){
							FieldAccess fia=ast.newFieldAccess();
							String arr[]=valor.split("\\.");

							String expression="";
							//System.out.println(arr.length);
							if (arr.length==2){
								expression=arr[0];
								fia.setExpression(ast.newSimpleName(expression));
								fia.setName(ast.newSimpleName(arr[1]));
							}else{
							for (int i = 0; i < arr.length-1; i++) {
								expression=expression+"."+expression;
							
							}
							fia.setExpression(ast.newSimpleName(expression));
							fia.setName(ast.newSimpleName(arr[arr.length-1]));
							}
				//			System.out.println(expression);
							//System.out.println(arr[arr.length-1]);
							
							
							mvp.setValue(fia);
						}else if(x.equals("boolean") ){
							if (param.get("valor").toString().equals("true")){
								mvp.setValue(ast.newBooleanLiteral(true));
							}else{
								mvp.setValue(ast.newBooleanLiteral(false));
							}
						}else{
							StringLiteral stl=ast.newStringLiteral();
							if (param.get("nombre").toString().equals("message")){
								stl.setLiteralValue('{'+valor+'}');
								}else{
							stl.setLiteralValue(valor);
							}
							mvp.setValue(stl);
						}
						
					}
					System.out.println(Generador.parseTipo(valor));
					//mvp.setValue(ast.newSimpleName());
					
					sma.values().add(mvp);
				
				}
				}
				fdecl.modifiers().add(sma);
			}
			
			td.bodyDeclarations().add(fdecl);
			
		}
		////////////////////////////////Campos Por Defecto
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("dtmfecha_creacion"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("Date")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}	
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("dtmfecha_modificacion"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("Date")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("dtmvalido_desde"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("Date")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("dtmvalido_hasta"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("Date")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("bolactivo"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newPrimitiveType(PrimitiveType.BOOLEAN));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("bolborrado"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newPrimitiveType(PrimitiveType.BOOLEAN));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("strip_creacion"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("String")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("strip_modificacion"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("String")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("strhost_creacion"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("String")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			frac.setName(ast.newSimpleName("strhost_modificacion"));
			FieldDeclaration fdecl=ast.newFieldDeclaration(frac);
			fdecl.setType(ast.newSimpleType(ast.newName("String")));
			td.bodyDeclarations().add(fdecl);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		////////////////////////////////Campos Por DefectoEND
		///////////////////////////////////////////////////////////////////
		////////// ahora a generar los metodos///////////////////////////
		String toStr="";
		FieldDeclaration fd[]=td.getFields();
		for (int i = 0; i < fd.length; i++) {
			//////get
			
			List<VariableDeclarationFragment> vardclf=fd[i].fragments();
			String nombre="";
			for (VariableDeclarationFragment variableDeclarationFragment : vardclf) {
			//	System.out.println("***************"+variableDeclarationFragment.getName().toString());
				nombre= variableDeclarationFragment.getName().toString()+ nombre;
				
			}
			MethodDeclaration get=ast.newMethodDeclaration();
			String nomb[]={"get",nombre};
			
			get.setName(ast.newSimpleName(Generador.toCamel(nomb)));
			
			td.bodyDeclarations().add(get);

			get.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			
			ReturnStatement rs=ast.newReturnStatement();
			
			rs.setExpression(ast.newSimpleName(nombre));

			Block block = ast.newBlock();
			block.statements().add(rs);
			get.setBody(block);
			
			if (fd[i].getType().isPrimitiveType())
			{
				get.setReturnType2(ast.newPrimitiveType(PrimitiveType.toCode(fd[i].getType().toString())));
				if (i==0)
					toStr=toStr+nombre;
				else
				toStr=toStr+"+ "+nombre;
			}else{				
				if (fd[i].getType().isParameterizedType()){

					ParameterizedType pt=ast.newParameterizedType(ast.newSimpleType(ast.newSimpleName("List")));
					
					String tipo[]=fd[i].getType().toString().split("<");
					
					pt.typeArguments().add(ast.newSimpleType(ast.newSimpleName(tipo[1].replaceFirst(">", ""))));

					get.setReturnType2(pt);
			    }else{
				
			    	get.setReturnType2(ast.newSimpleType(ast.newSimpleName(fd[i].getType().toString())));
				if (i==0)
					toStr=toStr+nombre;
				else
				toStr=toStr+"+ "+nombre;
			    }
				}
			////////////////////////////////////////////
			////////////////////set
			String nomb2[]={"set",nombre};
			MethodDeclaration md5 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md5);
			md5.setName(ast.newSimpleName(Generador.toCamel(nomb2)));
			md5.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			SingleVariableDeclaration param6=ast.newSingleVariableDeclaration();
			param6.setName(ast.newSimpleName("param"));
			if (fd[i].getType().isPrimitiveType())
			{
				param6.setType(ast.newPrimitiveType(PrimitiveType.toCode(fd[i].getType().toString())));
			}else{
				if (fd[i].getType().isParameterizedType()){

					ParameterizedType pt=ast.newParameterizedType(ast.newSimpleType(ast.newSimpleName("List")));
					
					String tipo[]=fd[i].getType().toString().split("<");
					
					pt.typeArguments().add(ast.newSimpleType(ast.newSimpleName(tipo[1].replaceFirst(">", ""))));

					param6.setType(pt);
			    }else{
				
				param6.setType(ast.newSimpleType(ast.newSimpleName(fd[i].getType().toString())));
			    }			
			}
			md5.parameters().add(param6);

			Block block5 = ast.newBlock();
			Assignment ass=ast.newAssignment();
			
		//	MemberRef mem=ast.newMemberRef();
		//	mem.setName(ast.newSimpleName(nombre));
			ThisExpression this1=ast.newThisExpression();
			
		//	this1.setQualifier(ast.newName(nombre));
			FieldAccess fie=ast.newFieldAccess();
			fie.setName(ast.newSimpleName(nombre));
			fie.setExpression(this1);
			ass.setLeftHandSide(fie);
			ass.setRightHandSide(ast.newSimpleName("param"));
			block5.statements().add(ast.newExpressionStatement(ass));
			md5.setBody(block5);
		/////////////////////////////////////////////////////////////////////////////	
			

		}
		////////////////////////////////////////////////////////////////
		///////////    toString
		MethodDeclaration toString = ast.newMethodDeclaration();
		td.bodyDeclarations().add(toString);
		toString.setName(ast.newSimpleName("toString"));
		toString.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
        toString.setReturnType2(ast.newSimpleType(ast.newName("String")));
		Block block5 = ast.newBlock();
		StringLiteral stl=ast.newStringLiteral();
		stl.setLiteralValue(toStr);
		ReturnStatement rst=ast.newReturnStatement();
		rst.setExpression(stl);
		block5.statements().add(rst);
		toString.setBody(block5);
	/////////////////////////////////////////////////////////////////////////////	
		
		//System.out.println(toStr);
		System.out.println(cu);
	
		this.JavaBean=cu;
								
		 FileWriter fichero = null;
	     PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(this.salida+this.javabean+"/"+this.javabean+".java");
	            pw = new PrintWriter(fichero);
	            //Se forza la Annotacion entity por no tener metodo en la clase CompilationUnit
	            pw.println(cu.toString().replaceFirst("public", "@Entity\npublic " ));

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }

	}
	public void modelo(){

		String bean=this.javabean;
		String paquetes=this.paquete;
		String imports[][]={new String[] { "java", "util", "ArrayList" },new String[] { "java", "util", "List" },new String[] {"SwingBernate","ModeloBase"},new String[] {"SwingBernate","DtoBase"}};

		String var[]={"listaBase","arreglo","i"};
		String params[]={"param","bean"};




		AST ast = AST.newAST(AST.JLS3);
		CompilationUnit cu = ast.newCompilationUnit();

		PackageDeclaration p1 = ast.newPackageDeclaration();
		p1.setName(ast.newSimpleName(paquetes));
		cu.setPackage(p1);

		//Agregamos Imports
		for (String[] strings : imports) {
			ImportDeclaration id = ast.newImportDeclaration();
			id.setName(ast.newName(strings));
			cu.imports().add(id);

		}


		TypeDeclaration td = ast.newTypeDeclaration();
		td.setName(ast.newSimpleName("modelo"+bean));	
		td.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		td.setSuperclassType(ast.newSimpleType(ast.newSimpleName("ModeloBase")));
		cu.types().add(td);

		//**********************Metodo buscar
		MethodDeclaration md = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md);
		md.setName(ast.newSimpleName("buscar"+bean));
		md.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));

		md.setReturnType2(ast.newSimpleType(ast.newName(bean)));

		SingleVariableDeclaration param1=ast.newSingleVariableDeclaration();
		SingleVariableDeclaration param2=ast.newSingleVariableDeclaration();
		SingleVariableDeclaration param3=ast.newSingleVariableDeclaration();

		param1.setName(ast.newSimpleName("param"));
		param1.setType(ast.newSimpleType(ast.newName(bean)));

		param2.setName(ast.newSimpleName("campo"));
		param2.setType(ast.newSimpleType(ast.newName("String")));

		param3.setName(ast.newSimpleName("clave"));
		param3.setType(ast.newSimpleType(ast.newName("String")));


		md.parameters().add(param1);
		md.parameters().add(param2);
		md.parameters().add(param3);

		Block block = ast.newBlock();

		ReturnStatement rs=ast.newReturnStatement();

		CastExpression cex=ast.newCastExpression();
		
		cex.setType(ast.newSimpleType(ast.newName(bean)));

		SuperMethodInvocation mi=ast.newSuperMethodInvocation();

		mi.setName(ast.newSimpleName("buscar"));

		MethodInvocation meinv1=ast.newMethodInvocation();
		meinv1.setName(ast.newSimpleName("get"));
		meinv1.arguments().add(ast.newNumberLiteral());
		//param1.setVarargs(true);
		//	Argument a=new Argument(null, 0, null, 0);
		meinv1.setExpression(mi);
		//mi.arguments().add();
		//org.eclipse.jdt.core.dom.Expression exp=new Expression;

		//cex.setExpression(ast.newExpressionStatement(exp));
		cex.setExpression(meinv1);
		rs.setExpression(cex);

		StringLiteral literal = ast.newStringLiteral();
		literal.setLiteralValue(param1.getName().toString());

		FieldAccess fa=ast.newFieldAccess();
		//fa.setName(ast.newSimpleName(param1.toString()));

		Name na=ast.newName("socio");

		//fa.setName(ast.newSimpleName(param1.toString()));

		VariableDeclarationFragment vdf=ast.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName("clave"));

		mi.arguments().add(ast.newSimpleName(param1.getName().toString()));
		mi.arguments().add(ast.newSimpleName(param2.getName().toString()));
		mi.arguments().add(ast.newSimpleName(param3.getName().toString()));

		block.statements().add(rs);
		md.setBody(block);

		//***************************************metodo buscar colleccion

		MethodDeclaration md2 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md2);
		md2.setName(ast.newSimpleName("buscar"+bean+"s"));

		md2.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));

		md2.setReturnType2(ast.newArrayType(ast.newSimpleType(ast.newName(bean))));

		Block block2 = ast.newBlock();

		VariableDeclarationFragment listabase=ast.newVariableDeclarationFragment();


		listabase.setName(ast.newSimpleName(var[0]));
		SuperMethodInvocation smd1=ast.newSuperMethodInvocation();
		smd1.setName(ast.newSimpleName("buscar"));

		ClassInstanceCreation iof1=ast.newClassInstanceCreation();


		iof1.setType(ast.newSimpleType(ast.newSimpleName(bean)));

		smd1.arguments().add(iof1);

		listabase.setInitializer(smd1);

		VariableDeclarationStatement vds=ast.newVariableDeclarationStatement(listabase);


		ParameterizedType param=ast.newParameterizedType(ast.newSimpleType(ast.newSimpleName("List")));

		param.typeArguments().add(ast.newSimpleType(ast.newSimpleName("DtoBase")));

		vds.setType(param);

		VariableDeclarationFragment arr=ast.newVariableDeclarationFragment();

		arr.setName(ast.newSimpleName("arreglo"));

		VariableDeclarationStatement vds2=ast.newVariableDeclarationStatement(arr);
		vds2.setType(ast.newArrayType(ast.newSimpleType(ast.newName(bean))));

		MethodInvocation mtinv=ast.newMethodInvocation();
		mtinv.setName(ast.newSimpleName("size"));
		mtinv.setExpression(ast.newSimpleName(var[0]));

		ArrayCreation arrcre1=ast.newArrayCreation();
		arrcre1.setType(ast.newArrayType(ast.newSimpleType(ast.newName(bean))));
		arrcre1.dimensions().add(mtinv);
		ArrayInitializer arrintz1= ast.newArrayInitializer();
		arr.setInitializer(arrcre1);


		ForStatement for1=ast.newForStatement();

		SingleVariableDeclaration i=ast.newSingleVariableDeclaration();
		i.setName(ast.newSimpleName("i"));
		i.setType(ast.newPrimitiveType(PrimitiveType.INT)); 

		VariableDeclarationFragment vardf=ast.newVariableDeclarationFragment();
		vardf.setName(ast.newSimpleName("i"));
		vardf.setInitializer(ast.newNumberLiteral("0"));





		VariableDeclarationExpression vardeex=ast.newVariableDeclarationExpression(vardf);
		vardeex.setType(ast.newPrimitiveType(PrimitiveType.INT));


		InfixExpression infix1=ast.newInfixExpression();
		infix1.setOperator(Operator.LESS);
		infix1.setLeftOperand(ast.newSimpleName("i"));

		MethodInvocation mtinv2=ast.newMethodInvocation();
		mtinv2.setName(ast.newSimpleName("size"));
		mtinv2.setExpression(ast.newSimpleName(var[0]));

		PostfixExpression posfix1=ast.newPostfixExpression();
		posfix1.setOperand(ast.newSimpleName("i"));
		posfix1.setOperator(PostfixExpression.Operator.INCREMENT);





		infix1.setRightOperand(mtinv2);
		for1.initializers().add(vardeex);
		for1.setExpression(infix1);

		for1.updaters().add(posfix1);

		Assignment assig1=ast.newAssignment();

		assig1.setOperator(org.eclipse.jdt.core.dom.Assignment.Operator.ASSIGN);
		ArrayAccess arraccs1=ast.newArrayAccess();
		arraccs1.setArray(ast.newSimpleName(var[1]));
		arraccs1.setIndex(ast.newSimpleName("i"));
		assig1.setLeftHandSide(arraccs1);

		CastExpression cast1=ast.newCastExpression();
		cast1.setType(ast.newSimpleType(ast.newName(bean)));

		MethodInvocation mtinv3=ast.newMethodInvocation();
		mtinv3.setName(ast.newSimpleName("get"));
		mtinv3.setExpression(ast.newSimpleName(var[0]));
		mtinv3.arguments().add(ast.newSimpleName("i"));
		cast1.setExpression(mtinv3);
		assig1.setRightHandSide(cast1);


		for1.setBody(ast.newExpressionStatement(assig1));

		ReturnStatement rs1=ast.newReturnStatement();
		rs1.setExpression(ast.newSimpleName(var[1]));
		block2.statements().add(vds);
		block2.statements().add(vds2);
		block2.statements().add(for1);
		block2.statements().add(rs1);

		md2.setBody(block2);
		////////////////////////////////////////////////////////////////////////////////////////////////////		


		MethodDeclaration md3 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md3);
		md3.setName(ast.newSimpleName("eliminar"));
		md3.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));

		SingleVariableDeclaration param4=ast.newSingleVariableDeclaration();
		param4.setName(ast.newSimpleName("param"));
		param4.setType(ast.newSimpleType(ast.newName(bean)));
		md3.parameters().add(param4);

		Block block3 = ast.newBlock();

		SuperMethodInvocation smi=ast.newSuperMethodInvocation();

		smi.setName(ast.newSimpleName("eliminar"));
		smi.arguments().add(ast.newSimpleName("param"));

		block3.statements().add(ast.newExpressionStatement(smi));
		md3.setBody(block3);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		MethodDeclaration md4 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md4);
		md4.setName(ast.newSimpleName("eliminar"));
		md4.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));

		SingleVariableDeclaration param5=ast.newSingleVariableDeclaration();
		param5.setName(ast.newSimpleName("clave"));
		param5.setType(ast.newSimpleType(ast.newSimpleName("String")));
		md4.parameters().add(param5);

		Block block4 = ast.newBlock();

		SuperMethodInvocation smi2=ast.newSuperMethodInvocation();

		smi2.setName(ast.newSimpleName("eliminar"));
		ThisExpression this1=ast.newThisExpression();
		MethodInvocation mtinv4=ast.newMethodInvocation();
		mtinv4.setName(ast.newSimpleName("buscar"+bean));
		mtinv4.setExpression(this1);
		StringLiteral string1=ast.newStringLiteral();
		string1.setLiteralValue("lngid");

		InstanceofExpression iofe1=ast.newInstanceofExpression();
		iofe1.setRightOperand(ast.newSimpleType(ast.newName(bean)));
		ClassInstanceCreation iof2=ast.newClassInstanceCreation();
		iof2.setType(ast.newSimpleType(ast.newSimpleName(bean)));
		mtinv4.arguments().add(iof2);
		mtinv4.arguments().add(string1);
		mtinv4.arguments().add(ast.newSimpleName("clave"));

		smi2.arguments().add(mtinv4);

		block4.statements().add(ast.newExpressionStatement(smi2));
		md4.setBody(block4);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		




		MethodDeclaration md5 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md5);
		md5.setName(ast.newSimpleName("grabar"));
		md5.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));

		SingleVariableDeclaration param6=ast.newSingleVariableDeclaration();
		param6.setName(ast.newSimpleName("param"));
		param6.setType(ast.newSimpleType(ast.newName(bean)));
		md5.parameters().add(param6);

		Block block5 = ast.newBlock();

		SuperMethodInvocation smi4=ast.newSuperMethodInvocation();

		smi4.setName(ast.newSimpleName("guardar"));
		smi4.arguments().add(ast.newSimpleName("param"));

		block5.statements().add(ast.newExpressionStatement(smi4));
		md5.setBody(block5);




		
		this.Modelo=cu;
		System.out.println(cu);

		 FileWriter fichero = null;
	     PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(this.salida+this.javabean+"/modelo"+this.javabean+".java");
	            pw = new PrintWriter(fichero);
	            pw.println(cu);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
	public void controlador(){
		String bean=this.javabean;
		String paquetes=this.paquete;
		String imports[][]={new String[] { "java", "util", "ArrayList" },
							new String[] { "java", "util", "List" },
							new String[] { "Reporte", "modeloReporte"},
							new String[] {"SwingBernate","ModeloBase"},
							new String[] {"SwingBernate","DtoBase"},
							new String[] {"SwingBernate","ControladorBase"},
							new String[] {"java","awt","event","ActionEvent"},
							new String[] {"java","awt","event","ActionListener"}};

		String var[]={"listaBase","arreglo","i"};
		String params[]={"param","bean"};

		String nombreClase="controlador"+bean;
		String nombreVista="vista"+bean;
		String nombreModelo="modelo"+bean;
		AST ast = AST.newAST(AST.JLS3);
		CompilationUnit cu = ast.newCompilationUnit();

		PackageDeclaration p1 = ast.newPackageDeclaration();
		p1.setName(ast.newSimpleName(paquetes));
		cu.setPackage(p1);

		//Agregamos Imports
		for (String[] strings : imports) {
			ImportDeclaration id = ast.newImportDeclaration();
			id.setName(ast.newName(strings));
			cu.imports().add(id);

		}

		
		TypeDeclaration td = ast.newTypeDeclaration();
		td.setName(ast.newSimpleName("controlador"+bean));	
		td.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		
		td.setSuperclassType(ast.newSimpleType(ast.newSimpleName("ControladorBase")));
		td.superInterfaceTypes().add(ast.newSimpleType(ast.newName("ActionListener")));
		td.superInterfaceTypes().add(ast.newSimpleType(ast.newName("MouseListener")));
		cu.types().add(td);
/////////////////////////Constructor//////////////////////////////////
		Block block = ast.newBlock();
		
		Class rBean;
		Class rVista;
		MethodDeclaration md = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md);
		
	try {

		md.setConstructor(true);
		md.setName(ast.newSimpleName(nombreClase));
		md.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		
		

		VariableDeclarationFragment vardf=ast.newVariableDeclarationFragment();
		vardf.setName(ast.newSimpleName("vista"));
		ClassInstanceCreation iof1=ast.newClassInstanceCreation();
		iof1.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
		iof1.arguments().add(ast.newThisExpression());
		vardf.setInitializer(iof1);
		VariableDeclarationStatement vds1=ast.newVariableDeclarationStatement(vardf);
		vds1.setType(ast.newSimpleType(ast.newName(nombreVista)));
		
		VariableDeclarationFragment vardf2=ast.newVariableDeclarationFragment();
		vardf2.setName(ast.newSimpleName("dto"));
		ClassInstanceCreation iof2=ast.newClassInstanceCreation();
		iof2.setType(ast.newSimpleType(ast.newSimpleName(bean)));
		vardf2.setInitializer(iof2);
		VariableDeclarationStatement vds2=ast.newVariableDeclarationStatement(vardf2);
		vds2.setType(ast.newSimpleType(ast.newName(bean)));

		ThisExpression this1=ast.newThisExpression();
		MethodInvocation mtinv1=ast.newMethodInvocation();
		mtinv1.setName(ast.newSimpleName("iniciarSesion"));
		mtinv1.setExpression(this1);
		mtinv1.arguments().add(ast.newSimpleName("vista"));
		mtinv1.arguments().add(ast.newSimpleName("dto"));
		
		MethodInvocation actualizarV=ast.newMethodInvocation();
		actualizarV.setExpression(ast.newThisExpression());
		actualizarV.setName(ast.newSimpleName("actualizarVista"));
		
		//this.getSession().getVista().getSimpleGrid().addMouseListener(this);
		
		MethodInvocation addML=ast.newMethodInvocation();
		
		addML.setName(ast.newSimpleName("addMouseListener"));
		
		addML.arguments().add(ast.newThisExpression());
		
		MethodInvocation getSimpleGrid=ast.newMethodInvocation();
		getSimpleGrid.setName(ast.newSimpleName("getSimpleGrid"));	
		addML.setExpression(getSimpleGrid);
		
		MethodInvocation getVista=ast.newMethodInvocation();
		
		getVista.setName(ast.newSimpleName("getVista"));
		
		getSimpleGrid.setExpression(getVista);
		
		MethodInvocation getSession= ast.newMethodInvocation();
		
		getSession.setName(ast.newSimpleName("getSession"));
		
		getVista.setExpression(getSession);
		
		getSession.setExpression(ast.newThisExpression());
		
		
		
		block.statements().add(vds1);
		block.statements().add(vds2);
		block.statements().add(ast.newExpressionStatement(mtinv1));
		block.statements().add(ast.newExpressionStatement(actualizarV));
		block.statements().add(ast.newExpressionStatement(addML));

		md.setBody(block);
		
//		VariableDeclarationFragment modeloBean=ast.newVariableDeclarationFragment();
//		modeloBean.setName(ast.newSimpleName("mod"+bean));
//		ClassInstanceCreation modeloBeanCIC=ast.newClassInstanceCreation();
//		modeloBeanCIC.setType(ast.newSimpleType(ast.newSimpleName("modelo"+bean)));
//		modeloBean.setInitializer(modeloBeanCIC);
//		VariableDeclarationStatement modeloBeanVDS=ast.newVariableDeclarationStatement(modeloBean);
//		modeloBeanVDS.setType(ast.newSimpleType(ast.newSimpleName(nombreModelo)));
//		
//		//    this.getSession().setListaDto(modelo.buscar(dto));
//		ThisExpression thisGetSession=ast.newThisExpression();
//		MethodInvocation getSetListaDto=ast.newMethodInvocation();
//		getSetListaDto.setName(ast.newSimpleName("setListaDto"));
//		
//		MethodInvocation modelobuscar=ast.newMethodInvocation();
//		modelobuscar.setExpression(ast.newSimpleName("mod"+bean));
//		modelobuscar.setName(ast.newSimpleName("buscar"));
//		modelobuscar.arguments().add(ast.newSimpleName("dto"));
//		getSetListaDto.arguments().add(modelobuscar);
//		
//		MethodInvocation getSessionV=ast.newMethodInvocation();
//		getSessionV.setName(ast.newSimpleName("getSession"));
//		getSessionV.setExpression(thisGetSession);
//		
//		getSetListaDto.setExpression(getSessionV);
//		
//		
//		
//		block.statements().add(modeloBeanVDS);
//		block.statements().add(ast.newExpressionStatement(mtinv1));
//		block.statements().add(ast.newExpressionStatement(getSetListaDto));
//
//		
//		md.setBody(block);
//		
//		
//		
//		 rBean=Class.forName(bean+"."+bean);
//		 rVista=Class.forName(bean+"."+nombreVista);
//	     Field rcamposVista[]=rVista.getDeclaredFields();
//	     Field rcamposBean[]=rBean.getDeclaredFields();
//	     for (Field field : rcamposVista) {
//
//	    	 if (field.getName().substring(0, 3).equals("cmb")){
//	    		 System.out.println("ComboBox detectado");
//	    		 /* 
//				modeloZafra modeloZafra=new modeloZafra();
//				DefaultComboBoxModel modeloComboZafra = new DefaultComboBoxModel(modeloZafra.buscarZafras());
//				vista=(vistaOrdenArrime)this.getSession().getVista();
//				vista.getCmbZafra().setModel(modeloComboZafra);
//	    		  */
//	    		 String strcampo=field.getName().substring(3,field.getName().length());
//	    		 //System.out.println(field.getName().substring(3,field.getName().length()));
//
//	    		 String strTipo="";
//
//	    		 for (Field field2 : rcamposBean) {
//	    			 if (field2.getName().equals(strcampo)){
//	    				 strTipo=field2.getType().getSimpleName();
//
//	    			 }	
//	    		 }
//
//	    		 ImportDeclaration id = ast.newImportDeclaration();
//	    		 id.setName(ast.newName(new String[] {strTipo,strTipo}));
//	    		 cu.imports().add(id);
//
//	    		 VariableDeclarationFragment modeloTipo=ast.newVariableDeclarationFragment();
//	    		 modeloTipo.setName(ast.newSimpleName("modelo"+strTipo));
//	    		 ClassInstanceCreation classMTipo=ast.newClassInstanceCreation();
//	    		 classMTipo.setType(ast.newSimpleType(ast.newName("modelo"+strTipo)));
//	    		 modeloTipo.setInitializer(classMTipo);
//	    		 VariableDeclarationStatement dclModeloTipo=ast.newVariableDeclarationStatement(modeloTipo);
//	    		 dclModeloTipo.setType(ast.newSimpleType(ast.newName("modelo"+strTipo)));
//	    		 
//	    		 ImportDeclaration id2 = ast.newImportDeclaration();
//	    		 id2.setName(ast.newName(new String[] {strTipo,"modelo"+strTipo}));
//	    		 cu.imports().add(id2);
//	    		 
//	    		 
//	    		 
//	    		 VariableDeclarationFragment modeloCombo=ast.newVariableDeclarationFragment();
//	    		 modeloCombo.setName(ast.newSimpleName("modeloCombo"+strTipo));
//	    		 ClassInstanceCreation newModeloCombo=ast.newClassInstanceCreation();
//	    		 newModeloCombo.setType(ast.newSimpleType(ast.newName(DefaultComboBoxModel.class.getName())));
//	    		 MethodInvocation buscarCollection=ast.newMethodInvocation();
//	    		 buscarCollection.setName(ast.newSimpleName("buscar"+strTipo+"s"));
//	    		 buscarCollection.setExpression(ast.newSimpleName("modelo"+strTipo));
//	    		 newModeloCombo.arguments().add(buscarCollection);
//	    		 modeloCombo.setInitializer(newModeloCombo);
//	    		 VariableDeclarationStatement dclModeloCombo=ast.newVariableDeclarationStatement(modeloCombo);
//	    		 dclModeloCombo.setType(ast.newSimpleType(ast.newName(DefaultComboBoxModel.class.getName())));
//	    		 block.statements().add(dclModeloTipo);
//	    		 block.statements().add(dclModeloCombo);
//
//	    		 Assignment assigVista=ast.newAssignment();
//	    		 assigVista.setLeftHandSide(ast.newSimpleName("vista"));
//	    		 assigVista.setOperator(org.eclipse.jdt.core.dom.Assignment.Operator.ASSIGN);
//	    		 
//	    		 
//	    		 CastExpression castVista=ast.newCastExpression();
//	    		 castVista.setType(ast.newSimpleType(ast.newName("vista"+bean)));
//	    		 
//	    		 ThisExpression thisExpression=ast.newThisExpression();
//	    		
//	    		 MethodInvocation getSession=ast.newMethodInvocation();
//	    		 getSession.setExpression(thisExpression);
//	    		 
//	    		 getSession.setName(ast.newSimpleName("getSession"));
//	    		 
//	    		 
//	    		 MethodInvocation getVista=ast.newMethodInvocation();
//	    		 getVista.setExpression(getSession);
//	    		 getVista.setName(ast.newSimpleName("getVista"));
//	    		 
//	    		 castVista.setExpression(getVista);
//	    		 
//	    		 
//	    		 
//	    		 assigVista.setRightHandSide(castVista);
//	    		 
//	    		 block.statements().add(ast.newExpressionStatement(assigVista));
//	    		 
//	    		 
//	    		 MethodInvocation setModel=ast.newMethodInvocation();
//	    		 setModel.setName(ast.newSimpleName("setModel"));
//	    		 setModel.arguments().add(ast.newSimpleName("modeloCombo"+strTipo));
//	    		 
//	    		 MethodInvocation getCmbTipo=ast.newMethodInvocation();
//	    		 getCmbTipo.setExpression(ast.newSimpleName("vista"));
//	    		 getCmbTipo.setName(ast.newSimpleName("getCmb"+strcampo));
//	    		 
//	    		 setModel.setExpression(getCmbTipo);
//	    		 
//	    		 
//	    		 block.statements().add(ast.newExpressionStatement(setModel));
//
//	    		 
//
//	    	 }else if(field.getName().substring(0, 3).equals("lst")){
//	    		 System.out.println("Lista Doble detectada");
//	    			/*
//	    			 *	    modeloEstado modeloEstado=new modeloEstado();
//			    		 	vista=(vistaOrdenArrime)this.getSession().getVista();
//			    			vista.getLstTablones().setModelDes(modeloTablon.buscarTablones());
//	    			*/
//	    		 String strcampo=field.getName().substring(3,field.getName().length());
//	    		 //System.out.println(field.getName().substring(3,field.getName().length()));
//
//	    		 String strTipo="";
//	    		 String strPTipo="";
//	    		 for (Field field2 : rcamposBean) {
//	    			 if (field2.getName().equals(strcampo)){
//	    				 strTipo=field2.getType().getSimpleName();
//	    				 if (strTipo.equals("List")) 
//	    			
//	    					 {
//	    					 System.out.println("###"+field2.getGenericType());
//	    					 
//	    					 java.lang.reflect.Type tipo=field2.getGenericType();
//	    					 
//	    					 java.lang.reflect.ParameterizedType ParameterizedType = (java.lang.reflect.ParameterizedType) tipo;
//	    					 
//	    					 java.lang.reflect.Type[] tipos = ParameterizedType.getActualTypeArguments();
//	    					 if (tipos.length>0)
//	    					 for (java.lang.reflect.Type type : tipos) {
//	    						 
//	    						 Class claseTipo=Class.forName(type.toString().replaceFirst("class", "").replaceAll(" ",""));
//	    						// TODO Manejo de arreglo para cuando sean distintos tipos en una lista
//	    						 strPTipo=claseTipo.getSimpleName();
//	    						 	
//							  }
//	    					 
//	    					 }
//	    			 }	
//	    		 }
//	    		 
//	    		 VariableDeclarationFragment modeloTipo=ast.newVariableDeclarationFragment();
//	    		 modeloTipo.setName(ast.newSimpleName("modelo"+strPTipo));
//	    		 ClassInstanceCreation classMTipo=ast.newClassInstanceCreation();
//	    		 classMTipo.setType(ast.newSimpleType(ast.newName("modelo"+strPTipo)));
//	    		 modeloTipo.setInitializer(classMTipo);
//	    		 VariableDeclarationStatement dclModeloTipo=ast.newVariableDeclarationStatement(modeloTipo);
//	    		 dclModeloTipo.setType(ast.newSimpleType(ast.newName("modelo"+strPTipo)));
//	    		 
//	    		 ImportDeclaration id2 = ast.newImportDeclaration();
//	    		 id2.setName(ast.newName(new String[] {strPTipo,"modelo"+strPTipo}));
//	    		 cu.imports().add(id2);
//	    		 
//	    		 block.statements().add(dclModeloTipo);
//	    		 
//	    		 
//	    		 Assignment assigVista=ast.newAssignment();
//	    		 assigVista.setLeftHandSide(ast.newSimpleName("vista"));
//	    		 assigVista.setOperator(org.eclipse.jdt.core.dom.Assignment.Operator.ASSIGN);
//	    		 CastExpression castVista=ast.newCastExpression();
//	    		 castVista.setType(ast.newSimpleType(ast.newName("vista"+bean)));
//	    		 ThisExpression thisExpression=ast.newThisExpression();
//	    		 MethodInvocation getSession=ast.newMethodInvocation();
//	    		 getSession.setExpression(thisExpression);
//	    		 getSession.setName(ast.newSimpleName("getSession"));
//	    		 MethodInvocation getVista=ast.newMethodInvocation();
//	    		 getVista.setExpression(getSession);
//	    		 getVista.setName(ast.newSimpleName("getVista"));
//	    		 castVista.setExpression(getVista);
//	    		 assigVista.setRightHandSide(castVista);
//	    		 block.statements().add(ast.newExpressionStatement(assigVista));
//	    		 
//	    		 MethodInvocation setModel=ast.newMethodInvocation();
//	    		 setModel.setName(ast.newSimpleName("setModelDes"));
//	    		 
//	    		 MethodInvocation buscarTipo=ast.newMethodInvocation();
//	    		 buscarTipo.setExpression(ast.newSimpleName("modelo"+strPTipo));
//	    		 buscarTipo.setName(ast.newSimpleName("buscar"+strPTipo+"s"));
//	    		 
//	    		 
//	    		 
//	    		 
//	    		 
//	    		 setModel.arguments().add(buscarTipo);
//	    		 
//	    		 MethodInvocation getCmbTipo=ast.newMethodInvocation();
//	    		 getCmbTipo.setExpression(ast.newSimpleName("vista"));
//	    		 getCmbTipo.setName(ast.newSimpleName("getLst"+strcampo));
//	    		 
//	    		 setModel.setExpression(getCmbTipo);
//	    		 
//	    		 
//	    		 block.statements().add(ast.newExpressionStatement(setModel));
//
//	    	 }
//		}
//	     MethodInvocation getSession6=ast.newMethodInvocation();
//	     getSession6.setName(ast.newSimpleName("getSession"));
//	     getSession6.setExpression(ast.newThisExpression());
//	     MethodInvocation setDtoActual=ast.newMethodInvocation();
//	     setDtoActual.setName(ast.newSimpleName("setDtoActual"));
//	     setDtoActual.arguments().add(ast.newNumberLiteral("0"));
//	     setDtoActual.arguments().add(ast.newSimpleName("dto"));
//	     setDtoActual.setExpression(getSession6);
//	     block.statements().add(ast.newExpressionStatement(setDtoActual));
	}  catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		///////////////////////////////////////actualizarVista

	try {
		MethodDeclaration mActualizarVista=ast.newMethodDeclaration();
		td.bodyDeclarations().add(mActualizarVista);
		mActualizarVista.setName(ast.newSimpleName("actualizarVista"));
		mActualizarVista.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		Block bActualizarVista = ast.newBlock();
		mActualizarVista.setBody(bActualizarVista);
		
		VariableDeclarationFragment vardf=ast.newVariableDeclarationFragment();
		vardf.setName(ast.newSimpleName("vista"));
		
		
		 CastExpression castVista=ast.newCastExpression();
		 castVista.setType(ast.newSimpleType(ast.newName("vista"+bean)));
		 ThisExpression thisExpression=ast.newThisExpression();
		 MethodInvocation getSession=ast.newMethodInvocation();
		 getSession.setExpression(thisExpression);
		 getSession.setName(ast.newSimpleName("getSession"));
		 MethodInvocation getVista=ast.newMethodInvocation();
		 getVista.setExpression(getSession);
		 getVista.setName(ast.newSimpleName("getVista"));
		 castVista.setExpression(getVista);
		 vardf.setInitializer(castVista);
		 
		 
		
			
		ClassInstanceCreation iof1=ast.newClassInstanceCreation();
		iof1.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
		iof1.arguments().add(ast.newThisExpression());
		//vardf.setInitializer(iof1);
		VariableDeclarationStatement vds1=ast.newVariableDeclarationStatement(vardf);
		vds1.setType(ast.newSimpleType(ast.newName(nombreVista)));
		
		VariableDeclarationFragment vardf2=ast.newVariableDeclarationFragment();
		vardf2.setName(ast.newSimpleName("dto"));
		ClassInstanceCreation iof2=ast.newClassInstanceCreation();
		iof2.setType(ast.newSimpleType(ast.newSimpleName(bean)));
		vardf2.setInitializer(iof2);
		VariableDeclarationStatement vds2=ast.newVariableDeclarationStatement(vardf2);
		vds2.setType(ast.newSimpleType(ast.newName(bean)));

		ThisExpression this1=ast.newThisExpression();
		MethodInvocation mtinv1=ast.newMethodInvocation();
		mtinv1.setName(ast.newSimpleName("iniciarSesion"));
		mtinv1.setExpression(this1);
		mtinv1.arguments().add(ast.newSimpleName("vista"));
		mtinv1.arguments().add(ast.newSimpleName("dto"));
		

		
		bActualizarVista.statements().add(vds1);
		bActualizarVista.statements().add(vds2);
		
		VariableDeclarationFragment modeloBean=ast.newVariableDeclarationFragment();
		modeloBean.setName(ast.newSimpleName("mod"+bean));
		ClassInstanceCreation modeloBeanCIC=ast.newClassInstanceCreation();
		modeloBeanCIC.setType(ast.newSimpleType(ast.newSimpleName("modelo"+bean)));
		modeloBean.setInitializer(modeloBeanCIC);
		VariableDeclarationStatement modeloBeanVDS=ast.newVariableDeclarationStatement(modeloBean);
		modeloBeanVDS.setType(ast.newSimpleType(ast.newSimpleName(nombreModelo)));
		
		//    this.getSession().setListaDto(modelo.buscar(dto));
		ThisExpression thisGetSession=ast.newThisExpression();
		MethodInvocation getSetListaDto=ast.newMethodInvocation();
		getSetListaDto.setName(ast.newSimpleName("setListaDto"));
		
		MethodInvocation modelobuscar=ast.newMethodInvocation();
		modelobuscar.setExpression(ast.newSimpleName("mod"+bean));
		modelobuscar.setName(ast.newSimpleName("buscar"));
		modelobuscar.arguments().add(ast.newSimpleName("dto"));
		getSetListaDto.arguments().add(modelobuscar);
		
		MethodInvocation getSessionV=ast.newMethodInvocation();
		getSessionV.setName(ast.newSimpleName("getSession"));
		getSessionV.setExpression(thisGetSession);
		
		getSetListaDto.setExpression(getSessionV);
		
		
		
		bActualizarVista.statements().add(modeloBeanVDS);
		//bActualizarVista.statements().add(ast.newExpressionStatement(mtinv1));
		bActualizarVista.statements().add(ast.newExpressionStatement(getSetListaDto));

		
		//md.setBody(bActualizarVista);
		
try {
	 //modeloReporte modeloReporte=new modeloReporte();
    //javax.swing.DefaultComboBoxModel modeloComboReporte=new javax.swing.DefaultComboBoxModel(modeloReporte.buscar(new Reporte(), "strpadre", "Pais").toArray());
    //vista.getImprimir().getTemplate().setModel(modeloComboReporte);
    
    VariableDeclarationFragment modeloTipo=ast.newVariableDeclarationFragment();
	 modeloTipo.setName(ast.newSimpleName("modeloReporte"));
	 ClassInstanceCreation classMTipo=ast.newClassInstanceCreation();
	 classMTipo.setType(ast.newSimpleType(ast.newName("modeloReporte")));
	 modeloTipo.setInitializer(classMTipo);
	 VariableDeclarationStatement dclModeloTipo=ast.newVariableDeclarationStatement(modeloTipo);
	 dclModeloTipo.setType(ast.newSimpleType(ast.newName("modeloReporte")));
	 

	 VariableDeclarationFragment modeloComboR=ast.newVariableDeclarationFragment();
	 modeloComboR.setName(ast.newSimpleName("modeloComboReporte"));
	 
	 ClassInstanceCreation newModeloCombo=ast.newClassInstanceCreation();
	 newModeloCombo.setType(ast.newSimpleType(ast.newName(DefaultComboBoxModel.class.getName())));
	 
	 MethodInvocation buscarR=ast.newMethodInvocation();
	 buscarR.setName(ast.newSimpleName("buscar"));
	 buscarR.setExpression(ast.newSimpleName("modeloReporte"));
	 
	 MethodInvocation toArray=ast.newMethodInvocation();
	 toArray.setExpression(buscarR);
	 toArray.setName(ast.newSimpleName("toArray"));
	 
	 
	 newModeloCombo.arguments().add(toArray);
	 
	 ClassInstanceCreation newReporte=ast.newClassInstanceCreation();
	 newReporte.setType(ast.newSimpleType(ast.newName("Reporte")));
	 buscarR.arguments().add(newReporte);
	 
	 StringLiteral strpadre=ast.newStringLiteral();
	 strpadre.setLiteralValue("strpadre");
	 buscarR.arguments().add(strpadre);
	 
	 StringLiteral beanst=ast.newStringLiteral();
	 beanst.setLiteralValue(bean);
	 buscarR.arguments().add(beanst);
	 modeloComboR.setInitializer(newModeloCombo);
	 VariableDeclarationStatement newComboVS=ast.newVariableDeclarationStatement(modeloComboR);
	 //newComboVS.setType(ast.newSimpleType(ast.newSimpleName(DefaultComboBoxModel.class.getName())));
	 newComboVS.setType(ast.newSimpleType(ast.newName(DefaultComboBoxModel.class.getName())));
	 
	 MethodInvocation setmodelr=ast.newMethodInvocation();
	 setmodelr.setName(ast.newSimpleName("setModel"));
	 setmodelr.arguments().add(ast.newSimpleName("modeloComboReporte"));
	 MethodInvocation getTemplate=ast.newMethodInvocation();
	 getTemplate.setName(ast.newSimpleName("getTemplate"));
	 MethodInvocation getImprimir=ast.newMethodInvocation();
	 getImprimir.setName(ast.newSimpleName("getImprimir"));
	 getImprimir.setExpression(ast.newSimpleName("vista"));
	 getTemplate.setExpression(getImprimir);
	 setmodelr.setExpression(getTemplate);
	 

	 
	 bActualizarVista.statements().add(dclModeloTipo);
	 bActualizarVista.statements().add(newComboVS);
	 bActualizarVista.statements().add(ast.newExpressionStatement(setmodelr));
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
List tiposs=Vista.types();
System.out.println(tiposs.size());
for (Iterator iterator = tiposs.iterator(); iterator.hasNext();) {
	TypeDeclaration object = (TypeDeclaration) iterator.next();
	System.out.println("################->>>>>"+object.toString()+"<----");	
}
//MethodVisitor visitor=new  MethodVisitor();
FieldVisitor visitor=new FieldVisitor();
Vista.accept(visitor);
List<VariableDeclarationFragment> rcamposVista=new ArrayList<VariableDeclarationFragment>();
//Hashtable<SimpleName, org.eclipse.jdt.core.dom.Type> rcamposVista=new Hashtable<SimpleName, org.eclipse.jdt.core.dom.Type>();
List<FieldDeclaration> rcamposBean=new ArrayList<FieldDeclaration>();

//Hashtable<String, String> rcamposBean=new Hashtable<String, String>();


for (FieldDeclaration field : visitor.getFields()) {
	VariableDeclarationFragment frac=(VariableDeclarationFragment)field.fragments().get(0);
	System.out.println("Tipo de Campo: "+ field.getType() + " Nombre: "+frac.getName());
	rcamposVista.add(frac);
	
}

FieldVisitor visitor2=new FieldVisitor();
JavaBean.accept(visitor2);

for (FieldDeclaration field : visitor2.getFields()) {
	VariableDeclarationFragment frac=(VariableDeclarationFragment)field.fragments().get(0);
	System.out.println("Tipo de Campo: "+ field.getType() + " Nombre: "+frac.getName());
	rcamposBean.add(field);
}




	     
	     for (VariableDeclarationFragment field : rcamposVista) {
	    	 System.out.println("ññññññññ"+field.getName());
	    	 if (field.getName().toString().substring(0, 3).equals("cmb")){
	    		 System.out.println("ComboBox detectado");
	    		  
	//			modeloZafra modeloZafra=new modeloZafra();
	//			DefaultComboBoxModel modeloComboZafra = new DefaultComboBoxModel(modeloZafra.buscarZafras());
	//			vista=(vistaOrdenArrime)this.getSession().getVista();
	//			vista.getCmbZafra().setModel(modeloComboZafra);
	    		  
	    		 String strcampo=field.getName().toString().substring(3,field.getName().toString().length());
	    		 //System.out.println(field.getName().substring(3,field.getName().length()));

	    		 String strTipo="";

	    		 for (FieldDeclaration field2 : rcamposBean) {
	    			 
	    			 VariableDeclarationFragment frac=(VariableDeclarationFragment)field2.fragments().get(0);
	    			 if (frac.getName().toString().equals(strcampo)){
	    				 
	    				 strTipo=field2.getType().toString();

	    			 }	
	    		 }

	    		 ImportDeclaration id = ast.newImportDeclaration();
	    		 id.setName(ast.newName(new String[] {strTipo,strTipo}));
	    		 cu.imports().add(id);

	    		 VariableDeclarationFragment modeloTipo=ast.newVariableDeclarationFragment();
	    		 modeloTipo.setName(ast.newSimpleName("modelo"+strTipo));
	    		 ClassInstanceCreation classMTipo=ast.newClassInstanceCreation();
	    		 classMTipo.setType(ast.newSimpleType(ast.newName("modelo"+strTipo)));
	    		 modeloTipo.setInitializer(classMTipo);
	    		 VariableDeclarationStatement dclModeloTipo=ast.newVariableDeclarationStatement(modeloTipo);
	    		 dclModeloTipo.setType(ast.newSimpleType(ast.newName("modelo"+strTipo)));
	    		 
	    		 ImportDeclaration id2 = ast.newImportDeclaration();
	    		 id2.setName(ast.newName(new String[] {strTipo,"modelo"+strTipo}));
	    		 cu.imports().add(id2);
	    		 
	    		 
	    		 
	    		 VariableDeclarationFragment modeloCombo=ast.newVariableDeclarationFragment();
	    		 modeloCombo.setName(ast.newSimpleName("modeloCombo"+strTipo));
	    		 ClassInstanceCreation newModeloCombo=ast.newClassInstanceCreation();
	    		 newModeloCombo.setType(ast.newSimpleType(ast.newName(DefaultComboBoxModel.class.getName())));
	    		 MethodInvocation buscarCollection=ast.newMethodInvocation();
	    		 buscarCollection.setName(ast.newSimpleName("buscar"+strTipo+"s"));
	    		 buscarCollection.setExpression(ast.newSimpleName("modelo"+strTipo));
	    		 newModeloCombo.arguments().add(buscarCollection);
	    		 modeloCombo.setInitializer(newModeloCombo);
	    		 VariableDeclarationStatement dclModeloCombo=ast.newVariableDeclarationStatement(modeloCombo);
	    		 dclModeloCombo.setType(ast.newSimpleType(ast.newName(DefaultComboBoxModel.class.getName())));
	    		 bActualizarVista.statements().add(dclModeloTipo);
	    		 bActualizarVista.statements().add(dclModeloCombo);

	    	
	    		 
	    		 
	    		 MethodInvocation setModel=ast.newMethodInvocation();
	    		 setModel.setName(ast.newSimpleName("setModel"));
	    		 setModel.arguments().add(ast.newSimpleName("modeloCombo"+strTipo));
	    		 
	    		 MethodInvocation getCmbTipo=ast.newMethodInvocation();
	    		 getCmbTipo.setExpression(ast.newSimpleName("vista"));
	    		 getCmbTipo.setName(ast.newSimpleName("getCmb"+strcampo));
	    		 
	    		 setModel.setExpression(getCmbTipo);
	    		 
	    		 
	    		 bActualizarVista.statements().add(ast.newExpressionStatement(setModel));

	    		 

	    	 }else if(field.getName().toString().substring(0, 3).equals("lst")){
	    		 System.out.println("Lista Doble detectada");
	    			
//	    			 *	    modeloEstado modeloEstado=new modeloEstado();
//			    		 	vista=(vistaOrdenArrime)this.getSession().getVista();
//			    			vista.getLstTablones().setModelDes(modeloTablon.buscarTablones());
	    			
	    		 String strcampo=field.getName().toString().substring(3,field.getName().toString().length());
	    		 //System.out.println(field.getName().substring(3,field.getName().length()));

	    		 String strTipo="";
	    		 String strPTipo="";
	    		 for (FieldDeclaration field2 : rcamposBean) {
	    			 
	    			 VariableDeclarationFragment frac=(VariableDeclarationFragment)field2.fragments().get(0);
	    			 if (frac.getName().toString().equals(strcampo)){
	    				 
	    				 ParameterizedType pt=(ParameterizedType)field2.getType();
	    				 
	    				 strTipo=pt.getType().toString();
	    				 
	    				 
	    				 if (strTipo.equals("List")) 
	    			
	    					 {
	    					 org.eclipse.jdt.core.dom.SimpleType st=(org.eclipse.jdt.core.dom.SimpleType)pt.typeArguments().get(0);
	    					// System.out.println("###"+st.getName().toString());
	    					 
	    					// java.lang.reflect.Type tipo=field2.getGenericType();
	    					 
	    					// java.lang.reflect.ParameterizedType ParameterizedType = (java.lang.reflect.ParameterizedType) tipo;
	    					 
	    					// java.lang.reflect.Type[] tipos = ParameterizedType.getActualTypeArguments();
	    					// if (tipos.length>0)
	    					// for (java.lang.reflect.Type type : tipos) {
	    						 
	    					//	 Class claseTipo=Class.forName(type.toString().replaceFirst("class", "").replaceAll(" ",""));
	    						// TODO Manejo de arreglo para cuando sean distintos tipos en una lista
	    						 strPTipo=st.getName().toString();
	    						 	
							 // }
	    					 
	    					 }
	    			 }	
	    		 }
	    		 
	    		 VariableDeclarationFragment modeloTipo=ast.newVariableDeclarationFragment();
	    		 modeloTipo.setName(ast.newSimpleName("modelo"+strPTipo));
	    		 ClassInstanceCreation classMTipo=ast.newClassInstanceCreation();
	    		 classMTipo.setType(ast.newSimpleType(ast.newName("modelo"+strPTipo)));
	    		 modeloTipo.setInitializer(classMTipo);
	    		 VariableDeclarationStatement dclModeloTipo=ast.newVariableDeclarationStatement(modeloTipo);
	    		 dclModeloTipo.setType(ast.newSimpleType(ast.newName("modelo"+strPTipo)));
	    		 
	    		 ImportDeclaration id2 = ast.newImportDeclaration();
	    		 id2.setName(ast.newName(new String[] {strPTipo,"modelo"+strPTipo}));
	    		 cu.imports().add(id2);
	    		 
	    		 bActualizarVista.statements().add(dclModeloTipo);
	    		 
	    		 
	    		 
	    		 

	    		 MethodInvocation setModel=ast.newMethodInvocation();
	    		 setModel.setName(ast.newSimpleName("setModelDes"));
	    		 
	    		 MethodInvocation buscarTipo=ast.newMethodInvocation();
	    		 buscarTipo.setExpression(ast.newSimpleName("modelo"+strPTipo));
	    		 buscarTipo.setName(ast.newSimpleName("buscar"+strPTipo+"s"));
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 setModel.arguments().add(buscarTipo);
	    		 
	    		 MethodInvocation getCmbTipo=ast.newMethodInvocation();
	    		 getCmbTipo.setExpression(ast.newSimpleName("vista"));
	    		 getCmbTipo.setName(ast.newSimpleName("getLst"+strcampo));
	    		 
	    		 setModel.setExpression(getCmbTipo);
	    		 
	    		 
	    		 bActualizarVista.statements().add(ast.newExpressionStatement(setModel));

	    	 }
		}
	     
	     
	    
		 
		 
	//   this.cargarGrid();
		 MethodInvocation cargarGrid=ast.newMethodInvocation();
		 cargarGrid.setName(ast.newSimpleName("cargarGrid"));
		 cargarGrid.setExpression(ast.newThisExpression());
		 
		 
		 
	     MethodInvocation getSession6=ast.newMethodInvocation();
	     getSession6.setName(ast.newSimpleName("getSession"));
	     getSession6.setExpression(ast.newThisExpression());
	    
	     MethodInvocation setDtoActual=ast.newMethodInvocation();
	     setDtoActual.setName(ast.newSimpleName("setDtoActual"));
	     setDtoActual.arguments().add(ast.newNumberLiteral("0"));
	     setDtoActual.arguments().add(ast.newSimpleName("dto"));
	     setDtoActual.setExpression(getSession6);
	     bActualizarVista.statements().add(ast.newExpressionStatement(setDtoActual));
	     bActualizarVista.statements().add(ast.newExpressionStatement(cargarGrid));
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		


		
		///////////////////////////////////////nuevo
		MethodDeclaration md2 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md2);
		md2.setName(ast.newSimpleName("nuevo"));
		md2.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		Block block2 = ast.newBlock();
		
		VariableDeclarationFragment vardf3=ast.newVariableDeclarationFragment();
		vardf3.setName(ast.newSimpleName("vista"));
		ClassInstanceCreation iof3=ast.newClassInstanceCreation();
		iof3.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
		iof3.arguments().add(ast.newThisExpression());
		vardf3.setInitializer(iof3);
		VariableDeclarationStatement vds3=ast.newVariableDeclarationStatement(vardf3);
		vds3.setType(ast.newSimpleType(ast.newName(nombreVista)));	
		Assignment ass1=ast.newAssignment();
		ass1.setLeftHandSide(ast.newSimpleName("vista"));
		ass1.setOperator(Assignment.Operator.ASSIGN);
		
		
		CastExpression cex1=ast.newCastExpression();
		cex1.setType(ast.newSimpleType(ast.newName(nombreVista)));
		
		ThisExpression this2=ast.newThisExpression();
		MethodInvocation mt1=ast.newMethodInvocation();
		mt1.setExpression(this2);
		mt1.setName(ast.newSimpleName("getSession"));
		MethodInvocation mt2=ast.newMethodInvocation();
		mt2.setExpression(mt1);
		mt2.setName(ast.newSimpleName("getVista"));
		
		cex1.setExpression(mt2);
		ass1.setRightHandSide(cex1);

		MethodInvocation mt3=ast.newMethodInvocation();
		mt3.setExpression(ast.newSimpleName("vista"));
		mt3.setName(ast.newSimpleName("setDto"));

		ClassInstanceCreation iof4=ast.newClassInstanceCreation();
		iof4.setType(ast.newSimpleType(ast.newSimpleName(bean)));
		
		mt3.arguments().add(iof4);
		
		md2.setBody(block2);
		block2.statements().add(vds3);
		block2.statements().add(ast.newExpressionStatement(ass1));
		block2.statements().add(ast.newExpressionStatement(mt3));
		///////////////////////////////////////grabar
		MethodDeclaration md3 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md3);
		md3.setName(ast.newSimpleName("grabar"));
		md3.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		Block block3 = ast.newBlock();
		md3.setBody(block3);
		VariableDeclarationFragment vardf23=ast.newVariableDeclarationFragment();
		vardf23.setName(ast.newSimpleName("vista"));
		ClassInstanceCreation iof23=ast.newClassInstanceCreation();
		iof23.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
		iof23.arguments().add(ast.newThisExpression());
		vardf23.setInitializer(iof23);
		VariableDeclarationStatement vds23=ast.newVariableDeclarationStatement(vardf23);
		vds23.setType(ast.newSimpleType(ast.newName(nombreVista)));	
		Assignment ass21=ast.newAssignment();
		ass21.setLeftHandSide(ast.newSimpleName("vista"));
		ass21.setOperator(Assignment.Operator.ASSIGN);
		CastExpression cex21=ast.newCastExpression();
		cex21.setType(ast.newSimpleType(ast.newName(nombreVista)));
		ThisExpression this22=ast.newThisExpression();
		MethodInvocation mt21=ast.newMethodInvocation();
		mt21.setExpression(this22);
		mt21.setName(ast.newSimpleName("getSession"));
		MethodInvocation mt22=ast.newMethodInvocation();
		mt22.setExpression(mt21);
		mt22.setName(ast.newSimpleName("getVista"));
		cex21.setExpression(mt22);

		ass21.setRightHandSide(cex21);

		block3.statements().add(vds23);
		block3.statements().add(ast.newExpressionStatement(ass21));
		
		MethodInvocation mSetHash=ast.newMethodInvocation();
		mSetHash.setExpression(ast.newSimpleName("dto"));
		mSetHash.setName(ast.newSimpleName("setHash"));
		MethodInvocation mGetHash=ast.newMethodInvocation();
		mGetHash.setExpression(ast.newSimpleName("vista"));
		mGetHash.setName(ast.newSimpleName("getDto"));
		mGetHash.arguments().add(ast.newSimpleName("dto"));
		mSetHash.arguments().add(mGetHash);
		
	
		VariableDeclarationFragment lsError=ast.newVariableDeclarationFragment();
		lsError.setName(ast.newSimpleName("lsError"));
		
		//VariableDeclarationExpression vard=ast.newVariableDeclarationExpression(lsError);
		//vard.setType(ast.newParameterizedType(ast.newSimpleType(ast.newSimpleName("String"))));
		ThisExpression this32=ast.newThisExpression();
		MethodInvocation mt31=ast.newMethodInvocation();
		mt31.setExpression(this32);
		mt31.setName(ast.newSimpleName("testValidacion"));
		mt31.arguments().add(ast.newSimpleName("dto"));
		
		lsError.setInitializer(mt31);
		
		ParameterizedType pt=ast.newParameterizedType(ast.newSimpleType(ast.newSimpleName("List")));
		pt.typeArguments().add(ast.newSimpleType(ast.newSimpleName("String")));
		VariableDeclarationStatement vard=ast.newVariableDeclarationStatement(lsError);
		vard.setType(pt);
		
		VariableDeclarationFragment dto=ast.newVariableDeclarationFragment();		
		dto.setName(ast.newSimpleName("dto"));
		
		MethodInvocation getDto=ast.newMethodInvocation();
		getDto.setName(ast.newSimpleName("getDto"));
		getDto.setExpression(ast.newSimpleName("vista"));
		
		
		ClassInstanceCreation newBean=ast.newClassInstanceCreation();
		newBean.setType(ast.newSimpleType(ast.newName(bean)));
		dto.setInitializer(newBean);
		//dto.setInitializer(getDto);
		VariableDeclarationStatement vardest=ast.newVariableDeclarationStatement(dto);
		vardest.setType(ast.newSimpleType(ast.newName(bean)));
		
		
		IfStatement if21=ast.newIfStatement();
		
		
		MethodInvocation empty=ast.newMethodInvocation();
		empty.setExpression(ast.newSimpleName("lsError"));
		empty.setName(ast.newSimpleName("isEmpty"));
		if21.setExpression(empty);
		
		Block blockIf=ast.newBlock();
		if21.setThenStatement(blockIf);
		
		VariableDeclarationFragment modelo=ast.newVariableDeclarationFragment();		
		modelo.setName(ast.newSimpleName("modelo"));
		ClassInstanceCreation modeloinst=ast.newClassInstanceCreation();
		modeloinst.setType(ast.newSimpleType(ast.newName(nombreModelo)));
		modelo.setInitializer(modeloinst);
		VariableDeclarationStatement modeloStatement=ast.newVariableDeclarationStatement(modelo);
		modeloStatement.setType(ast.newSimpleType(ast.newName(nombreModelo)));
		blockIf.statements().add(modeloStatement);
		
		MethodInvocation grabar=ast.newMethodInvocation();
		grabar.setName(ast.newSimpleName("grabar"));
		grabar.arguments().add(ast.newSimpleName("dto"));
		grabar.setExpression(ast.newSimpleName("modelo"));
		
		blockIf.statements().add(ast.newExpressionStatement(grabar));
		Block blockElse=ast.newBlock();
		if21.setElseStatement(blockElse);
		
		MethodInvocation mensageDialogo=ast.newMethodInvocation();
		mensageDialogo.setName(ast.newSimpleName("mensageDialogo"));
		mensageDialogo.setExpression(ast.newSimpleName("vista"));
		StringLiteral mensaje1=ast.newStringLiteral();
		mensaje1.setLiteralValue("error");

		StringLiteral mensaje2=ast.newStringLiteral();
		mensaje2.setLiteralValue("Por favor verifíque los datos. Debe ingresarlos correctamente!");

		StringLiteral mensaje3=ast.newStringLiteral();
		mensaje3.setLiteralValue("Error en datos");
	
		
		mensageDialogo.arguments().add(mensaje1);
		mensageDialogo.arguments().add(mensaje2);
		mensageDialogo.arguments().add(mensaje3);
		blockElse.statements().add(ast.newExpressionStatement(mensageDialogo));
		
		MethodInvocation marcarError=ast.newMethodInvocation();
		marcarError.setName(ast.newSimpleName("marcarError"));
		marcarError.setExpression(ast.newSimpleName("vista"));
		marcarError.arguments().add(ast.newSimpleName("lsError"));
		
		blockElse.statements().add(ast.newExpressionStatement(marcarError));

		block3.statements().add(vardest);
		block3.statements().add(ast.newExpressionStatement(mSetHash));
		block3.statements().add(vard);
		block3.statements().add(if21);
		////////////////////////////////////eliminar

//		vistaOrdenArrime vista=new vistaOrdenArrime(this);
//		vista=(vistaOrdenArrime)this.getSession().getVista();
//		modeloOrdenArrime modelo=new modeloOrdenArrime();
//		
//		if (vista.mensageDialogo("confirmar", "¿Desea eliminar este Registro?", "Confirmar Eliminación")==0)
//		{
//			modelo.eliminar(vista.getTxtCedula().getText());
//		 }
		
		
			MethodDeclaration md4 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md4);
			md4.setName(ast.newSimpleName("eliminar"));
			md4.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			Block block4 = ast.newBlock();
			md4.setBody(block4);

			VariableDeclarationFragment vardf32=ast.newVariableDeclarationFragment();
			vardf32.setName(ast.newSimpleName("vista"));
			ClassInstanceCreation iof32=ast.newClassInstanceCreation();
			iof32.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
			iof32.arguments().add(ast.newThisExpression());
			vardf32.setInitializer(iof32);
			VariableDeclarationStatement vds32=ast.newVariableDeclarationStatement(vardf32);
			vds32.setType(ast.newSimpleType(ast.newName(nombreVista)));	
			Assignment ass12=ast.newAssignment();
			ass12.setLeftHandSide(ast.newSimpleName("vista"));
			ass12.setOperator(Assignment.Operator.ASSIGN);
			
			
			CastExpression cex12=ast.newCastExpression();
			cex12.setType(ast.newSimpleType(ast.newName(nombreVista)));
			
			ThisExpression this222=ast.newThisExpression();
			MethodInvocation mt122=ast.newMethodInvocation();
			mt122.setExpression(this222);
			mt122.setName(ast.newSimpleName("getSession"));
			MethodInvocation mt222=ast.newMethodInvocation();
			mt222.setExpression(mt122);
			mt222.setName(ast.newSimpleName("getVista"));
			
			cex12.setExpression(mt222);
			ass12.setRightHandSide(cex12);

			VariableDeclarationFragment modeloE=ast.newVariableDeclarationFragment();		
			modeloE.setName(ast.newSimpleName("modelo"));
			ClassInstanceCreation modeloinstE=ast.newClassInstanceCreation();
			modeloinstE.setType(ast.newSimpleType(ast.newName(nombreModelo)));
			modeloE.setInitializer(modeloinstE);
			VariableDeclarationStatement modeloStatementE=ast.newVariableDeclarationStatement(modeloE);
			modeloStatementE.setType(ast.newSimpleType(ast.newName(nombreModelo)));
			
			
			block4.statements().add(vds32);
			block4.statements().add(ast.newExpressionStatement(ass12));
			block4.statements().add(modeloStatementE);
			
			Block ifBlockE=ast.newBlock();
			IfStatement ifE=ast.newIfStatement();
			MethodInvocation mDialogo=ast.newMethodInvocation();
			mDialogo.setExpression(ast.newSimpleName("vista"));
			mDialogo.setName(ast.newSimpleName("mensageDialogo"));
			StringLiteral deseaEliminar=ast.newStringLiteral();
			deseaEliminar.setLiteralValue("¿Desea eliminar este Registro?");
			StringLiteral confirmarE=ast.newStringLiteral();
			confirmarE.setLiteralValue("Confirmar Eliminación");
			StringLiteral confirmar=ast.newStringLiteral();
			confirmar.setLiteralValue("confirmar");
			mDialogo.arguments().add(confirmar);
			mDialogo.arguments().add(deseaEliminar);
			mDialogo.arguments().add(confirmarE);
			
			InfixExpression igual=ast.newInfixExpression();
			igual.setOperator(Operator.EQUALS);
			igual.setLeftOperand(mDialogo);
			igual.setRightOperand(ast.newNumberLiteral("0"));
			
			ifE.setThenStatement(ifBlockE);
			ifE.setExpression(igual);
			
			MethodInvocation eliminar=ast.newMethodInvocation();
			eliminar.setExpression(ast.newSimpleName("modelo"));
			eliminar.setName(ast.newSimpleName("eliminar"));
			
			MethodInvocation getText=ast.newMethodInvocation();
			getText.setName(ast.newSimpleName("getText"));
			
			MethodInvocation getId=ast.newMethodInvocation();
			getId.setName(ast.newSimpleName("getTxtlngid"));
			getId.setExpression(ast.newSimpleName("vista"));
			
			getText.setExpression(getId);
			
			eliminar.arguments().add(getText);
			ifBlockE.statements().add(ast.newExpressionStatement(eliminar));
			block4.statements().add(ifE);
			
	
		
		
		
		
		
		
		////////////////////////////////////buscar
			
			try {
				MethodDeclaration md5 = ast.newMethodDeclaration();
				td.bodyDeclarations().add(md5);
				md5.setName(ast.newSimpleName("buscar"));
				md5.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
				Block block5 = ast.newBlock();
				md5.setBody(block5);
				

				VariableDeclarationFragment vardf33=ast.newVariableDeclarationFragment();
				vardf33.setName(ast.newSimpleName("vista"));
				ClassInstanceCreation iof33=ast.newClassInstanceCreation();
				iof33.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
				iof33.arguments().add(ast.newThisExpression());
				vardf33.setInitializer(iof33);
				VariableDeclarationStatement vds33=ast.newVariableDeclarationStatement(vardf33);
				vds33.setType(ast.newSimpleType(ast.newName(nombreVista)));	
				Assignment ass13=ast.newAssignment();
				ass13.setLeftHandSide(ast.newSimpleName("vista"));
				ass13.setOperator(Assignment.Operator.ASSIGN);
				
				
				CastExpression cex13=ast.newCastExpression();
				cex13.setType(ast.newSimpleType(ast.newName(nombreVista)));
				
				ThisExpression this223=ast.newThisExpression();
				MethodInvocation mt123=ast.newMethodInvocation();
				mt123.setExpression(this223);
				mt123.setName(ast.newSimpleName("getSession"));
				MethodInvocation mt223=ast.newMethodInvocation();
				mt223.setExpression(mt123);
				mt223.setName(ast.newSimpleName("getVista"));
				
				cex13.setExpression(mt223);
				ass13.setRightHandSide(cex13);

				VariableDeclarationFragment modeloB=ast.newVariableDeclarationFragment();		
				modeloB.setName(ast.newSimpleName("modelo"));
				ClassInstanceCreation modeloinstB=ast.newClassInstanceCreation();
				modeloinstB.setType(ast.newSimpleType(ast.newName(nombreModelo)));
				modeloB.setInitializer(modeloinstB);
				VariableDeclarationStatement modeloStatementB=ast.newVariableDeclarationStatement(modeloB);
				modeloStatementB.setType(ast.newSimpleType(ast.newName(nombreModelo)));
				
				
				block5.statements().add(vds33);
				block5.statements().add(ast.newExpressionStatement(ass13));
				block5.statements().add(modeloStatementB);
				
				VariableDeclarationFragment vardf2=ast.newVariableDeclarationFragment();
				vardf2.setName(ast.newSimpleName("dto"));
				ClassInstanceCreation iof2=ast.newClassInstanceCreation();
				iof2.setType(ast.newSimpleType(ast.newSimpleName(bean)));
				vardf2.setInitializer(iof2);
				VariableDeclarationStatement vds2=ast.newVariableDeclarationStatement(vardf2);
				vds2.setType(ast.newSimpleType(ast.newName(bean)));
				block5.statements().add(vds2);
				//dto=modelo.buscar(new dtoOrdenArrime(),"Cedula",vista.getTxtCedula().getText());
				//vista.setDtoOrdenArrime(dto);
				
				Assignment asigDtoB=ast.newAssignment();
				asigDtoB.setOperator(Assignment.Operator.ASSIGN);
				asigDtoB.setLeftHandSide(ast.newSimpleName("dto"));
				MethodInvocation buscarB=ast.newMethodInvocation();
				buscarB.setName(ast.newSimpleName("buscar"+bean));
				buscarB.setExpression(ast.newSimpleName("modelo"));
				
				ClassInstanceCreation iof2B=ast.newClassInstanceCreation();
				iof2B.setType(ast.newSimpleType(ast.newSimpleName(bean)));
				
				buscarB.arguments().add(iof2B);
				StringLiteral lngid=ast.newStringLiteral();
				lngid.setLiteralValue("lngid");
				buscarB.arguments().add(lngid);
				
				asigDtoB.setRightHandSide(buscarB);
				MethodInvocation getLngId=ast.newMethodInvocation();
				getLngId.setName(ast.newSimpleName("getText"));
				
				MethodInvocation getId2=ast.newMethodInvocation();
				getId2.setName(ast.newSimpleName("getTxtlngid"));
				getId2.setExpression(ast.newSimpleName("vista"));
				
				getLngId.setExpression(getId2);
				
				buscarB.arguments().add(getLngId);

				block5.statements().add(ast.newExpressionStatement(asigDtoB));
				
				MethodInvocation setDto=ast.newMethodInvocation();
				setDto.setExpression(ast.newSimpleName("vista"));
				setDto.setName(ast.newSimpleName("setDto"));
				setDto.arguments().add(ast.newSimpleName("dto"));

				block5.statements().add(ast.newExpressionStatement(setDto));

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
				
				
		////////////////////////////////////siguiente
		try {
			MethodDeclaration md8 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md8);
			md8.setName(ast.newSimpleName("siguiente"));
			md8.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			Block block8= ast.newBlock();
			md8.setBody(block8);

//			VariableDeclarationFragment vardf232=ast.newVariableDeclarationFragment();
//			vardf232.setName(ast.newSimpleName("vista"));
//			ClassInstanceCreation iof232=ast.newClassInstanceCreation();
//			iof232.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
//			iof232.arguments().add(ast.newThisExpression());
//			vardf232.setInitializer(iof232);
//			VariableDeclarationStatement vds232=ast.newVariableDeclarationStatement(vardf232);
//			vds232.setType(ast.newSimpleType(ast.newName(nombreVista)));	
//			Assignment ass212=ast.newAssignment();
//			ass212.setLeftHandSide(ast.newSimpleName("vista"));
//			ass212.setOperator(Assignment.Operator.ASSIGN);
//			CastExpression cex212=ast.newCastExpression();
//			cex212.setType(ast.newSimpleType(ast.newName(nombreVista)));
//			ThisExpression this222=ast.newThisExpression();
//			MethodInvocation mt212=ast.newMethodInvocation();
//			mt212.setExpression(this222);
//			mt212.setName(ast.newSimpleName("getSession"));
//			MethodInvocation mt222=ast.newMethodInvocation();
//			mt222.setExpression(mt212);
//			mt222.setName(ast.newSimpleName("getVista"));
//			cex212.setExpression(mt222);
//			ass212.setRightHandSide(cex212);
			 //vista.setDto((Estado)this.getSession().getDtoById(this.getSession().getActual()+1));
			InfixExpression suma=ast.newInfixExpression();
			suma.setOperator(Operator.PLUS);
			suma.setRightOperand(ast.newNumberLiteral("1"));
			
			MethodInvocation getSession4=ast.newMethodInvocation();
			getSession4.setName(ast.newSimpleName("getSession"));
			getSession4.setExpression(ast.newThisExpression());
			
			MethodInvocation getActual=ast.newMethodInvocation();
			getActual.setName(ast.newSimpleName("getActual"));
			getActual.setExpression(getSession4);			
			
			suma.setLeftOperand(getActual);
			/*
			MethodInvocation getDtoById=ast.newMethodInvocation();
			getDtoById.setName(ast.newSimpleName("getDtoById"));
			getDtoById.arguments().add(suma);
			*/
			MethodInvocation getSession5=ast.newMethodInvocation();
			getSession5.setName(ast.newSimpleName("getSession"));
			getSession5.setExpression(ast.newThisExpression());
			/*
			//getDtoById.setExpression(getSession5);
			
			CastExpression castBean=ast.newCastExpression();
			castBean.setType(ast.newSimpleType(ast.newSimpleName(bean)));
			//castBean.setExpression(getDtoById);
			
			MethodInvocation setDto=ast.newMethodInvocation();
			setDto.setName(ast.newSimpleName("setDto"));
			setDto.setExpression(ast.newSimpleName("vista"));
			setDto.arguments().add(castBean);
			
			block8.statements().add(vds232);
			block8.statements().add(ast.newExpressionStatement(ass212));
			block8.statements().add(ast.newExpressionStatement(setDto));
			*/
			MethodInvocation setDtoActual=ast.newMethodInvocation();
			setDtoActual.setName(ast.newSimpleName("setDtoActual"));
			setDtoActual.setExpression(getSession5);
			ClassInstanceCreation newDto=ast.newClassInstanceCreation();
			newDto.setType(ast.newSimpleType(ast.newName(bean)));
			
			setDtoActual.arguments().add(suma);
			setDtoActual.arguments().add(newDto);
			block8.statements().add(ast.newExpressionStatement(setDtoActual));

		} catch (Exception e) {
			// TODO: handle exception
		}
				////////////////////////////////////anterior
		try {
			MethodDeclaration md9 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md9);
			md9.setName(ast.newSimpleName("anterior"));
			md9.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			Block block9 = ast.newBlock();
			md9.setBody(block9);
//
//			VariableDeclarationFragment vardf232=ast.newVariableDeclarationFragment();
//			vardf232.setName(ast.newSimpleName("vista"));
//			ClassInstanceCreation iof232=ast.newClassInstanceCreation();
//			iof232.setType(ast.newSimpleType(ast.newSimpleName(nombreVista)));
//			iof232.arguments().add(ast.newThisExpression());
//			vardf232.setInitializer(iof232);
//			VariableDeclarationStatement vds232=ast.newVariableDeclarationStatement(vardf232);
//			vds232.setType(ast.newSimpleType(ast.newName(nombreVista)));	
//			Assignment ass212=ast.newAssignment();
//			ass212.setLeftHandSide(ast.newSimpleName("vista"));
//			ass212.setOperator(Assignment.Operator.ASSIGN);
//			CastExpression cex212=ast.newCastExpression();
//			cex212.setType(ast.newSimpleType(ast.newName(nombreVista)));
//			ThisExpression this222=ast.newThisExpression();
//			MethodInvocation mt212=ast.newMethodInvocation();
//			mt212.setExpression(this222);
//			mt212.setName(ast.newSimpleName("getSession"));
//			MethodInvocation mt222=ast.newMethodInvocation();
//			mt222.setExpression(mt212);
//			mt222.setName(ast.newSimpleName("getVista"));
//			cex212.setExpression(mt222);
//			ass212.setRightHandSide(cex212);
			 //vista.setDto((Estado)this.getSession().getDtoById(this.getSession().getActual()+1));
			InfixExpression suma=ast.newInfixExpression();
			suma.setOperator(Operator.MINUS);
			suma.setRightOperand(ast.newNumberLiteral("1"));
			MethodInvocation getSession4=ast.newMethodInvocation();
			getSession4.setName(ast.newSimpleName("getSession"));
			getSession4.setExpression(ast.newThisExpression());
			MethodInvocation getActual=ast.newMethodInvocation();
			getActual.setName(ast.newSimpleName("getActual"));
			getActual.setExpression(getSession4);			
			suma.setLeftOperand(getActual);
//			
//			MethodInvocation getDtoById=ast.newMethodInvocation();
//			getDtoById.setName(ast.newSimpleName("getDtoById"));
//			getDtoById.arguments().add(suma);
			
			MethodInvocation getSession5=ast.newMethodInvocation();
			getSession5.setName(ast.newSimpleName("getSession"));
			getSession5.setExpression(ast.newThisExpression());
			
//			getDtoById.setExpression(getSession5);
//			
//			CastExpression castBean=ast.newCastExpression();
//			castBean.setType(ast.newSimpleType(ast.newSimpleName(bean)));
//			castBean.setExpression(getDtoById);
//			
//			MethodInvocation setDto=ast.newMethodInvocation();
//			setDto.setName(ast.newSimpleName("setDto"));
//			setDto.setExpression(ast.newSimpleName("vista"));
//			setDto.arguments().add(castBean);
//			
//			block9.statements().add(vds232);
//			block9.statements().add(ast.newExpressionStatement(ass212));
//			block9.statements().add(ast.newExpressionStatement(setDto));
			MethodInvocation setDtoActual=ast.newMethodInvocation();
			setDtoActual.setName(ast.newSimpleName("setDtoActual"));
			setDtoActual.setExpression(getSession5);
			ClassInstanceCreation newDto=ast.newClassInstanceCreation();
			newDto.setType(ast.newSimpleType(ast.newName(bean)));
			
			setDtoActual.arguments().add(suma);
			setDtoActual.arguments().add(newDto);
			block9.statements().add(ast.newExpressionStatement(setDtoActual));

		} catch (Exception e) {
			// TODO: handle exception
		}

		///////////////////////////////////Primero
		
		try {
			MethodDeclaration md8 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md8);
			md8.setName(ast.newSimpleName("primero"));
			md8.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			Block block8= ast.newBlock();
			md8.setBody(block8);
			
			MethodInvocation getSession5=ast.newMethodInvocation();
			getSession5.setName(ast.newSimpleName("getSession"));
			getSession5.setExpression(ast.newThisExpression());
			
			MethodInvocation setDtoActual=ast.newMethodInvocation();
			setDtoActual.setName(ast.newSimpleName("setDtoActual"));
			setDtoActual.setExpression(getSession5);
			ClassInstanceCreation newDto=ast.newClassInstanceCreation();
			newDto.setType(ast.newSimpleType(ast.newName(bean)));
			
			setDtoActual.arguments().add(ast.newNumberLiteral("0"));
			setDtoActual.arguments().add(newDto);
			block8.statements().add(ast.newExpressionStatement(setDtoActual));

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		///////////////////////////////////
		///////////////////////////////////Ultimo
		
		try {
			MethodDeclaration md8 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md8);
			md8.setName(ast.newSimpleName("ultimo"));
			md8.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			Block block8= ast.newBlock();
			md8.setBody(block8);
			
			MethodInvocation getSession5=ast.newMethodInvocation();
			getSession5.setName(ast.newSimpleName("getSession"));
			getSession5.setExpression(ast.newThisExpression());
			
			MethodInvocation setDtoActual=ast.newMethodInvocation();
			setDtoActual.setName(ast.newSimpleName("setDtoActual"));
			setDtoActual.setExpression(getSession5);
			ClassInstanceCreation newDto=ast.newClassInstanceCreation();
			newDto.setType(ast.newSimpleType(ast.newName(bean)));
			
			InfixExpression menos1=ast.newInfixExpression();
			
			menos1.setOperator(Operator.MINUS);
			
			MethodInvocation size=ast.newMethodInvocation();
			size.setName(ast.newSimpleName("size"));
			
			MethodInvocation getListaDto=ast.newMethodInvocation();
			getListaDto.setName(ast.newSimpleName("getListaDto"));
			
			MethodInvocation getSession=ast.newMethodInvocation();
			getSession.setName(ast.newSimpleName("getSession"));
			getSession.setExpression(ast.newThisExpression());
			
			getListaDto.setExpression(getSession);
			
			size.setExpression(getListaDto);
			
			menos1.setLeftOperand(size);
			
			menos1.setRightOperand(ast.newNumberLiteral("1"));
			
			setDtoActual.arguments().add(menos1);
			setDtoActual.arguments().add(newDto);
			block8.statements().add(ast.newExpressionStatement(setDtoActual));

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		///////////////////////////////////
		///////////////////////////////////ActionPerformed
		MethodDeclaration md6 = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md6);
		md6.setName(ast.newSimpleName("actionPerformed"));
		md6.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		SingleVariableDeclaration param1=ast.newSingleVariableDeclaration();
		param1.setName(ast.newSimpleName("ae"));
		param1.setType(ast.newSimpleType(ast.newName("ActionEvent")));
		md6.parameters().add(param1);
		IfStatement if1=ast.newIfStatement();
		MethodInvocation mt4=ast.newMethodInvocation();
		StringLiteral str1=ast.newStringLiteral();
		str1.setLiteralValue("nuevo");
		mt4.setExpression(str1);
		mt4.setName(ast.newSimpleName("equals"));
		MethodInvocation mt5=ast.newMethodInvocation();
		mt5.setExpression(ast.newSimpleName("ae"));
		mt5.setName(ast.newSimpleName("getActionCommand"));
		mt4.arguments().add(mt5);
		if1.setExpression(mt4);
		MethodInvocation mt6=ast.newMethodInvocation();
		mt6.setExpression(ast.newThisExpression());
		mt6.setName(ast.newSimpleName("nuevo"));
		if1.setThenStatement(ast.newExpressionStatement(mt6));
	
		IfStatement if2=ast.newIfStatement();
		MethodInvocation mt7=ast.newMethodInvocation();
		StringLiteral str2=ast.newStringLiteral();
		str2.setLiteralValue("grabar");
		mt7.setExpression(str2);
		mt7.setName(ast.newSimpleName("equals"));
		MethodInvocation mt8=ast.newMethodInvocation();
		mt8.setExpression(ast.newSimpleName("ae"));
		mt8.setName(ast.newSimpleName("getActionCommand"));
		mt7.arguments().add(mt8);
		if2.setExpression(mt7);
		MethodInvocation mt9=ast.newMethodInvocation();
		mt9.setExpression(ast.newThisExpression());
		mt9.setName(ast.newSimpleName("grabar"));
		if2.setThenStatement(ast.newExpressionStatement(mt9));
		
		IfStatement if3=ast.newIfStatement();
		MethodInvocation mt10=ast.newMethodInvocation();
		StringLiteral str3=ast.newStringLiteral();
		str3.setLiteralValue("buscar");
		mt10.setExpression(str3);
		mt10.setName(ast.newSimpleName("equals"));
		MethodInvocation mt11=ast.newMethodInvocation();
		mt11.setExpression(ast.newSimpleName("ae"));
		mt11.setName(ast.newSimpleName("getActionCommand"));
		mt10.arguments().add(mt11);
		if3.setExpression(mt10);
		MethodInvocation mt12=ast.newMethodInvocation();
		mt12.setExpression(ast.newThisExpression());
		mt12.setName(ast.newSimpleName("buscar"));
		if3.setThenStatement(ast.newExpressionStatement(mt12));
		
		IfStatement if4=ast.newIfStatement();
		MethodInvocation mt13=ast.newMethodInvocation();
		StringLiteral str4=ast.newStringLiteral();
		str4.setLiteralValue("eliminar");
		mt13.setExpression(str4);
		mt13.setName(ast.newSimpleName("equals"));
		MethodInvocation mt14=ast.newMethodInvocation();
		mt14.setExpression(ast.newSimpleName("ae"));
		mt14.setName(ast.newSimpleName("getActionCommand"));
		mt13.arguments().add(mt14);
		if4.setExpression(mt13);
		MethodInvocation mt15=ast.newMethodInvocation();
		mt15.setExpression(ast.newThisExpression());
		mt15.setName(ast.newSimpleName("eliminar"));
		if4.setThenStatement(ast.newExpressionStatement(mt15));

		
		IfStatement if5=ast.newIfStatement();
		MethodInvocation mt16=ast.newMethodInvocation();
		StringLiteral str5=ast.newStringLiteral();
		str5.setLiteralValue("Salir");
		mt16.setExpression(str5);
		mt16.setName(ast.newSimpleName("equals"));
		MethodInvocation mt17=ast.newMethodInvocation();
		mt17.setExpression(ast.newSimpleName("ae"));
		mt17.setName(ast.newSimpleName("getActionCommand"));
		mt16.arguments().add(mt17);
		if5.setExpression(mt16);
		MethodInvocation mt18=ast.newMethodInvocation();
		mt18.setExpression(ast.newThisExpression());
		mt18.setName(ast.newSimpleName("terminarVista"));
		if5.setThenStatement(ast.newExpressionStatement(mt18));
		
		IfStatement if42=ast.newIfStatement();
		MethodInvocation mt132=ast.newMethodInvocation();
		StringLiteral str42=ast.newStringLiteral();
		str42.setLiteralValue("siguiente");
		mt132.setExpression(str42);
		mt132.setName(ast.newSimpleName("equals"));
		MethodInvocation mt142=ast.newMethodInvocation();
		mt142.setExpression(ast.newSimpleName("ae"));
		mt142.setName(ast.newSimpleName("getActionCommand"));
		mt132.arguments().add(mt142);
		if42.setExpression(mt132);
		MethodInvocation mt152=ast.newMethodInvocation();
		mt152.setExpression(ast.newThisExpression());
		mt152.setName(ast.newSimpleName("siguiente"));
		if42.setThenStatement(ast.newExpressionStatement(mt152));

		IfStatement if43=ast.newIfStatement();
		MethodInvocation mt133=ast.newMethodInvocation();
		StringLiteral str43=ast.newStringLiteral();
		str43.setLiteralValue("anterior");
		mt133.setExpression(str43);
		mt133.setName(ast.newSimpleName("equals"));
		MethodInvocation mt143=ast.newMethodInvocation();
		mt143.setExpression(ast.newSimpleName("ae"));
		mt143.setName(ast.newSimpleName("getActionCommand"));
		mt133.arguments().add(mt143);
		if43.setExpression(mt133);
		MethodInvocation mt153=ast.newMethodInvocation();
		mt153.setExpression(ast.newThisExpression());
		mt153.setName(ast.newSimpleName("anterior"));
		if43.setThenStatement(ast.newExpressionStatement(mt153));
		
		IfStatement if44=ast.newIfStatement();
		MethodInvocation mt134=ast.newMethodInvocation();
		StringLiteral str44=ast.newStringLiteral();
		str44.setLiteralValue("refrescar");
		mt134.setExpression(str44);
		mt134.setName(ast.newSimpleName("equals"));
		MethodInvocation mt144=ast.newMethodInvocation();
		mt144.setExpression(ast.newSimpleName("ae"));
		mt144.setName(ast.newSimpleName("getActionCommand"));
		mt134.arguments().add(mt144);
		if44.setExpression(mt134);
		MethodInvocation mt154=ast.newMethodInvocation();
		mt154.setExpression(ast.newThisExpression());
		mt154.setName(ast.newSimpleName("actualizarVista"));
		if44.setThenStatement(ast.newExpressionStatement(mt154));

		IfStatement if45=ast.newIfStatement();
		MethodInvocation mt135=ast.newMethodInvocation();
		StringLiteral str45=ast.newStringLiteral();
		str45.setLiteralValue("primero");
		mt135.setExpression(str45);
		mt135.setName(ast.newSimpleName("equals"));
		MethodInvocation mt145=ast.newMethodInvocation();
		mt145.setExpression(ast.newSimpleName("ae"));
		mt145.setName(ast.newSimpleName("getActionCommand"));
		mt135.arguments().add(mt145);
		if45.setExpression(mt135);
		MethodInvocation mt155=ast.newMethodInvocation();
		mt155.setExpression(ast.newThisExpression());
		mt155.setName(ast.newSimpleName("primero"));
		if45.setThenStatement(ast.newExpressionStatement(mt155));

		IfStatement if46=ast.newIfStatement();
		MethodInvocation mt136=ast.newMethodInvocation();
		StringLiteral str46=ast.newStringLiteral();
		str46.setLiteralValue("ultimo");
		mt136.setExpression(str46);
		mt136.setName(ast.newSimpleName("equals"));
		MethodInvocation mt146=ast.newMethodInvocation();
		mt146.setExpression(ast.newSimpleName("ae"));
		mt146.setName(ast.newSimpleName("getActionCommand"));
		mt136.arguments().add(mt146);
		if46.setExpression(mt136);
		MethodInvocation mt156=ast.newMethodInvocation();
		mt156.setExpression(ast.newThisExpression());
		mt156.setName(ast.newSimpleName("ultimo"));
		if46.setThenStatement(ast.newExpressionStatement(mt156));

		IfStatement if47=ast.newIfStatement();
		MethodInvocation mt137=ast.newMethodInvocation();
		StringLiteral str47=ast.newStringLiteral();
		str47.setLiteralValue("Lista");
		mt137.setExpression(str47);
		mt137.setName(ast.newSimpleName("equals"));
		MethodInvocation mt147=ast.newMethodInvocation();
		mt147.setExpression(ast.newSimpleName("ae"));
		mt147.setName(ast.newSimpleName("getActionCommand"));
		mt137.arguments().add(mt147);
		if47.setExpression(mt137);
		MethodInvocation mt157=ast.newMethodInvocation();
		mt157.setExpression(ast.newThisExpression());
		mt157.setName(ast.newSimpleName("imprimir"));
		
		MethodInvocation mt1481=ast.newMethodInvocation();
		mt1481.setExpression(ast.newSimpleName("ae"));
		mt1481.setName(ast.newSimpleName("getActionCommand"));
		
		mt157.arguments().add(mt1481);
		if47.setThenStatement(ast.newExpressionStatement(mt157));
		
		IfStatement if48=ast.newIfStatement();
		MethodInvocation mt138=ast.newMethodInvocation();
		StringLiteral str48=ast.newStringLiteral();
		str48.setLiteralValue("Actual");
		mt138.setExpression(str48);
		mt138.setName(ast.newSimpleName("equals"));
		MethodInvocation mt148=ast.newMethodInvocation();
		mt148.setExpression(ast.newSimpleName("ae"));
		mt148.setName(ast.newSimpleName("getActionCommand"));
		mt138.arguments().add(mt148);
		if48.setExpression(mt138);
		MethodInvocation mt158=ast.newMethodInvocation();
		mt158.setExpression(ast.newThisExpression());
		mt158.setName(ast.newSimpleName("imprimir"));
		
		MethodInvocation mt1482=ast.newMethodInvocation();
		mt1482.setExpression(ast.newSimpleName("ae"));
		mt1482.setName(ast.newSimpleName("getActionCommand"));
		
		mt158.arguments().add(mt1482);
		if48.setThenStatement(ast.newExpressionStatement(mt158));

		
		//if ("cambiarVista".equals(ae.getActionCommand()))     this.cambiarVista() ;
		
		IfStatement if49=ast.newIfStatement();
		MethodInvocation mt139=ast.newMethodInvocation();
		StringLiteral str49=ast.newStringLiteral();
		str49.setLiteralValue("cambiarVista");
		mt139.setExpression(str49);
		mt139.setName(ast.newSimpleName("equals"));
		MethodInvocation mt149=ast.newMethodInvocation();
		mt149.setExpression(ast.newSimpleName("ae"));
		mt149.setName(ast.newSimpleName("getActionCommand"));
		mt139.arguments().add(mt149);
		if49.setExpression(mt139);
		
		MethodInvocation mt159=ast.newMethodInvocation();
		mt159.setExpression(ast.newThisExpression());
		mt159.setName(ast.newSimpleName("cambiarVista"));
	
		if49.setThenStatement(ast.newExpressionStatement(mt159));
		
		
		Block block6 = ast.newBlock();
		

		block6.statements().add(if1);
		block6.statements().add(if2);
		block6.statements().add(if3);
		block6.statements().add(if4);
		block6.statements().add(if42);
		block6.statements().add(if43);
		block6.statements().add(if44);
		block6.statements().add(if45);
		block6.statements().add(if46);
		block6.statements().add(if5);
		block6.statements().add(if47);
		block6.statements().add(if48);
		block6.statements().add(if49);

		md6.setBody(block6);
		
		
	//////////////////////////////////////////	
		/////		mouseClicked
		try {
			MethodDeclaration md7 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md7);
			md7.setName(ast.newSimpleName("mouseClicked"));
			md7.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			
			SingleVariableDeclaration param=ast.newSingleVariableDeclaration();
			param.setName(ast.newSimpleName("e"));
			param.setType(ast.newSimpleType(ast.newName("MouseEvent")));
			md7.parameters().add(param);
			
			Block block7 = ast.newBlock();
			md7.setBody(block7);
			
//			if (e.getClickCount() == 2) {
//		        JTable target = (JTable)e.getSource();
//		        int row = target.getSelectedRow();
//		        this.getSession().setDtoActual(row,new Productor());
//		        this.cambiarVista();       
//		       }
			
			IfStatement clickcount=ast.newIfStatement();
			
			
			InfixExpression igual2=ast.newInfixExpression();
			igual2.setOperator(InfixExpression.Operator.EQUALS);
			
			
			MethodInvocation getClickCount=ast.newMethodInvocation();
			getClickCount.setExpression(ast.newSimpleName("e"));
			getClickCount.setName(ast.newSimpleName("getClickCount"));
			
			igual2.setRightOperand(ast.newNumberLiteral("2"));
			
			
			
			
			igual2.setLeftOperand(getClickCount);
				
			clickcount.setExpression(igual2);
			
			Block blockif=ast.newBlock();
			
			clickcount.setThenStatement(blockif);
			
			VariableDeclarationFragment targetVF=ast.newVariableDeclarationFragment();
			
			targetVF.setName(ast.newSimpleName("target"));
			
			CastExpression castEsrc=ast.newCastExpression();
			
			MethodInvocation getSrc=ast.newMethodInvocation();
			 
			getSrc.setName(ast.newSimpleName("getSource"));
			 
			getSrc.setExpression(ast.newSimpleName("e"));
						
			castEsrc.setExpression(getSrc);
			
			castEsrc.setType(ast.newSimpleType(ast.newName("JTable")));
			
			targetVF.setInitializer(castEsrc);
			
			VariableDeclarationStatement target=ast.newVariableDeclarationStatement(targetVF);
		
			target.setType(ast.newSimpleType(ast.newName("JTable")));
			
			
			VariableDeclarationFragment row=ast.newVariableDeclarationFragment();
			
			row.setName(ast.newSimpleName("row"));
			
			MethodInvocation getSelectedRow=ast.newMethodInvocation();
			
			getSelectedRow.setName(ast.newSimpleName("getSelectedRow"));
			
			getSelectedRow.setExpression(ast.newSimpleName("target"));
			
			row.setInitializer(getSelectedRow);
			
			VariableDeclarationStatement rowST=ast.newVariableDeclarationStatement(row);
			
			rowST.setType(ast.newPrimitiveType(PrimitiveType.INT));
			
			MethodInvocation setDtoActual=ast.newMethodInvocation();
			 setDtoActual.setName(ast.newSimpleName("setDtoActual"));
			 
			 
			 setDtoActual.arguments().add(ast.newSimpleName("row"));
			 
			 ClassInstanceCreation newBean1=ast.newClassInstanceCreation();
			 
			 newBean1.setType(ast.newSimpleType(ast.newSimpleName(bean)));
			
			 setDtoActual.arguments().add(newBean1);
			
			 
			 MethodInvocation getSession=ast.newMethodInvocation();
			 getSession.setName(ast.newSimpleName("getSession"));
			 getSession.setExpression(ast.newThisExpression());
		
			 setDtoActual.setExpression(getSession);
			
			MethodInvocation cambiarVista=ast.newMethodInvocation();
			cambiarVista.setName(ast.newSimpleName("cambiarVista"));
			cambiarVista.setExpression(ast.newThisExpression());
			
			
			
			
			
			
			
			
			blockif.statements().add(target);
			blockif.statements().add(rowST);
			blockif.statements().add(ast.newExpressionStatement(setDtoActual));
			blockif.statements().add(ast.newExpressionStatement(cambiarVista));
			
			
			block7.statements().add(clickcount);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
					}
		
		//////////////////////////////////////////	
		/////		mouseEntered
		try {
			MethodDeclaration md7 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md7);
			md7.setName(ast.newSimpleName("mouseEntered"));
			md7.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			
			SingleVariableDeclaration param=ast.newSingleVariableDeclaration();
			param.setName(ast.newSimpleName("e"));
			param.setType(ast.newSimpleType(ast.newName("MouseEvent")));
			md7.parameters().add(param);
			
			Block block7 = ast.newBlock();
			md7.setBody(block7);
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		//////////////////////////////////////////	
		/////		mouseExited
		try {
			MethodDeclaration md7 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md7);
			md7.setName(ast.newSimpleName("mouseExited"));
			md7.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			
			SingleVariableDeclaration param=ast.newSingleVariableDeclaration();
			param.setName(ast.newSimpleName("e"));
			param.setType(ast.newSimpleType(ast.newName("MouseEvent")));
			md7.parameters().add(param);
			
			Block block7 = ast.newBlock();
			md7.setBody(block7);
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		//////////////////////////////////////////	
		/////		mousePressed
		try {
			MethodDeclaration md7 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md7);
			md7.setName(ast.newSimpleName("mousePressed"));
			md7.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			
			SingleVariableDeclaration param=ast.newSingleVariableDeclaration();
			param.setName(ast.newSimpleName("e"));
			param.setType(ast.newSimpleType(ast.newName("MouseEvent")));
			md7.parameters().add(param);
			
			Block block7 = ast.newBlock();
			md7.setBody(block7);
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		//////////////////////////////////////////	
		/////		mouseReleased
		try {
			MethodDeclaration md7 = ast.newMethodDeclaration();
			td.bodyDeclarations().add(md7);
			md7.setName(ast.newSimpleName("mouseReleased"));
			md7.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
			
			SingleVariableDeclaration param=ast.newSingleVariableDeclaration();
			param.setName(ast.newSimpleName("e"));
			param.setType(ast.newSimpleType(ast.newName("MouseEvent")));
			md7.parameters().add(param);
			
			Block block7 = ast.newBlock();
			md7.setBody(block7);
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		this.Controlador=cu;
		System.out.println(cu);
		
		 FileWriter fichero = null;
	     PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(this.salida+this.javabean+"/controlador"+this.javabean+".java");
	            pw = new PrintWriter(fichero);
	            pw.println(cu);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
	public void vista(){
		String bean=this.javabean;
		String paquetes=this.paquete;
		String imports[][]={new String[] { "java", "util"},
							new String[] {"SwingBernate"},
							new String[] {"SwingBernate","ayudantes"},
							new String[] {"java","awt","event"},
							new String[] {"javax","swing"}};

		String var[]={"listaBase","arreglo","i"};
		String params[]={"param","bean"};

		String nombreClase="vista"+bean;
		String nombreVista="vista"+bean;

		AST ast = AST.newAST(AST.JLS3);
		CompilationUnit cu = ast.newCompilationUnit();

		PackageDeclaration p1 = ast.newPackageDeclaration();
		p1.setName(ast.newSimpleName(paquetes));
		cu.setPackage(p1);

		//Agregamos Imports
		for (String[] strings : imports) {
			ImportDeclaration id = ast.newImportDeclaration();
			id.setName(ast.newName(strings));
			id.resolveBinding();
			id.setOnDemand(true);
			cu.imports().add(id);	
		}
		TypeDeclaration td = ast.newTypeDeclaration();
		td.setName(ast.newSimpleName(nombreClase));	
		td.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		
		td.setSuperclassType(ast.newSimpleType(ast.newSimpleName("VistaBase")));
		cu.types().add(td);
		
//////////////////////////////////////////////////////////////////////////////////////

		for (Iterator iterator2 = atributos.iterator(); iterator2.hasNext();) {
			Map atributo = (Map) iterator2.next();


			ArrayList anotaciones=(ArrayList)atributo.get("anotaciones");
		//	System.out.println(atributo.get("nombre"));
		//	System.out.println(atributo.get("anotaciones"));

			VariableDeclarationFragment frac=ast.newVariableDeclarationFragment();
			ClassInstanceCreation iof1=ast.newClassInstanceCreation();
			StringLiteral str=ast.newStringLiteral();
			
			str.setLiteralValue(atributo.get("nombre").toString().substring(0,1).toUpperCase()+atributo.get("nombre").toString().substring(1,atributo.get("nombre").toString().length())+": ");
			iof1.arguments().add(str);
			//iof1.arguments().add(ast.newSimpleName(atributo.get("nombre").toString()+": "));
			frac.setInitializer(iof1);
			frac.setName(ast.newSimpleName("lbl"+atributo.get("nombre").toString()));
			VariableDeclarationFragment frac2=ast.newVariableDeclarationFragment();
			ClassInstanceCreation iof2=ast.newClassInstanceCreation();
			frac2.setInitializer(iof2);
			
			
			//TODO discriminar el prefijo dado una anotacion
			FieldDeclaration fdecl1=ast.newFieldDeclaration(frac);
			FieldDeclaration fdecl2=ast.newFieldDeclaration(frac2);

			
			///// determinamos las caracteristicas del  campo
			int cont=0;
			
			for (Object object : anotaciones) {
				Map ano=(Map) object;
				
	
				if (ano.get("tipo").toString().equals("Id")){
					
					frac2.setName(ast.newSimpleName("txt"+atributo.get("nombre").toString()));
					fdecl1.setType(ast.newSimpleType(ast.newName("JLabel")));
					fdecl2.setType(ast.newSimpleType(ast.newName("JTextField")));
					iof1.setType(ast.newSimpleType(ast.newName("JLabel")));
					iof2.setType(ast.newSimpleType(ast.newName("JTextField")));
				}else{
				if((ano.get("tipo").toString().equals("ManyToOne"))){
					
					frac2.setName(ast.newSimpleName("cmb"+atributo.get("nombre").toString()));

					
					fdecl1.setType(ast.newSimpleType(ast.newName("JLabel")));
					fdecl2.setType(ast.newSimpleType(ast.newName("ComboBox")));
					
					iof1.setType(ast.newSimpleType(ast.newName("JLabel")));
					iof2.setType(ast.newSimpleType(ast.newName("ComboBox")));

					ClassInstanceCreation newDto=ast.newClassInstanceCreation();
					newDto.setType(ast.newSimpleType(ast.newName(atributo.get("tipo").toString())));
					iof2.arguments().add(newDto);

				}else{
					if((ano.get("tipo").toString().equals("OneToMany"))||(ano.get("tipo").toString().equals("ManyToMany"))){
						frac2.setName(ast.newSimpleName("lst"+atributo.get("nombre").toString()));
						fdecl1.setType(ast.newSimpleType(ast.newName("JLabel")));
						fdecl2.setType(ast.newSimpleType(ast.newName("ListaDoble")));
						iof1.setType(ast.newSimpleType(ast.newName("JLabel")));
						iof2.setType(ast.newSimpleType(ast.newName("ListaDoble")));
						
						ClassInstanceCreation newDto=ast.newClassInstanceCreation();
						newDto.setType(ast.newSimpleType(ast.newName(atributo.get("tipo").toString())));
						
						StringLiteral titulo=ast.newStringLiteral();
						titulo.setLiteralValue(atributo.get("nombre").toString());
						iof2.arguments().add(titulo);
						iof2.arguments().add(newDto);
						try {
							
							
							ImportDeclaration id = ast.newImportDeclaration();
							id.setName(ast.newName(new String[] {"SwingBernate","ayudantes","ListaDoble"}));
							id.resolveBinding();
							cu.imports().add(id);
							
						} catch (Exception e) {
							// TODO: handle exception
						}

					}else{
						frac2.setName(ast.newSimpleName("txt"+atributo.get("nombre").toString()));
						fdecl1.setType(ast.newSimpleType(ast.newName("JLabel")));
						fdecl2.setType(ast.newSimpleType(ast.newName("JTextField")));
						iof1.setType(ast.newSimpleType(ast.newName("JLabel")));
						iof2.setType(ast.newSimpleType(ast.newName("JTextField")));	
					}
				}
				}
				
				//System.out.println("#######################################################"+ano);
				
			}
			

			
			
			
			
			td.bodyDeclarations().add(fdecl1);
			td.bodyDeclarations().add(fdecl2);
			
			
			
			
			
		}
		

		/////////////////////////Constructor//////////////////////////////////
		
		MethodDeclaration md = ast.newMethodDeclaration();
		td.bodyDeclarations().add(md);
		md.setConstructor(true);
		md.setName(ast.newSimpleName(nombreClase));
		md.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
		
		Block block = ast.newBlock();
		
		SingleVariableDeclaration param1=ast.newSingleVariableDeclaration();
		param1.setName(ast.newSimpleName("controlador"));
		param1.setType(ast.newSimpleType(ast.newName("ActionListener")));
		md.parameters().add(param1);
		
		md.setBody(block);
		
		MethodInvocation setName=ast.newMethodInvocation();
		setName.setExpression(ast.newThisExpression());
		setName.setName(ast.newSimpleName("setTitle"));
		StringLiteral nombreV=ast.newStringLiteral();
		nombreV.setLiteralValue(bean);
		setName.arguments().add(nombreV);
		block.statements().add(ast.newExpressionStatement(setName));
		FieldDeclaration atrib[]=td.getFields();
		for (int i = 0; i < atrib.length; i++) {
			
			List<VariableDeclarationFragment> vardclf=atrib[i].fragments();
			String nombre="";
			for (VariableDeclarationFragment variableDeclarationFragment : vardclf) {
				//System.out.println("***************"+variableDeclarationFragment.getName().toString());
				nombre= variableDeclarationFragment.getName().toString()+ nombre;
				
			}
			
			if((nombre.substring(0, 3).equals("lbl"))||(nombre.substring(0, 3).equals("lst"))){

			}else{
				ThisExpression this1=ast.newThisExpression();
				FieldAccess f=ast.newFieldAccess();
				f.setExpression(this1);
				f.setName(ast.newSimpleName(nombre));
				MethodInvocation meinv2=ast.newMethodInvocation();
				meinv2.setExpression(f);
				meinv2.setName(ast.newSimpleName("addActionListener"));
				meinv2.arguments().add(ast.newSimpleName("controlador"));
				block.statements().add(ast.newExpressionStatement(meinv2));
			}
			//this.agregar(this.lbllngcodigo, this.txtlngcodigo);
			if (nombre.substring(0, 3).equals("txt")){
				ThisExpression this2=ast.newThisExpression();
				MethodInvocation meinv3=ast.newMethodInvocation();
				meinv3.setName(ast.newSimpleName("agregar"));
				meinv3.setExpression(this2);
				String cut=nombre.substring(3, nombre.length());
				meinv3.arguments().add(ast.newSimpleName("lbl"+cut));
				meinv3.arguments().add(ast.newSimpleName(nombre));

				block.statements().add(ast.newExpressionStatement(meinv3));
			}else{
				//TODO Aca se Agregan al Formulario segun tipo se hace algo
				if (nombre.substring(0, 3).equals("cmb")){
					ThisExpression this2=ast.newThisExpression();
					MethodInvocation meinv3=ast.newMethodInvocation();
					meinv3.setName(ast.newSimpleName("agregar"));
					meinv3.setExpression(this2);
					String cut=nombre.substring(3, nombre.length());
					meinv3.arguments().add(ast.newSimpleName("lbl"+cut));
					meinv3.arguments().add(ast.newSimpleName(nombre));
					block.statements().add(ast.newExpressionStatement(meinv3));
				}
				if (nombre.substring(0, 3).equals("lst")){
					ThisExpression this2=ast.newThisExpression();
					MethodInvocation meinv3=ast.newMethodInvocation();
					meinv3.setName(ast.newSimpleName("agregar"));
					meinv3.setExpression(this2);
					String cut=nombre.substring(3, nombre.length());
					meinv3.arguments().add(ast.newSimpleName("lbl"+cut));
					meinv3.arguments().add(ast.newSimpleName(nombre));
					block.statements().add(ast.newExpressionStatement(meinv3));
				}
			}
			
		}
		
		//this.getButtonNuevo().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonNuevo"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getButtonBuscar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonBuscar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getButtonEliminar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonEliminar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		//this.getImprimir().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getImprimir"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}

		//this.getButtonGuardar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonGuardar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getButtonCancelar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonCancelar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getButtonSiguiente().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonSiguiente"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getButtonAnterior().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonAnterior"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonPrimero"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}	
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonUltimo"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonRefrescar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		//this.getMenuItemNuevo().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getMenuItemNuevo"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getMenuItemBuscar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getMenuItemBuscar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getMenuItemEliminar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getMenuItemEliminar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getMenuItemGuardar().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getMenuItemGuardar"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//this.getMenuItemSalir().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getMenuItemSalir"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
	    //this.getButtonVistaR().addActionListener(controlador);
		try {
			MethodInvocation meinv1=ast.newMethodInvocation();
			meinv1.setName(ast.newSimpleName("getButtonVistaR"));
			ThisExpression this1=ast.newThisExpression();
			meinv1.setExpression(this1);
			MethodInvocation meinv2=ast.newMethodInvocation();
			meinv2.setExpression(meinv1);
			meinv2.setName(ast.newSimpleName("addActionListener"));
			meinv2.arguments().add(ast.newSimpleName("controlador"));
			block.statements().add(ast.newExpressionStatement(meinv2));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		try {
			String toStr="";
			FieldDeclaration fd[]=td.getFields();
			for (int i = 0; i < fd.length; i++) {
				//////get
				
				List<VariableDeclarationFragment> vardclf=fd[i].fragments();
				String nombre="";
				for (VariableDeclarationFragment variableDeclarationFragment : vardclf) {
					//System.out.println("***************"+variableDeclarationFragment.getName().toString());
					nombre= variableDeclarationFragment.getName().toString()+ nombre;
					
				}
				MethodDeclaration get=ast.newMethodDeclaration();
				String nomb[]={"get",nombre};
				
				get.setName(ast.newSimpleName(Generador.toCamel(nomb)));
				
				td.bodyDeclarations().add(get);

				get.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
				
				ReturnStatement rs=ast.newReturnStatement();
				
				rs.setExpression(ast.newSimpleName(nombre));
				//atributo.get("nombre").toString()
				Block block2 = ast.newBlock();
				block2.statements().add(rs);
				get.setBody(block2);
				
				if (fd[i].getType().isPrimitiveType())
				{
					get.setReturnType2(ast.newPrimitiveType(PrimitiveType.toCode(fd[i].getType().toString())));
					if (i==0)
						toStr=toStr+nombre;
					else
					toStr=toStr+"+ "+nombre;
				}else{
					get.setReturnType2(ast.newSimpleType(ast.newSimpleName(fd[i].getType().toString())));
					if (i==0)
						toStr=toStr+nombre;
					else
					toStr=toStr+"+ "+nombre;
				}
				////////////////////////////////////////////
				////////////////////set
				String nomb2[]={"set",nombre};
				MethodDeclaration md5 = ast.newMethodDeclaration();
				td.bodyDeclarations().add(md5);
				md5.setName(ast.newSimpleName(Generador.toCamel(nomb2)));
				md5.modifiers().addAll(ast.newModifiers(Modifier.PUBLIC));
				SingleVariableDeclaration param6=ast.newSingleVariableDeclaration();
				param6.setName(ast.newSimpleName("param"));
				if (fd[i].getType().isPrimitiveType())
				{
					param6.setType(ast.newPrimitiveType(PrimitiveType.toCode(fd[i].getType().toString())));
				}else{
					param6.setType(ast.newSimpleType(ast.newSimpleName(fd[i].getType().toString())));
				}
				md5.parameters().add(param6);

				Block block5 = ast.newBlock();
				Assignment ass=ast.newAssignment();
				
			//	MemberRef mem=ast.newMemberRef();
			//	mem.setName(ast.newSimpleName(nombre));
				ThisExpression this1=ast.newThisExpression();
				
			//	this1.setQualifier(ast.newName(nombre));
				FieldAccess fie=ast.newFieldAccess();
				fie.setName(ast.newSimpleName(nombre));
				fie.setExpression(this1);
				ass.setLeftHandSide(fie);
				ass.setRightHandSide(ast.newSimpleName("param"));
				block5.statements().add(ast.newExpressionStatement(ass));
				md5.setBody(block5);
			/////////////////////////////////////////////////////////////////////////////	
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");      

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		this.Vista=cu;
		System.out.println(cu);

		
		 FileWriter fichero = null;
	     PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(this.salida+this.javabean+"/vista"+this.javabean+".java");
	            pw = new PrintWriter(fichero);
	            pw.println(cu);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	
	}
	public void generarCRUD(){
		JavaBean();
		modelo();
		vista();
		controlador();
	}
	/*public static void main(String[] args) {
	//	String[] aux={"/opt/zacaro/bin/prueba1.yml","/opt/zacaro/bin/PlantillaJavaBean.yml"};
	if (args.length==1){
	System.out.println("Falta un Parametro");
	}	else{
		generador generador=new generador(args);
		generador.generarCRUD();
	}

	}*/
}

