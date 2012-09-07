package moduloPrototipo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.beans.*;
import org.hibernate.Session;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import Login.controladorLogin;
import Maestro.controladorMaestro;
import Menu.Menu;
import Menu.modeloMenu;
import SwingBernate.ControladorBase;
import SwingBernate.HibernateUtil;
import SwingBernate.MainDesktopSwingBernate;
import SwingBernate.Sesion;
import SwingBernate.ayudantes.Escritorio;
import SwingBernate.generador.Generador;
import Tema.Tema;
import Tema.modeloTema;
import Usuario.Usuario;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import Menu_Perfil.modeloMenu_Perfil;
import Perfil.modeloPerfil;
import Usuario_Perfil.Usuario_Perfil;
public class mainPrototipo extends MainDesktopSwingBernate implements ActionListener,TreeSelectionListener,MouseListener{

	JTree tree = new JTree();
	Escritorio desktop=new Escritorio();
	JDesktopPane desktopIz=new JDesktopPane();
	//JScrollBar scroll_bar;
	JSplitPane splitpane;
	JScrollPane scroll_izq;
	JScrollPane scroll_der;
	DefaultMutableTreeNode procesos;
	DefaultTreeModel modelo;
	JPopupMenu menuContextual = new JPopupMenu();
	Object idxNodo[][];
	private Usuario usrConectado = new Usuario();
	private Usuario_Perfil usrPerfil = new Usuario_Perfil();
	private Menu arrMenu[] = new Menu[1];
	
	public mainPrototipo() {

		//Splash y carga del Hibernate

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.toString();


		//Make the big window be indented 50 pixels from each edge
		//of the screen.
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(inset, inset,screenSize.width  - inset*2,screenSize.height - inset*2);
		this.setTitle("Zacaro ::. Cuadro de Mando Directivo ::. CVA Azúcar");
		//Set up the GUI.

		//JDesktopPane desktop = new JDesktopPane(); //a specialized layered pane
		JInternalFrame inter=this.crearInterfaz();
		inter.setVisible(true);
		this.setLayout(new BorderLayout());

		//desktop.setLayout(new FlowLayout());

		desktopIz.setBorder(new BevelBorder(BevelBorder.LOWERED));
		desktopIz.setLayout(new FlowLayout());
		desktopIz.add(inter);
		desktopIz.setBackground(new Color(208,198,198));

		//scroll_bar = new JScrollBar();
		//desktop.add(scroll_bar);
		
		scroll_izq=new JScrollPane(desktopIz);
		scroll_der=new JScrollPane();
		desktop.add(scroll_der);
		
		
		scroll_der.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll_der.setViewportView();
		scroll_der.setAutoscrolls(true);
		scroll_der.setVisible(true);
		
		splitpane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, desktopIz, desktop);
		splitpane.setOneTouchExpandable(true);
        splitpane.setDividerLocation(280);
        
        Dimension tam_min = new Dimension(280, 50);
        scroll_izq.setMinimumSize(tam_min);
        //scroll_der.setMinimumSize(tam_min);
        
        splitpane.setPreferredSize(new Dimension(280, 200));
        
        this.getContentPane().add(splitpane);
		//this.getContentPane().add(desktop,BorderLayout.CENTER);
		//this.getContentPane().add(desktopIz,BorderLayout.WEST);
		//this.getDesktop().setBorder(BorderLayout.CENTER);
        

		/**Creamos los Item para el Elemento Accion*/
		/*
        JMenu menu=new JMenu();
        menu=this.getMenuAccion();
        menu.add(this.crearItem("Nuevo","n"));
        menu.add(this.crearItem("Salir","s"));
		 */
		this.getMenuAccion().add(this.crearItem("Nuevo","n",this));
		this.getMenuAccion().add(this.crearItem("Actualizar","f5",this));
		this.getMenuAccion().addSeparator();
		this.getMenuAccion().add(this.crearItem("Salir","s",this));

		this.getMenuEdicion().add(this.crearItem("Deshacer","n",this));
		this.getMenuEdicion().add(this.crearItem("Rehacer","s",this));
		this.getMenuEdicion().addSeparator();
		this.getMenuEdicion().add(this.crearItem("copiar","s",this));
		this.getMenuEdicion().add(this.crearItem("cortar","s",this));
		this.getMenuEdicion().add(this.crearItem("pegar","s",this));

