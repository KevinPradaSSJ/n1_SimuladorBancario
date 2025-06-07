/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_simuladorBancario
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.simuladorBancario.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelAhorros extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para retirar dinero en la cuenta de ahorro.
     */
    private final static String RETIRAR_CUENTA_AHORRO = "RETIRAR CUENTA AHORRO";

    /**
     * Constante para consignar en la cuenta de ahorro.
     */
    private final static String CONSIGNAR_CUENTA_AHORRO = "CONSIGNAR CUENTA AHORRO";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal del simulador.
     */
    private InterfazSimulador principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del saldo de cuenta de ahorros.
     */
    private JLabel etiquetaSaldoAhorros;

    /**
     * Campo donde se visualiza el saldo de la cuenta de ahorros.
     */
    private JTextField txtSaldoAhorros;

    /**
     * Boton para consignar en la cuenta de ahorros.
     */
    private JButton btnConsignarCuentaAhorro;

    /**
     * Boton para hacer retiros de la cuenta de ahorros.
     */
    private JButton btnRetirarCuentaAhorro;
    
    /**
     * Etiqueta de porcentaje de ahorro
     */
    private JLabel etiquetaPorcentajeInteres;
    
    /**
     *  Texto del porcentaje
     */
    private JTextField txtPorcentaje;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo panel e inicializa sus elementos. <br>
     * <b>post: </b> Se inicializó el panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelAhorros( InterfazSimulador pPrincipal )
    {

        // Inicializa los elementos del panel
        principal = pPrincipal;

        etiquetaSaldoAhorros = new JLabel( "Saldo ahorros: " );
        txtSaldoAhorros = new JTextField( );
        txtSaldoAhorros.setEditable( false );
        txtSaldoAhorros.setPreferredSize(new Dimension(250, 30));
        etiquetaPorcentajeInteres = new JLabel ( "Interes Generado: " );
        txtPorcentaje = new JTextField( 10 );
        txtPorcentaje.setEditable( false );


        btnConsignarCuentaAhorro = new JButton( "Consignar" );	
        btnConsignarCuentaAhorro.setActionCommand( CONSIGNAR_CUENTA_AHORRO );
        btnConsignarCuentaAhorro.addActionListener( this );
        btnConsignarCuentaAhorro.setPreferredSize( new Dimension( 100, 0 ) );

        btnRetirarCuentaAhorro = new JButton( "Retirar" );
        btnRetirarCuentaAhorro.setActionCommand( RETIRAR_CUENTA_AHORRO );
        btnRetirarCuentaAhorro.addActionListener( this );
        btnRetirarCuentaAhorro.setPreferredSize( new Dimension( 100, 0 ) );

        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 2, 2, 2, 2) );
        panelInfo.setBorder( new EmptyBorder( 0, 0, 5, 0 ) );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new BorderLayout( ) );
        panelBotones.setBorder( new EmptyBorder( 0, 5, 5, 5 ) );
        panelBotones.setPreferredSize( new Dimension( 215, 0 ) );

        
        
        // Ubica los elementos en el panel
        panelInfo.add(etiquetaSaldoAhorros);
        panelInfo.add(txtSaldoAhorros);
        panelInfo.add(etiquetaPorcentajeInteres);
        panelInfo.add(txtPorcentaje);
        panelBotones.add( btnConsignarCuentaAhorro, BorderLayout.WEST );
        panelBotones.add( new JLabel( " " ), BorderLayout.CENTER );
        panelBotones.add( btnRetirarCuentaAhorro, BorderLayout.EAST );

        setLayout( new BorderLayout( ) );
        add( panelInfo, BorderLayout.CENTER );
        add( panelBotones, BorderLayout.EAST );
        setBorder( new CompoundBorder( new EmptyBorder( 1, 3, 0, 3 ), new TitledBorder( "Cuenta de ahorros" ) ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza el saldo de la cuenta de ahorros del cliente en la interfaz. <br>
     * <b>post: </b> Se actualizó la información con el saldo de la cuenta de ahorros.
     * @param pSaldo Saldo en la cuenta de ahorros del cliente. pSaldo != null.
     */
    public void actualizarSaldoAhorros( String pSaldo, String interesAhorro  )
    {
        txtSaldoAhorros.setText( pSaldo );
        txtPorcentaje.setText( interesAhorro + "%");
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    
    public void actionPerformed( ActionEvent pEvento )
    {
        String command = pEvento.getActionCommand( );
        if( command.equals( CONSIGNAR_CUENTA_AHORRO ) )
        {
            String strValor = JOptionPane.showInputDialog( principal, "Introduzca el monto de dinero a consignar", "Consignar", JOptionPane.QUESTION_MESSAGE );
            if( strValor != null )
                principal.consignarAhorros( strValor );
        }
        else if( command.equals( RETIRAR_CUENTA_AHORRO ) )
        {
            String strValor = JOptionPane.showInputDialog( principal, "Introduzca el monto de dinero a retirar", "Retirar", JOptionPane.QUESTION_MESSAGE );
            if( strValor != null )
                principal.retirarAhorros( strValor );
        }

     

    }

}
