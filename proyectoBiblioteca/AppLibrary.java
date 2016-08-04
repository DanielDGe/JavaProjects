package proyectoBiblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

public class AppLibrary extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId_Libro;
	private JTextField textFieldTitulo;
	private JTextField textFieldEditorial;
	private JTextField textFieldArea;
	private JTextField textField_IDAutor;
	private JTextField textField_IDLibro;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_IDLector;
	private JTextField textField_PLibro;
	private JTextField textField_FhPrest;
	private JTextField textField_FhDev;
	private JTextField textField_Devuelto;
	private JTextField textField_IDEst;
	private JTextField textField_CedEst;
	private JTextField textField_NameEst;
	private JTextField textField_DirEst;
	private JTextField textField_CarrerEst;
	private JTextField textField_EdadEst;
	private JTable table;
	private JTextField textField_Consulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppLibrary frame = new AppLibrary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppLibrary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 387);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmCargarRegistro = new JMenuItem("Cargar Registro");
		mntmCargarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.removeAll();
				contentPane.updateUI();
				contentPane.repaint();
				
				try {
					
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;user=Users;password=1234567";
					Connection conexion = DriverManager.getConnection(connectionUrl);
						
							
					
					JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
					tabbedPane.setBorder(new CompoundBorder());
					tabbedPane.setBackground(UIManager.getColor("Button.light"));
					tabbedPane.setBounds(10, 11, 576, 305);
					contentPane.add(tabbedPane);
					
					JPanel panel = new JPanel();
					tabbedPane.addTab("Libros", null, panel, null);
					tabbedPane.setBackgroundAt(0, new Color(227, 227, 227));
					panel.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("Id_Libro:");
					lblNewLabel.setBounds(56, 41, 56, 14);
					panel.add(lblNewLabel);
					
					textFieldId_Libro = new JTextField();
					textFieldId_Libro.setBounds(122, 38, 86, 20);
					panel.add(textFieldId_Libro);
					textFieldId_Libro.setColumns(10);
					
					JLabel lblTitulo = new JLabel("Titulo:");
					lblTitulo.setBounds(56, 72, 56, 14);
					panel.add(lblTitulo);
					
					textFieldTitulo = new JTextField();
					textFieldTitulo.setBounds(122, 69, 86, 20);
					panel.add(textFieldTitulo);
					textFieldTitulo.setColumns(10);
					
					JLabel lblEditorial = new JLabel("Editorial:");
					lblEditorial.setBounds(56, 103, 56, 14);
					panel.add(lblEditorial);
					
					textFieldEditorial = new JTextField();
					textFieldEditorial.setBounds(122, 100, 86, 20);
					panel.add(textFieldEditorial);
					textFieldEditorial.setColumns(10);
					
					textFieldArea = new JTextField();
					textFieldArea.setBounds(122, 130, 86, 20);
					panel.add(textFieldArea);
					textFieldArea.setColumns(10);
					
					JLabel lblEd = new JLabel("Area:");
					lblEd.setBounds(56, 133, 46, 14);
					panel.add(lblEd);
					
					JButton btnRegistrar = new JButton("Registrar");
					btnRegistrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								
								Statement sentencia = conexion.createStatement();
								String InstruccionSQL = ("INSERT INTO LIBRO (Id_Libro, Titulo, Editorial, Area) VALUES ('" + textFieldId_Libro.getText() + "','" + textFieldTitulo.getText() + "','" + textFieldEditorial.getText() + "','" + textFieldArea.getText() + "')");
							
								int n = sentencia.executeUpdate(InstruccionSQL);
							
								if (n==1){
									JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
								
								} else {
									JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
									
								}
								
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
							}
					          						
						}
					});
					btnRegistrar.setBackground(Color.LIGHT_GRAY);
					btnRegistrar.setBounds(404, 95, 89, 23);
					panel.add(btnRegistrar);
					
					JButton btnLimpiar = new JButton("Limpiar");
					btnLimpiar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							textFieldId_Libro.setText("");
							textFieldTitulo.setText(""); 
							textFieldEditorial.setText(""); 
							textFieldArea.setText("");
						}
					});
					btnLimpiar.setBackground(Color.LIGHT_GRAY);
					btnLimpiar.setBounds(404, 138, 89, 23);
					panel.add(btnLimpiar);
					
					//------------------------------------------------------------------------------------------------
					
					JPanel panel_2 = new JPanel();
					tabbedPane.addTab("Autor", null, panel_2, null);
					panel_2.setLayout(null);
					
					JLabel lblIdautor_1 = new JLabel("Id_Autor:");
					lblIdautor_1.setBounds(53, 43, 65, 14);
					panel_2.add(lblIdautor_1);
					
					textField = new JTextField();
					textField.setBounds(138, 40, 86, 20);
					panel_2.add(textField);
					textField.setColumns(10);
					
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(53, 74, 65, 14);
					panel_2.add(lblNombre);
					
					textField_1 = new JTextField();
					textField_1.setBounds(138, 71, 86, 20);
					panel_2.add(textField_1);
					textField_1.setColumns(10);
					
					JLabel lblNacionalidad = new JLabel("Nacionalidad:");
					lblNacionalidad.setBounds(53, 105, 78, 14);
					panel_2.add(lblNacionalidad);
					
					textField_2 = new JTextField();
					textField_2.setBounds(138, 102, 86, 20);
					panel_2.add(textField_2);
					textField_2.setColumns(10);
					
					JButton btnRegistrar_2 = new JButton("Registrar");
					btnRegistrar_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								
								Statement sentencia = conexion.createStatement();
								String InstruccionSQL = ("INSERT INTO Autor (Id_Autor, Nombre, Nacionalidad) VALUES ('" + textField.getText() + "','" + textField_1.getText() + "','" + textField_2.getText() + "')");
							
								int n = sentencia.executeUpdate(InstruccionSQL);
							
								if (n==1){
									JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
								
								} else {
									JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
									
								}
								
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
							}
							
						}
					});
					btnRegistrar_2.setBackground(Color.LIGHT_GRAY);
					btnRegistrar_2.setBounds(404, 95, 89, 23);
					panel_2.add(btnRegistrar_2);
					
					JButton btnLimpiar_2 = new JButton("Limpiar");
					btnLimpiar_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							textField.setText("");
							textField_1.setText(""); 
							textField_2.setText("");
							
						}
					});
					btnLimpiar_2.setBackground(Color.LIGHT_GRAY);
					btnLimpiar_2.setBounds(404, 138, 89, 23);
					panel_2.add(btnLimpiar_2);
					
					//----------------------------------------------------------------------------------------------
					
					JPanel panel_1 = new JPanel();
					tabbedPane.addTab("Libro Autor", null, panel_1, null);
					panel_1.setLayout(null);
					
					JLabel lblIdautor = new JLabel("Id_Autor:");
					lblIdautor.setBounds(59, 43, 68, 14);
					panel_1.add(lblIdautor);
					
					textField_IDAutor = new JTextField();
					textField_IDAutor.setBounds(137, 40, 86, 20);
					panel_1.add(textField_IDAutor);
					textField_IDAutor.setColumns(10);
					
					JLabel lblIdlibro = new JLabel("Id_Libro:");
					lblIdlibro.setBounds(59, 78, 68, 14);
					panel_1.add(lblIdlibro);
					
					textField_IDLibro = new JTextField();
					textField_IDLibro.setBounds(137, 75, 86, 20);
					panel_1.add(textField_IDLibro);
					textField_IDLibro.setColumns(10);
					
					JButton btnRegistrar_1 = new JButton("Registrar");
					btnRegistrar_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								
								Statement sentencia = conexion.createStatement();
								String InstruccionSQL = ("INSERT INTO LibroAutor (Id_Autor, Id_Libro) VALUES ('" + textField_IDAutor.getText() + "','" + textField_IDLibro.getText() + "')");
							
								int n = sentencia.executeUpdate(InstruccionSQL);
							
								if (n==1){
									JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
								
								} else {
									JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
									
								}
								
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
							}
							
						}
					});
					btnRegistrar_1.setBackground(Color.LIGHT_GRAY);
					btnRegistrar_1.setBounds(404, 95, 89, 23);
					panel_1.add(btnRegistrar_1);
					
					JButton btnLimpiar_1 = new JButton("Limpiar");
					btnLimpiar_1.setBackground(Color.LIGHT_GRAY);
					btnLimpiar_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							textField_IDAutor.setText("");
							textField_IDLibro.setText(""); 
							
						}
					});
					btnLimpiar_1.setBounds(404, 138, 89, 23);
					panel_1.add(btnLimpiar_1);
					
					//---------------------------------------------------------------------------------------------------
					
					JPanel panel_4 = new JPanel();
					tabbedPane.addTab("Estudiantes", null, panel_4, null);
					panel_4.setLayout(null);
					
					JLabel lblIdlector_1 = new JLabel("Id_Lector:");
					lblIdlector_1.setBounds(45, 37, 70, 14);
					panel_4.add(lblIdlector_1);
					
					textField_IDEst = new JTextField();
					textField_IDEst.setBounds(125, 34, 86, 20);
					panel_4.add(textField_IDEst);
					textField_IDEst.setColumns(10);
					
					JLabel lblCedula = new JLabel("Cedula:");
					lblCedula.setBounds(45, 68, 70, 14);
					panel_4.add(lblCedula);
					
					textField_CedEst = new JTextField();
					textField_CedEst.setBounds(125, 65, 86, 20);
					panel_4.add(textField_CedEst);
					textField_CedEst.setColumns(10);
					
					textField_NameEst = new JTextField();
					textField_NameEst.setBounds(125, 96, 86, 20);
					panel_4.add(textField_NameEst);
					textField_NameEst.setColumns(10);
					
					textField_DirEst = new JTextField();
					textField_DirEst.setBounds(125, 127, 86, 20);
					panel_4.add(textField_DirEst);
					textField_DirEst.setColumns(10);
					
					JLabel lblNombre_1 = new JLabel("Nombre:");
					lblNombre_1.setBounds(45, 99, 70, 14);
					panel_4.add(lblNombre_1);
					
					JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
					lblDireccin.setBounds(45, 130, 70, 14);
					panel_4.add(lblDireccin);
					
					textField_CarrerEst = new JTextField();
					textField_CarrerEst.setBounds(125, 158, 86, 20);
					panel_4.add(textField_CarrerEst);
					textField_CarrerEst.setColumns(10);
					
					textField_EdadEst = new JTextField();
					textField_EdadEst.setBounds(125, 189, 86, 20);
					panel_4.add(textField_EdadEst);
					textField_EdadEst.setColumns(10);
					
					JLabel lblCarrera = new JLabel("Carrera:");
					lblCarrera.setBounds(45, 161, 70, 14);
					panel_4.add(lblCarrera);
					
					JLabel lblEdad = new JLabel("Edad:");
					lblEdad.setBounds(45, 195, 70, 14);
					panel_4.add(lblEdad);
					
					JButton btnRegistrar_4 = new JButton("Registrar");
					btnRegistrar_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								
								Statement sentencia = conexion.createStatement();
								String InstruccionSQL = ("INSERT INTO Estudiante (Id_Lector, Cedula, Nombre, Direccion, Carrera, Edad) VALUES ('" + textField_IDEst.getText() + "','" + textField_CedEst.getText() + "','" + textField_NameEst.getText() + "','" + textField_DirEst.getText() + "','" + textField_CarrerEst.getText() + "','" + textField_EdadEst.getText() + "')");
							
								int n = sentencia.executeUpdate(InstruccionSQL);
							
								if (n==1){
									JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
								
								} else {
									JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
									
								}
								
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
							}
							
						}
					});
					btnRegistrar_4.setBackground(Color.LIGHT_GRAY);
					btnRegistrar_4.setBounds(404, 95, 89, 23);
					panel_4.add(btnRegistrar_4);
					
					JButton btnLimpiar_4 = new JButton("Limpiar");
					btnLimpiar_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							textField_IDEst.setText("");
							textField_CedEst.setText(""); 
							textField_NameEst.setText("");
							textField_DirEst.setText("");
							textField_CarrerEst.setText(""); 
							textField_EdadEst.setText("");
							
						}
					});
					btnLimpiar_4.setBackground(Color.LIGHT_GRAY);
					btnLimpiar_4.setBounds(404, 138, 89, 23);
					panel_4.add(btnLimpiar_4);
					
					//------------------------------------------------------------------------------------------------------------------
					
					JPanel panel_3 = new JPanel();
					tabbedPane.addTab("Prestamos", null, panel_3, null);
					panel_3.setLayout(null);
					
					JLabel lblIdlector = new JLabel("Id_Lector:");
					lblIdlector.setBounds(47, 39, 72, 14);
					panel_3.add(lblIdlector);
					
					textField_IDLector = new JTextField();
					textField_IDLector.setBounds(159, 36, 86, 20);
					panel_3.add(textField_IDLector);
					textField_IDLector.setColumns(10);
					
					textField_PLibro = new JTextField();
					textField_PLibro.setBounds(159, 67, 86, 20);
					panel_3.add(textField_PLibro);
					textField_PLibro.setColumns(10);
					
					textField_FhPrest = new JTextField();
					textField_FhPrest.setBounds(159, 98, 86, 20);
					panel_3.add(textField_FhPrest);
					textField_FhPrest.setColumns(10);
					
					textField_FhDev = new JTextField();
					textField_FhDev.setBounds(159, 129, 86, 20);
					panel_3.add(textField_FhDev);
					textField_FhDev.setColumns(10);
					
					textField_Devuelto = new JTextField();
					textField_Devuelto.setBounds(159, 160, 86, 20);
					panel_3.add(textField_Devuelto);
					textField_Devuelto.setColumns(10);
					
					JLabel lblIdlibro_1 = new JLabel("Id_Libro:");
					lblIdlibro_1.setBounds(47, 70, 72, 14);
					panel_3.add(lblIdlibro_1);
					
					JLabel lblFechaPrestamo = new JLabel("Fecha Prestamo:");
					lblFechaPrestamo.setBounds(47, 101, 102, 14);
					panel_3.add(lblFechaPrestamo);
					
					JLabel lblFechaDevolucion = new JLabel("Fecha Devolucion:");
					lblFechaDevolucion.setBounds(47, 132, 102, 14);
					panel_3.add(lblFechaDevolucion);
					
					JLabel lblDevuelto = new JLabel("Devuelto:");
					lblDevuelto.setBounds(47, 163, 72, 14);
					panel_3.add(lblDevuelto);
					
					JButton btnRegistrar_3 = new JButton("Registrar");
					btnRegistrar_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							try {
								
								Statement sentencia = conexion.createStatement();
								String InstruccionSQL = ("INSERT INTO Prestamo (Id_Lector, Id_Libro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES ('" + textField_IDLector.getText() + "','" + textField_PLibro.getText() + "','" + textField_FhPrest.getText() + "','" + textField_FhDev.getText() + "','" + textField_Devuelto.getText() + "')");
							
								int n = sentencia.executeUpdate(InstruccionSQL);
							
								if (n==1){
									JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente");
								
								} else {
									JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
									
								}
								
								
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Datos No Insertados Correctamente");
							}
							
						}
					});
					btnRegistrar_3.setBackground(Color.LIGHT_GRAY);
					btnRegistrar_3.setBounds(404, 95, 89, 23);
					panel_3.add(btnRegistrar_3);
					
					JButton btnLimpiar_3 = new JButton("Limpiar");
					btnLimpiar_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							textField_IDLector.setText("");
							textField_PLibro.setText(""); 
							textField_FhPrest.setText("");
							textField_FhDev.setText("");
							textField_Devuelto.setText(""); 
							
						}
					});
					btnLimpiar_3.setBackground(Color.LIGHT_GRAY);
					btnLimpiar_3.setBounds(404, 138, 89, 23);
					panel_3.add(btnLimpiar_3);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Cargando el driver
			}
		});
		mnMenu.add(mntmCargarRegistro);
		
		
		
		
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.removeAll();
				contentPane.updateUI();
				contentPane.repaint();
				
				textField_Consulta = new JTextField();
				textField_Consulta.setHorizontalAlignment(SwingConstants.CENTER);
				textField_Consulta.setBounds(142, 33, 303, 20);
				contentPane.add(textField_Consulta);
				textField_Consulta.setColumns(10);
				
				JLabel lblIngresaConsulta = new JLabel("Ingresa Consulta");
				lblIngresaConsulta.setHorizontalAlignment(SwingConstants.CENTER);
				lblIngresaConsulta.setBounds(244, 11, 112, 14);
				contentPane.add(lblIngresaConsulta);
				
				JTextArea textArea = new JTextArea();
				textArea.setColumns(8);
				textArea.setRows(10);
				textArea.setBounds(10, 71, 576, 210);
				contentPane.add(textArea);
								
				JButton btnConsultar = new JButton("Consultar");
				btnConsultar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
										
						try {
							
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Biblioteca;user=Users;password=1234567";
							Connection miConexion = DriverManager.getConnection(connectionUrl);
							
							Statement miStatement = miConexion.createStatement();
							
							String InstruccionSQL = textField_Consulta.getText();
							
							ResultSet rs = miStatement.executeQuery(InstruccionSQL);
							
							int NCols = rs.getMetaData().getColumnCount(); //Buscando el numero de columnas							
							
							int n;
							for (int x=1;x<=rs.getMetaData().getColumnCount();x++){
								 //System.out.print(rs.getMetaData().getColumnName(x)+ "\t");
								 
								 textArea.append(rs.getMetaData().getColumnName(x)+ "\t"); //Buscando los nombres de las columnas
							}
								  
							textArea.append("\n");
							textArea.append("\n");
							
							while (rs.next()){
								
								for (n = 1; n <= NCols; n++){
									System.out.print(rs.getString(n));
									System.out.print(", ");
									
									textArea.append(rs.getString(n) + "\t");
								}
								
								System.out.println();
								
								textArea.append("\n");
								
							}
							
						    
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
								
					}
				});
				btnConsultar.setForeground(Color.BLACK);
				btnConsultar.setBackground(Color.LIGHT_GRAY);
				btnConsultar.setBounds(263, 292, 89, 23);
				contentPane.add(btnConsultar);
				
				JButton Refresh = new JButton("");
				Refresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						textField_Consulta.setText(" ");
						textArea.setText(" ");
						
					}
				});
				
				Refresh.setToolTipText("Refrescar");
				Refresh.setBackground(Color.WHITE);
				Refresh.setIcon(new ImageIcon(""));
				Refresh.setBounds(455, 32, 28, 23);
				contentPane.add(Refresh);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				scrollPane.setBounds(10, 71, 576, 210);
				contentPane.add(scrollPane);
				
			}
		});
		mnMenu.add(mntmConsultar);
		
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnMenu.add(mntmSalir);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