		this.getMenuHerramientas().add(this.crearItem("Calculadora","s",this));
		this.getMenuHerramientas().add(this.crearItem("Mostrar Arbol de Procesos","s",this));
		this.getMenuHerramientas().add(this.crearItem("Cargar datos de Prueba","s",this));

		modeloTema temasmod=new modeloTema();
		JMenu subtemas=new JMenu("Temas");

		Tema[] temas=temasmod.buscarTemas();
		for (int i = 0; i < temas.length; i++) {
			subtemas.add(this.crearItem(temas[i].getStrnombre(),"s",this));
		}

		this.getMenuHerramientas().add(subtemas);

		this.getMenuAyuda().add(this.crearItem("Ayuda del Sistema","s",this));
		this.getMenuAyuda().add(this.crearItem("Ayuda de Procesos","s",this));
		this.getMenuAyuda().add(this.crearItem("Reportar un Error","s",this));
		this.getMenuAyuda().addSeparator();
		this.getMenuAyuda().add(this.crearItem("Acerca de este Sistema","s",this));

		//System.out.println(this.getMenuAccion().getItemCount());
		this.getBarraPrincipal().add(this.getMenuAccion());
		this.getBarraPrincipal().add(this.getMenuEdicion());
		this.getBarraPrincipal().add(this.getMenuHerramientas());
		this.getBarraPrincipal().add(this.getMenuAyuda());

		this.setJMenuBar(this.getBarraPrincipal());
		//.add(this.getMenuAccion());
		//Make dragging a little faster but perhaps uglier.
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		// El JFrame con el JDesktopPane

		this.getCentro().setBorder(new BevelBorder(BevelBorder.RAISED));

		this.getCentro().add(new JLabel("Información Importante"));
		this.getContentPane().add(this.getCentro(), BorderLayout.SOUTH);
		try {
			inter.setClosable(false);
			inter.setMaximum(true);
			inter.setResizable(false);
			inter.setIconifiable(false);
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 static void createAndShowGUI() {
		//Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Create and set up the window.
		mainPrototipo frame	= new mainPrototipo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Display the window.
		frame.setVisible(false);
		frame.desktopIz.setVisible(false);

		//temporalmente desactivado para que no pida login
		frame.ventanaLogin();
		if(frame.getUsrConectado()!=null){
			frame.setVisible(true);
			frame.desktopIz.setVisible(true);
			frame.desktop.setVisible(true);
			
			frame.setExtendedState(MAXIMIZED_BOTH);
		}else{
			//this.vista.dispose();
			frame.dispose();
			System.runFinalization();
			System.exit(0);
		}
	}

	

	private void crearNodos(List<String> lista){
		List<String> auxLista = new ArrayList<String>();
		String valor = "";		

		for (String lst : lista) {

			valor = lst.substring(0, lst.indexOf("-"));

			if(auxLista.isEmpty()){
				auxLista.add(valor);
			}else{

				boolean enc = false;
				for (int i = 0; i < auxLista.size(); i++) {
					if(auxLista.get(i).contentEquals(valor)){
						i = auxLista.size();
						enc = true;
					}
				}

				if(!enc){
					auxLista.add(valor);
				}
			}
		}

		int i = 0;
		idxNodo = new Object[auxLista.size()][3];
		for (String aux : auxLista) {
			DefaultMutableTreeNode nodoComp=new DefaultMutableTreeNode(aux);
			procesos.add(nodoComp);
			idxNodo[i][0] = aux;
			idxNodo[i][1] = nodoComp;
			idxNodo[i][2] = ""+i;
			i++;
		}
	}

	private void crearNodoRaiz(){
		Menu raiz = new Menu();
		raiz.setLngid(0);
		raiz.setStrnombre("Menú");
		raiz.setBolactivo(true);

		this.procesos = new DefaultMutableTreeNode(raiz);
		this.modelo = new DefaultTreeModel(this.procesos.getRoot());
		this.modelo.reload();
	}

	private void crearNodos(Menu arr[]){
		for (int i = 0; i < arr.length; i++) {
			Menu nodo = arr[i];
			if("Seleccione".compareTo(nodo.getStrnombre())!=0){
				DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(nodo);
				this.procesos.add(nuevoNodo);
				agregarNodo(nuevoNodo, nodo);
			}

		}
	}

	private void agregarNodo(DefaultMutableTreeNode padre, Menu menu){
		List<Menu> hijos = menu.getDtonodo();
		Collections.sort(hijos, Menu.ComparaNivelMenu);
		for (Menu menu2 : hijos) {
			DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(menu2);
			padre.add(hijo);
			agregarNodo(hijo, menu2);
		}

	}

	private void crearNodos1(Menu arr[]){

		DefaultMutableTreeNode root = (DefaultMutableTreeNode)this.modelo.getRoot();

		for (int i = 0; i < arr.length; i++) {
			Menu nodo = arr[i];
			if(nodo.getDtomenu() == null){
				this.procesos.add(new DefaultMutableTreeNode(nodo));
				this.modelo.reload();
			}else{
				this.buscarAgregarNodo(root, nodo);
			}
		}
	}

	private void buscarAgregarNodo(DefaultMutableTreeNode nodoarbol, Menu nodo){
		DefaultMutableTreeNode nodoAux2 = new DefaultMutableTreeNode();

		if(nodoarbol.getChildCount()>=0){
			for (Enumeration e=nodoarbol.children(); e.hasMoreElements(); ) {
				TreeNode n = (TreeNode)e.nextElement();
				Object nodeInfo = ((DefaultMutableTreeNode)n).getUserObject();
				Menu menuarbol = (Menu)nodeInfo;
				if(menuarbol.getLngid()==nodo.getDtomenu().getLngid()){
					nodoAux2=(DefaultMutableTreeNode)n;
					nodoAux2.add(new DefaultMutableTreeNode(nodo));
				}
				buscarAgregarNodo((DefaultMutableTreeNode)n,nodo);
				//this.modelo.reload();
			} 
		}		

	}

	public void actualizarArbolMenu(int tipo){

		/**
		 * int tipo:: Variable para indicar si el arbol de construye de
		 * padres a hijo (0) o de hijos a padres (1)
		 */

		this.procesos.removeAllChildren();

		if(tipo == 0){

			modeloMenu modelomenu = new modeloMenu();

			Menu arrMenu2[] = modelomenu.buscarSubMenu(new Menu(), true);
			this.arrMenu = (Menu[])resizeArray(this.arrMenu, arrMenu2.length);
			this.arrMenu = arrMenu2;

			if(arrMenu.length==1){
				Menu dtomenucfg = new Menu();
				dtomenucfg.setStrnombre("Configuración");
				dtomenucfg.setStrsigla("CFG");			
				dtomenucfg.setBolactivo(true);
				dtomenucfg.setBolsubmenu(true);
				dtomenucfg.setStrhost_creacion("localhost");
				dtomenucfg.setStrip_creacion("127.0.0.1");
				//modelomenu.grabar(dtomenucfg);

				Menu dtomenu = new Menu();
				dtomenu.setStrnombre("Menú");
				dtomenu.setStrsigla("MNU");			
				dtomenu.setBolactivo(true);
				dtomenu.setBolsubmenu(false);
				dtomenu.setStrpaquete("Menu.controladorMenu");
				dtomenu.setStrhost_creacion("localhost");
				dtomenu.setStrip_creacion("127.0.0.1");
				dtomenu.setDtomenu(dtomenucfg);
				//modelomenu.grabar(dtomenu);

				if(this.usrConectado == null){
					arrMenu = modelomenu.buscarSubMenu(new Menu(), true);
				}
			}	

			crearNodos(arrMenu);

		}else if(tipo == 1){
			//TODO Implementar Arbol de menu por perfil
			actualizarArregloMenu();
			crearNodos1(this.arrMenu);
			//cargarTema(this.usrConectado);
		}



		//crearNodos(arrMenu);
		this.modelo.reload();
	}


	private JInternalFrame crearInterfaz(){
		int openFrameCount = 0;
		int xOffset = 30, yOffset = 30;
		// Paneles
		JPanel arriba = new JPanel();
		JPanel izq  = new JPanel();
		JPanel der  = new JPanel();

		crearNodoRaiz();
		actualizarArbolMenu(0);

		tree.setModel(modelo);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		//Listen for when the selection changes.
		tree.addTreeSelectionListener(this);
		tree.addMouseListener(this);

		JMenuItem actualizar = new JMenuItem("Actualizar Menú");
		actualizar.addActionListener(this);
		this.menuContextual.add(actualizar);
		JMenuItem expandir = new JMenuItem("Expandir");
		expandir.addActionListener(this);
		this.menuContextual.add(expandir);
		JMenuItem contraer = new JMenuItem("Contraer");
		contraer.addActionListener(this);
		this.menuContextual.add(contraer);

		tree.add(this.menuContextual);
		tree.addMouseListener(this);

		JScrollPane scrollPaneTree = new JScrollPane(tree);

		izq.setBorder(new BevelBorder(BevelBorder.LOWERED));
		izq.setLayout( new BorderLayout());
		izq.add(new JLabel("Arbol de Procesos"),BorderLayout.NORTH);
		izq.add(scrollPaneTree,BorderLayout.CENTER);
		izq.add(new JLabel("Informacion del Proceso"),BorderLayout.SOUTH);


		JInternalFrame interfaz=new JInternalFrame("Interfaz #" + (++openFrameCount),
				true, //resizable
				true, //closable
				true, //maximizable
				true);
		interfaz.setSize(400,300);
		interfaz.setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		//interfaz.add(der,BorderLayout.EAST);
		interfaz.add(izq);
		interfaz.setClosable(false);
		return interfaz;
	}

	private void expandAll(JTree tree, TreePath parent, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode)parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e=node.children(); e.hasMoreElements(); ) {
				TreeNode n = (TreeNode)e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}

		// Expansion or collapse must be done bottom-up
		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}

	public String camelCase(String cadena){

		StringBuilder texto = new StringBuilder();

		StringTokenizer st = new StringTokenizer(cadena);
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			texto.append( String.valueOf(temp.charAt(0)).toUpperCase().concat(temp.substring(1)));
		}

		//System.out.println(texto.toString());

		return texto.toString().trim();
	}

	/**
	 * Reallocates an array with a new size, and copies the contents
	 * of the old array to the new array.
	 * @param oldArray  the old array, to be reallocated.
	 * @param newSize   the new array size.
	 * @return          A new array with the same contents.
	 */
	private static Object resizeArray (Object oldArray, int newSize) {
		int oldSize = java.lang.reflect.Array.getLength(oldArray);
		Class elementType = oldArray.getClass().getComponentType();
		Object newArray = java.lang.reflect.Array.newInstance(
				elementType, newSize);
		int preserveLength = Math.min(oldSize, newSize);
		if (preserveLength > 0)
			System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
		return newArray;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("*******************************************"+e.getActionCommand());
        String Titulo=new String("");
        
		if(e.getSource().getClass() == JMenuItem.class){

			TreeNode root = (TreeNode)tree.getModel().getRoot();
			if(e.getActionCommand().compareToIgnoreCase("Expandir")==0){
				this.expandAll(tree, new TreePath(root), true);
			}else if(e.getActionCommand().compareToIgnoreCase("Contraer")==0){
				this.expandAll(tree, new TreePath(root), false);
			}else if(e.getActionCommand().compareToIgnoreCase("Actualizar Menú")==0){
				this.actualizarArbolMenu(1);
			}

		}else{
			//this.desktopIz.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			String actionCommand = e.getActionCommand().toString();
			System.out.println("*******************************************" + e.getSource().getClass().getCanonicalName().toString());
			if(!actionCommand.isEmpty()){
				String controlador = actionCommand;
				String params = "";

				int p = controlador.indexOf(";");
				if(p>0){
					params = controlador;
					controlador = controlador.substring(0, p).trim();
					params = params.substring(p+1, params.length()).trim();

					System.out.println("Params::::.."+params);
				}

				System.out.println("Controlador::::.."+controlador);

				try {

					Class _clase = Class.forName(controlador);
					//Class clsmenu = Class.forName(e.getSource().getClass().toString());
					
					if (e.getSource().getClass().getCanonicalName().toString().equals("Menu.Menu")){
						Menu objMenu = (Menu) e.getSource();
						Titulo = objMenu.getStrnombre() + ".";
						//System.out.println("Titulo Ventana: " + objMenu.getStrnombre());
					}					
					
					if (controlador.equals("Maestro.controladorMaestro")){

						Constructor constructor =_clase.getConstructor(new Class[]{String.class});
						//String[] arrParams = params.split(",");
						controladorMaestro olador=(controladorMaestro)constructor.newInstance(params);

						Method getter = _clase.getMethod("getSession");
						Sesion s = (Sesion)getter.invoke(olador, new Object[0] );
					    //s.getVista().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						desktop.add(s.getVista()); 
						//scroll_der.add(s.getVista());
						//scroll_der.setVisible(true);
						s.getVista().setVisible(true);
						s.getVista().setTitle(Titulo);
						s.getVista().moveToFront();
						this.desktopIz.setCursor(Cursor.getDefaultCursor());
					}else{

						ControladorBase ctrlBase = (ControladorBase)_clase.newInstance();

						Method getter = _clase.getMethod("getSession");
						Sesion s = (Sesion)getter.invoke(ctrlBase, new Object[0] );
						
						//desktop.add(s.getVista()); 
						//s.getVista().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
						desktop.add(s.getVista());
						//scroll_der.setVisible(true);
						s.getVista().setVisible(true);
						s.getVista().setTitle(Titulo);
						s.getVista().moveToFront();
						this.desktopIz.setCursor(Cursor.getDefaultCursor());
					}

					/*ControladorBase ctrlBase = (ControladorBase)_clase.newInstance();

					Method getter = _clase.getMethod("getSession");
					Sesion s = (Sesion)getter.invoke(ctrlBase, new Object[0] );
					desktop.add(s.getVista());

					s.getVista().setVisible(true);
					s.getVista().moveToFront();*/

				} catch (Throwable e2) {
					// TODO Auto-generated catch block
					//this.desktopIz.setCursor(Cursor.getDefaultCursor());
					e2.printStackTrace();
				}
			}

		}

		if (e.getActionCommand().equals("Cargar datos de Prueba")){
			/*			//CargarDatosIniciales a=new CargarDatosIniciales();
			try {
				//datosDePrueba a=new datosDePrueba();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 */		}
		if (e.getActionCommand().equals("Salir")){
			//CargarDatosIniciales a=new CargarDatosIniciales();
			try {
				int i = 1;
				i = JOptionPane.showConfirmDialog(this,"Desea Salir del Sistema?","Confirmar Salida",JOptionPane.YES_NO_OPTION);
				if(i == 0){
					System.runFinalization();
					System.exit(0);	
				}				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	public static void cargarTema(Usuario usr){
		
		
		//modeloTema modelotema=new modeloTema();
		
		//Tema beanTema=modelotema.buscarTemas()[0];
		// Temas Personalizados TODO
		
		/*NimRODTheme tema=new NimRODTheme();
		
		tema.setPrimary1(Color.decode(beanTema.getStrprimario1()));
		tema.setPrimary2(Color.decode(beanTema.getStrprimario2()));
		tema.setPrimary3(Color.decode(beanTema.getStrprimario3()));
		
		tema.setSecondary1(Color.decode(beanTema.getStrsecundario1()));
		tema.setSecondary2(Color.decode(beanTema.getStrsecundario2()));
		tema.setSecondary3(Color.decode(beanTema.getStrsecundario3()));
	
		tema.setWhite(Color.decode(beanTema.getStrblanco()));
		tema.setBlack(Color.decode(beanTema.getStrnegro()));
	
		tema.setFrameOpacity(Integer.parseInt(beanTema.getLngframeopacidad()+""));
		tema.setMenuOpacity(Integer.parseInt(beanTema.getLngmenuopacidad()+""));
		*/
		
		NimRODLookAndFeel nrlf=new NimRODLookAndFeel();
		
		if(usr != null){
			if(usr.getDto_tema() != null){
				
				NimRODTheme tema=new NimRODTheme();
				Tema beanTema = usr.getDto_tema();
				
				tema.setPrimary1(Color.decode(beanTema.getStrprimario1()));
				tema.setPrimary2(Color.decode(beanTema.getStrprimario2()));
				tema.setPrimary3(Color.decode(beanTema.getStrprimario3()));
				
				tema.setSecondary1(Color.decode(beanTema.getStrsecundario1()));
				tema.setSecondary2(Color.decode(beanTema.getStrsecundario2()));
				tema.setSecondary3(Color.decode(beanTema.getStrsecundario3()));
			
				tema.setWhite(Color.decode(beanTema.getStrblanco()));
				tema.setBlack(Color.decode(beanTema.getStrnegro()));
			
				tema.setFrameOpacity(Integer.parseInt(beanTema.getLngframeopacidad()+""));
				tema.setMenuOpacity(Integer.parseInt(beanTema.getLngmenuopacidad()+""));
				
				nrlf.setCurrentTheme(tema);
				
			}else
				nrlf.setCurrentTheme(new NimRODTheme());
		}else		
			nrlf.setCurrentTheme(new NimRODTheme());
		
		try {
			 UIManager.setLookAndFeel( nrlf);
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		
		cargarTema(null);
		if (args.length>=1){
			System.out.println("Modo generador");
			if (args.length==1){
				System.out.println("Falta un Parametro");
				System.out.println("Sintaxis generador Archivo.yml ruta");
			}	else{

				Generador generador=new Generador(args);
				generador.generarCRUD();
			}

		}else{
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				
				}
				
			});
		}
	}

	public void ventanaLogin(){
		controladorLogin ctrl2 = new controladorLogin((Component)this);
		this.setUsrConectado(ctrl2.getUsr());
		List<Usuario_Perfil> lstusuario_Perf = this.usrConectado.getDto_perfil();
		for (Usuario_Perfil usuarioPerfil : lstusuario_Perf) {
			this.usrPerfil = usuarioPerfil;
		}

		if(this.usrPerfil.getDtoperfil()!=null){			
			//actualizarArregloMenu();			
			actualizarArbolMenu(1);
		}

	}

	public void actualizarArregloMenu(){
		modeloPerfil modelo_perfil = new modeloPerfil();

		List<Object> lstidsmenu = modelo_perfil.getids_arbol(this.usrPerfil.getDtoperfil().getLngid());
		this.arrMenu = (Menu[])resizeArray(this.arrMenu, lstidsmenu.size());

		modeloMenu modmenu = new modeloMenu(); 

		int j =0;
		for (Object menu : lstidsmenu) {
			this.arrMenu[j] = (Menu)modmenu.buscar(new Menu(), Long.parseLong(((Integer)menu).toString()));
			j++;
		}	
	}

	public Usuario getUsrConectado() {
		return usrConectado;
	}

	public void setUsrConectado(Usuario usrConectado) {
		this.usrConectado = usrConectado;
	}

	public Usuario_Perfil getUsrPerfil() {
		return usrPerfil;
	}

	public void setUsrPerfil(Usuario_Perfil usrPerfil) {
		this.usrPerfil = usrPerfil;
	}

	public DefaultMutableTreeNode getProcesos() {
		return procesos;
	}

	public void setProcesos(DefaultMutableTreeNode procesos) {
		this.procesos = procesos;
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Raton Presionado");

		if( e.getButton() == 1 ){

			if(e.getClickCount() == 2){
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

				if(node != null){
					Object nodeInfo = node.getUserObject();

					if (node.isLeaf()) {
						Menu seleccion = (Menu)nodeInfo;
						this.actionPerformed(new ActionEvent(seleccion,seleccion.hashCode(),seleccion.getStrpaquete()));
						tree.getSelectionModel().clearSelection();					
					}	
				}				
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		if (evt.isPopupTrigger()) {
			this.menuContextual.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}
	@Override
	public void mouseReleased(MouseEvent evt) {
		// TODO Auto-generated method stub
		/*if (evt.isPopupTrigger()) {
			this.menuContextual.show(evt.getComponent(), evt.getX(), evt.getY());
        }*/

	}

}